package com.sdc.system.spring.redis.cache.key;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.cache.interceptor.KeyGenerator;


/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月16日
* @Company: ediankai
*/
public class MyKeyGenerator implements KeyGenerator{

	
	public Object generate(Object target, Method method, Object... params) {
		
		Map map = new MyCacheKey(target, method, params).keyHash();
		
//		return ":" + hashcode;
		return  map;
	}

}