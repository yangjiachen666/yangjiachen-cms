/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleTermServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月27日 下午6:59:59 
 */
package com.yangjiachen.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjiachen.cms.dao.ArticleTermMapper;
import com.yangjiachen.cms.domain.ArticleTerm;
import com.yangjiachen.cms.service.ArticleTermService;

/** 
 * @ClassName: ArticleTermServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月27日 下午6:59:59  
 */
@Service
public class ArticleTermServiceImpl implements ArticleTermService {

	@Resource
	private ArticleTermMapper articleTermMapper;
	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param term 
	 * @see com.yangjiachen.cms.service.ArticleTermService#insert(com.yangjiachen.cms.domain.ArticleTerm) 
	 */
	@Override
	public void insert(ArticleTerm term) {
		// TODO Auto-generated method stub
		 articleTermMapper.insert(term);
	}
	
	
	
}
