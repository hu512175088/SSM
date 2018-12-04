package com.ssm.dao;

import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ①注册 --> ②登录 --> ③显示用户所有信息
 * ①:验证非空,验证是否存在,用ajax技术来实现提交
 * ②:验证非空,用ajax技术来实现提交
 * ③:必须在登录成功状态下显示(过滤器),
 * 		实现搜索(用户名称,用户性别,创建日期[开始日期,截止日期])
 * 		实现排序按照最新用户,并且进行分页
 * 方法:
 * 		验证用户名的方法
 * 		添加方法
 * 		显示
 * 		总记录数
 */
public interface UserMapper {

	/**
	 * 验证用户登录账号是否存在
	 */
	User searchUserCodeIsExists(@Param("userCode") String userCode);
	
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
	int count(User user);
	
}
