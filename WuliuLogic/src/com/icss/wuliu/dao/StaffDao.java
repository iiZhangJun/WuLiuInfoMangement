package com.icss.wuliu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tstaff;

@Repository
public class StaffDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public List<Tstaff> getAllStaff() throws Exception{
		String hql = "select new Tstaff(f.staffid,f.staffname) From Tstaff f";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		return q.list();
	}
}
