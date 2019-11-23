/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: RedisArticleService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年11月22日 下午4:01:58 
 */
package com.yangjiachen.cms.service;

import com.yangjiachen.cms.domain.ArticleWithBLOBs;

/** 
 * @ClassName: RedisArticleService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年11月22日 下午4:01:58  
 */
public interface RedisArticleService {
	void save(ArticleWithBLOBs articleWithBLOBs);
}
