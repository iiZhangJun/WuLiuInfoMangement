package com.icss.wuliu.biz;

import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.TurnPage;

import com.icss.dto.OrderBasInfodto;
import com.icss.wuliu.dao.SiteDao;

@Service
@Transactional(readOnly=true)
public class SiteBiz {
	@Autowired
	private SiteDao siteDao;
	
	
	/**
	 * 添加配送站点
	 * SiteBiz.java
	 * @throws Exception 
	 */
	@Transactional(rollbackFor=Throwable.class)
	public int addNewSite(Tpoint point,String cityID) throws Exception{
		return siteDao.addNewSite(point,cityID);
	}
	
	/**
	 * 删除配送点	
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void delOneSite(String pointid) throws Exception{
		
		siteDao.delOneSite(pointid);
	}
	
	/**
	 * 查询配送站点
	 */
	public String getSite(String pointName,TurnPage tp) throws Exception{
		String str;
		List<Tpoint> sites = siteDao.getSite(pointName,tp);
		 //自定义JsonConfig用于过滤Hibernate配置文件所产生的递归数据  
		 JsonConfig config = new JsonConfig();  
		 config.setExcludes(new String[]{"handler","hibernateLazyInitializer"});  //只要设置这个数组，指定过滤哪些字段。     
		 //组成JSON数组  
		 str = JSONArray.fromObject(sites,config).toString();  
		return str;
	}
	/**
	 * 获得所有的配送点id及名称
	 * TODO
	 * SiteBiz.java
	 */
	public List<Tpoint> getAllSite() throws Exception{
		
		List<Tpoint> sites = siteDao.getAllSite();
		return sites;
	}
	
	/**
	 * 根据id获取配送点
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Tpoint getSiteById(long id) throws Exception{
		
		return siteDao.getSiteById(id);
	}
	
	/**配送点查询对应订单*/
	public List<OrderBasInfodto> getOrderOnSite(String flag,String siteid,String state,TurnPage tp)throws Exception{
		
		List<OrderBasInfodto> orders = siteDao.getOrderOnSite(flag,siteid, state, tp);
		return orders;
	}
	
}
