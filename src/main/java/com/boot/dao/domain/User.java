package com.boot.dao.domain;

public class User {
	private Integer id;
	private String userName;
	private String userPassword;
	private Integer userAuthor;
	private Integer userDepartment;
	private Integer userSex;
	private String userPhone;
	private String userEmail;
	private String userAddress;
	private String userHead;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserAuthor() {
		return userAuthor;
	}
	public void setUserAuthor(Integer userAuthor) {
		this.userAuthor = userAuthor;
	}
	public Integer getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(Integer userDepartment) {
		this.userDepartment = userDepartment;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
}
