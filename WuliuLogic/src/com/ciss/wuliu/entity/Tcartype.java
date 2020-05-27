package com.ciss.wuliu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tcartype entity. @author MyEclipse Persistence Tools
 */

public class Tcartype implements java.io.Serializable {

	// Fields

	private String cartypeid;
	private String cartypename;
	/*private Set tautos = new HashSet(0);*/

	// Constructors

	/** default constructor */
	public Tcartype() {
	}

	/** minimal constructor */
	public Tcartype(String cartypeid) {
		this.cartypeid = cartypeid;
	}

	/** full constructor */
	public Tcartype(String cartypeid, String cartypename) {
		this.cartypeid = cartypeid;
		this.cartypename = cartypename;
	}

	// Property accessors

	public String getCartypeid() {
		return this.cartypeid;
	}

	public void setCartypeid(String cartypeid) {
		this.cartypeid = cartypeid;
	}

	public String getCartypename() {
		return this.cartypename;
	}

	public void setCartypename(String cartypename) {
		this.cartypename = cartypename;
	}

	/*public Set getTautos() {
		return this.tautos;
	}

	public void setTautos(Set tautos) {
		this.tautos = tautos;
	}*/

}