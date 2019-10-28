/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: TermServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月27日 下午7:06:00 
 */
package com.yangjiachen.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjiachen.cms.dao.TermMapper;
import com.yangjiachen.cms.domain.Term;
import com.yangjiachen.cms.service.TermService;

/** 
 * @ClassName: TermServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月27日 下午7:06:00  
 */
@Service
public class TermServiceImpl implements TermService {
	@Resource
	private TermMapper termMapper;

	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param articleTerm
	 * @return 
	 * @see com.yangjiachen.cms.service.TermService#insert(com.yangjiachen.cms.domain.ArticleTerm) 
	 */
	@Override
	public int insert(Term term) {
		// TODO Auto-generated method stub
		return termMapper.insert(term);
	}

	/* (non Javadoc) 
	 * @Title: selectByName
	 * @Description: TODO
	 * @param name
	 * @return 
	 * @see com.yangjiachen.cms.service.TermService#selectByName(java.lang.String) 
	 */
	@Override
	public Term selectByName(String name) {
		// TODO Auto-generated method stub
		return termMapper.selectByName(name);
	}

}
