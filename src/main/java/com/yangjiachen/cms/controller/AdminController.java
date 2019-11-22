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

import java.util.Date;
import java.util.List;

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
import com.yangjiachen.cms.domain.Friendly;
import com.yangjiachen.cms.domain.Special;
import com.yangjiachen.cms.domain.SpecialArticle;
import com.yangjiachen.cms.domain.Speciala;
import com.yangjiachen.cms.domain.User;
import com.yangjiachen.cms.exception.CMSException;
import com.yangjiachen.cms.service.ArticleService;
import com.yangjiachen.cms.service.FriendlyService;
import com.yangjiachen.cms.service.SpecialService;
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
	@Resource
	private SpecialService specialService;
	@Resource
	private FriendlyService friendlyService;
	
	
	/**
	 * 
	 * @Title: deleteArticle 
	 * @Description: 完成文章的删除操作
	 * @param id
	 * @return: void
	 */
	@RequestMapping("delete")
	public String deleteArticle(Integer id) {
		articleService.deleteByPrimaryKey(id);
		return "redirect:/admin/articles";
	}
	
	
	
	
	
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
		PageInfo<ArticleWithBLOBs> info = articleService.selects(article, page, pageSize);
		String pages = PageUtil.page(page, info.getPages(), "/admin/articles?status="+article.getStatus(), pageSize);
		m.addAttribute("articles", info.getList());
		m.addAttribute("article", article);
		m.addAttribute("pages", pages);
		m.addAttribute("page", page);
		return "admin/articles";
	}
	
	/**
	 * 
	 * @Title: specials 
	 * @Description: 文章专题
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("specials")
	public String specials(Model model) {
		List<Special> specials = specialService.selects();
		model.addAttribute("specials", specials);
		return "/admin/specials";
	}
	/**
	 * 
	 * @Title: addSpecial 
	 * @Description: 去添加专题页面
	 * @return
	 * @return: String
	 */
	@GetMapping("addSpecial")
	public String addSpecial() {
		return "/admin/addspecial";
	}
	/**
	 * 
	 * @Title: addSpecial 
	 * @Description:完成添加专题请求
	 * @param special
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("addspecial")
	public boolean addSpecial(Special special) {
		special.setCreated(new Date());
		int i = specialService.addSpecial(special);
		return i>0;
	}
	/**
	 * 
	 * @Title: updateSpecial 
	 * @Description: 去修改专题页面
	 * @param model
	 * @param sid
	 * @return
	 * @return: String
	 */
	@GetMapping("updateSpecial")
	public String updateSpecial(Model model,Integer sid) {
		Special special = specialService.selectSpecialBySid(sid);
		model.addAttribute("special", special);
		return "admin/updatespecial";
	}
	/**
	 * 
	 * @Title: updateSpecial 
	 * @Description: 完成修改专题
	 * @param special
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("updatespecial")
	public boolean updateSpecial(Special special) {
		return specialService.updatespecial(special)>0;
	}
	
	
	/**
	 * 
	 * @Title: addArticle 
	 * @Description: 去增加文章
	 * @param sid
	 * @return
	 * @return: String
	 */
	@GetMapping("addArticle")
	public String addArticle(Model model,Integer sid) {
		Special special = specialService.selectSpecialBySid(sid);
		model.addAttribute("special", special);
		return "admin/specialdetail";
	}
	/**
	 * 
	 * @Title: addArticle 
	 * @Description: 完成文章专栏内添加文章
	 * @param specialArticle
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("addArticle")
	public boolean addArticle(Model model,SpecialArticle specialArticle) {
		try {
			int i = specialService.addArticle(specialArticle);
			return i>0;
		} catch (CMSException e) {
			// TODO: handle exception
			e.printStackTrace();
			String message = e.getMessage();
			model.addAttribute("error", message);
			return false;
		}
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
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 完成审核文章是否通过或者驳回
	 * @param article
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("updateArticle")
	public Object updateArticle(ArticleWithBLOBs article) {
		if(article.getStatus()==1) {
			
		}
		return articleService.updateByPrimaryKeySelective(article)>0;
	}
	/**
	 * 
	 * @Title: linkSelect 
	 * @Description: 友情连接页面
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@GetMapping("/links/selects")
	public String linkSelect(Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		PageInfo<Friendly> info = friendlyService.selects(page, pageSize);
		String pages = PageUtil.page(page, info.getPages(), "/admin/links/selects", pageSize);
		model.addAttribute("friendlys", info.getList());
		model.addAttribute("pages", pages);
		return "/admin/links";
	}
	/**
	 * 
	 * @Title: addlinks 
	 * @Description: 去添加友情连接页面
	 * @return
	 * @return: String
	 */
	@GetMapping("addlinks")
	public String addlinks() {
		return "/admin/addlink";
	}
	
	@ResponseBody
	@PostMapping("addlink")
	public boolean addlink(Friendly friendly,String url1) {
		friendly.setCreated(new Date());
		friendly.setUrl(url1);
		return friendlyService.insert(friendly)>0;
	}
}
