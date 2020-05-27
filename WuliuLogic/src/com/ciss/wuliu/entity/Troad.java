package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Troad entity. @author MyEclipse Persistence Tools
 */

public class Troad implements java.io.Serializable {

	// Fields

	private long troadid;
	private Tpoint startpt;
	private Tpoint endpt;
	private String roadname;
	private Double raodlength;
	private Double raodvalue;
	private String startptname;
	private String endptname;
	private Set tclasses = new HashSet(0);
	private Set troadwaybypoints = new HashSet(0);
	// Constructors

	/** default constructor */
	public Troad() {
	}

	/** minimal constructor */
	public Troad(long troadid) {
		this.troadid = troadid;
	}

	/** full constructor */
	public Troad(long troadid, Tpoint startpt,
			Tpoint endpt, String roadname, Double raodlength,
			Double raodvalue, Set tclasses, Set troadwaybypoints) {
		this.troadid = troadid;
		this.startpt = startpt;
		this.endpt = endpt;
		this.roadname = roadname;
		this.raodlength = raodlength;
		this.raodvalue = raodvalue;
		this.tclasses = tclasses;
		this.troadwaybypoints = troadwaybypoints;
	}

	// Property accessors

	public long getTroadid() {
		return this.troadid;
	}

	public void setTroadid(long troadid) {
		this.troadid = troadid;
	}

	public Tpoint endpt() {
		return this.endpt;
	}

	public void setEndpt(Tpoint endpt) {
		this.endpt = endpt;
	}

	public Tpoint getStartpt() {
		return this.startpt;
	}
	
	public Tpoint getEndpt() {
		return endpt;
	}
	

	public void setStartpt(Tpoint startpt) {
		this.startpt = startpt;
	}

	public String getRoadname() {
		return this.roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public Double getRaodlength() {
		return this.raodlength;
	}

	public void setRaodlength(Double raodlength) {
		this.raodlength = raodlength;
	}

	public Double getRaodvalue() {
		return this.raodvalue;
	}

	public void setRaodvalue(Double raodvalue) {
		this.raodvalue = raodvalue;
	}

	public Set getTclasses() {
		return this.tclasses;
	}

	public void setTclasses(Set tclasses) {
		this.tclasses = tclasses;
	}

	public Set getTroadwaybypoints() {
		return this.troadwaybypoints;
	}

	public void setTroadwaybypoints(Set troadwaybypoints) {
		this.troadwaybypoints = troadwaybypoints;
	}
	
	public String getStartptname() {
		return startptname;
	}

	public void setStartptname(String startptname) {
		this.startptname = startptname;
	}

	public String getEndptname() {
		return endptname;
	}

	public void setEndptname(String endptname) {
		this.endptname = endptname;
	}

	public Troad(long troadid, Tpoint startpt,Tpoint endpt, 
				 String roadname, Double raodlength,Double raodvalue) {
		this.troadid = troadid;
		this.startptname = startpt.getPointname();
		this.endptname = endpt.getPointname();
		this.roadname = roadname;
		this.raodlength = raodlength;
		this.raodvalue = raodvalue;
	}
}