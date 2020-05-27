package com.ciss.wuliu.entity;

import java.math.BigDecimal;

/**
 * Tbaseroad entity. @author MyEclipse Persistence Tools
 */

public class Tbaseroad implements java.io.Serializable {

	// Fields

	private BigDecimal baseid;
	private Tpoint tpointByRecvpointid;
	private Tpoint tpointBySendpointid;
	private String basename;
	private Double basevalue;
	private Double lenght;

	// Constructors

	/** default constructor */
	public Tbaseroad() {
	}

	/** minimal constructor */
	public Tbaseroad(BigDecimal baseid) {
		this.baseid = baseid;
	}

	/** full constructor */
	public Tbaseroad(BigDecimal baseid, Tpoint tpointByRecvpointid,
			Tpoint tpointBySendpointid, String basename, Double basevalue,
			Double lenght) {
		this.baseid = baseid;
		this.tpointByRecvpointid = tpointByRecvpointid;
		this.tpointBySendpointid = tpointBySendpointid;
		this.basename = basename;
		this.basevalue = basevalue;
		this.lenght = lenght;
	}

	// Property accessors

	public BigDecimal getBaseid() {
		return this.baseid;
	}

	public void setBaseid(BigDecimal baseid) {
		this.baseid = baseid;
	}

	public Tpoint getTpointByRecvpointid() {
		return this.tpointByRecvpointid;
	}

	public void setTpointByRecvpointid(Tpoint tpointByRecvpointid) {
		this.tpointByRecvpointid = tpointByRecvpointid;
	}

	public Tpoint getTpointBySendpointid() {
		return this.tpointBySendpointid;
	}

	public void setTpointBySendpointid(Tpoint tpointBySendpointid) {
		this.tpointBySendpointid = tpointBySendpointid;
	}

	public String getBasename() {
		return this.basename;
	}

	public void setBasename(String basename) {
		this.basename = basename;
	}

	public Double getBasevalue() {
		return this.basevalue;
	}

	public void setBasevalue(Double basevalue) {
		this.basevalue = basevalue;
	}

	public Double getLenght() {
		return this.lenght;
	}

	public void setLenght(Double lenght) {
		this.lenght = lenght;
	}

}