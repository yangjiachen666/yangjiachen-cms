/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleTermServiceImplTest.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月27日 下午7:01:07 
 */
package com.yangjiachen.cms.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangjiachen.cms.domain.Term;
import com.yangjiachen.cms.service.TermService;
import com.yangjiachen.common.utils.StreamUtil;
import com.yangjiachen.common.utils.StringUtil;

/** 
 * @ClassName: ArticleTermServiceImplTest 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月27日 下午7:01:07  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {

	@Resource
	private TermService termService;

	@Test
	public void test11() {
		String file = StreamUtil.readTextFile(this.getClass().getResourceAsStream("/data.txt"));
		System.out.println(file);
		String[] split = file.split("\\|");
		for (String string : split) {
			Term term = new Term();
			String uniqueName = StringUtil.toUniqueName(string);
			term.setUniqueName(uniqueName);
			termService.insert(term);
		}

	}
}
