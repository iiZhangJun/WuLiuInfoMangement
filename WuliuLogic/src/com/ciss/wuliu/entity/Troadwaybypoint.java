package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Troadwaybypoint entity. @author MyEclipse Persistence Tools
 */

public class Troadwaybypoint implements java.io.Serializable {

	// Fields

	private long waypassid;
	private Tpoint tpoint;
	private Troad troad;
	private int sequence;
	private Set tclasstimes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Troadwaybypoint() {
	}

	/** minimal constructor */
	public Troadwaybypoint(long waypassid) {
		this.waypassid = waypassid;
	}

	/** full constructor */
	public Troadwaybypoint(long waypassid, Tpoint tpoint, Troad troad,
			int sequence, Set tclasstimes) {
		this.waypassid = waypassid;
		this.tpoint = tpoint;
		this.troad = troad;
		this.sequence = sequence;
		this.tclasstimes = tclasstimes;
	}

	// Property accessors

	public long getWaypassid() {
		return this.waypassid;
	}

	public void setWaypassid(long waypassid) {
		this.waypassid = waypassid;
	}

	public Tpoint getTpoint() {
		return this.tpoint;
	}

	public void setTpoint(Tpoint tpoint) {
		this.tpoint = tpoint;
	}

	public Troad getTroad() {
		return this.troad;
	}

	public void setTroad(Troad troad) {
		this.troad = troad;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int i) {
		this.sequence = i;
	}

	public Set getTclasstimes() {
		return this.tclasstimes;
	}

	public void setTclasstimes(Set tclasstimes) {
		this.tclasstimes = tclasstimes;
	}
	
	public Troadwaybypoint(Tpoint point){
		this.tpoint = point;
	}
	
}