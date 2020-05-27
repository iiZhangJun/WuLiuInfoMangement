package com.icss.compback.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.Troad;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.biz.RoteBiz;
import com.icss.wuliu.biz.SiteBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("admin/")
public class RoteAction {
	
	@Autowired
	private RoteBiz roteBiz;
	@Autowired
	private SiteBiz siteBiz;
	
	@RequestMapping(value="roteManage",method=RequestMethod.GET)
	public String roteManage(Model model){
		String Rbet;
		try {
			List<Tpoint> sites = siteBiz.getAllSite();
			model.addAttribute("points", sites);
			Rbet = "roteManage/roteMag";
		} catch (Exception e) {
			e.printStackTrace();
			Rbet = "error";
		}
		return Rbet;
	}
	
	
	@RequestMapping("getAllRote")
	@ResponseBody
	public String getAllRote(HttpServletRequest request){
		String roteSTR = "";
		String startSite = request.getParameter("startSite");
		String endSite = request.getParameter("endSite");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			roteSTR = roteBiz.getAllRote(startSite,endSite,tp);
			roteSTR = JsonUtil.getDatagridJSON(tp.getAllres(),roteSTR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roteSTR;
	}
	
	@RequestMapping("getRoteBySite")
	@ResponseBody
	public String getRoteBySite(String roadid){
		String roteSTR;
		try {
			roteSTR = roteBiz.getRoteBySite(roadid);
		} catch (Exception e) {
			e.printStackTrace();
			roteSTR = "";
		}
		return roteSTR;
	}
	
	@RequestMapping("delRote")
	@ResponseBody
	public int delRote(String roadid){
		int flag;
		try {
			roteBiz.delRote(roadid);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}
	
	@RequestMapping(value="roteManage",method=RequestMethod.POST)
	@ResponseBody
	public int addNewRote(String endptid,String stptid,Troad rote,String siteids){
		int Rbet;
		System.out.println(stptid);
		System.out.println((long)Integer.parseInt(stptid));
		Tpoint stpt = new Tpoint();
		stpt.setPointid((long)Integer.parseInt(stptid));
		Tpoint endpt = new Tpoint();
		endpt.setPointid((long)Integer.parseInt(endptid));
		rote.setStartpt(stpt);
		rote.setEndpt(endpt);
		String[] bySite = siteids.split(",");
		try {
			roteBiz.addNewRote(rote,bySite);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
			Rbet = 0;
		}
		return Rbet;
	}

}
