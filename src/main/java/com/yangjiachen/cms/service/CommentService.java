/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CommentService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月28日 下午7:58:27 
 */
package com.yangjiachen.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.domain.Comment;

/** 
 * @ClassName: CommentService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月28日 下午7:58:27  
 */
public interface CommentService {
	PageInfo<Comment> selects(Integer articleId,Integer page,Integer pageSize);
	
	
	int insert(Comment comment);
}
