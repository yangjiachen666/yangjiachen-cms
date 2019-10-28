/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: Term.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.dao 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月27日 下午6:56:41 
 */
package com.yangjiachen.cms.dao;

import org.apache.ibatis.annotations.Param;

import com.yangjiachen.cms.domain.Term;

/** 
 * @ClassName: Term 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月27日 下午6:56:41  
 */
public interface TermMapper {

	/** 
	 * @Title: insert 
	 * @Description: TODO
	 * @param term
	 * @return
	 * @return: int
	 */
	int insert(Term term);
	
	Term selectByName(@Param("uniqueName")String name);
}
