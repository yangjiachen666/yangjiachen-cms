/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: CMSException.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.exception 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月17日 下午2:33:59 
 */
package com.yangjiachen.cms.exception;

/** 
 * @ClassName: CMSException 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月17日 下午2:33:59  
 */
public class CMSException extends RuntimeException{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** 
	 * @Title:CMSException
	 * @Description:TODO 
	 * @param messages 
	 */
	public CMSException(String messages) {
		super(messages);
	}
	public CMSException() {
		super();
	}
}
