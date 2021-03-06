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
import com.yangjiachen.cms.domain.ArticleTerm;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.domain.Term;
import com.yangjiachen.cms.exception.CMSException;
import com.yangjiachen.cms.service.ArticleService;
import com.yangjiachen.cms.service.ArticleTermService;
import com.yangjiachen.cms.service.TermService;
import com.yangjiachen.common.utils.StringUtil;

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
	
	@Resource
	private TermService termService;
	
	@Resource
	private ArticleTermService articleTermService;

	/* (non Javadoc) 
	 * @Title: articles
	 * @Description: TODO
	 * @param article
	 * @return 
	 * @see com.yangjiachen.cms.service.ArticleService#articles(com.yangjiachen.cms.domain.Article) 
	 */
	@Override
	public PageInfo<ArticleWithBLOBs> selects(Article article,Integer page,Integer pageSize) {
		PageHelper.startPage(page,pageSize);
		List<ArticleWithBLOBs> articles = articleMapper.selects(article);
		return new PageInfo<ArticleWithBLOBs>(articles);
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
		
		try {
			articleMapper.insertSelective(record);
			String terms = record.getTerms();
			if(StringUtil.hasText(terms)) {
				String[] split = terms.split(",");
				for (String string : split) {
					String name = StringUtil.toUniqueName(string);
					Term term2 = termService.selectByName(name);
					if(term2==null) {
						term2 = new Term();
						term2.setUniqueName(StringUtil.toUniqueName(name));
						termService.insert(term2);
					}
					ArticleTerm term = new ArticleTerm();
					term.setAid(record.getId());
					term.setTid(term2.getId());
					articleTermService.insert(term);
				}
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CMSException("添加失败了");
		}
		
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

	/* (non Javadoc) 
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.yangjiachen.cms.service.ArticleService#deleteByPrimaryKey(java.lang.Integer) 
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.deleteByPrimaryKey(id);
	}	
}
