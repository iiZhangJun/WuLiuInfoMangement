package com.icss.wuliu.biz;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciss.wuliu.entity.Tjoin;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.OrderBasInfodto;
import com.icss.wuliu.dao.HandoverDao;

@Service("handoverBiz")
@Transactional(readOnly=true)
public class HandoverBiz {
	
	@Autowired 
	HandoverDao handoverDao;
	@Autowired
	OrderBiz orderBiz;
	
	@Transactional(rollbackFor = Throwable.class)
	public int bindHandover(String flag,Tjoin join,String[] orderids,long pointid,String[] joinids) throws Exception{
		
		int joinidendifer =  handoverDao.createHandover(join);
		if(orderids.length > 0){
			for(String oid :orderids){
				/*生成下一站的交接单*/
				handoverDao.bindOrderAndHandover(joinidendifer,oid);
				/*记录中转信息**/
				handoverDao.bindTransInfo(oid, pointid);
				if(flag.equals("start")){
					/*订单状态修改为发出*/
					orderBiz.updateOrderState(oid, "发出",-1);
				}
			}
			if(joinids != null){
				/*更新上一站的交接单状态为已处理*/
				for(String joinid : joinids){
					handoverDao.updateJoinState(joinid);
				}
			}
		}
		
		return joinidendifer;
	}
	
	@Transactional(rollbackFor = Throwable.class)
	public void finishHandover(String[] orderids,long pointid,String[] joinids,int userid) throws Exception{
		if(orderids.length > 0){
			for(String oid :orderids){
				/*记录中转信息**/
				handoverDao.bindTransInfo(oid, pointid);
				/*订单状态修改为发出*/
				orderBiz.updateOrderState(oid, "抵达",userid);
			}
			if(joinids != null){
				/*更新交接单状态为已处理*/
				for(String joinid : joinids){
					handoverDao.updateJoinState(joinid);
				}
			}
		}
		
	}
	
	/**
	 * 获取流转到该站点的订单信息，再次生成中转与交接信息
	 * @param orderid
	 * @param pointid
	 * @return
	 * @throws Exception
	 */
	public List<OrderBasInfodto>  getPassPointOrder(String flag,String orderid,long pointid,TurnPage tp)throws Exception{
		
		return handoverDao.getPassPointOrder(flag,orderid, pointid,tp);
	}
	
	/**
	 * 
	 */
	public List<OrderBasInfodto>  getArrivalOrder(String orderid,long pointid,TurnPage tp)throws Exception{
		
		return handoverDao.getArrivalOrder(orderid, pointid,tp);
	}
	
	
	
}
