package com.ciss.wuliu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tclass entity. @author MyEclipse Persistence Tools
 */

public class Tclass implements java.io.Serializable {

	// Fields

	private Integer tclassid;
	private Troad troad;
	private Tauto tauto;
	private Date tclassstarttime;
	private Date tclassendtime;
	private String tclassstate;
	private String classremarks;
	private Set tjoins = new HashSet(0);
	private Set tclasstimes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tclass() {
	}

	/** minimal constructor */
	public Tclass(Integer tclassid) {
		this.tclassid = tclassid;
	}

	/** full constructor */
	public Tclass(Integer tclassid, Troad troad, Tauto tauto,
			Date tclassstarttime, Date tclassendtime, String tclassstate,
			String classremarks, Set tjoins, Set tclasstimes) {
		this.tclassid = tclassid;
		this.troad = troad;
		this.tauto = tauto;
		this.tclassstarttime = tclassstarttime;
		this.tclassendtime = tclassendtime;
		this.tclassstate = tclassstate;
		this.classremarks = classremarks;
		this.tjoins = tjoins;
		this.tclasstimes = tclasstimes;
	}

	// Property accessors

	public Integer getTclassid() {
		return this.tclassid;
	}

	public void setTclassid(Integer tclassid) {
		this.tclassid = tclassid;
	}

	public Troad getTroad() {
		return this.troad;
	}

	public void setTroad(Troad troad) {
		this.troad = troad;
	}

	public Tauto getTauto() {
		return this.tauto;
	}

	public void setTauto(Tauto tauto) {
		this.tauto = tauto;
	}

	public Date getTclassstarttime() {
		return this.tclassstarttime;
	}

	public void setTclassstarttime(Date tclassstarttime) {
		this.tclassstarttime = tclassstarttime;
	}

	public Date getTclassendtime() {
		return this.tclassendtime;
	}

	public void setTclassendtime(Date tclassendtime) {
		this.tclassendtime = tclassendtime;
	}

	public String getTclassstate() {
		return this.tclassstate;
	}

	public void setTclassstate(String tclassstate) {
		this.tclassstate = tclassstate;
	}

	public String getClassremarks() {
		return this.classremarks;
	}

	public void setClassremarks(String classremarks) {
		this.classremarks = classremarks;
	}

	public Set getTjoins() {
		return this.tjoins;
	}

	public void setTjoins(Set tjoins) {
		this.tjoins = tjoins;
	}

	public Set getTclasstimes() {
		return this.tclasstimes;
	}

	public void setTclasstimes(Set tclasstimes) {
		this.tclasstimes = tclasstimes;
	}

}