package com.boot.dao.domain;

import java.sql.Date;

public class Opportunity {
		private int id;
		private String bussessName;
		private int bussessCustomerId;
		private String bussessCustomerName;
		private int bussessContactId;
		private String bussessContactName;
		private int bussessProgress;
		private int bussessRate;
		private Date bussessNextContact;
		private int bussessMoney;
		private int bussessState;
		private String bussessRemark;
		private String bussessResponsible;
		private Date bussessCreateTime;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getBussessName() {
			return bussessName;
		}
		public void setBussessName(String bussessName) {
			this.bussessName = bussessName;
		}
		public int getBussessCustomerId() {
			return bussessCustomerId;
		}
		public void setBussessCustomerId(int bussessCustomerId) {
			this.bussessCustomerId = bussessCustomerId;
		}
		public String getBussessCustomerName() {
			return bussessCustomerName;
		}
		public void setBussessCustomerName(String bussessCustomerName) {
			this.bussessCustomerName = bussessCustomerName;
		}
		public int getBussessContactId() {
			return bussessContactId;
		}
		public void setBussessContactId(int bussessContactId) {
			this.bussessContactId = bussessContactId;
		}
		public String getBussessContactName() {
			return bussessContactName;
		}
		public void setBussessContactName(String bussessContactName) {
			this.bussessContactName = bussessContactName;
		}
		public int getBussessProgress() {
			return bussessProgress;
		}
		public void setBussessProgress(int bussessProgress) {
			this.bussessProgress = bussessProgress;
		}
		public int getBussessRate() {
			return bussessRate;
		}
		public void setBussessRate(int bussessRate) {
			this.bussessRate = bussessRate;
		}
		public Date getBussessNextContact() {
			return bussessNextContact;
		}
		public void setBussessNextContact(Date bussessNextContact) {
			this.bussessNextContact = bussessNextContact;
		}
		public int getBussessMoney() {
			return bussessMoney;
		}
		public void setBussessMoney(int bussessMoney) {
			this.bussessMoney = bussessMoney;
		}
		public int getBussessState() {
			return bussessState;
		}
		public void setBussessState(int bussessState) {
			this.bussessState = bussessState;
		}
		public String getBussessRemark() {
			return bussessRemark;
		}
		public void setBussessRemark(String bussessRemark) {
			this.bussessRemark = bussessRemark;
		}
		public String getBussessResponsible() {
			return bussessResponsible;
		}
		public void setBussessResponsible(String bussessResponsible) {
			this.bussessResponsible = bussessResponsible;
		}
		public Date getBussessCreateTime() {
			return bussessCreateTime;
		}
		public void setBussessCreateTime(Date bussessCreateTime) {
			this.bussessCreateTime = bussessCreateTime;
		}
}
