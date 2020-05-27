package com.ciss.wuliu.entity;

/**
 * Tauto entity. @author MyEclipse Persistence Tools
 */

public class Tauto implements java.io.Serializable {

	// Fields
	private String no;
	private String autoid;
	private Tcartype tcartype;
	private String autotypename;
	private Double cartweight;
	private Double carvol;
	private Tstaff driver1;
	private String driver1name;
	private Tstaff driver2;
	private String driver2name;
	/*private Set tclasses = new HashSet(0);*/

	// Constructors

	/** default constructor */
	public Tauto() {
	}

	/** minimal constructor */
	public Tauto(String autoid) {
		this.autoid = autoid;
	}

	/** full constructor */
	public Tauto(String autoid, Tcartype tcartype, Double cartweight,
			Double carvol, Tstaff driver1, Tstaff driver2) {
		this.no = autoid;
		this.autoid = autoid;
		this.autotypename = tcartype.getCartypename();
		this.cartweight = cartweight;
		this.carvol = carvol;
		this.driver1name = driver1.getStaffname();
		this.driver2name = driver2.getStaffname();
	}

	// Property accessors

	public String getAutoid() {
		return this.autoid;
	}

	public void setAutoid(String autoid) {
		this.autoid = autoid;
	}

	public Tcartype getTcartype() {
		return this.tcartype;
	}

	public void setTcartype(Tcartype tcartype) {
		this.tcartype = tcartype;
	}

	public Double getCartweight() {
		return this.cartweight;
	}

	public void setCartweight(Double cartweight) {
		this.cartweight = cartweight;
	}

	public Double getCarvol() {
		return this.carvol;
	}

	public void setCarvol(Double carvol) {
		this.carvol = carvol;
	}

	public Tstaff getDriver1() {
		return this.driver1;
	}

	public void setDriver1(Tstaff driver1) {
		this.driver1 = driver1;
	}

	public Tstaff getDriver2() {
		return this.driver2;
	}

	public void setDriver2(Tstaff driver2) {
		this.driver2 = driver2;
	}


	public String getAutotypename() {
		return autotypename;
	}

	public void setAutotypename(String autotypename) {
		this.autotypename = autotypename;
	}

	public String getDriver1name() {
		return driver1name;
	}

	public void setDriver1name(String driver1name) {
		this.driver1name = driver1name;
	}

	public String getDriver2name() {
		return driver2name;
	}

	public void setDriver2name(String driver2name) {
		this.driver2name = driver2name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	/*public Set getTclasses() {
		return this.tclasses;
	}

	public void setTclasses(Set tclasses) {
		this.tclasses = tclasses;
	}*/
	
}