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
	 * �������վ��
	 * SiteBiz.java
	 * @throws Exception 
	 */
	@Transactional(rollbackFor=Throwable.class)
	public int addNewSite(Tpoint point,String cityID) throws Exception{
		return siteDao.addNewSite(point,cityID);
	}
	
	/**
	 * ɾ�����͵�	
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void delOneSite(String pointid) throws Exception{
		
		siteDao.delOneSite(pointid);
	}
	
	/**
	 * ��ѯ����վ��
	 */
	public String getSite(String pointName,TurnPage tp) throws Exception{
		String str;
		List<Tpoint> sites = siteDao.getSite(pointName,tp);
		 //�Զ���JsonConfig���ڹ���Hibernate�����ļ��������ĵݹ�����  
		 JsonConfig config = new JsonConfig();  
		 config.setExcludes(new String[]{"handler","hibernateLazyInitializer"});  //ֻҪ����������飬ָ��������Щ�ֶΡ�     
		 //���JSON����  
		 str = JSONArray.fromObject(sites,config).toString();  
		return str;
	}
	/**
	 * ������е����͵�id������
	 * TODO
	 * SiteBiz.java
	 */
	public List<Tpoint> getAllSite() throws Exception{
		
		List<Tpoint> sites = siteDao.getAllSite();
		return sites;
	}
	
	/**
	 * ����id��ȡ���͵�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Tpoint getSiteById(long id) throws Exception{
		
		return siteDao.getSiteById(id);
	}
	
	/**���͵��ѯ��Ӧ����*/
	public List<OrderBasInfodto> getOrderOnSite(String flag,String siteid,String state,TurnPage tp)throws Exception{
		
		List<OrderBasInfodto> orders = siteDao.getOrderOnSite(flag,siteid, state, tp);
		return orders;
	}
	
}
