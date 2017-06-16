package com.sdc.utils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import com.sdc.utils.BaseMapper;
import com.sdc.utils.ReflectUtil;


/**
* description: 
* hash key 生成策略
* @author today zhaojintian@ediankai.com
* @date 2016年12月22日
* @Company: ediankai
*/

public class MyHashKey  implements Serializable{


	/**
	* <p>Description: </p>
	* <p>Company: diankai</p>
	* @author today
	* @date 2016年12月17日
	*/
	private static final long serialVersionUID = -268857070365741656L;

	/** 调用目标参数 */
	private Object[] params;
	
	private int hashCode;
	
	private static final Logger logger = Logger.getLogger(MyHashKey.class);
	
	public MyHashKey( Object[] elements ) {
	/*	logger.info(target.toString());
		logger.info(method.toString());
		logger.info(elements.toString());*/
		
		if(ArrayUtils.isNotEmpty(elements)){
			this.params = new Object[elements.length];
			for(int i =0;i<elements.length;i++){
				Object ele = elements[i];
				if(ele instanceof BaseMapper){
					this.params[i] = ReflectUtil.beanToMap(ele);
				}else{
					this.params[i] = ele;
				}
			}
		}
		this.hashCode = generatorHashCode();

	}
	

	//生成hashCode
	private int generatorHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hashCode;
		result = prime * result + Arrays.hashCode(params);
		return result;
	}

	
	@Override
	public final int hashCode() {
		
		return hashCode;
	}
	
	
	

}