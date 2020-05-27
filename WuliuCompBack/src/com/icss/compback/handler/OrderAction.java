package com.icss.compback.handler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.biz.OrderBiz;

@Controller
@RequestMapping("admin/")
public class OrderAction {
	@Autowired
	private OrderBiz orderBiz;
	
	@RequestMapping(value="orderManage")
	public String orderManage(){
		return "orderManage/orderInfo";
	}
	
	
	@RequestMapping(value="getOrder")
	@ResponseBody
	public String getOrder(String orderid,String page,String rows){
		String orderSTR;
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		
		try {
			orderSTR = orderBiz.getOrderInfo(orderid,tp);
		} catch (Exception e) {
			e.printStackTrace();
			orderSTR = "";
		}
		
		return orderSTR;
	}

}
