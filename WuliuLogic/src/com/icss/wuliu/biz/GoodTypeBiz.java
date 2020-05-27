package com.icss.wuliu.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Tgoodstype;
import com.icss.wuliu.dao.GoodTypeDao;

@Service("goodTypeBiz")
@Transactional(readOnly=true)
public class GoodTypeBiz {
	
	@Autowired
	GoodTypeDao goodTypeDao;
	
	public List<Tgoodstype> getGoodType() throws Exception{
		
		return goodTypeDao.getGoodType();
	}
}
