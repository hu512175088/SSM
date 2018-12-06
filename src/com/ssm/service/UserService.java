package com.ssm.service;

import com.ssm.pojo.User;

import java.util.List;

public interface UserService {

	/**
	 * 验证用户登录账号是否存在
	 */
	User searchUserCodeIsExists(String userCode);
	
	/**
	 * 添加用户
	 */
	int add(User user);
	
	/**
	 * 显示:实现搜索(用户名称,用户性别,创建日期[开始日期,截止日期])
	 * 实现排序按照最新用户,并且进行分页
	 */
	List<User> searchUserListByUserNameAndGenderAndDateTime(User user);
	
	/**
	 * 求总记录数
	 */
	int count();
	
	/**
	 * 求总页数
	 */
//	int pageCount(User user);
	
}
