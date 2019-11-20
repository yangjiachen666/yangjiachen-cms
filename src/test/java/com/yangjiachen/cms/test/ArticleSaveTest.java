/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleSaveTest.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.test 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年11月19日 下午1:27:40 
 */
package com.yangjiachen.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangjiachen.cms.dao.ArticleMapper;
import com.yangjiachen.cms.dao.ArticleRespositer;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;

/** 
 * @ClassName: ArticleSaveTest 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年11月19日 下午1:27:40  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleSaveTest {
	
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleRespositer articleRespositer;
	
	@Test
	public void saveArticle() {
		List<ArticleWithBLOBs> selects = articleMapper.selects(null);
		articleRespositer.saveAll(selects);
	}
	
	
}
