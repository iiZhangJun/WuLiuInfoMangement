package com.icss.compback.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciss.wuliu.entity.Tpoint;
import com.icss.wuliu.biz.SiteBiz;

@Controller
@RequestMapping("admin")
public class AuthorityAction {
	
	@Autowired
	SiteBiz siteBiz;
	
	@RequestMapping(value="authorityMange")
	public String authorityMange(Model model){
		
		try {
			List<Tpoint> sites = siteBiz.getAllSite();
			model.addAttribute("points", sites);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "authorityManage/authorityMag";
	}
}
