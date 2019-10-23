/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ChannelServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月18日 下午2:13:25 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjiachen.cms.dao.ChannelMapper;
import com.yangjiachen.cms.domain.Channel;
import com.yangjiachen.cms.service.ChannelService;

/** 
 * @ClassName: ChannelServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月18日 下午2:13:25  
 */
@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channelMapper;

	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @return 
	 * @see com.yangjiachen.cms.service.ChannelService#selects() 
	 */
	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelMapper.selects();
	}
	
	
}
