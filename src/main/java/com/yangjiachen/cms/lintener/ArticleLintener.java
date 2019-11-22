/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleLintener.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.lintener 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年11月13日 下午2:52:19 
 */
package com.yangjiachen.cms.lintener;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.yangjiachen.cms.dao.ArticleMapper;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;

/** 
 * @ClassName: ArticleLintener 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年11月13日 下午2:52:19  
 */
public class ArticleLintener implements MessageListener<String, String>{

	@Resource
	private ArticleMapper articleMapper;
	/* (non Javadoc) 
	 * @Title: onMessage
	 * @Description: TODO
	 * @param data 
	 * @see org.springframework.kafka.listener.GenericMessageListener#onMessage(java.lang.Object) 
	 */
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		String value = data.value();
		System.err.println(value+"============");
		if(value.startsWith("article")) {
			String[] split = value.split("=");
			String id = split[1];
			System.err.println("接收到id了==="+id);
			ArticleWithBLOBs bs = articleMapper.selectByPrimaryKey(Integer.parseInt(id));
			bs.setHits(bs.getHits()+1);
			articleMapper.updateByPrimaryKeySelective(bs);
			System.err.println("修改完成了");
		}else {
			ArticleWithBLOBs bs = JSON.parseObject(value, ArticleWithBLOBs.class);
			articleMapper.insertSelective(bs);
			System.err.println("添加完成了");
		}
		
	}
	
}
