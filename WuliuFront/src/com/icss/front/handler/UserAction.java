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
				model.addAttribute("msg", "订单预定成功,请耐心等待配送人员取件！");
				
				Rbet = "front/placeOrder";
			}else{
				model.addAttribute("errMsg","网络访问错误，请联系管理员！");
				Rbet = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg","网络出错，请联系管理员");
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
				//若登录成功，将用户放入到session中
				session.setAttribute("user", user);
				Rbet = "front/index";
			}else{
				model.addAttribute("msg", "用户名密码错误");
				Rbet = "login";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "网络异常");
			Rbet = "error";
		}
		return Rbet;
	}

}
