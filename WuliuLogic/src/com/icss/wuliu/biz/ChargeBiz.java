package com.icss.wuliu.biz;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ciss.wuliu.entity.Tcharge;
import com.ciss.wuliu.entity.Tcity;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.dao.ChargeDao;

@Service("chargeBiz")
@Transactional(readOnly=true)
public class ChargeBiz {
	
	@Autowired
	private ChargeDao chargeDao;
	
	/**
	 * 计算运费，运费算法
	 * @throws Exception 
	 */
	public double calcuCharge(String[] start,String[] end,double weight) throws Exception{
		
		double totalCharge = 0;
		double roadCharge = chargeDao.getRoadCharge(start, end);
		Tcharge tCharge = chargeDao.getStandardCharge(start);
		if(weight <= tCharge.getFirstweight()){
			totalCharge = roadCharge;
		}else{
			double beyond = weight - tCharge.getFirstweight();
			totalCharge = roadCharge +  beyond * tCharge.getSecondweight();
		}
		return totalCharge;
	}
	
	@Transactional(rollbackFor=Throwable.class)
	public void addCharge(String[] city,Tcharge tcharge) throws Exception{
		
		String cityID = chargeDao.getCityID(city);
		tcharge.setTcity(new Tcity(cityID));
		chargeDao.addCharge(tcharge);
	}
	
	
	public String getChargeInfo(String state,TurnPage tp) throws Exception{
		
		List<Tcharge> chargeInfo = chargeDao.getChargeInfo(state,tp);
		 //自定义JsonConfig用于过滤Hibernate配置文件所产生的递归数据  
		 JsonConfig config = new JsonConfig();  
		 config.setExcludes(new String[]{"handler","hibernateLazyInitializer"});  //只要设置这个数组，指定过滤哪些字段。     
		 //组成JSON数组  
		 String chargeSTR = JSONArray.fromObject(chargeInfo,config).toString();
		 
		return chargeSTR;
	}
	
	
	@Transactional(rollbackFor = Throwable.class)
	public void auditCharge(Tcharge tcharge) throws Exception{
		chargeDao.auditCharge(tcharge);
	}
	
	
}
