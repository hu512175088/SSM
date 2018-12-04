package com.ssm.interceptor;

import com.ssm.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 拦截器
 * @author Administrator
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		// 获取用户的请求路径
		String url = request.getRequestURI();
		// 获取Session中的用户信息
		User user = (User) request.getSession().getAttribute("user");
		if (user != null
				|| url.indexOf(".css") > -1 
				|| url.indexOf(".js") > -1
				|| url.indexOf(".png") > -1
				|| url.indexOf(".jpg") > -1
				|| url.indexOf(".jpeg") > -1
				|| url.indexOf(".gif") > -1
				|| url.indexOf("goUserRegister") > -1
				|| url.indexOf("validateUserCodeIsExists") > -1
				|| url.indexOf("addUserRegister") > -1
				|| url.indexOf("goUserLogin") > -1
				|| url.indexOf("validateLoginUser") > -1
				||url.indexOf("goFileDow") > -1
				||url.indexOf("validatetable_name") > -1
				||url.indexOf("goDowFile") > -1
				||url.indexOf("goDownload") > -1
			) {
			return true;
		} else {
			request.setAttribute("illegalLogiin", "您必须重新登录才能访问");
			request.getRequestDispatcher("goUserLogin").forward(request, response);
			return false;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
