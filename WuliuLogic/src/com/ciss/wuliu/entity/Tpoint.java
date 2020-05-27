package com.ciss.wuliu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tpoint entity. @author MyEclipse Persistence Tools
 */

public class Tpoint implements java.io.Serializable {

	// Fields

	private long pointid;
	private Tcity tcity;
	private String pointname;
	private String pointaddr;
	private String pointphone;
	private String district;
	private Set troadsForEndpointid = new HashSet(0);
	private Set troadwaybypoints = new HashSet(0);
	private Set troadsForStartpointid = new HashSet(0);
	/*private Set tordersForStartpointid = new HashSet(0);*/
	private Set tjoinsForRecvpointid = new HashSet(0);
	/*private Set tordersForEndpointid = new HashSet(0);*/
	private Set tjoinsForSendpointid = new HashSet(0);
	private Set tusers = new HashSet(0);
	private Set transfers = new HashSet(0);
	private Set tbaseroadsForSendpointid = new HashSet(0);
	private Set tbaseroadsForRecvpointid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tpoint() {
	}

	/** minimal constructor */
	public Tpoint(long pointid) {
		this.pointid = pointid;
	}

	/** full constructor */
	public Tpoint(long pointid, Tcity tcity, String pointname,
			String pointaddr, String pointphone, Set troadsForEndpointid,
			Set troadwaybypoints, Set troadsForStartpointid,
			Set tordersForStartpointid, Set tjoinsForRecvpointid,
			Set tordersForEndpointid, Set tjoinsForSendpointid, Set tusers,
			Set transfers, Set tbaseroadsForSendpointid,
			Set tbaseroadsForRecvpointid) {
		this.pointid = pointid;
		this.tcity = tcity;
		this.pointname = pointname;
		this.pointaddr = pointaddr;
		this.pointphone = pointphone;
		this.troadsForEndpointid = troadsForEndpointid;
		this.troadwaybypoints = troadwaybypoints;
		this.troadsForStartpointid = troadsForStartpointid;
		/*this.tordersForStartpointid = tordersForStartpointid;*/
		this.tjoinsForRecvpointid = tjoinsForRecvpointid;
		/*this.tordersForEndpointid = tordersForEndpointid;*/
		this.tjoinsForSendpointid = tjoinsForSendpointid;
		this.tusers = tusers;
		this.transfers = transfers;
		this.tbaseroadsForSendpointid = tbaseroadsForSendpointid;
		this.tbaseroadsForRecvpointid = tbaseroadsForRecvpointid;
	}

	// Property accessors

	public long getPointid() {
		return this.pointid;
	}

	public void setPointid(long pointid) {
		this.pointid = pointid;
	}

	public Tcity getTcity() {
		return this.tcity;
	}

	public void setTcity(Tcity tcity) {
		this.tcity = tcity;
	}

	public String getPointname() {
		return this.pointname;
	}

	public void setPointname(String pointname) {
		this.pointname = pointname;
	}

	public String getPointaddr() {
		return this.pointaddr;
	}

	public void setPointaddr(String pointaddr) {
		this.pointaddr = pointaddr;
	}

	public String getPointphone() {
		return this.pointphone;
	}

	public void setPointphone(String pointphone) {
		this.pointphone = pointphone;
	}
	
	public Set getTroadsForEndpointid() {
		return this.troadsForEndpointid;
	}

	public void setTroadsForEndpointid(Set troadsForEndpointid) {
		this.troadsForEndpointid = troadsForEndpointid;
	}

	public Set getTroadwaybypoints() {
		return this.troadwaybypoints;
	}

	public void setTroadwaybypoints(Set troadwaybypoints) {
		this.troadwaybypoints = troadwaybypoints;
	}

	public Set getTroadsForStartpointid() {
		return this.troadsForStartpointid;
	}

	public void setTroadsForStartpointid(Set troadsForStartpointid) {
		this.troadsForStartpointid = troadsForStartpointid;
	}

	/*public Set getTordersForStartpointid() {
		return this.tordersForStartpointid;
	}

	public void setTordersForStartpointid(Set tordersForStartpointid) {
		this.tordersForStartpointid = tordersForStartpointid;
	}*/

	public Set getTjoinsForRecvpointid() {
		return this.tjoinsForRecvpointid;
	}

	public void setTjoinsForRecvpointid(Set tjoinsForRecvpointid) {
		this.tjoinsForRecvpointid = tjoinsForRecvpointid;
	}

	/*public Set getTordersForEndpointid() {
		return this.tordersForEndpointid;
	}

	public void setTordersForEndpointid(Set tordersForEndpointid) {
		this.tordersForEndpointid = tordersForEndpointid;
	}*/

	public Set getTjoinsForSendpointid() {
		return this.tjoinsForSendpointid;
	}

	public void setTjoinsForSendpointid(Set tjoinsForSendpointid) {
		this.tjoinsForSendpointid = tjoinsForSendpointid;
	}

	public Set getTusers() {
		return this.tusers;
	}

	public void setTusers(Set tusers) {
		this.tusers = tusers;
	}

	public Set getTransfers() {
		return this.transfers;
	}

	public void setTransfers(Set transfers) {
		this.transfers = transfers;
	}

	public Set getTbaseroadsForSendpointid() {
		return this.tbaseroadsForSendpointid;
	}

	public void setTbaseroadsForSendpointid(Set tbaseroadsForSendpointid) {
		this.tbaseroadsForSendpointid = tbaseroadsForSendpointid;
	}

	public Set getTbaseroadsForRecvpointid() {
		return this.tbaseroadsForRecvpointid;
	}

	public void setTbaseroadsForRecvpointid(Set tbaseroadsForRecvpointid) {
		this.tbaseroadsForRecvpointid = tbaseroadsForRecvpointid;
	}

	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Tpoint(long pointid, Tcity tcity, String pointname,
			String pointaddr, String pointphone) {
		super();
		this.pointid = pointid;
		this.district = tcity.toString();
		this.pointname = pointname;
		this.pointaddr = pointaddr;
		this.pointphone = pointphone;
	}
	
	public Tpoint(long pointid, String pointname){
		this.pointid = pointid;
		this.pointname = pointname;
	}
	
}