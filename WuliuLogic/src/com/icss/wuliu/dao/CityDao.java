package com.icss.wuliu.dao;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao extends BaseDao{
	/**
	 * �����β����id,�ҵ���Ӧ��·�����Ȩֵ
	 */
	public	String  getCityID(String[] city) throws Exception{
		String sql = "select cityid from tcity where province=? and city=? and district = ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, city[0]);
		q.setString(1, city[1]);
		q.setString(2, city[2]);
		q.addScalar("cityid",Hibernate.STRING);
		//q.setResultTransformer(Transformers.aliasToBean(String.class));
		return (String) q.list().get(0);
	}
}
