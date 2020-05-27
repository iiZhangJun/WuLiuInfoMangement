package com.icss.wuliu.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tauto;
import com.ciss.wuliu.entity.Tcartype;
import com.ciss.wuliu.entity.TurnPage;
@Repository
public class AutoDao extends BaseDao{
	
	public void addNewAutoType(Tcartype autoType) throws Exception{
		
		Session session = this.findSession();
		session.save(autoType);
		session.flush();
	}
	
	public void delAutoType(String cartypeid) throws Exception{
		
		Session session = this.findSession();
		Tcartype autoType = (Tcartype) session.get(Tcartype.class, cartypeid);
		session.delete(autoType);
		session.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tcartype> getAllAutoType() throws Exception{
		
		String hql = "From Tcartype";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		return q.list();
	}
	
	public void addAuto(Tauto auto) throws Exception{
		
		Session session = this.findSession();
		session.save(auto);
		session.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tauto> getAutoInfo(String carNum,TurnPage tp) throws Exception{
		
		String hql = "select new Tauto(ta.autoid, ta.tcartype, ta.cartweight,ta.carvol, ta.driver1, ta.driver2) from Tauto ta";
		if(!carNum.equals("")){
			hql = hql + " where ta.autoid=?";
		}
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		if(!carNum.equals("")){
			q.setParameter(0, carNum);
		}
		if(tp != null){
			tp.setAllres(q.list().size());
			q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
			q.setMaxResults(tp.getResnum());
		}
		return q.list();
	}
	
	public void delAuto(String carNum) throws Exception{
		Session session = this.findSession();
		Tauto auto = (Tauto) session.get(Tauto.class, carNum);
		session.delete(auto);
		session.flush();
	}
}
