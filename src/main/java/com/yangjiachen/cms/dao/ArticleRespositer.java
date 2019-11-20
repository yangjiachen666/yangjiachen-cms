/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleRespositer.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.dao 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年11月19日 下午1:22:31 
 */
package com.yangjiachen.cms.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;

/** 
 * @ClassName: ArticleRespositer 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年11月19日 下午1:22:31  
 */
public interface ArticleRespositer extends ElasticsearchRepository<ArticleWithBLOBs, Integer>{
	
	List<ArticleWithBLOBs> findByTitle(String key);
	
}
