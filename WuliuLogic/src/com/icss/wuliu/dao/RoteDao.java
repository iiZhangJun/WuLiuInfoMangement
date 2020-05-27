package com.icss.wuliu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.Troad;
import com.ciss.wuliu.entity.Troadwaybypoint;
import com.ciss.wuliu.entity.TurnPage;

@Repository
public class RoteDao extends BaseDao{
	
	
	@SuppressWarnings("unchecked")
	public List<Troad> getAllRote(String startSite,String endSite,TurnPage tp) throws Exception{
		String hql = "select new Troad(r.troadid,r.startpt,r.endpt,r.roadname,r.raodlength,r.raodvalue)"
				   + " FROM Troad r"
				   + " where r.startpt.pointname like '%" + startSite + "%'" 
				   + " and r.endpt.pointname like '%" + endSite + "%'";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		if(tp != null){
			tp.setAllres(q.list().size());
			q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
			q.setMaxResults(tp.getResnum());
		}
		return q.list();
	}
	
	/**
	 * 查询某线路的途径配送点
	 * RoteDao.java
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<Tpoint> getRoteBySite(String roadid) throws Exception{
		
		List<Tpoint> sites = new ArrayList<Tpoint>();
		String hql = "select new Troadwaybypoint(b.tpoint) From Troadwaybypoint b where b.troad.troadid = ? order by b.sequence";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		q.setParameter(0, (long)Integer.parseInt(roadid));
		List<Troadwaybypoint> bySites = q.list();
		for(int i=0;i<bySites.size();i++){
			Tpoint pt = bySites.get(i).getTpoint();
			sites.add(pt);
		}
		return sites;
	}
	
	public void delRote(String roadid) throws Exception{
		Session session = this.findSession();
		//Troad rote = (Troad) session.get(Troad.class, (long)Integer.parseInt(roadid));
		Troad rote = new Troad();
		rote.setTroadid((long)Integer.parseInt(roadid));
		session.delete(rote);
		session.flush();
	}
	
	
	public long addNewRote(Troad rote) throws Exception{
		
		Session session = this.findSession();
		session.save(rote);
		long roteid = (Long) session.getIdentifier(rote);
		/*session.beginTransaction().commit();*/
		return roteid;
	}
	
	public void addBySite(Troadwaybypoint byst) throws Exception{
		Session session = this.findSession();
		session.persist(byst);
		//session.save(byst);
		/*session.beginTransaction().commit();*/
		session.flush();
	}
	
}
