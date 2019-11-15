/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: FriendlyServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月29日 下午2:57:29 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.dao.FriendlyMapper;
import com.yangjiachen.cms.domain.Friendly;
import com.yangjiachen.cms.service.FriendlyService;

/** 
 * @ClassName: FriendlyServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月29日 下午2:57:29  
 */
@Service
public class FriendlyServiceImpl implements FriendlyService {
	@Resource
	private FriendlyMapper friendlyMapper;

	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @return 
	 * @see com.yangjiachen.cms.service.FriendlyService#selects() 
	 */
	@Override
	public PageInfo<Friendly> selects(Integer page,Integer pageSize) {
		PageHelper.startPage(page,pageSize);
		List<Friendly> list = friendlyMapper.selects();
		
		return new PageInfo<Friendly>(list);
	}

	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param friendly
	 * @return 
	 * @see com.yangjiachen.cms.service.FriendlyService#insert(com.yangjiachen.cms.domain.Friendly) 
	 */
	@Override
	public int insert(Friendly friendly) {
		// TODO Auto-generated method stub
		return friendlyMapper.insert(friendly);
	}
	
}
