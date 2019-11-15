/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CommentServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月28日 下午7:58:46 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangjiachen.cms.dao.CommentMapper;
import com.yangjiachen.cms.domain.Comment;
import com.yangjiachen.cms.service.CommentService;

/** 
 * @ClassName: CommentServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月28日 下午7:58:46  
 */
@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource
	private CommentMapper commentMapper;

	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @param articleId
	 * @return 
	 * @see com.yangjiachen.cms.service.CommentService#selects(java.lang.Integer) 
	 */
	@Override
	public PageInfo<Comment> selects(Integer articleId,Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Comment> comments = commentMapper.selects(articleId);
		PageInfo<Comment> info = new PageInfo<Comment>(comments);
		return info;
	}

	/* (non Javadoc) 
	 * @Title: insert
	 * @Description: TODO
	 * @param comment
	 * @return 
	 * @see com.yangjiachen.cms.service.CommentService#insert(com.yangjiachen.cms.domain.Comment) 
	 */
	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.insert(comment);
	}
}
