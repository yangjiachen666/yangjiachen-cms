/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialService.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.service 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月25日 下午2:34:31 
 */
package com.yangjiachen.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yangjiachen.cms.domain.Special;
import com.yangjiachen.cms.domain.SpecialArticle;

/** 
 * @ClassName: SpecialService 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月25日 下午2:34:31  
 */
public interface SpecialService {
	List<Special> selects();

	/** 
	 * @Title: addSpecial 
	 * @Description: TODO
	 * @param special
	 * @return
	 * @return: boolean
	 */
	int addSpecial(Special special);
	
	int updatespecial(Special special);
	
	Special selectSpecialBySid(@Param("sid")Integer sid);

	/** 
	 * @Title: addArticle 
	 * @Description: TODO
	 * @param specialArticle
	 * @return
	 * @return: int
	 */
	int addArticle(SpecialArticle specialArticle);
}
