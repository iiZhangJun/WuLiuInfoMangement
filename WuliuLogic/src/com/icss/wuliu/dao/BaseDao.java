package com.icss.wuliu.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session findSession() throws Exception {
			//openSession（）获得一个新的session
			return this.sessionFactory.getCurrentSession();	//从当前线程获得session，获得一个新的数据库连接，否则打开一个新session
		}
}
