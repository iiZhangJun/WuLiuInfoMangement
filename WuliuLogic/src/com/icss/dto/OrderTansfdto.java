package com.icss.dto;

import java.sql.Timestamp;
import java.util.Date;

public class OrderTansfdto {
	private String transferid;
	private int pointid;
	private String pointname;
	private String pointaddr;
	private String pointphone;
	private Timestamp transferTime;
	public String getTransferid() {
		return transferid;
	}
	public void setTransferid(String transferid) {
		this.transferid = transferid;
	}
	public String getPointname() {
		return pointname;
	}
	public void setPointname(String pointname) {
		this.pointname = pointname;
	}
	public String getPointaddr() {
		return pointaddr;
	}
	public void setPointaddr(String pointaddr) {
		this.pointaddr = pointaddr;
	}
	public String getPointphone() {
		return pointphone;
	}
	public void setPointphone(String pointphone) {
		this.pointphone = pointphone;
	}
	public Timestamp getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Timestamp transferTime) {
		this.transferTime = transferTime;
	}
	public int getPointid() {
		return pointid;
	}
	public void setPointid(int pointid) {
		this.pointid = pointid;
	}
	
}
