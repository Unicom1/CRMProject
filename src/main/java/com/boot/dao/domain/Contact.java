package com.boot.dao.domain;

import java.sql.Date;

public class Contact {
	private int id;
	private String contactName;
	private String contactRole;
	private String contactPosition;
	private int contactSex;
	private String contactPhone;
	private String contactEmail;
	private String contactAddress;
	private String contactCreateUser;
	private Date contactCreateTime;
	private String contactRemark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactRole() {
		return contactRole;
	}
	public void setContactRole(String contactRole) {
		this.contactRole = contactRole;
	}
	public String getContactPosition() {
		return contactPosition;
	}
	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}
	public int getContactSex() {
		return contactSex;
	}
	public void setContactSex(int contactSex) {
		this.contactSex = contactSex;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getContactCreateUser() {
		return contactCreateUser;
	}
	public void setContactCreateUser(String contactCreateUser) {
		this.contactCreateUser = contactCreateUser;
	}
	public Date getContactCreateTime() {
		return contactCreateTime;
	}
	public void setContactCreateTime(Date contactCreateTime) {
		this.contactCreateTime = contactCreateTime;
	}
	public String getContactRemark() {
		return contactRemark;
	}
	public void setContactRemark(String contactRemark) {
		this.contactRemark = contactRemark;
	}

}
