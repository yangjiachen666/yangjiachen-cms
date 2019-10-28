/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: Term.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.domain 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月27日 下午6:35:43 
 */
package com.yangjiachen.cms.domain;

/** 
 * @ClassName: Term 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月27日 下午6:35:43  
 */
public class Term {
	private Integer id;
	private String displayName;
	private String uniqueName;
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
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the uniqueName
	 */
	public String getUniqueName() {
		return uniqueName;
	}
	/**
	 * @param uniqueName the uniqueName to set
	 */
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}
}
