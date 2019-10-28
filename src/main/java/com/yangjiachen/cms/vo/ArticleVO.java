/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleVO.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.vo 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月24日 下午7:35:30 
 */
package com.yangjiachen.cms.vo;

import java.io.Serializable;

/** 
 * @ClassName: ArticleVO 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月24日 下午7:35:30  
 */
public class ArticleVO implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private String descipt;
	private String url;
	/**
	 * @return the descipt
	 */
	public String getDescipt() {
		return descipt;
	}
	/**
	 * @param descipt the descipt to set
	 */
	public void setDescipt(String descipt) {
		this.descipt = descipt;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
