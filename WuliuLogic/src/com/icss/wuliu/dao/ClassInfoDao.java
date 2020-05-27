package com.icss.wuliu.dao;

import java.util.List;



import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tclass;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.ClassInfodto;

@Repository
public class ClassInfoDao extends BaseDao{
	
	public void addClassInfo(Tclass tclass) throws Exception{
		Session session = this.findSession();
		session.save(tclass);
		session.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClassInfodto> getClassInfo(String startSite,String endSite, TurnPage tp) throws Exception{
		
		String sql = "select sp.pointname sp1,ep.pointname ep1,c.troadid,c.tclassid,c.tclassstarttime,c.tclassendtime,c.tclassstate,a.autoid,s1.staffname driver1,s2.staffname driver2,r.roadname,r.raodlength"
				   + " from tauto a,tclass c, tpoint ep,troad r,tpoint sp,tstaff s1,tstaff s2"
				   + " where a.autoid = c.autoid and ep.pointid = r.endpointid and sp.pointid = r.startpointid"
				   + " and r.troadid = c.troadid and s1.staffid = a.driver1 and s2.staffid = a.driver2";
		
		if(startSite != null && !startSite.equals("") && endSite != null && !endSite.equals("")){
			sql += "and sp.pointname like '% " + startSite + "%' and ep.pointname like '%" + endSite + "%'";
		}else if(startSite != null && !startSite.equals("")){
			sql += "and sp.pointname like '% " + startSite + "%'";
		}else if(endSite != null && !endSite.equals("")){
			sql += "and ep.pointname like '%" + endSite + "%'";
		}
		
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		
		q.addScalar("sp1", Hibernate.STRING);
		q.addScalar("ep1", Hibernate.STRING);
		q.addScalar("troadid", Hibernate.LONG);
		q.addScalar("tclassid", Hibernate.INTEGER);
		q.addScalar("tclassstarttime", Hibernate.TIMESTAMP);
		q.addScalar("tclassendtime", Hibernate.TIMESTAMP);
		q.addScalar("tclassstate", Hibernate.STRING);
		q.addScalar("autoid", Hibernate.STRING);
		q.addScalar("driver1", Hibernate.STRING);
		q.addScalar("driver2", Hibernate.STRING);
		q.addScalar("roadname", Hibernate.STRING);
		q.addScalar("raodlength", Hibernate.FLOAT);
		q.setResultTransformer(Transformers.aliasToBean(ClassInfodto.class));
		
		tp.setAllres(q.list().size());
		q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
		q.setMaxResults(tp.getResnum());
		
		return q.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ClassInfodto> queryPassClassInfo(String classid,long pointid,TurnPage tp) throws Exception{
		String sql = "select DISTINCT c.tclassid,r.troadid,r.roadname,c.tclassstarttime,c.tclassendtime,c.tclassstate,c.classremarks " 
				   + " from tclass c,troadwaybypoint wp,troad r where r.troadid = c.troadid and r.troadid = wp.troadid and wp.passpointid = " + pointid 
				   + " or r.startpointid = " + pointid + " and c.tclassid like '%" + classid + "%'";
		
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		
		q.addScalar("tclassid", Hibernate.INTEGER);
		q.addScalar("troadid", Hibernate.LONG);
		q.addScalar("roadname", Hibernate.STRING);
		q.addScalar("tclassstarttime", Hibernate.TIMESTAMP);
		q.addScalar("tclassendtime", Hibernate.TIMESTAMP);
		q.addScalar("tclassstate", Hibernate.STRING);
		q.addScalar("classremarks",Hibernate.STRING);
		
		q.setResultTransformer(Transformers.aliasToBean(ClassInfodto.class));
		if(tp != null){
			tp.setAllres(q.list().size());
			q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
			q.setMaxResults(tp.getResnum());
		}
		return q.list();
	}
	
	public Tclass getTclassById(int classid) throws Exception{
		
		Session session = this.findSession();
		Tclass tclass = (Tclass) session.get(Tclass.class, classid);
		return tclass;
	}
}
