package com.icss.wuliu.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Texcorder;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.dao.ExcepDao;
import com.icss.wuliu.dao.OrderDao;

@Service("excepBiz")
@Transactional(readOnly=true)
public class ExceptBiz {
	
	@Autowired
	ExcepDao excepDao;
	@Autowired
	OrderDao orderDao;
	
	
	@Transactional(rollbackFor=Throwable.class)
	public int recordException(String orderid,Texcorder excorder) throws Exception{
		
		orderDao.updateOrderState(orderid, "“Ï≥£",-1);
		return excepDao.recordException(orderid, excorder);
	}
	
	public List<Texcorder> queryExcepOrder(TurnPage tp,String orderid) throws Exception{
		
		return excepDao.queryExcepOrder(tp,orderid);
	}
	
	@Transactional(readOnly=false)
	public int updateExcorder(Texcorder excorder) throws Exception{
		
		int i =excepDao.updateExcorder(excorder);
		return i;
	}
	
	
}
