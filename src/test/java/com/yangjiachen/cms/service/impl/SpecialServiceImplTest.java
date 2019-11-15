/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialServiceImplTest.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月30日 上午9:03:48 
 */
package com.yangjiachen.cms.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangjiachen.cms.domain.Special;
import com.yangjiachen.cms.service.SpecialService;

/** 
 * @ClassName: SpecialServiceImplTest 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月30日 上午9:03:48  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class SpecialServiceImplTest {
	@Resource
	private SpecialService specialService;

	/**
	 * Test method for {@link com.yangjiachen.cms.service.impl.SpecialServiceImpl#selects()}.
	 */
	@Test
	public void testSelects() {
		List<Special> selects = specialService.selects();
		for (Special special : selects) {
			System.out.println(special);
		}
	}
	
	@Test
	public void testSelectById() {
		Special special = specialService.selectSpecialBySid(1);
		System.out.println(special);
	}

}
