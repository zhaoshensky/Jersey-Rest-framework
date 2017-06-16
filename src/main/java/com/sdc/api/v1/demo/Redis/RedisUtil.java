package com.sdc.api.v1.demo.Redis;

import com.sdc.system.spring.redis.RedisFactory;
import com.sdc.system.spring.redis.factory.RedisBase;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/13.
 */
@Repository
public class RedisUtil {
    RedisFactory redisBase = new RedisBase("Cache");


    public String get(String key) {
        String s = redisBase.get(key);
        return s;
    }

    public Long delAll(String[] key) {
        //如果是多个不允许删除
        Long del = redisBase.del(key);
        return del;
    }

    public String getHash(String key, String field) {
        String s = redisBase.hget(key, field);
        return s;
    }

    public Long delHash(String key, String[] field) {
        //如果是多个不允许删除
        Long del = redisBase.hdel(key, field);
        return del;
    }
}
