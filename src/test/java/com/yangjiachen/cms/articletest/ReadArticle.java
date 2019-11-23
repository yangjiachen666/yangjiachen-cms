/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ReadArticle.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.articletest 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年11月22日 下午3:49:14 
 */
package com.yangjiachen.cms.articletest;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.serializer.CalendarCodec;
import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.service.RedisArticleService;
import com.yangjiachen.common.utils.DateUtil;
import com.yangjiachen.common.utils.FileUtil;
import com.yangjiachen.common.utils.RandomUtil;
import com.yangjiachen.common.utils.StreamUtil;

/** 
 * @ClassName: ReadArticle 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年11月22日 下午3:49:14  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ReadArticle {
	@Autowired
	private RedisArticleService redisArticleService;
	@Test
	public  void readArticle() {
		File file = new File("D:\\article");
		File[] files = file.listFiles();
		int i = 0;
		for (File txts : files) {
			ArticleWithBLOBs article = new ArticleWithBLOBs();
			String title = txts.getName().substring(0,txts.getName().lastIndexOf("."));
			article.setTitle(title);
			String string = StreamUtil.readTextFile(txts);
			article.setContent(string);
			String summary = string.substring(0, 50);
			article.setSummary(summary);
			article.setHits(RandomUtil.random(0,100));
			article.setHits(RandomUtil.random(0, 1));
			article.setUserId(156);
			Calendar calendar = Calendar.getInstance();
			calendar.set(2019, 0, 1);
			Date date = DateUtil.randomDate(calendar.getTime(), new Date());
			article.setCreated(date);
			redisArticleService.save(article);
			i++;
			if(i>150)
				break;
		}
		
	}
}
