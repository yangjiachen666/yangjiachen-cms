/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ChannelService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月18日 下午2:13:11 
 */
package com.yangjiachen.cms.service;

import java.util.List;

import com.yangjiachen.cms.domain.Channel;

/** 
 * @ClassName: ChannelService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月18日 下午2:13:11  
 */
public interface ChannelService {
	List<Channel> selects();
}
