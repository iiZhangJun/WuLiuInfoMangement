package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Transfer entity. @author MyEclipse Persistence Tools
 */

public class Transfer implements java.io.Serializable {

	// Fields

	private int transferid;
	private Tpoint tpoint;
	private Torder torder;
	private int sequence;
	private Date transferTime;
	// Constructors

	/** default constructor */
	public Transfer() {
	}

	/** minimal constructor */
	public Transfer(int transferid) {
		this.transferid = transferid;
	}

	/** full constructor */
	public Transfer(int transferid, Tpoint tpoint, Torder torder,
			int sequence) {
		this.transferid = transferid;
		this.tpoint = tpoint;
		this.torder = torder;
		this.sequence = sequence;
	}

	// Property accessors

	public int getTransferid() {
		return this.transferid;
	}

	public void setTransferid(int transferid) {
		this.transferid = transferid;
	}

	public Tpoint getTpoint() {
		return this.tpoint;
	}

	public void setTpoint(Tpoint tpoint) {
		this.tpoint = tpoint;
	}

	public Torder getTorder() {
		return this.torder;
	}

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Date getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
	}
	
}