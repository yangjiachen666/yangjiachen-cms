/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CategoryService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月18日 下午2:37:07 
 */
package com.yangjiachen.cms.service;

import java.util.List;

import com.yangjiachen.cms.domain.Category;

/** 
 * @ClassName: CategoryService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月18日 下午2:37:07  
 */
public interface CategoryService {
	List<Category> selects (Integer id);
}
