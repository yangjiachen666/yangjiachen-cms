/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: TermService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月27日 下午7:05:31 
 */
package com.yangjiachen.cms.service;

import com.yangjiachen.cms.domain.Term;

/** 
 * @ClassName: TermService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月27日 下午7:05:31  
 */
public interface TermService {
	int insert(Term term);

	/** 
	 * @Title: selectByName 
	 * @Description: TODO
	 * @param name
	 * @return
	 * @return: Term
	 */
	Term selectByName(String name);

	
}
