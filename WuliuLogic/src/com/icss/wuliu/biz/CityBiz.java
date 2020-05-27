package com.icss.wuliu.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.wuliu.dao.CityDao;

@Service
@Transactional(readOnly=true)
public class CityBiz {
	
	@Autowired
	private CityDao cityDao;
	
	public String getCityID(String[] city) throws Exception{
		
		return cityDao.getCityID(city);
		
	}
}
