package com.icss.front.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icss.dto.OrderBasInfodto;
import com.icss.dto.OrderTansfdto;
import com.icss.wuliu.biz.ChargeBiz;
import com.icss.wuliu.biz.OrderBiz;

@Controller
public class MainAction {

	@Autowired
	private ChargeBiz chargeBiz;
	@Autowired
	private OrderBiz orderBiz;
	
	@RequestMapping("main")
	public String goFront(){
		return "front/index";
	}
	
	@RequestMapping(value="calcuCharge",method=RequestMethod.GET)
	public String calcuCharge(){
		return "front/calcuCharge";
	}
	
	
	
	@RequestMapping(value="queryOrder",method=RequestMethod.GET)
	public String queryOrder(){
		return "front/queryOrder";
	}

	
	@RequestMapping(value="queryOrder",method=RequestMethod.POST)
	public String queryOrder(String orderid,Model model){
		String Rbet;
		try {
			//先查询订单状态
			List<OrderBasInfodto> baseOrders = orderBiz.queryOrderState(orderid);
			OrderBasInfodto basOrder = new OrderBasInfodto();
			List<OrderTansfdto> transInfo = null;
			if(baseOrders != null && baseOrders.size() > 0){
				basOrder = baseOrders.get(0);
				String orderState = basOrder.getState();
				if(orderState.contains("审核")){
					basOrder.setStatedesc("您的订单暂时没有物流信息！");
				}else if(orderState.contains("入库")){
					basOrder.setStatedesc("已揽件，等待发出！");
				}else if(orderState.contains("发出")){
					basOrder.setStatedesc("运送中...");
					transInfo = orderBiz.queryOrder(orderid);
				}else if(basOrder.getState().equals("抵达")){
					basOrder.setStatedesc("配送中...");
					transInfo = orderBiz.queryOrder(orderid);
				}else if(orderState.contains("已签收")){
					basOrder.setStatedesc("已签收...");
					transInfo = orderBiz.queryOrder(orderid);
				}else if(orderState.contains("异常")){
					basOrder.setStatedesc("异常");
					transInfo = orderBiz.queryOrder(orderid);
				}
			}else{
				model.addAttribute("message", "您输入的订单编号不存在，请核对正确后重新输入！");
			}
			
			model.addAttribute("baseOrder", basOrder);
			model.addAttribute("transInfo", transInfo);
			Rbet = "front/queryOrder";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "网络异常，请稍后重试！");
			Rbet = "error";
		}
		return Rbet;
	}

	
	
	@RequestMapping(value="CalcuCharge",method=RequestMethod.POST)
	public String calcuCharge(String city1,String city2,double weight,Model model){
		String Rbet;
		//先查询city1处的收费标准，并判断weight是否大于首重量单价，
		//若weight<首重量，再计算距离，根据两点间距离与权值计算
		
		String[] start= city1.split("-");
		String[] end= city2.split("-");
		try {
			double charge = chargeBiz.calcuCharge(start, end, weight);
			model.addAttribute("city1", city1);
			model.addAttribute("city2", city2);
			model.addAttribute("weight", weight);
			model.addAttribute("charge", charge);
			Rbet = "front/calcuCharge";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "网络访问错误");
			Rbet = "error";
		}
		return Rbet;
	}
	
	
}
