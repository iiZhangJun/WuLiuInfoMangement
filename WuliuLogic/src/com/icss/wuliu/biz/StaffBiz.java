package com.icss.wuliu.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Tstaff;
import com.icss.wuliu.dao.StaffDao;
@Service
@Transactional(readOnly=true)
public class StaffBiz {
	
	@Autowired
	private StaffDao stuffDao;
	
	public List<Tstaff> getAllStaff() throws Exception{
		
		List<Tstaff> stuffs = stuffDao.getAllStaff();
		return stuffs;
	}
}
