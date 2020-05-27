package com.icss.siteback.handler;

import java.util.List;


import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Texcorder;
import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;
import com.icss.wuliu.biz.ExceptBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("siteBack")
public class ExceptAction {
	
	@Autowired
	ExceptBiz excepBiz;
	
	@RequestMapping(value="recordExcepOrder",method=RequestMethod.GET)
	public String recordExcepOrder(){
		
		return "exceptOrder/exceptOrderRecord";
	}
	
	@RequestMapping(value="recordExcepOrder",method=RequestMethod.POST)
	@ResponseBody
	public int recordExcepOrder(String orderid,Texcorder exorder){
		int i = 0;
		try {
			i = excepBiz.recordException(orderid, exorder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="queryExcepOrder",method=RequestMethod.GET)
	public String queryExcepOrder(HttpSession session,Model model){
		Tuser user = (Tuser) session.getAttribute("user");
		Tpoint point = user.getTpoint();
		model.addAttribute("point",point);
		return "exceptOrder/exceptOrderInfo";
	}
	
	@RequestMapping(value="queryExcepOrder",method=RequestMethod.POST)
	@ResponseBody
	public String queryExcepOrder(String rows,String page,String orderid){
		String orderInfoStr = "";

		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			List<Texcorder> orders = excepBiz.queryExcepOrder(tp,orderid);
			JSONArray jsonArray = JSONArray.fromObject(orders);			
			String str = jsonArray.toString();
			orderInfoStr = JsonUtil.getDatagridJSON(tp.getAllres(),str);
			System.out.print(orderInfoStr);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return orderInfoStr;
	}
	
	@RequestMapping(value="updateExcorder")
	@ResponseBody
	public int updateExcorder(Texcorder excorder){
		
		int i = 0;
		try {
			i = excepBiz.updateExcorder(excorder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	

}
