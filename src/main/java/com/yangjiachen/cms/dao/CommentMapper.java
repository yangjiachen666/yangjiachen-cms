/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CommonMapper.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.dao 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月28日 下午7:39:26 
 */
package com.yangjiachen.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yangjiachen.cms.domain.Comment;

/** 
 * @ClassName: CommonMapper 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月28日 下午7:39:26  
 */
public interface CommentMapper {
	List<Comment> selects(@Param("articleId")Integer articleId);
	
	int insert(Comment comment);
}
