/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: UserVO.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.vo 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月17日 下午2:31:09 
 */
package com.yangjiachen.cms.vo;

import com.yangjiachen.cms.domain.User;

/** 
 * @ClassName: UserVO 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月17日 下午2:31:09  
 */
public class UserVO extends User {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private String repassword;

	/**
	 * @return the repassword
	 */
	public String getRepassword() {
		return repassword;
	}

	/**
	 * @param repassword the repassword to set
	 */
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
