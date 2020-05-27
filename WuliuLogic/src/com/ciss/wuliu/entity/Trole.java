package com.ciss.wuliu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Trole entity. @author MyEclipse Persistence Tools
 */

public class Trole implements java.io.Serializable {

	// Fields

	private int roleid;
	private String rolename;
	private Set tusers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Trole() {
	}

	/** minimal constructor */
	public Trole(Byte roleid) {
		this.roleid = roleid;
	}

	/** full constructor */
	public Trole(Byte roleid, String rolename, Set tusers) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.tusers = tusers;
	}

	// Property accessors

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set getTusers() {
		return this.tusers;
	}

	public void setTusers(Set tusers) {
		this.tusers = tusers;
	}

}