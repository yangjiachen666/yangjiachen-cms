/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月16日 下午7:23:08 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.dao.ArticleMapper;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.service.ArticleService;

/** 
 * @ClassName: ArticleServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月16日 下午7:23:08  
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Resource
	private ArticleMapper articleMapper;

	/* (non Javadoc) 
	 * @Title: articles
	 * @Description: TODO
	 * @param article
	 * @return 
	 * @see com.yangjiachen.cms.service.ArticleService#articles(com.yangjiachen.cms.domain.Article) 
	 */
	@Override
	public PageInfo<Article> selects(Article article,Integer page,Integer pageSize) {
		PageHelper.startPage(page,pageSize);
		List<Article> articles = articleMapper.selects(article);
		return new PageInfo<Article>(articles);
	}

	/* (non Javadoc) 
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param record
	 * @return 
	 * @see com.yangjiachen.cms.service.ArticleService#insertSelective(com.yangjiachen.cms.domain.ArticleWithBLOBs) 
	 */
	@Override
	public int insertSelective(ArticleWithBLOBs record) {
		// TODO Auto-generated method stub
		return articleMapper.insertSelective(record);
	}

	/* (non Javadoc) 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.yangjiachen.cms.service.ArticleService#selectByPrimaryKey(java.lang.Integer) 
	 */
	@Override
	public ArticleWithBLOBs selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	/* (non Javadoc) 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO
	 * @param record
	 * @return 
	 * @see com.yangjiachen.cms.service.ArticleService#updateByPrimaryKeySelective(com.yangjiachen.cms.domain.ArticleWithBLOBs) 
	 */
	@Override
	public int updateByPrimaryKeySelective(ArticleWithBLOBs record) {
		// TODO Auto-generated method stub
		return articleMapper.updateByPrimaryKeySelective(record);
	}	
}
