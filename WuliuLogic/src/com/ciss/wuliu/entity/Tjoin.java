package com.ciss.wuliu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tjoin entity. @author MyEclipse Persistence Tools
 */

public class Tjoin implements java.io.Serializable {

	// Fields

	private int joinid;
	private Tclass tclass;
	private Tpoint tpointByRecvpointid;
	private Tpoint tpointBySendpointid;
	private Double joinvol;
	private Double joinweight;
	private Date joinsendtime;
	private Date joinexptime;
	private Date joinrecvtime;
	private String joinstate="Œ¥¥¶¿Ì";
	private Set torderbyjoins = new HashSet(0);
	private Set texcorders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tjoin() {
	}

	/** minimal constructor */
	public Tjoin(int joinid) {
		this.joinid = joinid;
	}

	/** full constructor */
	public Tjoin(int joinid, Tclass tclass, Tpoint tpointByRecvpointid,
			Tpoint tpointBySendpointid, Double joinvol, Double joinweight,
			Date joinsendtime, Date joinexptime, Date joinrecvtime,
			Set torderbyjoins, Set texcorders) {
		this.joinid = joinid;
		this.tclass = tclass;
		this.tpointByRecvpointid = tpointByRecvpointid;
		this.tpointBySendpointid = tpointBySendpointid;
		this.joinvol = joinvol;
		this.joinweight = joinweight;
		this.joinsendtime = joinsendtime;
		this.joinexptime = joinexptime;
		this.joinrecvtime = joinrecvtime;
		this.torderbyjoins = torderbyjoins;
		this.texcorders = texcorders;
	}

	// Property accessors

	public int getJoinid() {
		return this.joinid;
	}

	public void setJoinid(int joinid) {
		this.joinid = joinid;
	}

	public Tclass getTclass() {
		return this.tclass;
	}

	public void setTclass(Tclass tclass) {
		this.tclass = tclass;
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

	public Double getJoinvol() {
		return this.joinvol;
	}

	public void setJoinvol(Double joinvol) {
		this.joinvol = joinvol;
	}

	public Double getJoinweight() {
		return this.joinweight;
	}

	public void setJoinweight(Double joinweight) {
		this.joinweight = joinweight;
	}

	public Date getJoinsendtime() {
		return this.joinsendtime;
	}

	public void setJoinsendtime(Date joinsendtime) {
		this.joinsendtime = joinsendtime;
	}

	public Date getJoinexptime() {
		return this.joinexptime;
	}

	public void setJoinexptime(Date joinexptime) {
		this.joinexptime = joinexptime;
	}

	public Date getJoinrecvtime() {
		return this.joinrecvtime;
	}

	public void setJoinrecvtime(Date joinrecvtime) {
		this.joinrecvtime = joinrecvtime;
	}

	public Set getTorderbyjoins() {
		return this.torderbyjoins;
	}

	public void setTorderbyjoins(Set torderbyjoins) {
		this.torderbyjoins = torderbyjoins;
	}

	public Set getTexcorders() {
		return this.texcorders;
	}

	public void setTexcorders(Set texcorders) {
		this.texcorders = texcorders;
	}

	public String getJoinstate() {
		return joinstate;
	}

	public void setJoinstate(String joinstate) {
		this.joinstate = joinstate;
	}

}