package com.sdc.system.spring.redis.factory.pool;

import redis.clients.jedis.Jedis;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年3月10日
* @Company: ediankai
*/
public interface RedisPool {

    /** 
     * 构造方法执行后，初始化， 
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次
     */
    public void init();
       
     /** 
      * 获取Jedis实例 
      * @return 
      */  
     public Jedis getResource() ; 
            
     /** 
      * 释放jedis资源 
      * @param jedis 
      */  
      public void returnResource(final Jedis jedis, boolean conectionBroken) ;  
	
	
}
