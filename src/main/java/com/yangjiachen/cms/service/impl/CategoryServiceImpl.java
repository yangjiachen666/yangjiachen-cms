/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CategoryServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月18日 下午2:37:25 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjiachen.cms.dao.CategoryMapper;
import com.yangjiachen.cms.domain.Category;
import com.yangjiachen.cms.service.CategoryService;

/** 
 * @ClassName: CategoryServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月18日 下午2:37:25  
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryMapper;

	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @return 
	 * @see com.yangjiachen.cms.service.CategoryService#selects() 
	 */
	@Override
	public List<Category> selects(Integer channelId) {
		// TODO Auto-generated method stub
		return categoryMapper.selects(channelId);
	}
	
	
}
