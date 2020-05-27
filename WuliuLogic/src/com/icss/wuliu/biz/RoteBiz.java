package com.icss.wuliu.biz;



import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Tpoint;
import com.ciss.wuliu.entity.Troad;
import com.ciss.wuliu.entity.Troadwaybypoint;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.wuliu.dao.RoteDao;
import com.icss.wuliu.dao.SiteDao;
import com.icss.wuliu.util.JsonUtil;

@Service
@Transactional(readOnly=true)
public class RoteBiz {
	@Autowired
	private RoteDao roteDao;
	@Autowired
	private SiteDao siteDao;
	
	public List<Troad> getAllRote() throws Exception{
		String startSite = "";
		String endSite = "";
		TurnPage tp = null;
		List<Troad> rotes = roteDao.getAllRote(startSite, endSite, tp);
		return rotes;
	}
	
	
	public String getAllRote(String startSite,String endSite,TurnPage tp) throws Exception{
		
		List<Troad> rotes = roteDao.getAllRote(startSite, endSite, tp);
		
		 //自定义JsonConfig用于过滤Hibernate配置文件所产生的递归数据  
		 JsonConfig config = new JsonConfig();  
		 config.setExcludes(new String[]{"handler","hibernateLazyInitializer"});  //只要设置这个数组，指定过滤哪些字段。     
		 //组成JSON数组  
		String str = JSONArray.fromObject(rotes,config).toString();
		System.out.println(str);	
		return str;
	}
	
	public String getRoteBySite(String roadid) throws Exception{
		String roteSTR;
		List<Tpoint> sites = roteDao.getRoteBySite(roadid);
		 //自定义JsonConfig用于过滤Hibernate配置文件所产生的递归数据  
		 JsonConfig config = new JsonConfig();  
		 config.setExcludes(new String[]{"handler","hibernateLazyInitializer"});  //只要设置这个数组，指定过滤哪些字段。     
		 //组成JSON数组  
		String str = JSONArray.fromObject(sites,config).toString();
		System.out.println(str);	
		roteSTR = JsonUtil.getDatagridJSON(sites.size(),str);
		return roteSTR;
	}
	
	@Transactional(rollbackFor=Throwable.class)
	public void delRote(String roadid) throws Exception{
		roteDao.delRote(roadid);
	}
	
	
	@Transactional(readOnly=false)
	//@Transactional(rollbackFor=Throwable.class)
	public void addNewRote(Troad rote,String[] bySite) throws Exception{
		
		long roteid = roteDao.addNewRote(rote);
		for(int i=0;i<bySite.length;i++){
			Troadwaybypoint byst = new Troadwaybypoint();
			byst.setSequence(i);
			//Tpoint pt = new Tpoint();
			Tpoint pt = siteDao.getOneSite((long)Integer.parseInt(bySite[i]));
			//pt.setPointid((long)Integer.parseInt(bySite[i]));
			byst.setTroad(rote);
			byst.getTroad().setTroadid(roteid);
			byst.setTpoint(pt);
			roteDao.addBySite(byst);
		}
		
	}
	
}
