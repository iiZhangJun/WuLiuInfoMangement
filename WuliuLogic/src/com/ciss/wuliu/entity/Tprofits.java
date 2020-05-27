package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Tprofits entity. @author MyEclipse Persistence Tools
 */

public class Tprofits implements java.io.Serializable {

	// Fields

	private BigDecimal profitsid;
	private Torder torder;
	private BigDecimal allprofits;
	private Double sendprofits;
	private Double companyprofits;
	private Double recvprofits;
	private Date gettime;
	private String profitsremarks;

	// Constructors

	/** default constructor */
	public Tprofits() {
	}

	/** minimal constructor */
	public Tprofits(BigDecimal profitsid) {
		this.profitsid = profitsid;
	}

	/** full constructor */
	public Tprofits(BigDecimal profitsid, Torder torder, BigDecimal allprofits,
			Double sendprofits, Double companyprofits, Double recvprofits,
			Date gettime, String profitsremarks) {
		this.profitsid = profitsid;
		this.torder = torder;
		this.allprofits = allprofits;
		this.sendprofits = sendprofits;
		this.companyprofits = companyprofits;
		this.recvprofits = recvprofits;
		this.gettime = gettime;
		this.profitsremarks = profitsremarks;
	}

	// Property accessors

	public BigDecimal getProfitsid() {
		return this.profitsid;
	}

	public void setProfitsid(BigDecimal profitsid) {
		this.profitsid = profitsid;
	}

	public Torder getTorder() {
		return this.torder;
	}

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

	public BigDecimal getAllprofits() {
		return this.allprofits;
	}

	public void setAllprofits(BigDecimal allprofits) {
		this.allprofits = allprofits;
	}

	public Double getSendprofits() {
		return this.sendprofits;
	}

	public void setSendprofits(Double sendprofits) {
		this.sendprofits = sendprofits;
	}

	public Double getCompanyprofits() {
		return this.companyprofits;
	}

	public void setCompanyprofits(Double companyprofits) {
		this.companyprofits = companyprofits;
	}

	public Double getRecvprofits() {
		return this.recvprofits;
	}

	public void setRecvprofits(Double recvprofits) {
		this.recvprofits = recvprofits;
	}

	public Date getGettime() {
		return this.gettime;
	}

	public void setGettime(Date gettime) {
		this.gettime = gettime;
	}

	public String getProfitsremarks() {
		return this.profitsremarks;
	}

	public void setProfitsremarks(String profitsremarks) {
		this.profitsremarks = profitsremarks;
	}

}