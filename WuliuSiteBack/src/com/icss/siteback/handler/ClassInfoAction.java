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

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;
import com.icss.dto.ClassInfodto;
import com.icss.wuliu.biz.ClassInfoBiz;

@Controller
@RequestMapping("siteBack")
public class ClassInfoAction {
	
	@Autowired
	private ClassInfoBiz classInfoBiz;

	@RequestMapping(value="queryClass", method=RequestMethod.GET)
	String queryClassInfo(Model model,HttpSession session){
		
		Tuser user = (Tuser) session.getAttribute("user");
		Tpoint point = user.getTpoint();
		model.addAttribute("point",point);
		return "handoverManage/classInfo";
	}
	
	@RequestMapping(value="queryPassClassInfo")
	@ResponseBody
	String queryPassClassInfo(String classid,String pointid,String page,String rows,Model model,HttpSession session){
		
		String ClassInfoSTR = "";
		
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		
		try {
			List<ClassInfodto> classInfo = classInfoBiz.queryPassClassInfo(classid,Integer.parseInt(pointid),tp);
			ClassInfoSTR = JSONArray.fromObject(classInfo).toString();
			System.out.println(ClassInfoSTR);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ClassInfoSTR;
	}
}
