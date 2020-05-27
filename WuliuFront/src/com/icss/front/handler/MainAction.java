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
			//�Ȳ�ѯ����״̬
			List<OrderBasInfodto> baseOrders = orderBiz.queryOrderState(orderid);
			OrderBasInfodto basOrder = new OrderBasInfodto();
			List<OrderTansfdto> transInfo = null;
			if(baseOrders != null && baseOrders.size() > 0){
				basOrder = baseOrders.get(0);
				String orderState = basOrder.getState();
				if(orderState.contains("���")){
					basOrder.setStatedesc("���Ķ�����ʱû��������Ϣ��");
				}else if(orderState.contains("���")){
					basOrder.setStatedesc("���������ȴ�������");
				}else if(orderState.contains("����")){
					basOrder.setStatedesc("������...");
					transInfo = orderBiz.queryOrder(orderid);
				}else if(basOrder.getState().equals("�ִ�")){
					basOrder.setStatedesc("������...");
					transInfo = orderBiz.queryOrder(orderid);
				}else if(orderState.contains("��ǩ��")){
					basOrder.setStatedesc("��ǩ��...");
					transInfo = orderBiz.queryOrder(orderid);
				}else if(orderState.contains("�쳣")){
					basOrder.setStatedesc("�쳣");
					transInfo = orderBiz.queryOrder(orderid);
				}
			}else{
				model.addAttribute("message", "������Ķ�����Ų����ڣ���˶���ȷ���������룡");
			}
			
			model.addAttribute("baseOrder", basOrder);
			model.addAttribute("transInfo", transInfo);
			Rbet = "front/queryOrder";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "�����쳣�����Ժ����ԣ�");
			Rbet = "error";
		}
		return Rbet;
	}

	
	
	@RequestMapping(value="CalcuCharge",method=RequestMethod.POST)
	public String calcuCharge(String city1,String city2,double weight,Model model){
		String Rbet;
		//�Ȳ�ѯcity1�����շѱ�׼�����ж�weight�Ƿ�������������ۣ�
		//��weight<���������ټ�����룬��������������Ȩֵ����
		
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
			model.addAttribute("errMsg", "������ʴ���");
			Rbet = "error";
		}
		return Rbet;
	}
	
	
}
