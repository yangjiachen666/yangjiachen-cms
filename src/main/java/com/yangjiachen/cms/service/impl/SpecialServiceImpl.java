/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialServiceImpl.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service.impl 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月25日 下午2:34:44 
 */
package com.yangjiachen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangjiachen.cms.dao.ArticleMapper;
import com.yangjiachen.cms.dao.SpecialMapper;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;
import com.yangjiachen.cms.domain.Special;
import com.yangjiachen.cms.domain.SpecialArticle;
import com.yangjiachen.cms.exception.CMSException;
import com.yangjiachen.cms.service.SpecialService;
import com.yangjiachen.common.utils.StringUtil;

/** 
 * @ClassName: SpecialServiceImpl 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月25日 下午2:34:44  
 */
@Service
public class SpecialServiceImpl implements SpecialService {
	@Resource
	private SpecialMapper specialMapper;
	@Resource
	private ArticleMapper articleMapper;
	
	/* (non Javadoc) 
	 * @Title: selects
	 * @Description: TODO
	 * @return 
	 * @see com.yangjiachen.cms.service.SpecialService#selects() 
	 */
	@Override
	public List<Special> selects() {
		return specialMapper.selects();
	}

	/* (non Javadoc) 
	 * @Title: addSpecial
	 * @Description: 添加专题时验证标题是否是空的,如果是空的则添加失败
	 * @param special
	 * @return 
	 * @see com.yangjiachen.cms.service.SpecialService#addSpecial(com.yangjiachen.cms.domain.Special) 
	 */
	@Override
	public int addSpecial(Special special) {
		String title = special.getTitle();
		boolean b = StringUtil.hasText(title);
		
		if(b) {
			return specialMapper.addSpecial(special);
		}
		
		return 0;
	}

	/* (non Javadoc) 
	 * @Title: updatespecial
	 * @Description: 修改专题时验证专题是否是空的,如果空的则修改失败
	 * @param special
	 * @return 
	 * @see com.yangjiachen.cms.service.SpecialService#updatespecial(com.yangjiachen.cms.domain.Special) 
	 */
	@Override
	public int updatespecial(Special special) {
		String title = special.getTitle();
		if(StringUtil.hasText(title)) {
			return specialMapper.updatespecial(special);
		}
		return 0;
	}
	/* (non Javadoc) 
	 * @Title: selectSpecialBySid
	 * @Description: TODO
	 * @param sid
	 * @return 
	 * @see com.yangjiachen.cms.service.SpecialService#selectSpecialBySid(java.lang.Integer) 
	 */
	@Override
	public Special selectSpecialBySid(Integer sid) {
		// TODO Auto-generated method stub
		return specialMapper.selectSpecialBySid(sid);
	}

	/* (non Javadoc) 
	 * @Title: addArticle
	 * @Description: TODO
	 * @param specialArticle
	 * @return 
	 * @see com.yangjiachen.cms.service.SpecialService#addArticle(com.yangjiachen.cms.domain.SpecialArticle) 
	 */
	@Override
	public int addArticle(SpecialArticle specialArticle) {
		Integer aid = specialArticle.getAid();
		ArticleWithBLOBs article = articleMapper.selectByPrimaryKey(aid);
		if(article!=null) {
			return specialMapper.addArticle(specialArticle);
		}else {
			throw new CMSException("没有此文章呦");
		}
		
	}
}
