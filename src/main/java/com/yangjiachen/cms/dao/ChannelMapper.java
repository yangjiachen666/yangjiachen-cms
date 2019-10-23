package com.yangjiachen.cms.dao;

import java.util.List;

import com.yangjiachen.cms.domain.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

	/** 
	 * @Title: selects 
	 * @Description: TODO
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
}