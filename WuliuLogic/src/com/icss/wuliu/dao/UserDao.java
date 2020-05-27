package com.icss.wuliu.dao;

import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;

@Repository("userDao")
public class UserDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public Tuser login(String uname,String pwd,int role) throws Exception{
		Tuser user = null;
		String hql = "from Tuser t where t.username = ? and t.password = ? and t.trole.roleid = ?";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		q.setString(0, uname);
		q.setString(1, pwd);
		q.setInteger(2, role);
		List<Tuser> users = q.list();
		if(users.size() > 0){
			user = users.get(0);
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tuser> getUser(int roleid,TurnPage tp) throws Exception{
		
		String sql = "Select t.userid,t.username,p.pointname "
				   + " From tuser t Left Join tpoint p on t.pointid = p.pointid"
				   + " where t.roleid = ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, roleid);
		q.addScalar("userid", Hibernate.INTEGER);
		q.addScalar("username", Hibernate.STRING);
		q.addScalar("pointname", Hibernate.STRING);
		q.setResultTransformer(Transformers.aliasToBean(Tuser.class));
		tp.setAllres(q.list().size());
		q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
		q.setMaxResults(tp.getResnum());
		
		
		return q.list();
	}
	
	public int addUser(Tuser user,String pointid,String roleid) throws Exception{
		
		String sql = "insert into tuser(pointid,roleid,username,password) values(?,?,?,?)";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0,pointid);
		q.setParameter(1, roleid);
		q.setParameter(2, user.getUsername());
		q.setParameter(3, user.getPassword());
		int i = q.executeUpdate();
		return i;
	}
	
	public void deleteUser(int userid) throws Exception{
		
		Session session = this.findSession();
		Tuser user = (Tuser) session.get(Tuser.class, userid);
		session.delete(user);
		session.flush();
	}
	
	public int updateSiteUser(Tuser user) throws Exception{
		String sql = "update tuser set username = ?,password = ? where userid = ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, user.getUsername());
		q.setParameter(1, user.getPassword());
		q.setParameter(2, user.getUserid());
		int i = q.executeUpdate();
		return i;
	}
}
