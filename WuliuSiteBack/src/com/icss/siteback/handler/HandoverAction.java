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

import com.ciss.wuliu.entity.Tclass;
import com.ciss.wuliu.entity.Tjoin;
import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;
import com.icss.dto.ClassInfodto;
import com.icss.dto.OrderBasInfodto;
import com.icss.wuliu.biz.ClassInfoBiz;
import com.icss.wuliu.biz.HandoverBiz;
import com.icss.wuliu.biz.SiteBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("siteBack")
public class HandoverAction {
	
	@Autowired
	HandoverBiz handoverBiz;
	@Autowired
	SiteBiz siteBiz;
	@Autowired
	ClassInfoBiz classInfoBiz;
	
	/**
	 * 物流发出时生成交接单
	 * @param request
	 * @return
	 */
	@RequestMapping(value="generateHandover")
	@ResponseBody
	public int generateHandover(String flag,HttpServletRequest request){
		
		String id = request.getParameter("ids");
		String[] orderids = id.split(",");
		String classid = request.getParameter("classid");
		String startptid = request.getParameter("startpointid"); 
		String endptid = request.getParameter("endpointid");
		int joinidendifer = 0;
		Tjoin join = new Tjoin();
		try {
			Tclass tclass = classInfoBiz.getTclassById(Integer.parseInt(classid));
			join.setTclass(tclass);
			Tpoint startpt = siteBiz.getSiteById(Integer.parseInt(startptid));
			join.setTpointBySendpointid(startpt);
			Tpoint endpt = siteBiz.getSiteById(Integer.parseInt(endptid));
			join.setTpointByRecvpointid(endpt);
			joinidendifer = handoverBiz.bindHandover(flag,join,orderids,Integer.parseInt(startptid),null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return joinidendifer;
	}
	
	@RequestMapping(value="handoverConfirm",method=RequestMethod.GET)
	public String handoverConfirm(String flag,HttpSession session,Model model){
		
		String path = "";
		if(flag.equals("start")){
			path = "handoverManage/waitOrder";
		}else if(flag.equals("pass")){
			path = "handoverManage/handover";
		}else if(flag.equals("end")){
			path="handoverManage/orderfinish";
		}
		
		Tuser user = (Tuser) session.getAttribute("user");
		Tpoint point = user.getTpoint();
		model.addAttribute("point",point);
		try {
			List<Tpoint> sites = siteBiz.getAllSite();
			model.addAttribute("points", sites);
			List<ClassInfodto> classInfo = classInfoBiz.queryPassClassInfo("",point.getPointid(),null);
			model.addAttribute("classInfo", classInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 获取流转到该站点的订单信息
	 * 
	 */
	@RequestMapping(value="getPassPointOrderInfo")
	@ResponseBody
	public String  getPassPointOrder(String flag,String orderid,String pointid,String page,String rows){
		String orderInfoStr = "";
		
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			List<OrderBasInfodto> orders = handoverBiz.getPassPointOrder(flag,orderid,Integer.parseInt(pointid), tp);
			JSONArray jsonArray = JSONArray.fromObject(orders);			
			String str = jsonArray.toString();
			orderInfoStr = JsonUtil.getDatagridJSON(tp.getAllres(),str);
			System.out.print(orderInfoStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderInfoStr;
	}
	
	/**
	 * 经过某站点时再次生成中转与交接信息，并更新交接单状态
	 */
	@RequestMapping(value="transferHandover")
	@ResponseBody
	public int transferHandover(String flag,HttpServletRequest request){
		
		String id = request.getParameter("ids");
		String[] orderids = id.split(",");
		String[] joinids = request.getParameter("joinids").split(",");
		String classid = request.getParameter("classid");
		String startptid = request.getParameter("startpointid"); 
		String endptid = request.getParameter("endpointid");
		
		int joinidendifer = 0;
		Tjoin join = new Tjoin();
		try {
			Tclass tclass = classInfoBiz.getTclassById(Integer.parseInt(classid));
			join.setTclass(tclass);
			Tpoint startpt = siteBiz.getSiteById(Integer.parseInt(startptid));
			join.setTpointBySendpointid(startpt);
			Tpoint endpt = siteBiz.getSiteById(Integer.parseInt(endptid));
			join.setTpointByRecvpointid(endpt);
			joinidendifer = handoverBiz.bindHandover(flag,join,orderids,Integer.parseInt(startptid),joinids);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return joinidendifer;
	}
	
	/**
	 * 收货点进行收货，更新订单状态为抵达并进行货物配送
	 */
	@RequestMapping(value="finishHandover")
	@ResponseBody
	public int finishHandover(HttpServletRequest request,HttpSession session){
		int flag = 0;
		String id = request.getParameter("ids");
		String[] orderids = id.split(",");
		String[] joinids = request.getParameter("joinids").split(",");
		String endpointid = request.getParameter("endpointid");
		Tuser user = (Tuser) session.getAttribute("user");
		int userid = user.getUserid();
		try {
			handoverBiz.finishHandover(orderids,Integer.parseInt(endpointid),joinids,userid);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping(value="getArrivalOrder")
	@ResponseBody
	public String  getArrivalOrder(String orderid,String pointid,String page,String rows)throws Exception{
		
		String orderInfoStr = "";

		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			List<OrderBasInfodto> orders = handoverBiz.getArrivalOrder(orderid,Integer.parseInt(pointid), tp);
			JSONArray jsonArray = JSONArray.fromObject(orders);			
			String str = jsonArray.toString();
			orderInfoStr = JsonUtil.getDatagridJSON(tp.getAllres(),str);
			System.out.print(orderInfoStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderInfoStr;
	}
	
}
