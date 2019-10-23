package com.yangjiachen.cms.dao;

import java.util.List;

import com.yangjiachen.cms.domain.Article;
import com.yangjiachen.cms.domain.ArticleWithBLOBs;

public interface ArticleMapper {

	List<Article> selects(Article article);
		
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
}