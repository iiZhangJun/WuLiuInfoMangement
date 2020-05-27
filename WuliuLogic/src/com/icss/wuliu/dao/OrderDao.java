package com.icss.wuliu.dao;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Torder;
import com.ciss.wuliu.entity.TurnPage;
import com.icss.dto.OrderBasInfodto;
import com.icss.dto.OrderTansfdto;

@Repository("orderDao")
public class OrderDao extends BaseDao{
	
	
	@SuppressWarnings("unchecked")
	public List<OrderBasInfodto> getOrderInfo(String orderid,TurnPage tp) throws Exception{
		String sql = "Select o.ORDERID orderid,stpt.POINTNAME stptname,endpt.POINTNAME edptname,"
				   + " o.WEIGHT  weight,o.SENDNAME sendname,o.RECVTIME  recvtime,o.SENDTIME sendtime,"
				   + " o.RECVNAME recvname,o.COST cost,o.STATE state,"
				   + " u.username username,stpt.POINTADDR stptaddr,endpt.POINTADDR edptaddr From TORDER o"
				   + " Inner Join TPOINT stpt On stpt.POINTID = o.STARTPOINTID"
				   + " Inner Join TPOINT endpt On o.ENDPOINTID = endpt.POINTID"
				   + " Left Join TUSER u On u.userid = o.MAILING";
		Session session = this.findSession();
		if(!orderid.equals("")){
			sql = sql + " where o.orderid='" + orderid + "'";
		}else{
			sql = sql + " order by o.SENDTIME DESC";
		}
		SQLQuery q = session.createSQLQuery(sql);
		q.addScalar("orderid",Hibernate.STRING);
		q.addScalar("stptname",Hibernate.STRING);
		q.addScalar("edptname",Hibernate.STRING);
		q.addScalar("weight",Hibernate.DOUBLE);
		q.addScalar("sendname",Hibernate.STRING);
		q.addScalar("recvtime",Hibernate.TIMESTAMP);
		q.addScalar("sendtime",Hibernate.TIMESTAMP);
		q.addScalar("recvname",Hibernate.STRING);
		q.addScalar("cost",Hibernate.DOUBLE);
		q.addScalar("state",Hibernate.STRING);
		q.addScalar("username",Hibernate.STRING);
		q.addScalar("stptaddr",Hibernate.STRING);
		q.addScalar("edptaddr",Hibernate.STRING);
		q.setResultTransformer(Transformers.aliasToBean(OrderBasInfodto.class));
		tp.setAllres(q.list().size());
		q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
		q.setMaxResults(tp.getResnum());
		
		return q.list();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<OrderTansfdto> queryOrder(String orderid) throws Exception{
		String sql = "Select trsf.transferTime,tp.pointid,tp.POINTNAME pointname,tp.POINTADDR pointaddr,"
				   + "tp.POINTPHONE pointphone,trsf.TRANSFERID transferid From TRANSFER trsf"
				   + " Inner Join TPOINT tp On trsf.POINTID = tp.POINTID"
				   + " where trsf.orderid=? order by trsf.transferTime";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, orderid);
		q.addScalar("transferid",Hibernate.STRING);
		q.addScalar("pointid",Hibernate.INTEGER);
		q.addScalar("pointname",Hibernate.STRING);
		q.addScalar("pointaddr",Hibernate.STRING);
		q.addScalar("pointphone",Hibernate.STRING);
		q.addScalar("transferTime",Hibernate.TIMESTAMP);
		q.setResultTransformer(Transformers.aliasToBean(OrderTansfdto.class));
		
		return q.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrderBasInfodto> queryOrderState(String orderid) throws Exception{
		
		String sql = "Select tod.STATE state,edpt.POINTNAME edptname,edpt.POINTADDR edptaddr,edpt.POINTPHONE edpttel,"
				   + "tod.ORDERID orderid,stpt.POINTNAME stptname,stpt.POINTADDR stptaddr,stpt.POINTPHONE stpttel,"
				   + "tod.SENDTIME sendtime,tod.RECVTIME recvtime, edpt.pointid edptpointid,stpt.pointid stptpointid From TORDER tod"
				   + " Inner Join TPOINT stpt On tod.STARTPOINTID = stpt.POINTID"
				   + " Inner Join TPOINT edpt On tod.ENDPOINTID = edpt.POINTID"
				   + " where tod.orderid = '" + orderid + "'";
		
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		
		q.addScalar("state", Hibernate.STRING);
		q.addScalar("edptname",Hibernate.STRING);
		q.addScalar("edptaddr",Hibernate.STRING);
		q.addScalar("edpttel",Hibernate.STRING);
		q.addScalar("orderid", Hibernate.STRING);
		q.addScalar("stptname",Hibernate.STRING);
		q.addScalar("stptaddr",Hibernate.STRING);
		q.addScalar("stpttel",Hibernate.STRING);
		q.addScalar("sendtime",Hibernate.DATE);
		q.addScalar("recvtime",Hibernate.DATE);
		q.addScalar("edptpointid",Hibernate.INTEGER);
		q.addScalar("stptpointid",Hibernate.INTEGER);
		q.setResultTransformer(Transformers.aliasToBean(OrderBasInfodto.class));
		return q.list();
	}
	
	
	/**
	 * 用户下单
	 */
	public Torder placeOrder(Torder order)throws Exception{

		String oid = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		oid = sdf.format(new Date().getTime());
		order.setOrderid(oid);
		String sql = "insert into torder(ORDERID,GOODSTYPEID,STARTCITYID,ENDCITYID,SENDTIME,WEIGHT," +
				"SAFE,DESCRIBE,SENDNAME,SENDPHONE,SENDADDRESS,RECVNAME,RECVPHONE,RECVADDRESS," +
				"FAST,FASTCOST,COST,STATE,REMARKS,EXPTIME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, oid);
		q.setInteger(1, order.getTgoodstype().getGoodstypeid());
		q.setString(2, order.getTcityByStartcityid().getCityid());
		q.setString(3, order.getTcityByEndcityid().getCity());
		q.setTimestamp(4, new Date());
		order.setSendtime(new Date());
		q.setDouble(5, order.getWeight());
		q.setDouble(6, order.getSafe());
		q.setString(7, order.getDescribe());
		q.setString(8, order.getSendname());
		q.setString(9, order.getSendphone());
		q.setString(10, order.getSendaddress());
		q.setString(11, order.getRecvname());
		q.setString(12, order.getRecvphone());
		q.setString(13, order.getRecvaddress());
		q.setInteger(14, order.getFast());
		if(order.getFast() == 1){
			double fastcost = order.getCost()/3;
			q.setDouble(15, fastcost);
			order.setFastcost(fastcost);
			double cost = order.getCost() + fastcost;
			q.setDouble(16,cost);
			order.setCost(cost);
		}else{
			q.setDouble(15, 0);
			order.setFastcost(0.0);
			q.setDouble(16, order.getCost());
		}
		
		q.setString(17,order.getState());
		q.setString(18, order.getRemarks());
		q.setTimestamp(19, order.getExptime());
		q.executeUpdate();
		
		return order;
	}
	
	/**
	 * 更新订单状态
	 * @param orderid
	 * @param state
	 * @return
	 * @throws Exception 
	 */
	public int updateOrderState(String orderid,String state,int userid) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currtime = sdf.format(new Date());
		Session session = this.findSession();
		String sql = "";
		if(state.equals("已签收")){
			sql = "update torder set state = '" + state + "',recvtime = '" + currtime + "' where orderid = '" + orderid + "'";
		}else if(state.equals("抵达")){
			sql = "update torder set state = '" + state + "',mailing = " + userid + " where orderid = '" + orderid + "'";
		}else{
			sql = "update torder set state = '" + state + "' where orderid = '" + orderid + "'";
		}
		SQLQuery q = session.createSQLQuery(sql);
		int i = q.executeUpdate();
		return i;
	}
	
