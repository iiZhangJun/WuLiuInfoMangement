package com.icss.wuliu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tjoin;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.OrderBasInfodto;

@Repository("handoverDao")
public class HandoverDao extends BaseDao{
	
	/**
	 * ���ɽ��ӵ�
	 * @param sendpointid
	 * @param recvpointid
	 * @param classid
	 * @return
	 * @throws Exception
	 */
	public int createHandover(Tjoin join) throws Exception{
		
		Session session = this.findSession();
		session.save(join);
		session.flush();
		int joinid =  (Integer) session.getIdentifier(join);
		return joinid;
	}
	
	/**
	 * �������뽻�ӵ���
	 */
	public void bindOrderAndHandover(int joinid,String orderid) throws Exception{
		
		Session session = this.findSession();
		
		String sql = "insert into torderbyjoin(joinid,orderid) values(?,?)";
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, joinid);
		q.setParameter(1, orderid);
		q.executeUpdate();
		session.flush();
	}
	
	public void updateJoinState(String joinid) throws Exception{
		
		Session session = this.findSession();
		
		String sql = "update tjoin set joinstate = '�Ѵ���' where joinid = " + joinid;
		SQLQuery q = session.createSQLQuery(sql);
		q.executeUpdate();
		session.flush();
	}
	
	/**
	 * ���붩����ת��Ϣ
	 * @throws Exception 
	 */
	public void bindTransInfo(String orderid, long pointid) throws Exception{
		
		Session session = this.findSession();
		String sql = "insert into transfer(orderid,pointid,transferTime) values(?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, orderid);
		q.setParameter(1, pointid);
		q.setParameter(2, sdf.format(new Date()));
		q.executeUpdate();
		session.flush();
	}
	
	/**
	 * ��ȡ��ת����վ��Ķ�����Ϣ���ٴ�������ת�뽻����Ϣ
	 * @param orderid
	 * @param pointid
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<OrderBasInfodto> getPassPointOrder(String flag,String orderid,long pointid,TurnPage tp) throws Exception{
		
		Session session = this.findSession();
		String sql = "SELECT o.orderid,j.joinid,o.sendname,o.sendphone,o.sendaddress,o.cost,o.fastcost,o.safe,o.recvname,o.recvphone,o.recvaddress"
				   + " FROM torder o INNER JOIN torderbyjoin oj ON o.orderid=oj.orderid" 
				   + " INNER JOIN tjoin j ON j.joinid = oj.joinid "
				   + " where j.recvpointid = " + pointid + " and j.joinstate ='δ����' and o.orderid like '%" + orderid + "%'";
		if(flag.equals("pass")){
			sql += " and o.endpointid !=" + pointid ;
		}else if(flag.equals("end")){
			sql += " and o.endpointid =" + pointid ;
		}
		SQLQuery q = session.createSQLQuery(sql);
		q.addScalar("orderid",Hibernate.STRING);
		q.addScalar("joinid",Hibernate.STRING);
		q.addScalar("sendname",Hibernate.STRING);
		q.addScalar("sendphone",Hibernate.STRING);
		q.addScalar("sendaddress",Hibernate.STRING);
		q.addScalar("recvname",Hibernate.STRING);
		q.addScalar("recvphone",Hibernate.STRING);
		q.addScalar("recvaddress",Hibernate.STRING);
		q.addScalar("cost",Hibernate.DOUBLE);
		q.addScalar("fastcost",Hibernate.DOUBLE);
		q.addScalar("safe",Hibernate.DOUBLE);
		
		q.setResultTransformer(Transformers.aliasToBean(OrderBasInfodto.class));
		if(tp != null){
			tp.setAllres(q.list().size());
			q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
			q.setMaxResults(tp.getResnum());
		}
		
		return q.list();
	}
	
	/**
	 * �����������ɵĶ��������¶���״̬Ϊ���
	 */
	@SuppressWarnings("unchecked")
	public List<OrderBasInfodto> getArrivalOrder(String orderid,long pointid,TurnPage tp) throws Exception{
		
		//String sql = "SELECT o.orderid,o.sendname,o.sendphone,o.sendaddress,o.cost,o.fastcost,o.safe,o.recvname,o.recvphone,o.recvaddress FROM torder o where o.endpointid = " + pointid + " and o.state = '�ִ�'";
		String sql = "SELECT o.orderid,o.sendname,o.sendphone,o.sendaddress,o.cost,o.fastcost,o.safe,o.recvname,o.recvphone,o.recvaddress,o.state FROM torder o where o.orderid like '%" + orderid + "%' and o.endpointid = " + pointid + " and o.state = '�ִ�'";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		
		q.addScalar("orderid",Hibernate.STRING);
		
		q.addScalar("sendname",Hibernate.STRING);
		q.addScalar("sendphone",Hibernate.STRING);
		q.addScalar("sendaddress",Hibernate.STRING);
		q.addScalar("recvname",Hibernate.STRING);
		q.addScalar("recvphone",Hibernate.STRING);
		q.addScalar("recvaddress",Hibernate.STRING);
		q.addScalar("cost",Hibernate.DOUBLE);
		q.addScalar("fastcost",Hibernate.DOUBLE);
		q.addScalar("safe",Hibernate.DOUBLE);
		q.addScalar("state",Hibernate.STRING);
		
		q.setResultTransformer(Transformers.aliasToBean(OrderBasInfodto.class));
		if(tp != null){
			tp.setAllres(q.list().size());
			q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
			q.setMaxResults(tp.getResnum());
		}
		return q.list();
	}
	
	
	
}
