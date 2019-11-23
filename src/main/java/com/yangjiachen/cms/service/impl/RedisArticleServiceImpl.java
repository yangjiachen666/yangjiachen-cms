/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: RedisArticleServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年11月22日 下午4:02:11 
 */
package com.yangjiachen.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.service.RedisArticleService;

/** 
 * @ClassName: RedisArticleServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年11月22日 下午4:02:11  
 */
@Service
public class RedisArticleServiceImpl implements RedisArticleService {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private int i=0;
	public void save(ArticleWithBLOBs articleWithBLOBs) {
		String redisKey = "saveArticle_"+i;
		redisTemplate.opsForValue().set(redisKey, articleWithBLOBs);
		i++;
		kafkaTemplate.send("articles", redisKey);
		System.err.println(i);
		System.err.println("发送成功");
	}
}
