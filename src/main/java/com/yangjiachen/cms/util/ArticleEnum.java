/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: ArticleEnum.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.util 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月24日 下午6:35:14 
 */
package com.yangjiachen.cms.util;

/** 
 * @ClassName: ArticleEnum 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月24日 下午6:35:14  
 */
public enum ArticleEnum {
	
	HTML(0,"html"),IMAGE(1,"image");
	
	private Integer code;
	private String name;
	
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	ArticleEnum(Integer code,String name) {
		this.code=code;
		this.name=name;
	}
	
}
