package com.icss.wuliu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ciss.wuliu.entity.Tcharge;
import com.ciss.wuliu.entity.TurnPage;

@Repository("chargeDao")
public class ChargeDao extends BaseDao{
	
	
	/**
	 * 获得首尾城区id,找到相应线路，查出权值
	 */
	public	String  getCityID(String[] city) throws Exception{
		String sql = "select cityid from tcity where province like ? and city like ? and district like ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, "%" + city[0] + "%");
		q.setString(1, "%" + city[1] + "%");
		q.setString(2, "%" + city[2] + "%");
		q.addScalar("cityid",Hibernate.STRING);
		//q.setResultTransformer(Transformers.aliasToBean(String.class));
		return (String) q.list().get(0);
	}
	
	/**
	 * 获得首尾配送点id,找到相应线路，查出权值
	 */
	@SuppressWarnings("unchecked")
	public List<String> getPointID(String cityID) throws Exception{
		String sql = "select pointid from tpoint where cityid = ?";
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setString(0, cityID);
		q.addScalar("pointid",Hibernate.STRING);
		//q.setResultTransformer(Transformers.aliasToBean(String.class));
		return (List<String>) q.list();
	}
	
	
	/**
	 * 按始发地与终点路线查询出运费，即权值
	 */
	public double getRoadCharge(String[] start,String[] end) throws Exception{
		
		String startCity = getCityID(start);
		String endCity = getCityID(end);
		List<String> startPoint = getPointID(startCity);
		List<String> endPoint = getPointID(endCity);
		String startpt = "(";
		for(int i=0;i<startPoint.size();i++){
			if(i==startPoint.size()-1){
				startpt += startPoint.get(i) + ")";
			}else{
				startpt += startPoint.get(i) + ",";
			}
		}
		
		String endpt = "(";
		for(int i=0;i<endPoint.size();i++){
			
			if(i==endPoint.size()-1){
				endpt += endPoint.get(i) + ")";
			}else{
				endpt += endPoint.get(i) + ",";
			}
		}
		String sql = "select raodvalue from troad where startpointid in " + startpt + " and endpointid in " + endpt;
		Session session = this.findSession();
		SQLQuery q = session.createSQLQuery(sql);
		//q.setString(0, startpt);
		//q.setString(1, endpt);
	    //q.uniqueResult();
		q.addScalar("raodvalue", Hibernate.DOUBLE);
		//q.setResultTransformer(Transformers.aliasToBean(Double.class));
		return (Double) q.list().get(0);
	}
	
	
	/**
	 * 查询始发地运费标准
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Tcharge getStandardCharge(String[] start) throws Exception{
		
		String cityID = getCityID(start);
		Tcharge tcharge = null;
		String hql = "from Tcharge tch where tch.tcity.cityid = ?";
		Session session = this.findSession();
		Query q = session.createQuery(hql);
		q.setString(0, cityID);
		List<Tcharge> tcharges = q.list();
		if(tcharges.size()>0){
			tcharge = tcharges.get(0);
		}
		return tcharge;
	}
	
	/**
	 * 配送费添加
	 * @param tcharge
	 * @throws Exception
	 */
	public void addCharge(Tcharge tcharge) throws Exception{
		
		Session session = this.findSession();
		session.save(tcharge);
		session.flush();
	}
	/**
	 * 配送费查询
	 * @param state
	 * @param tp
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Tcharge> getChargeInfo(String state,TurnPage tp) throws Exception{
		
		String hql = "select new Tcharge (c.chargeid, c.tcity,c.firstweight,c.firstvol,c.secondweight,c.secondvol,c.starttime,c.endtime,c.chargestate,c.chargeremarks) From Tcharge c";
		Session session = this.findSession();
		if (state != null && !state.equals("")) {
			hql += " where c.chargestate = ?";
		}else{
			hql += " where c.chargestate in('-1','0','1')";
		}
		Query q = session.createQuery(hql);
		if(state != null && !state.equals("")){
			q.setParameter(0, state);
		}
		tp.setAllres(q.list().size());
		q.setFirstResult((tp.getPageNo()-1)*tp.getResnum());
		q.setMaxResults(tp.getResnum());
		return q.list();
	}
	
	/**
	 * 配送费审核、更新
	 * @param tcharge
	 * @return
	 * @throws Exception 
	 */
	public void auditCharge(Tcharge tcharge) throws Exception{
		
		Session session = this.findSession();
		Tcharge charge = (Tcharge) session.get(Tcharge.class, tcharge.getChargeid());
		charge.setChargestate(tcharge.getChargestate());
		if(tcharge.getChargestate().equals("1")){
			charge.setStarttime(new Date());
		}else if(tcharge.getChargestate().equals("-1")){
			charge.setEndtime(new Date());
		}
		session.update(charge);
		session.flush();
	}
	
	
}
