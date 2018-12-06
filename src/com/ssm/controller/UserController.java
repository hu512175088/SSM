package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

	@Resource
	private UserService userService = null;

	
	/**
	 * 跳转到注册页面
	 */
	@RequestMapping("/goUserRegister")
	public String goUserRegister() {
		return "UserRegister";
	}
	
	/**
	 * 验证用户账户是否存在
	 * @param userCode
	 * @return
	 */
	@RequestMapping("/validateUserCodeIsExists")
	@ResponseBody
	public Object validateUserCodeIsExists(@RequestParam("userCode") String userCode) {
		User user = userService.searchUserCodeIsExists(userCode);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (user != null) {// 当前账号存在,则禁止注册
			resultMap.put("valiResult", false);
		} else {// 不存在,可以注册
			resultMap.put("valiResult", true);
		}
		return JSON.toJSONString(resultMap);
	}
	
	/**  
	 * 注册
	 */
	@RequestMapping("/addUserRegister")
	@ResponseBody
	public Object addUserRegister(
			@RequestParam("userCode") String userCode,
			@RequestParam("password") String password,
			@RequestParam("userName") String userName
			) {
		User user = new User();
		user.setUserCode(userCode);
		user.setUserName(userName);
		user.setPassword(password);
		int addResult = userService.add(user);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (addResult > -1) {// 添加成功
			resultMap.put("addResult", true);
		} else {// 失败
			resultMap.put("addResult", false);
		}
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * 跳转到登录页面
	 */
	@RequestMapping("/goUserLogin")
	public String goUserLogin() {
		return "UserLogin";
	}
	
	/**
	 * 处理登录
	 */
	@RequestMapping("/validateLoginUser")
	@ResponseBody
	public Object validateLoginUser(
			HttpSession session,
			@RequestParam("userCode") String userCode,
			@RequestParam("password") String password
		) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		User resultUser = userService.searchUserCodeIsExists(userCode);
		if (resultUser != null) {// 登录账号存在
			if (password.equals(resultUser.getPassword())) {
				session.setAttribute("user", resultUser);
				resultMap.put("loginMessage", true);
			} else {
				resultMap.put("loginMessage", false);
			}
		} else {
			resultMap.put("loginMessage", false);
		}
		return JSON.toJSONString(resultMap);
	}

	/**
	 * 跳转到所有表展示页
	 */
	@RequestMapping("/goUserItems")
	public String goUserItems(
			HttpServletRequest request
			//@RequestParam(value="cp",required=false) String cp
	) {
		 //cp : 当前页
		//if (cp == null) {
		//	cp = "1";
		//}
//		// 获取用户所有数据
		User user = new User();
//		// ①
	//user.setPageSize(15);
//		// ②
		//user.setCurrentPage(Integer.parseInt(cp));
//		// 总页数
//	int pageCount = userService.pageCount(user);
//		// 总条数
	int count = userService.count();
		List<User> userList = userService.searchUserListByUserNameAndGenderAndDateTime(user);
		request.setAttribute("userList", userList);
		//request.setAttribute("cp", cp);
		request.setAttribute("count", count);
		//request.setAttribute("pageCount", pageCount);
		return "UserItems";
	}
	
}










