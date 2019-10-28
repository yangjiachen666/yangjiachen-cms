/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: Special.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.domain 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月25日 下午2:26:36 
 */
package com.yangjiachen.cms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
 * @ClassName: Special 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月25日 下午2:26:36  
 */
public class Special implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String abstracts;
	private Date created;
	private Integer count;
	private List<Article> articles;
	/**
	 * @return the articles
	 */
	public List<Article> getArticles() {
		return articles;
	}
	/**
	 * @param articles the articles to set
	 */
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the abstracts
	 */
	public String getAbstracts() {
		return abstracts;
	}
	/**
	 * @param abstracts the abstracts to set
	 */
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/* (non Javadoc) 
	 * @Title: toString
	 * @Description: TODO
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "Special [id=" + id + ", title=" + title + ", abstracts=" + abstracts + ", created=" + created
				+ ", count=" + count + ", articles=" + articles + "]";
	}
}
