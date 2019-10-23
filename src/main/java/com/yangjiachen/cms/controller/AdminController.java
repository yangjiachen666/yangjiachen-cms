/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: UserController.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.controller 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月15日 下午8:12:33 
 */
package com.yangjiachen.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.domain.User;
import com.yangjiachen.cms.service.ArticleService;
import com.yangjiachen.cms.service.UserService;
import com.yangjiachen.cms.util.PageUtil;

/** 
 * @ClassName: UserController 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月15日 下午8:12:33  
 */
@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private ArticleService articleService;
	
	/**
	 * 
	 * @Title: users 
	 * @Description: 去管理员页面
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","users"})
	public String users() {
		return "admin/index";
	}
	/**
	 * 
	 * @Title: articles 
	 * @Description: 查询所有文章信息
	 * @param m
	 * @param article
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@GetMapping("articles")
	public String articles(Model m,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		if(article.getStatus()==null) {
			article.setStatus(0);
		}
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		String pages = PageUtil.page(page, info.getPages(), "/admin/articles?status="+article.getStatus(), pageSize);
		m.addAttribute("articles", info.getList());
		m.addAttribute("article", article);
		m.addAttribute("pages", pages);
		m.addAttribute("page", page);
		return "admin/articles";
	}
	
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有用户信息
	 * @param m
	 * @param username
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@GetMapping("selects")
	public String selects(Model m,@RequestParam(defaultValue = "")String username,@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<User> info = userService.users(username, page, pageSize);
		String pages = PageUtil.page(page, info.getPages(), "/admin/selects?username="+username, pageSize);
		m.addAttribute("users", info.getList());
		m.addAttribute("username", username);
		m.addAttribute("pages", pages);
		return "admin/users";
	}
	
	/**
	 * 
	 * @Title: updateLocked 
	 * @Description: 修改状态(正常或者禁用)
	 * @param user
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("updateLocked")
	public Object updateLocked(User user) {
		System.out.println(user);
		return userService.updateByPrimaryKeySelective(user)>0;
	}
	
	/**
	 * 
	 * @Title: updateHot 
	 * @Description: 修改是否热门(是热门或者不是热门)
	 * @param article
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("updateHot") 
	public Object updateHot(ArticleWithBLOBs article) {
	  int i = articleService.updateByPrimaryKeySelective(article); 
	  if(i>0) 
		  return true; 
		  return false; 
	  }
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 查看发布的文章详情
	 * @param model
	 * @param id
	 * @return
	 * @return: String
	 */
	@GetMapping("articleDetail")
	public String articleDetail(Model model,Integer id,Integer page) {
		ArticleWithBLOBs article = articleService.selectByPrimaryKey(id);
		model.addAttribute("article", article);
		model.addAttribute("page", page);
		return "/admin/article";
	}
	
	@ResponseBody
	@PostMapping("updateArticle")
	public Object updateArticle(ArticleWithBLOBs article) {
		return articleService.updateByPrimaryKeySelective(article)>0;
	}
}
