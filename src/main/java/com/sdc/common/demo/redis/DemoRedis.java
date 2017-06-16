package com.sdc.common.demo.redis;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sdc.system.spring.redis.RedisFactory;
import com.sdc.system.spring.redis.factory.RedisBase;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月19日
* @Company: ediankai
*/
@Repository 
public class DemoRedis {
	
//	@Resource
	private RedisFactory redisBase = new RedisBase("Data");
	
	public void setDemo(){
		redisBase.set("redistest", "123");
	}

}
