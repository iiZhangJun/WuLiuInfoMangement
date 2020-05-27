package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Torder entity. @author MyEclipse Persistence Tools
 */

public class Torder implements java.io.Serializable {

	// Fields

	private String orderid;
	private Tpoint tpointByEndpointid;
	private String startpointAddr;
	private String endpointAddr;
	private Tcity tcityByEndcityid;
	private Tcity tcityByStartcityid;
	private Tgoodstype tgoodstype;
	private Tpoint tpointByStartpointid;
	private Tstaff tstaff;
	private String staffname;
	private BigDecimal senddelivery;
	private BigDecimal recvdelivery;
	private Date sendtime;
	private Date exptime;
	private Date recvtime;
	private Double safe;
	private Double weight;
	private Double volume;
	private String describe;
	private String sendname;
	private String sendphone;
	private String sendaddress;
	private String recvname;
	private String recvphone;
	private String recvaddress;
	private Integer fast = 0;
	private Double fastcost = (double) 0;
	private Double cost;
	private BigDecimal transfer;
	private String state;
	private String remarks;
	private Set transfers = new HashSet(0);
	private Set torderbyjoins = new HashSet(0);
	private Set texcorders = new HashSet(0);
	private Set tprofitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Torder() {
	}

	/** minimal constructor */
	public Torder(String orderid) {
		this.orderid = orderid;
	}

	/** full constructor */
	public Torder(String orderid, Tpoint tpointByEndpointid,
			Tcity tcityByEndcityid, Tcity tcityByStartcityid,
			Tgoodstype tgoodstype, Tpoint tpointByStartpointid, Tstaff tstaff,
			BigDecimal senddelivery, BigDecimal recvdelivery, Date sendtime,
			Date exptime, Date recvtime, Double safe, Double weight,
			Double volume, String describe, String sendname, String sendphone,
			String sendaddress, String recvname, String recvphone,
			String recvaddress, Integer fast, Double fastcost, Double cost,
			BigDecimal transfer, String state, String remarks, Set transfers,
			Set torderbyjoins, Set texcorders, Set tprofitses) {
		this.orderid = orderid;
		this.tpointByEndpointid = tpointByEndpointid;
		this.tcityByEndcityid = tcityByEndcityid;
		this.tcityByStartcityid = tcityByStartcityid;
		this.tgoodstype = tgoodstype;
		this.tpointByStartpointid = tpointByStartpointid;
		this.tstaff = tstaff;
		this.senddelivery = senddelivery;
		this.recvdelivery = recvdelivery;
		this.sendtime = sendtime;
		this.exptime = exptime;
		this.recvtime = recvtime;
		this.safe = safe;
		this.weight = weight;
		this.volume = volume;
		this.describe = describe;
		this.sendname = sendname;
		this.sendphone = sendphone;
		this.sendaddress = sendaddress;
		this.recvname = recvname;
		this.recvphone = recvphone;
		this.recvaddress = recvaddress;
		this.fast = fast;
		this.fastcost = fastcost;
		this.cost = cost;
		this.transfer = transfer;
		this.state = state;
		this.remarks = remarks;
		this.transfers = transfers;
		this.torderbyjoins = torderbyjoins;
		this.texcorders = texcorders;
		this.tprofitses = tprofitses;
	}

	// Property accessors

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Tpoint getTpointByEndpointid() {
		return this.tpointByEndpointid;
	}

	public void setTpointByEndpointid(Tpoint tpointByEndpointid) {
		this.tpointByEndpointid = tpointByEndpointid;
	}

	public Tcity getTcityByEndcityid() {
		return this.tcityByEndcityid;
	}

	public void setTcityByEndcityid(Tcity tcityByEndcityid) {
		this.tcityByEndcityid = tcityByEndcityid;
	}

	public Tcity getTcityByStartcityid() {
		return this.tcityByStartcityid;
	}

