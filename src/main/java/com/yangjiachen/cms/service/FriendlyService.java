/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FriendlyService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月29日 下午2:57:12 
 */
package com.yangjiachen.cms.service;

import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.domain.Friendly;

/** 
 * @ClassName: FriendlyService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月29日 下午2:57:12  
 */
public interface FriendlyService {
	PageInfo<Friendly> selects(Integer page,Integer pageSize);
	
	int insert(Friendly friendly);
}
