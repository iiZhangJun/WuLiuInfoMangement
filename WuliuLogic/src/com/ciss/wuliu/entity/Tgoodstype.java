package com.ciss.wuliu.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Tgoodstype entity. @author MyEclipse Persistence Tools
 */

public class Tgoodstype implements java.io.Serializable {

	// Fields

	private Integer goodstypeid;
	private String goodstypename;
	/*private Set torders = new HashSet(0);*/

	// Constructors

	/** default constructor */
	public Tgoodstype() {
	}

	/** minimal constructor */
	public Tgoodstype(Integer goodstypeid) {
		this.goodstypeid = goodstypeid;
	}

	/** full constructor */
	public Tgoodstype(Integer goodstypeid, String goodstypename, Set torders) {
		this.goodstypeid = goodstypeid;
		this.goodstypename = goodstypename;
		/*this.torders = torders;*/
	}

	// Property accessors

	public Integer getGoodstypeid() {
		return this.goodstypeid;
	}

	public void setGoodstypeid(int i) {
		this.goodstypeid = i;
	}

	public String getGoodstypename() {
		return this.goodstypename;
	}

	public void setGoodstypename(String goodstypename) {
		this.goodstypename = goodstypename;
	}

	/*public Set getTorders() {
		return this.torders;
	}
	
	public void setTorders(Set torders) {
		this.torders = torders;
	}*/

}