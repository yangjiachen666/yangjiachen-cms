/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: PassportController.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.controller 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月17日 下午1:20:13 
 */
package com.yangjiachen.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yangjiachen.cms.domain.User;
import com.yangjiachen.cms.exception.CMSException;
import com.yangjiachen.cms.service.UserService;
import com.yangjiachen.cms.vo.UserVO;

/** 
 * @ClassName: PassportController 
 * @Description: user表  性别字段gender 0代表男,1代表女   状态字段locked 0代表正常   1代表锁定    用户角色role  0代表普通用户  1代表管理员
 * @author:杨家琛
 * @date: 2019年10月17日 下午1:20:13  
 */
@RequestMapping("passport")
@Controller
public class PassportController {
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @Title: reg 
	 * @Description: 去注册页面
	 * @return
	 * @return: String
	 */
	@GetMapping(value = {"","reg"})
	public String reg() {
		return "passport/reg";
	}
	/**
	 * 
	 * @Title: reg 
	 * @Description: 完成注册请求
	 * @param model
	 * @param userVO
	 * @param redirectAttributes
	 * @return
	 * @return: String
	 */
	@PostMapping("reg")
	public String reg(Model model,UserVO userVO,RedirectAttributes redirectAttributes) {
		
		try {
			userVO.setNickname(userVO.getUsername());
			userVO.setLocked(0);
			userVO.setRole("0");
			userService.insertSelective(userVO);
			redirectAttributes.addFlashAttribute("user", userVO);
			return "redirect:login";
		}catch (CMSException e) {
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统异常,请联系管理员!");
		}
		return "passport/reg";
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 去登陆页面
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login() {
		return "passport/login";
	}
	/**
	 * 
	 * @Title: onlyUsername 
	 * @Description: 用户名唯一验证
	 * @param model
	 * @param username
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("onlyUsername")
	public Object onlyUsername(Model model,String username) {
		try {
			Integer id = userService.selectByUsername(username);
			if(id!=null && id>0) {
				return false;
			}
		}catch (CMSException e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("error", e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("error", "系统异常,请尽快联系管理员");
		}
		return true;
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 完成登陆请求
	 * @param model
	 * @param user
	 * @param session
	 * @return
	 * @return: String
	 */
	@PostMapping("login")
	public String login(Model model,User user,HttpSession session) {
		try {
				User u = userService.getUserByUsername(user);
				if(u.getRole().equals("0") && u.getLocked()!=1) {
					session.setAttribute("user", u);
					return "redirect:/index";
				}
				if(u.getRole().equals("1")) {
					session.setAttribute("admin", u);
					return "redirect:/admin";
				}
				
		} catch (CMSException e) {
			e.printStackTrace();
			model.addAttribute("error",e.getMessage() );
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("error","系统异常,请尽快联系管理员" );
		}
		model.addAttribute("error1", "该用户已经被限制,请联系管理员");
		return "/passport/login";
	}
	/**
	 * 
	 * @Title: loginout 
	 * @Description: 完成退出功能
	 * @param request
	 * @return
	 * @return: String
	 */
	@GetMapping("logout")
	public String loginout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(null!=session)
			session.invalidate();
		return "redirect:/passport/login";
	}
}
