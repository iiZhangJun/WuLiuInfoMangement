package com.icss.compback.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciss.wuliu.entity.Tcharge;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.biz.ChargeBiz;
import com.icss.wuliu.util.JsonUtil;

@Controller
@RequestMapping("admin")
public class ChargeAction {
	
	@Autowired
	ChargeBiz chargeBiz;
	
	@RequestMapping("chargeManage")
	public String chargeMag(){
		
		return "chargeManage/chargeMag";
	}
	
	@RequestMapping("chargeAudit")
	public String chargeAudit(){
		
		return "chargeManage/chargeAudit";
	}
	
	@RequestMapping("addCharge")
	@ResponseBody
	public int addCharge(Tcharge tcharge,String city,Model model){
		int Rbet = 0;
		String[] ct= city.split("-");
		try {
			chargeBiz.addCharge(ct,tcharge);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Rbet;
	}
	
	@RequestMapping("getChargeInfo")
	@ResponseBody
	public String getChargeInfo(String state,String page,String rows){
		String chargeSTR = "";
		TurnPage tp = new TurnPage();
		tp.setPageNo(Integer.parseInt(page));
		tp.setResnum(Integer.parseInt(rows));
		
		try {
			chargeSTR = chargeBiz.getChargeInfo(state,tp);
			chargeSTR = JsonUtil.getDatagridJSON(tp.getAllres(),chargeSTR);
			System.out.print(chargeSTR);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chargeSTR;
	}
	
	@ResponseBody
	@RequestMapping("auditCharge")
	public int auditCharge(Tcharge tcharge){
		int Rbet = 0;
		try {
			chargeBiz.auditCharge(tcharge);
			Rbet = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Rbet;
	}
	
	
	
}
