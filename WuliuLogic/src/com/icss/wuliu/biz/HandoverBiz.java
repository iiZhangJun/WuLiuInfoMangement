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
				/*������һվ�Ľ��ӵ�*/
				handoverDao.bindOrderAndHandover(joinidendifer,oid);
				/*��¼��ת��Ϣ**/
				handoverDao.bindTransInfo(oid, pointid);
				if(flag.equals("start")){
					/*����״̬�޸�Ϊ����*/
					orderBiz.updateOrderState(oid, "����",-1);
				}
			}
			if(joinids != null){
				/*������һվ�Ľ��ӵ�״̬Ϊ�Ѵ���*/
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
				/*��¼��ת��Ϣ**/
				handoverDao.bindTransInfo(oid, pointid);
				/*����״̬�޸�Ϊ����*/
				orderBiz.updateOrderState(oid, "�ִ�",userid);
			}
			if(joinids != null){
				/*���½��ӵ�״̬Ϊ�Ѵ���*/
				for(String joinid : joinids){
					handoverDao.updateJoinState(joinid);
				}
			}
		}
		
	}
	
	/**
	 * ��ȡ��ת����վ��Ķ�����Ϣ���ٴ�������ת�뽻����Ϣ
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
