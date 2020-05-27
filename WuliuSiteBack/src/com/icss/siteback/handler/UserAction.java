package com.icss.siteback.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.Tuser;
import com.icss.wuliu.biz.UserBiz;

@Controller
public class UserAction {

	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String uname,String pwd,HttpSession session,Model model){
		String Rbet;
		try {
			Tuser user = userBiz.login(uname, pwd,2);
			if(user != null){
				//若登录成功，将用户放入到session中
				session.setAttribute("user", user);
				Tpoint point = user.getTpoint();
				session.setAttribute("point", point);
				Rbet = "main";
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
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		//return "main";
		return "login";
	}
	
	@RequestMapping("siteBack/userInfoMag")
	public String userInfo(HttpSession session,Model model){
		Tuser user = (Tuser) session.getAttribute("user");
		model.addAttribute("user", user);
		Tpoint point = (Tpoint) session.getAttribute("point");
		model.addAttribute("point", point);
		return "userInfoManage/userInfoMag";
	}
	
	@RequestMapping("siteBack/updateUserInfo")
	@ResponseBody
	public int updateUserInfo(Tuser user){
		int i = 0;
		try {
			i = userBiz.updateSiteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
