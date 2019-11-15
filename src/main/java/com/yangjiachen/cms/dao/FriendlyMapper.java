/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FriendlyService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.dao 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月29日 下午2:53:48 
 */
package com.yangjiachen.cms.dao;

import java.util.List;

import com.yangjiachen.cms.domain.Friendly;

/** 
 * @ClassName: FriendlyService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月29日 下午2:53:48  
 */
public interface FriendlyMapper {
	List<Friendly> selects();

	/** 
	 * @Title: insert 
	 * @Description: TODO
	 * @param friendly
	 * @return
	 * @return: int
	 */
	int insert(Friendly friendly);
}
