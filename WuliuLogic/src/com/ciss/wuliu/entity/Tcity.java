package com.ciss.wuliu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tcity entity. @author MyEclipse Persistence Tools
 */

public class Tcity implements java.io.Serializable {

	// Fields

	private String cityid;
	private String province;
	private String city;
	private String district;
	/*private Set tcharges = new HashSet(0);
	private Set tordersForStartcityid = new HashSet(0);
	private Set tordersForEndcityid = new HashSet(0);
	private Set tpoints = new HashSet(0);
*/
	// Constructors

	/** default constructor */
	public Tcity() {
	}

	/** minimal constructor */
	public Tcity(String cityid) {
		this.cityid = cityid;
	}

	/** full constructor */
	/*public Tcity(String cityid, String province, String city, String district,
			Set tcharges, Set tordersForStartcityid, Set tordersForEndcityid,
			Set tpoints) {
		this.cityid = cityid;
		this.province = province;
		this.city = city;
		this.district = district;
		this.tcharges = tcharges;
		this.tordersForStartcityid = tordersForStartcityid;
		this.tordersForEndcityid = tordersForEndcityid;
		this.tpoints = tpoints;
	}*/

	// Property accessors

	public String getCityid() {
		return this.cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String toString(){
		
		return this.province + this.city + this.district;
	}
	
	/*public Set getTcharges() {
		return this.tcharges;
	}*/

	/*public void setTcharges(Set tcharges) {
		this.tcharges = tcharges;
	}

	public Set getTordersForStartcityid() {
		return this.tordersForStartcityid;
	}

	public void setTordersForStartcityid(Set tordersForStartcityid) {
		this.tordersForStartcityid = tordersForStartcityid;
	}

	public Set getTordersForEndcityid() {
		return this.tordersForEndcityid;
	}

	public void setTordersForEndcityid(Set tordersForEndcityid) {
		this.tordersForEndcityid = tordersForEndcityid;
	}

	public Set getTpoints() {
		return this.tpoints;
	}

	public void setTpoints(Set tpoints) {
		this.tpoints = tpoints;
	}
*/
}