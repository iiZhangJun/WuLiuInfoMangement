package com.ciss.wuliu.entity;

import java.math.BigDecimal;

/**
 * Torderbyjoin entity. @author MyEclipse Persistence Tools
 */

public class Torderbyjoin implements java.io.Serializable {

	// Fields

	private BigDecimal orderbyjoinid;
	private Tjoin tjoin;
	private Torder torder;

	// Constructors

	/** default constructor */
	public Torderbyjoin() {
	}

	/** minimal constructor */
	public Torderbyjoin(BigDecimal orderbyjoinid) {
		this.orderbyjoinid = orderbyjoinid;
	}

	/** full constructor */
	public Torderbyjoin(BigDecimal orderbyjoinid, Tjoin tjoin, Torder torder) {
		this.orderbyjoinid = orderbyjoinid;
		this.tjoin = tjoin;
		this.torder = torder;
	}

	// Property accessors

	public BigDecimal getOrderbyjoinid() {
		return this.orderbyjoinid;
	}

	public void setOrderbyjoinid(BigDecimal orderbyjoinid) {
		this.orderbyjoinid = orderbyjoinid;
	}

	public Tjoin getTjoin() {
		return this.tjoin;
	}

	public void setTjoin(Tjoin tjoin) {
		this.tjoin = tjoin;
	}

	public Torder getTorder() {
		return this.torder;
	}

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

}