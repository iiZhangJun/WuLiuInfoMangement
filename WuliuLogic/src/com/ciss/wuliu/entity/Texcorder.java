package com.ciss.wuliu.entity;

import java.util.Date;

/**
 * Texcorder entity. @author MyEclipse Persistence Tools
 */

public class Texcorder implements java.io.Serializable {

	// Fields

	private int excid;
	/*private Tjoin tjoin;*/
	private Torder torder;
	private String orderid;
	private Date exctime;
	private String accident;
	private String resolve;
	private String position;
	private String excstate;

	// Constructors

	/** default constructor */
	public Texcorder() {
	}

	/** minimal constructor */
	public Texcorder(int excid) {
		this.excid = excid;
	}

	/** full constructor */
	public Texcorder(int excid, Torder torder, Date exctime,
			String accident, String resolve, String position, String excstate) {
		this.excid = excid;
		this.orderid = torder.getOrderid();
		this.exctime = exctime;
		this.accident = accident;
		this.resolve = resolve;
		this.position = position;
		this.excstate = excstate;
	}

	// Property accessors

	public int getExcid() {
		return this.excid;
	}

	public void setExcid(int excid) {
		this.excid = excid;
	}

	/*public Tjoin getTjoin() {
		return this.tjoin;
	}

	public void setTjoin(Tjoin tjoin) {
		this.tjoin = tjoin;
	}*/

	public Torder getTorder() {
		return this.torder;
	}

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

	public Date getExctime() {
		return this.exctime;
	}

	public void setExctime(Date exctime) {
		this.exctime = exctime;
	}

	public String getAccident() {
		return this.accident;
	}

	public void setAccident(String accident) {
		this.accident = accident;
	}

	public String getResolve() {
		return this.resolve;
	}

	public void setResolve(String resolve) {
		this.resolve = resolve;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getExcstate() {
		return this.excstate;
	}

	public void setExcstate(String excstate) {
		this.excstate = excstate;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}