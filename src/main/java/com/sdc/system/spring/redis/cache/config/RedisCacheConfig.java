package com.sdc.system.spring.redis.cache.config;
/*package com.sdc.utils.redis.cache.config;

*//**
* description: spring cache和redis的结合配置类
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月17日
* @Company: ediankai
*//*

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.sdc.utils.redis.cache.key.MyKeyGenerator;

import java.util.ResourceBundle;


@Configuration
@EnableCaching
@ComponentScan("com.kingdowin.xiugr.server")
@PropertySource("classpath:/redis-cache.properties")
public class RedisCacheConfig extends CachingConfigurerSupport {


    private static final ResourceBundle bundle = ResourceBundle.getBundle("redis-cache");

    private String redisHost = bundle.getString("redis.host");
    private int redisPort = Integer.valueOf(bundle.getString("redis.port"));
//    private String redisPassword = bundle.getString("redis.auth");
    private int expireTime = Integer.valueOf(bundle.getString("cache.expiretime"));
    private int database = Integer.valueOf(bundle.getString("redis.database"));

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        // Defaults
        redisConnectionFactory.setHostName(redisHost);
        redisConnectionFactory.setPort(redisPort);
        redisConnectionFactory.setDatabase(database);
        
//        redisConnectionFactory.setPassword(redisPassword);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

    *//**
     * 缓存管理器
     * @param redisTemplate
     * @return
     *//*
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(expireTime);// Sets the default expire time (in seconds)
        return cacheManager;
    }

    *//**
     * @description 自定义的缓存key的生成策略</br>
     *              若想使用这个key</br>
     *              只需要讲注解上keyGenerator的值设置为customKeyGenerator即可</br>
     * @return 自定义策略生成的key
     *//*
    @Bean
    public KeyGenerator customKeyGenerator() {
        
    	return new MyKeyGenerator();
    	
    }

}*/