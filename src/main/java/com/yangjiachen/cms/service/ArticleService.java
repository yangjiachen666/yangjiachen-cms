/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月16日 下午7:22:54 
 */
package com.yangjiachen.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.domain.Category;

/** 
 * @ClassName: ArticleService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月16日 下午7:22:54  
 */
public interface ArticleService {
	
	PageInfo<ArticleWithBLOBs> selects(Article article,Integer page,Integer pageSize);
	
    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

}
