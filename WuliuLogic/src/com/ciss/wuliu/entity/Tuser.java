package com.ciss.wuliu.entity;

import java.math.BigDecimal;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */

public class Tuser implements java.io.Serializable {

	// Fields

	private int userid;
	private Tpoint tpoint;
	private Trole trole;
	private String username;
	private String password;
	private String pointname;

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(int userid) {
		this.userid = userid;
	}

	/** full constructor */
	public Tuser(int userid, Tpoint tpoint, Trole trole,
			String username, String password) {
		this.userid = userid;
		this.tpoint = tpoint;
		this.pointname = tpoint.getPointname();
		this.trole = trole;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Tpoint getTpoint() {
		return this.tpoint;
	}

	public void setTpoint(Tpoint tpoint) {
		this.tpoint = tpoint;
	}

	public Trole getTrole() {
		return this.trole;
	}

	public void setTrole(Trole trole) {
		this.trole = trole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Tuser(int userid, Tpoint tpoint,String username) {
		this.userid = userid;
		this.pointname = tpoint.getPointname();
		this.username = username;
	}

	public String getPointname() {
		return pointname;
	}

	public void setPointname(String pointname) {
		this.pointname = pointname;
	}
	
}