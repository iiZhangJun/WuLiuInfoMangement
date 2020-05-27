package com.icss.front.handler;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciss.wuliu.entity.Tcity;
import com.ciss.wuliu.entity.Tgoodstype;
import com.ciss.wuliu.entity.Torder;
import com.ciss.wuliu.entity.Tuser;
import com.icss.wuliu.biz.ChargeBiz;
import com.icss.wuliu.biz.OrderBiz;
import com.icss.wuliu.biz.UserBiz;

@Controller
public class UserAction {
	
	@Autowired
	private UserBiz userBiz;
	@Autowired
	private OrderBiz orderBiz;
	@Autowired
	private ChargeBiz chargeBiz;
	
/*	@RequestMapping(value="user/placeOrder",method=RequestMethod.POST)
	public String placeOrder(Torder order,Model model,HttpServletRequest request){
		String Rbet;
		String oid;
		String goodtypeid = request.getParameter("goodtype");
		Tgoodstype goodtype = new Tgoodstype();
		goodtype.setGoodstypeid(Integer.parseInt(goodtypeid));
		order.setTgoodstype(goodtype);
		
		String[] city1 = request.getParameter("city1").split("-");
		String[] city2 = request.getParameter("city2").split("-");
		
		try {
			String city1ID = orderBiz.getCityID(city1);
			Tcity startct = new Tcity();
			startct.setCityid(city1ID);
			order.setTcityByStartcityid(startct);
			String city2ID = orderBiz.getCityID(city2);
			Tcity endct = new Tcity();
			endct.setCityid(city2ID);
			order.setTcityByEndcityid(endct);
			
			
			double charge = chargeBiz.calcuCharge(city1, city2, order.getWeight());
			order.setCost(charge);
			model.addAttribute("charge", charge);
			order.setState("0");
			
			order = orderBiz.placeOrder(order);
			if(order.getOrderid() != null){
				model.addAttribute("order",order);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String completeTime = sdf.format(order.getSendtime());
				model.addAttribute("completeTime",completeTime);
				model.addAttribute("msg", "����Ԥ���ɹ�,�����ĵȴ�������Աȡ����");
				
				Rbet = "front/placeOrder";
			}else{
				model.addAttribute("errMsg","������ʴ�������ϵ����Ա��");
				Rbet = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg","�����������ϵ����Ա");
			Rbet = "error";
			
		}
		return Rbet;
	}*/
	
	@RequestMapping("indexPage")
	public String indexPage(){
		
		return "front/index";
	}
	
	@RequestMapping("login")
	public String login(String uname,String pwd,HttpSession session,Model model){
		String Rbet;
		try {
			Tuser user = userBiz.login(uname, pwd,3);
			if(user != null){
				//����¼�ɹ������û����뵽session��
				session.setAttribute("user", user);
				Rbet = "front/index";
			}else{
				model.addAttribute("msg", "�û����������");
				Rbet = "login";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "�����쳣");
			Rbet = "error";
		}
		return Rbet;
	}

}
