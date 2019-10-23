/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: UserService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月15日 下午8:19:39 
 */
package com.yangjiachen.cms.service;

import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.domain.User;
import com.yangjiachen.cms.vo.UserVO;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月15日 下午8:19:39  
 */
public interface UserService {
	PageInfo<User> users(String username,Integer pageNum,Integer pageSize);

    int insertSelective(UserVO userVO);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);
    
    Integer selectByUsername(String username);
    
    User getUserByUsername(User user);
}
