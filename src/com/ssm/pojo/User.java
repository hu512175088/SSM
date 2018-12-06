package com.ssm.pojo;

import java.util.Date;

public class User {

	/**
	 * 真实姓名
	 */
	private String userName;

	/**
	 * 用户登录名称
	 */
	private String userCode;

	/**
	 * 用户登录密码
	 */
	private String password;

	/**
	 * 用户创建时间
	 */
	private Date createTime;



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
