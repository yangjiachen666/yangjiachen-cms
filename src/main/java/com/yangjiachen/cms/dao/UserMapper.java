package com.yangjiachen.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yangjiachen.cms.domain.User;

public interface UserMapper {
	
	List<User> users(@Param("username")String username);

	User getUserByUsername(User user);
	
    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    Integer selectByUsername(String username);
}