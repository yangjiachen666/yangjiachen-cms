/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: MyController.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.controller 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月17日 下午7:55:11 
 */
package com.yangjiachen.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.domain.Category;
import com.yangjiachen.cms.domain.Channel;
import com.yangjiachen.cms.domain.User;
import com.yangjiachen.cms.service.ArticleService;
import com.yangjiachen.cms.service.CategoryService;
import com.yangjiachen.cms.service.ChannelService;
import com.yangjiachen.cms.util.ArticleEnum;
import com.yangjiachen.cms.util.PageUtil;
import com.yangjiachen.cms.vo.ArticleVO;

/** 
 * @ClassName: MyController 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月17日 下午7:55:11  
 */
@RequestMapping("my")
@Controller
public class MyController {
	
	@Resource
	private ChannelService channelService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ArticleService articleService;
	/**
	 * 
	 * @Title: myIndex 
	 * @Description: 访问个人中心页面
	 * @return
	 * @return: String
	 */
	@RequestMapping(value= {"","index"})
	public String myIndex() {
		return "/my/index";
	}
	
	
	/**
	 * 
	 * @Title: publish 
	 * @Description: 去发布文章页面
	 * @return
	 * @return: String
	 */
	@GetMapping("/article/publish")
	public String publish() {
		return "/my/publish";
	}
	/**
	 * 
	 * @Title: publicPic 
	 * @Description: 去发布图片集页面
	 * @return
	 * @return: String
	 */
	@GetMapping("publishPic")
	public String publicPic() {
		return "/my/publicPic";
	}
	/**
	 * 
	 * @Title: publicPic 
	 * @Description: 完成发布图片集
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("publishPic")
	public boolean publicPic(HttpServletRequest request,String [] descripts,MultipartFile[] files,ArticleWithBLOBs article) {
		
		List<ArticleVO> list = new ArrayList<ArticleVO>();
		if(files.length>0) {
			int i =0;
			for (MultipartFile file : files) {
				if(!file.isEmpty()) {
					String path="d:/pic/";
					String oldFilename = file.getOriginalFilename();
					String newFilename = UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
					try {
						file.transferTo(new File(path+newFilename));
						ArticleVO vo = new ArticleVO();
						vo.setUrl(newFilename);
						vo.setDescipt(descripts[i++]);
						article.setPicture(newFilename);
						list.add(vo);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			 		}
				}
			}
		}
		HttpSession session = request.getSession(false);
		if(session==null) 
			return false;
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		article.setUpdated(new Date());
		Gson gson = new Gson();
		String json = gson.toJson(list);
		article.setContent(json);
		article.setStatus(0);
		article.setContentType(ArticleEnum.IMAGE.getCode());
		article.setDeleted(0);
		article.setHits(0);
		article.setHot(0);
		int i = articleService.insertSelective(article);
		return i>0;
	}
	
	/**
	 * 
	 * @Title: selectsChannel 
	 * @Description: 二级联动查询所有导航
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("selectsChannel")
	public Object selectsChannel() {
		List<Channel> channels = channelService.selects();
		return channels;
	}
	/**
	 * 
	 * @Title: selectscategory 
	 * @Description: 二级联动查询当前栏目下的分类
	 * @param channelId
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("selectscategory")
	public Object selectscategory(Integer channelId) {
		List<Category> categorys = categoryService.selects(channelId);
		return categorys;
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 发布文章
	 * @param request
	 * @param article
	 * @param file
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("publish")
	public Object publish(HttpServletRequest request,ArticleWithBLOBs article,MultipartFile file) {
		if(!file.isEmpty()) {
			String path="d:/pic/";
			String oldFilename = file.getOriginalFilename();
			String newFilename = UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
			try {
				file.transferTo(new File(path+newFilename));
				article.setPicture(newFilename);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession(false);
		if(session==null) 
			return false;
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		article.setUpdated(new Date());
		article.setHot(0);
		article.setContentType(ArticleEnum.HTML.getCode());
		article.setStatus(0);
		article.setDeleted(0);
		article.setHits(0);
		int i = articleService.insertSelective(article);
		return i>0;
	}
	/**
	 * 
	 * @Title: selectByUser 
	 * @Description: 查询当前用户文章展示用户的个人中心
	 * @param model
	 * @param request
	 * @param article
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@GetMapping("selectsByUser")
	public String selectByUser(Model model,HttpServletRequest request,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		HttpSession session = request.getSession(false);
		if(session==null) 
			return "redirect:/passport/login";
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		article.setUserId(id);
		article.setDeleted(0);
		if(article.getStatus()==null) {
			article.setStatus(0);
		}
		if(article.getTitle()==null) {
			article.setTitle("");
		}
		if(article.getTerms()==null) {
			article.setTerms("");
		}
		PageInfo<Article> info = articleService.selects(article, page, pageSize);

		String pages = PageUtil.page(page, info.getPages(),"/my/selectsByUser?status="+article.getStatus()+"&title="+article.getTitle()+"&terms="+article.getTerms(), pageSize);
		model.addAttribute("articles", info.getList());
		model.addAttribute("pages", pages);
		model.addAttribute("article", article);
		model.addAttribute("page", page);
		return "/my/articles";
	}
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 展示文章信息
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
		return "/my/article";
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 修改重新发布文章
	 * @param model
	 * @param id
	 * @return
	 * @return: String
	 */
	@GetMapping("/publish")
	public String publish(Model model,Integer id) {
		ArticleWithBLOBs article = articleService.selectByPrimaryKey(id);
		model.addAttribute("article", article);
		return "/my/updateArticle";
	}
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 修改个人文章
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@PostMapping("updateArticle")
	public Object updateArticle(HttpServletRequest request,ArticleWithBLOBs article,MultipartFile file) {
		if(!file.isEmpty()) {
			String path="d:/pic/";
			String oldFilename = file.getOriginalFilename();
			String newFilename = UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
			try {
				file.transferTo(new File(path+newFilename));
				article.setPicture(newFilename);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession(false);
		if(session==null) 
			return false;
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		article.setCreated(new Date());
		article.setUpdated(new Date());
		article.setHot(0);
		article.setStatus(0);
		article.setDeleted(0);
		article.setHits(0);
		int i = articleService.updateByPrimaryKeySelective(article);
		return i>0;
	}
	/**
	 * 
	 * @Title: delArticle 
	 * @Description: 撤销发布的文章
	 * @param id
	 * @param page
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@GetMapping("delArticle")
	public Object delArticle(ArticleWithBLOBs article) {
		article.setDeleted(1);
		return articleService.updateByPrimaryKeySelective(article)>0;
		
	}
	
}
