package com.icss.dto;

import java.util.Date;

public class ClassInfodto {
	
	private String  sp1;
	private String ep1;
	private long troadid;
	private int tclassid;
	private Date tclassstarttime;
	private Date tclassendtime;
	private String tclassstate;
	private String classremarks;
	private String autoid;
	private String driver1;
	private String driver2;
	private String roadname;
	private float raodlength;
	public String getSp1() {
		return sp1;
	}
	public void setSp1(String sp1) {
		this.sp1 = sp1;
	}
	public String getEp1() {
		return ep1;
	}
	public void setEp1(String ep1) {
		this.ep1 = ep1;
	}
	public long getTroadid() {
		return troadid;
	}
	public void setTroadid(long troadid) {
		this.troadid = troadid;
	}
	public int getTclassid() {
		return tclassid;
	}
	public void setTclassid(int tclassid) {
		this.tclassid = tclassid;
	}
	public Date getTclassstarttime() {
		return tclassstarttime;
	}
	public void setTclassstarttime(Date tclassstarttime) {
		this.tclassstarttime = tclassstarttime;
	}
	public Date getTclassendtime() {
		return tclassendtime;
	}
	public void setTclassendtime(Date tclassendtime) {
		this.tclassendtime = tclassendtime;
	}
	public String getTclassstate() {
		return tclassstate;
	}
	public void setTclassstate(String tclassstate) {
		this.tclassstate = tclassstate;
	}
	public String getAutoid() {
		return autoid;
	}
	public void setAutoid(String autoid) {
		this.autoid = autoid;
	}
	public String getDriver1() {
		return driver1;
	}
	public void setDriver1(String driver1) {
		this.driver1 = driver1;
	}
	public String getDriver2() {
		return driver2;
	}
	public void setDriver2(String driver2) {
		this.driver2 = driver2;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	public float getRaodlength() {
		return raodlength;
	}
	public void setRaodlength(float raodlength) {
		this.raodlength = raodlength;
	}
	public String getClassremarks() {
		return classremarks;
	}
	public void setClassremarks(String classremarks) {
		this.classremarks = classremarks;
	}
}
