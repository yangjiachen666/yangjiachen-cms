/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: SpecialMapper.java 
 * @Prject: yangjiachen-cms
 * @Package: com.yangjiachen.cms.dao 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年10月25日 下午2:28:34 
 */
package com.yangjiachen.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yangjiachen.cms.domain.Special;
import com.yangjiachen.cms.domain.SpecialArticle;

/** 
 * @ClassName: SpecialMapper 
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年10月25日 下午2:28:34  
 */
public interface SpecialMapper {
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

	int addArticle(SpecialArticle specialArticle);
	
}
