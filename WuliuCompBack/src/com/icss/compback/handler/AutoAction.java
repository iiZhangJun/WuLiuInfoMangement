package com.icss.compback.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tauto;
import com.ciss.wuliu.entity.Tcartype;
import com.ciss.wuliu.entity.Tstaff;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.biz.AutoBiz;
import com.icss.wuliu.biz.StaffBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("admin")
public class AutoAction {
	@Autowired
	private AutoBiz autoBiz;
	@Autowired
	private StaffBiz staffBiz;
	
	@RequestMapping("autoTypeManage")
	public String autoTypeMag(){
		
		return "AutoManage/autoTypeMag";
	}
	
	
	@RequestMapping("addNewAutoType")
	@ResponseBody
	public int addNewAutoType(Tcartype autoType){

		int Rbet;
		try {
			autoBiz.addNewAutoType(autoType);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
			Rbet = 0;
		}
		return Rbet;
	}
	
	@RequestMapping("getAutoType")
	@ResponseBody
	public String getAutoType(){
		String autoTypeSTR;
		try {
			List<Tcartype> autoType = autoBiz.getAllAutoType();
			autoTypeSTR = JSONArray.fromObject(autoType).toString();
			autoTypeSTR = JsonUtil.getDatagridJSON(autoType.size(), autoTypeSTR);
			System.out.println(autoTypeSTR);
		} catch (Exception e) {
			e.printStackTrace();
			autoTypeSTR = "";
		}
		return autoTypeSTR;
	}
	
	@RequestMapping("delAutoType")
	@ResponseBody
	public int delAutoType(String cartypeid){
		int flag;
		try {
			autoBiz.delAutoType(cartypeid);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}
	
	
	
	@RequestMapping("autoManage")
	public String autoMag(Model model){
		String Rbet;
		try {
			List<Tcartype> autoType = autoBiz.getAllAutoType();
			model.addAttribute("carType",autoType);
			List<Tstaff> staff = staffBiz.getAllStaff();
			model.addAttribute("staff",staff);
			
			Rbet = "AutoManage/autoMag";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", "网络访问错误，请联系管理员！");
			Rbet = "error";
		}
		return Rbet;
	}
	
	@RequestMapping("addNewAuto")
	@ResponseBody
	public int addNewAutoType(Tauto auto,HttpServletRequest request){
		int Rbet;
		String maindriver = request.getParameter("maindriver");
		String seconddriver = request.getParameter("seconddriver");
		String autoTypeid = request.getParameter("autoType");
		
		Tstaff driver1 = new Tstaff((long)Integer.parseInt(maindriver));
		Tstaff driver2 = new Tstaff((long)Integer.parseInt(seconddriver));
		Tcartype autoType = new Tcartype(autoTypeid);
		
		auto.setDriver1(driver1);
		auto.setDriver2(driver2);
		auto.setTcartype(autoType);
		
		try {
			autoBiz.addNewAuto(auto);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
			Rbet = 0;
		}
		return Rbet;
	}
	
	@RequestMapping("getAutoInfo")
	@ResponseBody
	public String getAutoInfo(String carNum,String page,String rows){
		String autoSTR;
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			autoSTR = autoBiz.getAutoInfo(carNum,tp);
		} catch (Exception e) {
			e.printStackTrace();
			autoSTR = "";
		}
		return autoSTR;
	}
	
	@RequestMapping("delAuto")
	@ResponseBody
	public int delAuto(String carNum){
		int Rbet;
		try {
			autoBiz.delAuto(carNum);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
			Rbet = 0;
		}
		return Rbet;
		
	}

}
