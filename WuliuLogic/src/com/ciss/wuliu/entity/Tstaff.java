package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Tstaff entity. @author MyEclipse Persistence Tools
 */

public class Tstaff implements java.io.Serializable {

	// Fields

	private long staffid;
	private String staffname;
	private String staffpost;
	private String staffphone;
	private Set torders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tstaff() {
	}

	/** minimal constructor */
	public Tstaff(long staffid) {
		this.staffid = staffid;
	}

	/** full constructor */
	public Tstaff(long staffid, String staffname, String staffpost,
			String staffphone, Set torders) {
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffpost = staffpost;
		this.staffphone = staffphone;
		this.torders = torders;
	}

	// Property accessors

	public long getStaffid() {
		return this.staffid;
	}

	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}

	public String getStaffname() {
		return this.staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getStaffpost() {
		return this.staffpost;
	}

	public void setStaffpost(String staffpost) {
		this.staffpost = staffpost;
	}

	public String getStaffphone() {
		return this.staffphone;
	}

	public void setStaffphone(String staffphone) {
		this.staffphone = staffphone;
	}

	public Set getTorders() {
		return this.torders;
	}

	public void setTorders(Set torders) {
		this.torders = torders;
	}
	
	public Tstaff(long staffid,String staffname){
		this.staffid = staffid;
		this.staffname = staffname;
	}
	
}