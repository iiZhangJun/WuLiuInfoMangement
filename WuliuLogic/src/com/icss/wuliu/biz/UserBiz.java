package com.icss.wuliu.biz;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;
import com.icss.wuliu.dao.UserDao;

@Service("userBiz")
@Transactional(readOnly=true)
public class UserBiz {
	
	@Autowired
	private UserDao userDao;
	
	public Tuser login(String uname,String pwd,int role) throws Exception{
		Tuser user = userDao.login(uname, pwd,role);
		return user;
		
	}
	
	public List<Tuser> getUser(int roleid,TurnPage tp) throws Exception{
		
		return userDao.getUser(roleid, tp);
	}
	
	@Transactional(readOnly=false)
	public int addSiteUser(Tuser user,String pointid,String roleid) throws Exception{
		
		return userDao.addUser(user, pointid, roleid);
	}
	
	@Transactional(readOnly=false)
	public void deleteUser(int userid) throws Exception{
		
		userDao.deleteUser(userid);
	}
	
	@Transactional(readOnly=false)
	public int updateSiteUser(Tuser user) throws Exception{
		
		return userDao.updateSiteUser(user);
	}
	
}
