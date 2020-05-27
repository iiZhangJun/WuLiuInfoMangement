package com.icss.wuliu.dao;

import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.OrderBasInfodto;

@Repository
public class SiteDao extends BaseDao{
	
	
	/**
	 * 添加配送站点
	 * SiteDao.java
	 * @throws Exception 
	 */
	public int addNewSite(Tpoint point,String cityID) throws Exception{
		
		Session session = this.findSession();
		String sql = "insert into tpoint (pointid,cityid,pointname,pointaddr,pointphone)"
				   +  " select max(pointid)+1,?,?,?,? from tpoint";
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, cityID);
		q.setParameter(1, point.getPointname());
		q.setParameter(2, point.getPointaddr());
		q.setParameter(3, point.getPointphone());
		int i = q.executeUpdate();
		session.flush();
		return i;
	}
	
	
	/**
	 * 删除某一配送点
	 * @throws Exception 
	 */
	public void delOneSite(String pointid) throws Exception{
		Session session = this.findSession();
		Tpoint site = new Tpoint();
		site.setPointid((long)Integer.parseInt(pointid));
		//Tpoint site = (Tpoint) session.get(Tpoint.class, BigDecimal.valueOf(Integer.parseInt(pointid)));
		session.delete(site);
		session.flush();
	}
	
	/**
	 * 查询配送点信息
	 */
	@SuppressWarnings("unchecked")
	public List<Tpoint> getSite(String pointName,TurnPage tp) throws Exception{
		List<Tpoint> sites = null;
		String hql = "select new Tpoint(t.pointid, t.tcity, t.pointname,t.pointaddr,t.pointphone)"
				   + " from Tpoint t where t.pointname like '%" + pointName + "%'";
		Session session = this.findSession();
		Query q =  session.createQuery(hql);
		tp.setAllres(q.list().size());
		q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
		q.setMaxResults(tp.getResnum());
		sites = q.list();
		return sites;
	}
	
	public Tpoint getOneSite(long pointId) throws Exception{
		
		Session session = this.findSession();
		Tpoint pt = (Tpoint) session.get(Tpoint.class, pointId);
		return pt;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tpoint> getAllSite() throws Exception{
		
		List<Tpoint> sites = null;
		String hql="select new Tpoint(t.pointid,t.pointname) from Tpoint t";
		Session session = this.findSession();
		Query q =  session.createQuery(hql);
		sites = q.list();
		return sites;
	}

	public Tpoint getSiteById(long id) throws Exception{
		Session session = this.findSession();
		Tpoint pt = (Tpoint) session.get(Tpoint.class, id);
		return pt;
	}
	
	
	/**查询起点为配送点对应订单*/
	@SuppressWarnings("unchecked")
	public List<OrderBasInfodto> getOrderOnSite(String flag,String pointid,String state,TurnPage tp) throws Exception{
		String sql = null;
		if(flag.equals("start")){
			sql = "Select o.ORDERID orderid,o.SENDNAME sendname,o.sendphone,o.sendaddress,"
			   + "o.recvname,o.recvphone,o.recvaddress, o.WEIGHT weight,o.cost,"
			   + "o.fastcost,o.safe,o.state From TORDER o"
			   + " Inner Join TPOINT stpt On stpt.POINTID = o.STARTPOINTID"
			   + " where o.state = '" + state + "'" + " and o.startpointid = " + pointid;
		}else if(flag.equals("end")){
			sql = "Select o.ORDERID orderid,o.SENDNAME sendname,o.sendphone,o.sendaddress,"
			   + "o.recvname,o.recvphone,o.recvaddress, o.WEIGHT weight,o.cost,"
			   + "o.fastcost,o.safe,o.state From TORDER o"
			   + " Inner Join TPOINT edpt On edpt.POINTID = o.ENDPOINTID"
			   + " where o.state = '" + state + "'" + " and o.endpointid = " + pointid;
		}
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		
		q.addScalar("orderid",Hibernate.STRING);
		
		q.addScalar("sendname",Hibernate.STRING);
		q.addScalar("recvname",Hibernate.STRING);
		q.addScalar("sendphone",Hibernate.STRING);
		q.addScalar("recvphone",Hibernate.STRING);
		q.addScalar("sendaddress",Hibernate.STRING);
		q.addScalar("recvaddress",Hibernate.STRING);
		
		q.addScalar("weight",Hibernate.DOUBLE);
		q.addScalar("cost",Hibernate.DOUBLE);
		q.addScalar("fastcost",Hibernate.DOUBLE);
		q.addScalar("safe",Hibernate.DOUBLE);
		q.addScalar("state",Hibernate.STRING);
		
		q.setResultTransformer(Transformers.aliasToBean(OrderBasInfodto.class));
		
		return q.list();
	}
	
	
	
	
	
}
