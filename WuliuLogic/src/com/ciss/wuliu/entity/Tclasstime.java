package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Tclasstime entity. @author MyEclipse Persistence Tools
 */

public class Tclasstime implements java.io.Serializable {

	// Fields

	private BigDecimal tclasstimeid;
	private Tclass tclass;
	private Troadwaybypoint troadwaybypoint;
	private Date cometime;
	private Date gotime;

	// Constructors

	/** default constructor */
	public Tclasstime() {
	}

	/** minimal constructor */
	public Tclasstime(BigDecimal tclasstimeid) {
		this.tclasstimeid = tclasstimeid;
	}

	/** full constructor */
	public Tclasstime(BigDecimal tclasstimeid, Tclass tclass,
			Troadwaybypoint troadwaybypoint, Date cometime, Date gotime) {
		this.tclasstimeid = tclasstimeid;
		this.tclass = tclass;
		this.troadwaybypoint = troadwaybypoint;
		this.cometime = cometime;
		this.gotime = gotime;
	}

	// Property accessors

	public BigDecimal getTclasstimeid() {
		return this.tclasstimeid;
	}

	public void setTclasstimeid(BigDecimal tclasstimeid) {
		this.tclasstimeid = tclasstimeid;
	}

	public Tclass getTclass() {
		return this.tclass;
	}

	public void setTclass(Tclass tclass) {
		this.tclass = tclass;
	}

	public Troadwaybypoint getTroadwaybypoint() {
		return this.troadwaybypoint;
	}

	public void setTroadwaybypoint(Troadwaybypoint troadwaybypoint) {
		this.troadwaybypoint = troadwaybypoint;
	}

	public Date getCometime() {
		return this.cometime;
	}

	public void setCometime(Date cometime) {
		this.cometime = cometime;
	}

	public Date getGotime() {
		return this.gotime;
	}

	public void setGotime(Date gotime) {
		this.gotime = gotime;
	}

}