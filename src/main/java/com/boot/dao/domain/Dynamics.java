package com.boot.dao.domain;

import java.sql.Date;

public class Dynamics {
		
	private int id;
	private String logUserName;
	private int logContent;
	private int logNumber;
	private Date logTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogUserName() {
		return logUserName;
	}
	public void setLogUserName(String logUserName) {
		this.logUserName = logUserName;
	}
	public int getLogContent() {
		return logContent;
	}
	public void setLogContent(int logContent) {
		this.logContent = logContent;
	}
	public int getLogNumber() {
		return logNumber;
	}
	public void setLogNumber(int logNumber) {
		this.logNumber = logNumber;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

}
