/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: MyInterceptor.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.util 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月22日 下午3:14:26 
 */
package com.yangjiachen.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * @ClassName: MyInterceptor 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月22日 下午3:14:26  
 */
public class MyInterceptor extends HandlerInterceptorAdapter{
	/* (non Javadoc) 
	 * @Title: preHandle
	 * @Description: TODO
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object) 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(null!=session) {
			Object attribute = session.getAttribute("user");
			if(null!=attribute) {
				return true;
			}
		}
		request.setAttribute("error", "请先登录");
		request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);
		return false;
	}
}
