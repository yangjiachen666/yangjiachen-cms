/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: indexController4.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.controller 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月18日 下午1:58:49 
 */
package com.yangjiachen.cms.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.domain.Category;
import com.yangjiachen.cms.domain.Channel;
import com.yangjiachen.cms.service.ArticleService;
import com.yangjiachen.cms.service.CategoryService;
import com.yangjiachen.cms.service.ChannelService;
import com.yangjiachen.cms.util.PageUtil;
import com.yangjiachen.common.utils.DateUtil;

/** 
 * @ClassName: indexController4 
 * @Description: 前台页面展示
 * @author:杨家琛
 * @date: 2019年10月18日 下午1:58:49  
 */
@Controller
public class indexController {
	
	@Resource
	private ChannelService channelService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ArticleService articleService;
	
	/**
	 * 
	 * @Title: index 
	 * @Description: 展示文章,初始热门文章
	 * @param model
	 * @param article
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping(value= {"","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		//左侧栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		//默认查找已经审核过的
		article.setStatus(1);
		article.setDeleted(0);
		//栏目不为空查找
		if(null!=article.getChannelId()) {
			//通过栏目id获取所有类型
			List<Category> categorys = categoryService.selects(article.getChannelId());
			model.addAttribute("categorys", categorys);
			//通过栏目和类型获取文章
			//前台是动态sql所以不需要判断categoryid是否为空
			PageInfo<Article> info = articleService.selects(article,page,pageSize);
			//展示全部的时候因为categoryId是null 所以400请求,这样解决
			String params="?channelId="+article.getChannelId();
			if(null!=article.getCategoryId()) {
				params+="&categoryId="+article.getCategoryId();
			}
			
			String pages = PageUtil.page(page, info.getPages(), params, pageSize);
			
			model.addAttribute("articles",info.getList());
			model.addAttribute("pages", pages);
			if(-1==article.getChannelId()) {
				article.setChannelId(null);
			}
		}
		
		//第一次访问channelId是空  所以赋hot 也就是默认查找热门文章
		if(null==article.getChannelId()) {
			//开始访问的时候展示热门文章
			article.setHot(1);
			PageInfo<Article> info = articleService.selects(article,page,pageSize);
			String pages = PageUtil.page(page, info.getPages(), "", pageSize);
			model.addAttribute("hotarticles",info.getList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("article", article);
		
		//24小时热门
		Article article2 = new Article();
		article2.setHot(1);
		article2.setDeleted(0);
		article2.setCreated(DateUtil.getDateByBefore());
		article2.setStatus(1);
		PageInfo<Article> info = articleService.selects(article2, 1, 4);
		model.addAttribute("article24", info.getList());
		
		Article article3 = new Article();
		article3.setDeleted(0);
		article3.setStatus(1);
		PageInfo<Article> info1 = articleService.selects(article3, 1, 5);
		model.addAttribute("articleNew", info1.getList());
		
		return "index/index";
	}
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 展示文章详情
	 * @param model
	 * @param channelId
	 * @return
	 * @return: String
	 */
	@GetMapping("select")
	public String select(Model model,Integer id) {
		ArticleWithBLOBs article = articleService.selectByPrimaryKey(id);
		model.addAttribute("article", article);
		return "index/article";
	}
}	
