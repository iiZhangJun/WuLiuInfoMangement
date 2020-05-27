package com.icss.wuliu.biz;

import java.util.List;




import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Torder;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.OrderBasInfodto;
import com.icss.dto.OrderTansfdto;
import com.icss.wuliu.dao.ChargeDao;
import com.icss.wuliu.dao.OrderDao;
import com.icss.wuliu.util.JsonUtil;

@Service("orderBiz")
@Transactional(readOnly=true)
public class OrderBiz {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ChargeDao chargeDao;
	
	
	public String getOrderInfo(String orderid,TurnPage tp) throws Exception{
		String orderSTR;
		List<OrderBasInfodto> orders = orderDao.getOrderInfo(orderid,tp);
		orderSTR = JSONArray.fromObject(orders).toString();
		System.out.println(orderSTR);
		orderSTR = JsonUtil.getDatagridJSON(tp.getAllres(), orderSTR);
		System.out.println(orderSTR);
		return orderSTR;
	}
	
	
	public List<OrderTansfdto> queryOrder(String orderid) throws Exception{
		
		return orderDao.queryOrder(orderid);
	}
	
	
	public List<OrderBasInfodto> queryOrderState(String orderid) throws Exception{
			
			return orderDao.queryOrderState(orderid);
	}
		
	public String getCityID(String[] city) throws Exception{
		
		return chargeDao.getCityID(city);
		
	}
	
	public Torder placeOrder(Torder order) throws Exception {
		Torder order2 = null;
		order2 = orderDao.placeOrder(order);
		return order2;
	}

	/**
	 * 更新订单状态
	 * @param orderid
	 * @param state
	 * @return
	 * @throws Exception 
	 */
	@Transactional(readOnly=false)
	public int updateOrderState(String orderid,String state,int userid) throws Exception{
		
		return orderDao.updateOrderState(orderid,state,userid);
	}
	
	@Transactional(readOnly=false)
	public void updateOrder(Torder order) throws Exception{
		
		orderDao.updateOrder(order);
	}
	
	
	/**
	 * 用户在配送点下单
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly=false)
	public Torder makeOrder(Torder order) throws Exception{
		
		return orderDao.makeOrder(order);
	}
	
	public List<OrderBasInfodto> queryOrderById(String orderid) throws Exception{
		
		return orderDao.queryOrderById(orderid);
	}
}
