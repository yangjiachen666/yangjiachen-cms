/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: AdminInterceptor.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.util 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月22日 下午3:11:09 
 */
package com.yangjiachen.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * @ClassName: AdminInterceptor 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月22日 下午3:11:09  
 */
public class AdminInterceptor extends HandlerInterceptorAdapter{
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
			Object object = session.getAttribute("admin");
			if(null!=object) {
				return true;
			}
		}
		request.setAttribute("error", "请先登录");
		request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);
		return false;
	}
}
