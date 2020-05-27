package com.icss.wuliu.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Texcorder;
import com.ciss.wuliu.entity.TurnPage;

@Repository("excepDao")
public class ExcepDao extends BaseDao {
	
	/**
	 * 录入发生异常的订单信息
	 * @param orderid
	 * @param excorder
	 * @return
	 * @throws Exception
	 */
	public int recordException(String orderid,Texcorder excorder) throws Exception{
		
		String sql = "insert into texcorder(orderid,exctime,accident,resolve,position,excstate) values(?,?,?,?,?,?)";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, orderid);
		q.setParameter(1, excorder.getExctime());
		q.setParameter(2, excorder.getAccident());
		q.setParameter(3, excorder.getResolve());
		q.setParameter(4, excorder.getPosition());
		q.setParameter(5, excorder.getExcstate());
		int i = q.executeUpdate();
		session.flush();
		return i;
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<Texcorder> queryExcepOrder(TurnPage tp,String orderid) throws Exception{
		
		String sql = "select texc.excid,texc.orderid,texc.exctime,texc.accident,texc.resolve,texc.position,texc.excstate"
				   + " from Texcorder texc where texc.orderid = ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, orderid);
		q.addScalar("excid", Hibernate.INTEGER);
		q.addScalar("orderid", Hibernate.STRING);
		q.addScalar("exctime", Hibernate.TIMESTAMP);
		q.addScalar("accident", Hibernate.STRING);
		q.addScalar("resolve", Hibernate.STRING);
		q.addScalar("position", Hibernate.STRING);
		q.addScalar("excstate", Hibernate.STRING);
		q.setResultTransformer(Transformers.aliasToBean(Texcorder.class));
		tp.setAllres(q.list().size());
		q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
		q.setMaxResults(tp.getResnum());
		return q.list();
	}
	
	
	
	public int updateExcorder(Texcorder excorder) throws Exception{
		
		String sql = "update texcorder t set t.resolve = ?,t.position = ?,t.excstate=? where t.excid = ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		
		q.setParameter(0, excorder.getResolve());
		q.setParameter(1, excorder.getPosition());
		q.setParameter(2, excorder.getExcstate());
		q.setParameter(3, excorder.getExcid());
		
		int i = q.executeUpdate();
		session.flush();
		return i;
	}
}