	/*public int updateOrderSendOrRecvTime(String orderid,String state) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currtime = sdf.format(new Date());
		String sql = "";
		Session session = this.findSession();
		if(state.equals("发出")){
			sql = "update torder set state = '" + state + "',sendtime = '" + currtime + "' where orderid = '" + orderid + "'";
		}else if(state.equals("已签收")){
			sql = "update torder set state = '" + state + "',recvtime = '" + currtime + "' where orderid = '" + orderid + "'";
		}else{
			
		}
		SQLQuery q = session.createSQLQuery(sql);
		int i = q.executeUpdate();
		return i;
	}*/
	
	
	/**
	 * 修改订单信息
	 * @param order
	 * @throws Exception
	 */
	public void updateOrder(Torder order) throws Exception{
		
		Session session = this.findSession();
		Torder od = (Torder) session.get(Torder.class, order.getOrderid());
		od.setRecvphone(order.getRecvphone());
		od.setSendphone(order.getSendphone());
		od.setState(order.getState());
		od.setCost(order.getCost());
		session.saveOrUpdate(od);
		session.flush();
	}
	
	/**
	 * 用户在配送点下单
	 * @return
	 * @throws Exception
	 */
	public Torder makeOrder(Torder order) throws Exception{
		
		Session session = this.findSession();
		
		String oid = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		oid = sdf.format(new Date().getTime());
		order.setOrderid(oid);
		session.saveOrUpdate(order.getTpointByStartpointid());
		session.save(order);
		session.flush();
		return order;
		
		/* insert 
		    into
		        WULIU.TORDER
		        (ENDPOINTID, ENDCITYID, STARTCITYID, GOODSTYPEID, STARTPOINTID, MAILING, SENDDELIVERY, RECVDELIVERY, SENDTIME, EXPTIME, RECVTIME, SAFE, WEIGHT, VOLUME, DESCRIB, SENDNAME, SENDPHONE, SENDADDRESS, RECVNAME, RECVPHONE, RECVADDRESS, FAST, FASTCOST, COST, TRANSFER, STATE, REMARKS, ORDERID) 
		    values
		        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)*/
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrderBasInfodto> queryOrderById(String orderid) throws Exception{
		
		String sql = "Select o.ORDERID orderid,o.SENDNAME sendname,o.sendphone,o.sendaddress,"
				   + "o.recvname,o.recvphone,o.recvaddress, o.WEIGHT weight,o.cost,"
				   + "o.fastcost,o.safe,o.state From TORDER o"
				   + " Inner Join TPOINT stpt On stpt.POINTID = o.STARTPOINTID"
				   + " where o.orderid like '%" + orderid + "%'";
		
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);		
		
		q.addScalar("orderid",Hibernate.STRING);
		
		q.addScalar("sendname",Hibernate.STRING);
		q.addScalar("recvname",Hibernate.STRING);
		q.addScalar("sendphone",Hibernate.STRING);
		q.addScalar("recvphone",Hibernate.STRING);
		q.addScalar("sendaddress",Hibernate.STRING);
		q.addScalar("recvaddress",Hibernate.STRING);
		
		q.addScalar("weight",Hibernate.DOUBLE);
		q.addScalar("cost",Hibernate.DOUBLE);
		q.addScalar("fastcost",Hibernate.DOUBLE);
		q.addScalar("safe",Hibernate.DOUBLE);
		q.addScalar("state",Hibernate.STRING);
		
		q.setResultTransformer(Transformers.aliasToBean(OrderBasInfodto.class));
		
		return q.list();
	}
	
	
	
}
