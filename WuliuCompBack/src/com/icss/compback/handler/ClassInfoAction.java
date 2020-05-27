package com.icss.compback.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tauto;
import com.ciss.wuliu.entity.Tclass;
import com.ciss.wuliu.entity.Troad;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.biz.AutoBiz;
import com.icss.wuliu.biz.ClassInfoBiz;
import com.icss.wuliu.biz.RoteBiz;
import com.icss.wuliu.util.JsonUtil;


@Controller
@RequestMapping("admin")
public class ClassInfoAction {
	
	@Autowired
	ClassInfoBiz classInfoBiz;
	
	@Autowired
	AutoBiz autoBiz;
	
	@Autowired
	RoteBiz roteBiz;
	
	@RequestMapping("classInfoManage")
	public String classInfoMag(Model model){
		String Rbet = "";
		try {
			List<Tauto> autos = autoBiz.getAllAuto();
			model.addAttribute("autoMobiles", autos);
			List<Troad> rotes = roteBiz.getAllRote();
			model.addAttribute("roads", rotes);
			
			Rbet = "classManage/classInfoMag";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "网络访问错误，请联系管理员！");
			Rbet = "error";
		}
		return Rbet;
	}
	
	@RequestMapping("addClassInfo")
	@ResponseBody
	public int addClassInfo(Tclass tclass,Model model,HttpServletRequest request){
		int Rbet = 0;
		try {
			String autoId = request.getParameter("cars");
			String roteId = request.getParameter("rotes");
			tclass.setTroad(new Troad(Long.parseLong(roteId)));
			tclass.setTauto(new Tauto(autoId));
			classInfoBiz.addClassInfo(tclass);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Rbet;
	}
	
	
	@RequestMapping("getClassInfo")
	@ResponseBody
	public String getClassInfo(String page,String rows,Model model,HttpServletRequest request){
		
		String  classInfoSTR = "";
		String startSite = request.getParameter("beginSite");
		String endSite = request.getParameter("endSite");
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			String str = classInfoBiz.getClassInfo(startSite,endSite,tp);
			classInfoSTR = JsonUtil.getDatagridJSON(tp.getAllres(),str);
			System.out.print(classInfoSTR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classInfoSTR;
	}
	
	
}
