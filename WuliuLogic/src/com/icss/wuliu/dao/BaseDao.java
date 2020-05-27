package com.icss.wuliu.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session findSession() throws Exception {
			//openSession�������һ���µ�session
			return this.sessionFactory.getCurrentSession();	//�ӵ�ǰ�̻߳��session�����һ���µ����ݿ����ӣ������һ����session
		}
}
