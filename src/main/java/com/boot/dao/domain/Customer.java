package com.boot.dao.domain;

import java.sql.Date;

public class Customer {
	private Integer id;
	private String cName;
	private Integer cState;
	private String cWork;
	private String cSource;
	private String cResponsible;
	private Integer cLevel;
	private String cAddress;
	private Date cCreateTime;
	private String cRemark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Integer getcState() {
		return cState;
	}
	public void setcState(Integer cState) {
		this.cState = cState;
	}
	public String getcWork() {
		return cWork;
	}
	public void setcWork(String cWork) {
		this.cWork = cWork;
	}
	public String getcSource() {
		return cSource;
	}
	public void setcSource(String cSource) {
		this.cSource = cSource;
	}
	public String getcResponsible() {
		return cResponsible;
	}
	public void setcResponsible(String cResponsible) {
		this.cResponsible = cResponsible;
	}
	public Integer getcLevel() {
		return cLevel;
	}
	public void setcLevel(Integer cLevel) {
		this.cLevel = cLevel;
	}
	public String getcRemark() {
		return cRemark;
	}
	public void setcRemark(String cRemark) {
		this.cRemark = cRemark;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public Date getcCreateTime() {
		return cCreateTime;
	}
	public void setcCreateTime(Date cCreateTime) {
		this.cCreateTime = cCreateTime;
	}
}
