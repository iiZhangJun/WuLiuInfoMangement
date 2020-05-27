package com.icss.wuliu.biz;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Tauto;
import com.ciss.wuliu.entity.Tcartype;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.dao.AutoDao;
import com.icss.wuliu.util.JsonUtil;

@Service
@Transactional(readOnly=true)
public class AutoBiz {
	@Autowired
	private AutoDao autoDao;
	
	
	@Transactional(rollbackFor=Throwable.class)
	public void addNewAutoType(Tcartype autoType) throws Exception{
		
		autoDao.addNewAutoType(autoType);
	}
	
	@Transactional(rollbackFor=Throwable.class)
	public void delAutoType(String cartypeid) throws Exception{
		
		autoDao. delAutoType(cartypeid);
	}
	
	public List<Tcartype> getAllAutoType() throws Exception{
		
		List<Tcartype> autoType = autoDao.getAllAutoType();
		return autoType;
	}
	
	public List<Tauto> getAllAuto()throws Exception{
		String carNum = "";
		TurnPage tp = null;
		List<Tauto> autos = autoDao.getAutoInfo(carNum, tp);
		return autos;
	}
	
	@Transactional(rollbackFor=Throwable.class)
	public void addNewAuto(Tauto auto) throws Exception{
		
		autoDao. addAuto(auto);
	}
	
	public String getAutoInfo(String carNum,TurnPage tp) throws Exception{
		
		List<Tauto> auto = autoDao.getAutoInfo(carNum, tp);
		String autoSTR = JSONArray.fromObject(auto).toString();
		autoSTR = JsonUtil.getDatagridJSON(auto.size(), autoSTR);
		System.out.println(autoSTR);
		return autoSTR;
	}
	
	@Transactional(rollbackFor=Throwable.class)
	public void delAuto(String carNum) throws Exception{
		
		autoDao.delAuto(carNum);
	}
	
}
