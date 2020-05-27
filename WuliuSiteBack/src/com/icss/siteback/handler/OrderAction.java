package com.icss.siteback.handler;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tgoodstype;
import com.ciss.wuliu.entity.Torder;
import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;
import com.icss.dto.OrderBasInfodto;
import com.icss.wuliu.biz.GoodTypeBiz;
import com.icss.wuliu.biz.OrderBiz;
import com.icss.wuliu.biz.SiteBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("siteBack")
public class OrderAction {
	
	@Autowired
	private SiteBiz siteBiz;
	@Autowired
	private OrderBiz orderBiz;
	@Autowired
	private GoodTypeBiz goodTypeBiz;
	
	@RequestMapping(value="makeOrder", method=RequestMethod.GET)
	String makeOrder(HttpServletRequest request,HttpSession session,Model model){

		try {
			Tuser user = (Tuser) session.getAttribute("user");
			Tpoint point = user.getTpoint();
			model.addAttribute("point",point);
			List <Tgoodstype> goodsType = goodTypeBiz.getGoodType();
			List<Tpoint> sites = siteBiz.getAllSite();
			model.addAttribute("points", sites);
			model.addAttribute("goodtype", goodsType);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "orderManage/makeOrder";
	}
	
	@RequestMapping(value="updateOrderState", method=RequestMethod.GET)
	String updateOrder(HttpSession session,Model model){
		Tuser user = (Tuser) session.getAttribute("user");
		Tpoint point = user.getTpoint();
		model.addAttribute("point",point);
		return "orderManage/updateOrder";
	}
	
	@RequestMapping(value="orderReceipt", method=RequestMethod.GET)
	String changeOrderState(HttpSession session,Model model){
		Tuser user = (Tuser) session.getAttribute("user");
		Tpoint point = user.getTpoint();
		model.addAttribute("point",point);
		return "orderManage/receiptOrder";
	}
	
	@RequestMapping(value="checkOrder", method=RequestMethod.GET)
	String checkOrder(String state,Model model,HttpSession session){
		String path = "";
		Tuser user = (Tuser) session.getAttribute("user");
		Tpoint point = user.getTpoint();
		model.addAttribute("point",point);
		if(state.equals("审核")){
			path = "orderManage/checkOrder";
		}else if(state.equals("确认")){
			path = "orderManage/finishOrder";
		}
		return path;
	}
	
	
	@RequestMapping(value="queryOrderState")
	@ResponseBody
	String queryOrderById(String orderid){
		String str = "";
		try {
			List<OrderBasInfodto> oderInfo = orderBiz.queryOrderById(orderid);
			JSONArray jsonArray = JSONArray.fromObject(oderInfo);				
			str = jsonArray.toString();
			str = JsonUtil.getDatagridJSON(oderInfo.size(),str);
			System.out.println(str);	
			
		} catch (Exception e) {
			str = "";
			e.printStackTrace();
		}
		
		return str;
	}
	
	@RequestMapping(value="makeOrder", method=RequestMethod.POST)
	@ResponseBody
	String makeOrder(Torder order,Model model,HttpServletRequest request){

		try {
			String goodtypeid = request.getParameter("goodsTypeId");
			String startptid = request.getParameter("stptid");
			String endptid = request.getParameter("edptid");
			
			Tgoodstype goodtype = new Tgoodstype();
			goodtype.setGoodstypeid(Integer.parseInt(goodtypeid));
			order.setTgoodstype(goodtype);
			
			Tpoint startpt = siteBiz.getSiteById(Integer.parseInt(startptid));
			order.setTpointByStartpointid(startpt);
			
			if(endptid != null && !endptid.equals("")){
				Tpoint endpt = siteBiz.getSiteById(Integer.parseInt(endptid));
				order.setTpointByEndpointid(endpt);
			}
			
			order = orderBiz.makeOrder(order);
			if(order != null){
				model.addAttribute("order",order);
				model.addAttribute("good", order.getTgoodstype());
				if(order.getTpointByEndpointid() != null){
					model.addAttribute("endpoint", order.getTpointByEndpointid());
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "下单成功，单号为 -- " + order.getOrderid();
	}
	
	@RequestMapping(value="queryOrderOnSite")
	@ResponseBody
	String queryOrderOnSite(String flag,String pointid,String state,Model model,String page,String rows){
		
		String  orderOnsiteSTR = "";
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			List<OrderBasInfodto> orders = siteBiz.getOrderOnSite(flag,pointid, state, tp);
			JSONArray jsonArray = JSONArray.fromObject(orders);			
			String str = jsonArray.toString();
			/*str = JsonUtil.getDatagridJSON(1,str);*/
			orderOnsiteSTR = JsonUtil.getDatagridJSON(tp.getAllres(),str);
			System.out.print(orderOnsiteSTR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderOnsiteSTR;
	}
	
	
	@RequestMapping(value="updateOrderState", method=RequestMethod.POST)
	@ResponseBody
	int updateOrderState(String orderid,String state){
		int flag = 0;
		try {
			flag = orderBiz.updateOrderState(orderid, state,-1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@RequestMapping(value="updateOrder", method=RequestMethod.POST)
	@ResponseBody
	int updateOrder(Torder order){
		int flag = 0;
		try {
			orderBiz.updateOrder(order);
			flag = 1;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping(value="receiptOrder")
	@ResponseBody
	int receiptOrder(HttpServletRequest request,String state){
		
		int flag = 0;
		String id = request.getParameter("ids");
		String[] orderids = id.split(",");
		try {
			if(orderids != null){
				for(String oid : orderids){
					orderBiz.updateOrderState(oid, state,-1);
				}
			}
			flag = 1;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
