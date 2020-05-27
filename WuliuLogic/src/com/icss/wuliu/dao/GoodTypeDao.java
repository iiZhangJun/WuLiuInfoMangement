package com.icss.wuliu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tgoodstype;

@Repository("goodTypeDao")
public class GoodTypeDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public List<Tgoodstype> getGoodType() throws Exception{
		
		String hql = "From Tgoodstype";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		return q.list();
	}
}
