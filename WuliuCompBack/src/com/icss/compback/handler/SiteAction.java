package com.icss.compback.handler;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.biz.CityBiz;
import com.icss.wuliu.biz.SiteBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("admin/")
public class SiteAction {
	
	@Autowired
	private SiteBiz siteBiz;
	
	@Autowired
	private CityBiz cityBiz;
	
	@RequestMapping("siteManage")
	public String SiteManage(Model model){
		
		return "siteManage/siteAdd";
	}
	
	
	@RequestMapping("addNewSite")
	@ResponseBody
	public int addNewSite(Tpoint point){
		int flag = 0;
		String cityname[] = point.getDistrict().split("-");
		try {
			String cityID = cityBiz.getCityID(cityname);
			flag = siteBiz.addNewSite(point,cityID);
		} catch (Exception e) {
			e.printStackTrace();
			flag = 0;
		}
		return flag;
	}
	
	
	
	/**
	 * É¾³ýÅäËÍµã
	 */
	@RequestMapping("delSite")
	@ResponseBody
	public int delOneSite(String pointid){
		int flag = 0;
		try {
			siteBiz.delOneSite(pointid);
			flag = 1;
		} catch (Exception e) {
				/*Âß¼­É¾³ý*/
			
			
		}
		return flag;
	}
	
	/**
	 * ²éÑ¯ÅäËÍµã
	 */
	@RequestMapping(value="getSite")
	@ResponseBody
	public String getSite(String pointid,String page,String rows){
		
		String  siteSTR = "";
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		try {
			String str = siteBiz.getSite(pointid, tp);
			siteSTR = JsonUtil.getDatagridJSON(tp.getAllres(),str);
			System.out.print(siteSTR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return siteSTR;
	}
	
}
