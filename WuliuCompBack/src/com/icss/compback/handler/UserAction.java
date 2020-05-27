package com.icss.compback.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.TurnPage;
import com.ciss.wuliu.entity.Tuser;
import com.icss.wuliu.biz.UserBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
public class UserAction {
	
	@Autowired
	private UserBiz userBiz;
	
	
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String uname,String pwd,HttpSession session,Model model){
		String Rbet;
		try {
			Tuser user = userBiz.login(uname, pwd,1);
			if(user != null){
				//若登录成功，将用户放入到session中
				session.setAttribute("user", user);
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
	
	@RequestMapping(value="admin/getUser")
	@ResponseBody
	public String getUser(String roleid,String rows,String page){
		String UserSTR = "";
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			List<Tuser> users = userBiz.getUser(Integer.parseInt(roleid), tp);
			JSONArray jsonArray = JSONArray.fromObject(users);			
			UserSTR = jsonArray.toString();
			UserSTR = JsonUtil.getDatagridJSON(tp.getAllres(),UserSTR);
			System.out.print(UserSTR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return UserSTR;
	}
	
	@RequestMapping(value="admin/addSiteUser")
	@ResponseBody 
	public int addSiteUser(Tuser user,String pointid,String roleid){
		
		int i = 0;
		try {
			i = userBiz.addSiteUser(user, pointid, roleid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="admin/removeUser")
	@ResponseBody 
	public int addSiteUser(String userid){
		
		int i = 0;
		try {
			userBiz.deleteUser(Integer.parseInt(userid));
			i = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