	public void setTcityByStartcityid(Tcity tcityByStartcityid) {
		this.tcityByStartcityid = tcityByStartcityid;
	}

	public Tgoodstype getTgoodstype() {
		return this.tgoodstype;
	}

	public void setTgoodstype(Tgoodstype tgoodstype) {
		this.tgoodstype = tgoodstype;
	}

	public Tpoint getTpointByStartpointid() {
		return this.tpointByStartpointid;
	}

	public void setTpointByStartpointid(Tpoint tpointByStartpointid) {
		this.tpointByStartpointid = tpointByStartpointid;
	}

	public Tstaff getTstaff() {
		return this.tstaff;
	}

	public void setTstaff(Tstaff tstaff) {
		this.tstaff = tstaff;
	}

	public BigDecimal getSenddelivery() {
		return this.senddelivery;
	}

	public void setSenddelivery(BigDecimal senddelivery) {
		this.senddelivery = senddelivery;
	}

	public BigDecimal getRecvdelivery() {
		return this.recvdelivery;
	}

	public void setRecvdelivery(BigDecimal recvdelivery) {
		this.recvdelivery = recvdelivery;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Date getExptime() {
		return this.exptime;
	}

	public void setExptime(Date exptime) {
		this.exptime = exptime;
	}

	public Date getRecvtime() {
		return this.recvtime;
	}

	public void setRecvtime(Date recvtime) {
		this.recvtime = recvtime;
	}

	public Double getSafe() {
		return this.safe;
	}

	public void setSafe(Double safe) {
		this.safe = safe;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getSendname() {
		return this.sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getSendphone() {
		return this.sendphone;
	}

	public void setSendphone(String sendphone) {
		this.sendphone = sendphone;
	}

	public String getSendaddress() {
		return this.sendaddress;
	}

	public void setSendaddress(String sendaddress) {
		this.sendaddress = sendaddress;
	}

	public String getRecvname() {
		return this.recvname;
	}

	public void setRecvname(String recvname) {
		this.recvname = recvname;
	}

	public String getRecvphone() {
		return this.recvphone;
	}

	public void setRecvphone(String recvphone) {
		this.recvphone = recvphone;
	}

	public String getRecvaddress() {
		return this.recvaddress;
	}

	public void setRecvaddress(String recvaddress) {
		this.recvaddress = recvaddress;
	}

	public Integer getFast() {
		return this.fast;
	}

	public void setFast(Integer fast) {
		this.fast = fast;
	}

	public Double getFastcost() {
		return this.fastcost;
	}

	public void setFastcost(Double fastcost) {
		this.fastcost = fastcost;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public BigDecimal getTransfer() {
		return this.transfer;
	}

	public void setTransfer(BigDecimal transfer) {
		this.transfer = transfer;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getTransfers() {
		return this.transfers;
	}

	public void setTransfers(Set transfers) {
		this.transfers = transfers;
	}

	public Set getTorderbyjoins() {
		return this.torderbyjoins;
	}

	public void setTorderbyjoins(Set torderbyjoins) {
		this.torderbyjoins = torderbyjoins;
	}

	public Set getTexcorders() {
		return this.texcorders;
	}

	public void setTexcorders(Set texcorders) {
		this.texcorders = texcorders;
	}

	public Set getTprofitses() {
		return this.tprofitses;
	}

	public void setTprofitses(Set tprofitses) {
		this.tprofitses = tprofitses;
	}
	
	public Torder(String orderid,Tpoint tpointByStartpointid,Tpoint tpointByEndpointid,
					String sendname,String recvname,Tstaff tstaff,Date sendtime){
		this.orderid = orderid;
		this.startpointAddr = tpointByStartpointid.getPointaddr();
		this.endpointAddr = tpointByEndpointid.getPointaddr();
		this.sendname = sendname;
		this.recvname = recvname;
		this.staffname = tstaff.getStaffname();
		this.sendtime = sendtime;
	}
	
	
	
}