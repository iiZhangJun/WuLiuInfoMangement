package com.icss.dto;

import java.util.Date;

public class OrderBasInfodto {
	
	private String orderid;
	private String state;
	private String statedesc;
	private int stptpointid;
	private String stptname;
	private String stptaddr;
	private String stpttel;
	private int edptpointid;
	private String edptname;
	private String edptaddr;
	private String edpttel;
	
	private String sendname;
	private String sendphone;
	private String sendaddress;
	private Date sendtime;
	private String recvname;
	private String recvphone;
	private String recvaddress;
	private Date recvtime;
	
	private double weight;
	private double safe;
	private double fastcost;
	private double cost;
	
	private String username;
	private Integer userid;
	
	private String joinid;
	
	public String getState() {
		return state;
	}
	
	public String getOrderid() {
		return orderid;
	}
	
	public String getStptname() {
		return stptname;
	}
	
	public String getStptaddr() {
		return stptaddr;
	}
	
	public String getStpttel() {
		return stpttel;
	}
	
	public String getEdptname() {
		return edptname;
	}
	
	public String getEdptaddr() {
		return edptaddr;
	}
	
	public String getEdpttel() {
		return edpttel;
	}

	public Date getSendtime() {
		return sendtime;
	}
	
	public Date getRecvtime() {
		return recvtime;
	}

	public String getStatedesc() {
		return statedesc;
	}

	public void setStatedesc(String statedesc) {
		this.statedesc = statedesc;
	}
	

	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getRecvname() {
		return recvname;
	}

	public void setRecvname(String recvname) {
		this.recvname = recvname;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStptname(String stptname) {
		this.stptname = stptname;
	}

	public void setStptaddr(String stptaddr) {
		this.stptaddr = stptaddr;
	}

	public void setStpttel(String stpttel) {
		this.stpttel = stpttel;
	}

	public void setEdptname(String edptname) {
		this.edptname = edptname;
	}

	public void setEdptaddr(String edptaddr) {
		this.edptaddr = edptaddr;
	}

	public void setEdpttel(String edpttel) {
		this.edpttel = edpttel;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public void setRecvtime(Date recvtime) {
		this.recvtime = recvtime;
	}

	public String getSendphone() {
		return sendphone;
	}

	public void setSendphone(String sendphone) {
		this.sendphone = sendphone;
	}

	public String getSendaddress() {
		return sendaddress;
	}

	public void setSendaddress(String sendaddress) {
		this.sendaddress = sendaddress;
	}

	public String getRecvphone() {
		return recvphone;
	}

	public void setRecvphone(String recvphone) {
		this.recvphone = recvphone;
	}

	public String getRecvaddress() {
		return recvaddress;
	}

	public void setRecvaddress(String recvaddress) {
		this.recvaddress = recvaddress;
	}

	public double getSafe() {
		return safe;
	}

	public void setSafe(double safe) {
		this.safe = safe;
	}

	public double getFastcost() {
		return fastcost;
	}

	public void setFastcost(double fastcost) {
		this.fastcost = fastcost;
	}

	public String getJoinid() {
		return joinid;
	}

	public void setJoinid(String joinid) {
		this.joinid = joinid;
	}

	public int getStptpointid() {
		return stptpointid;
	}

	public void setStptpointid(int stptpointid) {
		this.stptpointid = stptpointid;
	}

	public int getEdptpointid() {
		return edptpointid;
	}

	public void setEdptpointid(int edptpointid) {
		this.edptpointid = edptpointid;
	}
	
}
