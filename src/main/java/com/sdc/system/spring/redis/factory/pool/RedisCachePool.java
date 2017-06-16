package com.sdc.system.spring.redis.factory.pool;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年1月7日
* @Company: ediankai
*/
import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;  
import redis.clients.jedis.JedisPoolConfig;  

@Repository
public class RedisCachePool implements RedisPool{  
	
	 private static final Logger logger = Logger.getLogger(RedisCachePool.class);
     
     private static JedisPool jedisPool = null;  
     
     private static int redisPoolMaxTotal;
     
     private static int redisPoolMaxIdle;
     
     private static int redisPoolMaxWaitMillis;
     
     private static boolean redisPoolTestOnReturn;
     
     private static String redisPoolHostName;
    
     private static int redisPoolPort;
    
     private static int redisPoolTimeout;
     
     
     

	/**
	 * @param redisPoolMaxTotal the redisPoolMaxTotal to set
	 */
     @Value("${redis.pool.maxTotal}")
	public void setRedisPoolMaxTotal(int redisPoolMaxTotal) {
		RedisCachePool.redisPoolMaxTotal = redisPoolMaxTotal;
	}

	/**
	 * @param redisPoolMaxIdle the redisPoolMaxIdle to set
	 */
     @Value("${redis.pool.maxIdle}")
	public void setRedisPoolMaxIdle(int redisPoolMaxIdle) {
		RedisCachePool.redisPoolMaxIdle = redisPoolMaxIdle;
	}

	/**
	 * @param redisPoolMaxWaitMillis the redisPoolMaxWaitMillis to set
	 */
     @Value("${redis.pool.maxWaitMillis}")
	public void setRedisPoolMaxWaitMillis(int redisPoolMaxWaitMillis) {
		RedisCachePool.redisPoolMaxWaitMillis = redisPoolMaxWaitMillis;
	}

	/**
	 * @param redisPoolTestOnReturn the redisPoolTestOnReturn to set
	 */
     @Value("${redis.pool.testOnReturn}")
	public  void setRedisPoolTestOnReturn(boolean redisPoolTestOnReturn) {
		RedisCachePool.redisPoolTestOnReturn = redisPoolTestOnReturn;
	}

	/**
	 * @param redisPoolHostName the redisPoolHostName to set
	 */
     @Value("${rediscache.pool.hostName}")
	public void setRedisPoolHostName(String redisPoolHostName) {
		RedisCachePool.redisPoolHostName = redisPoolHostName;
	}

	/**
	 * @param redisPoolPort the redisPoolPort to set
	 */
     @Value("${rediscache.pool.port}")
	public void setRedisPoolPort(int redisPoolPort) {
		RedisCachePool.redisPoolPort = redisPoolPort;
	}

	/**
	 * @param redisPoolTimeout the redisPoolTimeout to set
	 */
     @Value("${redis.pool.timeout}")
	public void setRedisPoolTimeout(int redisPoolTimeout) {
		RedisCachePool.redisPoolTimeout = redisPoolTimeout;
	}
     
     /** 
      * 构造方法执行后，初始化， 
      * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次
      */
     @PostConstruct  
     public void init(){
   	  
   	  if( jedisPool == null ){
   		  try {  
           	  
	        	 /* ResourceBundle bundle = ResourceBundle.getBundle("spring/properties/test/redis");
				    if (bundle == null) {
					throw new IllegalArgumentException(
						"[redis-data.properties] is not found!");
				    }*/
	        	 
	               JedisPoolConfig config = new JedisPoolConfig();  
	               config.setMaxTotal( redisPoolMaxTotal );  
	               config.setMaxIdle( redisPoolMaxIdle  );  
	               config.setMaxWaitMillis( redisPoolMaxWaitMillis );  
	               config.setTestOnBorrow( redisPoolTestOnReturn );  
	               
	               jedisPool = new JedisPool ( config, redisPoolHostName, redisPoolPort , redisPoolTimeout ); 
	          } catch (Exception e) {  
	               e.printStackTrace();  
	          }  
   	  }
   	  
     }
        
      /** 
       * 获取Jedis实例 
       * @return 
       */  
      public synchronized Jedis getResource() {  
          try {  
              if (jedisPool != null) {  
                  Jedis resource = jedisPool.getResource();  
                  logger.info(resource.toString());
                  return resource;  
              } else {  
                  return null;  
              }  
          } catch (Exception e) {  
              e.printStackTrace();  
              return null;  
          }  
      }  
             
      /** 
       * 释放jedis资源 
       * @param jedis 
       */  
       public synchronized void returnResource(final Jedis jedis, boolean conectionBroken) {  
           if (jedis == null) {  
        	   return;
           } 
           try {
               if (conectionBroken) {
                   jedisPool.returnBrokenResource(jedis);
               } else {
                   jedisPool.returnResource(jedis);
               }
           } catch (Exception e) {
               logger.error("return back jedis failed, will fore close the jedis.", e);
           
           }
           
       }  
       
  
}  