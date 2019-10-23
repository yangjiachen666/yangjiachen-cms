/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: UserServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月15日 下午8:19:57 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.dao.UserMapper;
import com.yangjiachen.cms.domain.User;
import com.yangjiachen.cms.exception.CMSException;
import com.yangjiachen.cms.service.UserService;
import com.yangjiachen.cms.util.Md5Util;
import com.yangjiachen.cms.vo.UserVO;
import com.yangjiachen.common.utils.StringUtil;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月15日 下午8:19:57  
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	/* (non Javadoc) 
	 * @Title: users
	 * @Description: TODO
	 * @param username
	 * @return 
	 * @see com.yangjiachen.cms.service.UserService#users(java.lang.String) 
	 */
	@Override
	public PageInfo<User> users(String username,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.users(username);
		return new PageInfo<User>(users);
	}

	/* (non Javadoc) 
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param record
	 * @return 
	 * @see com.yangjiachen.cms.service.UserService#insertSelective(com.yangjiachen.cms.domain.User) 
	 */
	@Override
	public int insertSelective(UserVO userVO) {
		
		if(null==userVO) {
			throw new CMSException("您的账号和密码没有输入呦");
		}
		if(!StringUtil.hasText(userVO.getUsername())) {
			throw new CMSException("用户名不能为空呦");
		}
		if(userVO.getUsername().length()<2 || userVO.getUsername().length()>5) {
			throw new CMSException("用户名的长度在2-5位呦");
		}
		if(!StringUtil.hasText(userVO.getPassword())) {
			throw new CMSException("密码不能为空呦");
		}
		if(userVO.getPassword().length()<8 || userVO.getPassword().length()>15) {
			throw new CMSException("密码长度在8-15位");
		}
		if(!(userVO.getRepassword().equals(userVO.getPassword()))) {
			throw new CMSException("两次输入的密码不一致");
		}
		
		userVO.setPassword(Md5Util.md5Encoding(userVO.getPassword()));
		// TODO Auto-generated method stub
		return userMapper.insertSelective(userVO);
	}

	/* (non Javadoc) 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param id
	 * @return 
	 * @see com.yangjiachen.cms.service.UserService#selectByPrimaryKey(java.lang.Integer) 
	 */
	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	/* (non Javadoc) 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO
	 * @param record
	 * @return 
	 * @see com.yangjiachen.cms.service.UserService#updateByPrimaryKeySelective(com.yangjiachen.cms.domain.User) 
	 */
	@Override
	public int updateByPrimaryKeySelective(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	/* (non Javadoc) 
	 * @Title: selectByUsername
	 * @Description: TODO
	 * @param username
	 * @return 
	 * @see com.yangjiachen.cms.service.UserService#selectByUsername(java.lang.String) 
	 */
	@Override
	public Integer selectByUsername(String username) {
		return userMapper.selectByUsername(username);
	}
	
	/* (non Javadoc) 
	 * @Title: getUserByUsername
	 * @Description: TODO
	 * @param user
	 * @return 
	 * @see com.yangjiachen.cms.service.UserService#getUserByUsername(com.yangjiachen.cms.domain.User) 
	 */
	@Override
	public User getUserByUsername(User user) {
		
		if(null==user)
			throw new CMSException("账号和密码不能为空");
		if(null==user.getUsername()) 
			throw new CMSException("账号不能为空");
		if(null==user.getPassword())
			throw new CMSException("密码不能为空");
		
		User u = userMapper.getUserByUsername(user);
		
		if(u==null)
			throw new CMSException("没有此用户");
		
		if(!(u.getPassword().equals(Md5Util.md5Encoding(user.getPassword()))))
			throw new CMSException("密码不正确");
		
		return u;
	}
}
