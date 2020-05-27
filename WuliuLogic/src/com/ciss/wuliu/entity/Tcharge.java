package com.ciss.wuliu.entity;

import java.util.Date;

/**
 * Tcharge entity. @author MyEclipse Persistence Tools
 */

public class Tcharge implements java.io.Serializable {

	// Fields

	private int chargeid;
	private Tcity tcity;
	private Double firstweight;
	private Double firstvol;
	private Double secondweight;
	private Double secondvol;
	private Date starttime;
	private Date endtime;
	private String chargestate = "0";
	private String chargeremarks;
	private String citySTR;
	// Constructors

	/** default constructor */
	public Tcharge() {
	}

	/** minimal constructor */
	public Tcharge(int chargeid) {
		this.chargeid = chargeid;
	}

	/** full constructor */
	public Tcharge(int chargeid, Tcity tcity, Double firstweight,
			Double firstvol, Double secondweight, Double secondvol,
			Date starttime, Date endtime, String chargestate,
			String chargeremarks) {
		this.chargeid = chargeid;
		this.citySTR = tcity.getProvince() + "-" + tcity.getCity() + "-"+ tcity.getDistrict();
		this.firstweight = firstweight;
		this.firstvol = firstvol;
		this.secondweight = secondweight;
		this.secondvol = secondvol;
		this.starttime = starttime;
		this.endtime = endtime;
		if(chargestate.equals("1")){
			this.chargestate = "使用中。。。";
		}else if(chargestate.equals("0")){
			this.chargestate = "待审核。。。";
		}else if(chargestate.equals("-1")){
			this.chargestate = "已废弃。。。";
		}
		this.chargeremarks = chargeremarks;
	}

	// Property accessors

	public int getChargeid() {
		return this.chargeid;
	}

	public void setChargeid(int chargeid) {
		this.chargeid = chargeid;
	}

	public Tcity getTcity() {
		return this.tcity;
	}

	public void setTcity(Tcity tcity) {
		this.tcity = tcity;
	}

	public Double getFirstweight() {
		return this.firstweight;
	}

	public void setFirstweight(Double firstweight) {
		this.firstweight = firstweight;
	}

	public Double getFirstvol() {
		return this.firstvol;
	}

	public void setFirstvol(Double firstvol) {
		this.firstvol = firstvol;
	}

	public Double getSecondweight() {
		return this.secondweight;
	}

	public void setSecondweight(Double secondweight) {
		this.secondweight = secondweight;
	}

	public Double getSecondvol() {
		return this.secondvol;
	}

	public void setSecondvol(Double secondvol) {
		this.secondvol = secondvol;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getChargestate() {
		return this.chargestate;
	}

	public void setChargestate(String chargestate) {
		this.chargestate = chargestate;
	}

	public String getChargeremarks() {
		return this.chargeremarks;
	}

	public void setChargeremarks(String chargeremarks) {
		this.chargeremarks = chargeremarks;
	}

	public String getCitySTR() {
		return citySTR;
	}

	public void setCitySTR(String citySTR) {
		this.citySTR = citySTR;
	}

}