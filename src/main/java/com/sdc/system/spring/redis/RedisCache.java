package com.sdc.system.spring.redis;
//package com.sdc.utils.redis;
///**
//* description: redis 缓存配置
//*
//*
//* @author today zhaojintian@ediankai.com
//* @date 2016年12月10日
//* @Company: ediankai
//*/
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//import org.springframework.cache.Cache;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cache.support.SimpleValueWrapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.dao.DataAccessException;  
//import org.springframework.data.redis.connection.RedisConnection;  
//import org.springframework.data.redis.core.RedisCallback;  
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.util.StringUtils;  
//  
///** 
// * 〈一句话功能简述〉<br> 
// * 〈功能详细描述〉 
// *  
// * @author Administrator 
// * @see [相关类/方法]（可选） 
// * @since [产品/模块版本] （可选） 
// */ 
//public class RedisCache implements Cache {  
//  
//    /** 
//     * Redis 
//     */  
//    private RedisTemplate<String, Object> redisTemplate;  
//  
//    /** 
//     * 缓存名称 
//     */  
//    private String name;  
//    
//    /** 
//     * 缓存key 前缀
//     */  
//    private String preKey; 
//
//	/** 
//     * 超时时间 
//     */  
//    private long timeout;  
//    
// 
//  
//    /* 
//     * (non-Javadoc) 
//     * @see org.springframework.cache.Cache#getName() 
//     */  
//    @Override  
//    public String getName() {  
//        return this.name;  
//    }  
//  
//    /* 
//     * (non-Javadoc) 
//     * @see org.springframework.cache.Cache#getNativeCache() 
//     */  
//    @Override  
//    public Object getNativeCache() {  
//        // TODO Auto-generated method stub  
//        return this.redisTemplate;  
//    }  
//  
//    /* 
//     * (non-Javadoc) 
//     * @see org.springframework.cache.Cache#get(java.lang.Object) 
//     */  
//    @Override  
//    public ValueWrapper get(Object key) {  
//    	 
//        if (StringUtils.isEmpty(key)) {  
//            return null;  
//        } else {  
//            final String finalKey;  
//            if (key instanceof String) {  
//                finalKey = this.getPreKey() + (String) key ;  
//            } else {  
//                finalKey = this.getPreKey() + key.toString();  
//            }  
// 
//            Object object = null;  
//            object = redisTemplate.execute(new RedisCallback<Object>() {  
//                public Object doInRedis(RedisConnection connection) throws DataAccessException {  
//                    byte[] key = finalKey.getBytes();  
//                    byte[] value = connection.get(key);  
//                    if (value == null) {  
//                        return null;  
//                    }  
//                   
//                    return toObject(value);
//                }  
//            });  
//            return (object != null ? new SimpleValueWrapper(object) : null);  
//        }  
//    }  
//    
//  
//    /* 
//     * (non-Javadoc) 
//     * @see org.springframework.cache.Cache#get(java.lang.Object, java.lang.Class) 
//     */  
//    @SuppressWarnings("unchecked")  
//    @Override  
//    public <T> T get(Object key, Class<T> type) {  
//        if (StringUtils.isEmpty(key) || null == type) {  
//            return null;  
//        } else {  
//            final String finalKey;  
//            final Class<T> finalType = type;  
//            if (key instanceof String) {  
//                finalKey = this.getPreKey() + (String) key;  
//            } else {  
//                finalKey = this.getPreKey() + key.toString();  
//            }  
//            final Object object = redisTemplate.execute(new RedisCallback<Object>() {  
//                public Object doInRedis(RedisConnection connection) throws DataAccessException {  
//                    byte[] key = finalKey.getBytes();  
//                    byte[] value = connection.get(key);  
//                    if (value == null) {  
//                        return null;  
//                    }  
//                    return toObject(value);
//                }  
//            });  
//            if (finalType != null && finalType.isInstance(object) && null != object) {  
//                return (T) object;  
//            } else {  
//                return null;  
//            }  
//        }  
//    }  
//  
//    /* 
//     * (non-Javadoc) 
//     * @see org.springframework.cache.Cache#put(java.lang.Object, java.lang.Object) 
//     */  
//    @Override  
//    public void put(final Object key, final Object value) {  
//    	
//        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {  
//            return;  
//        } else {  
//            final String finalKey;  
//            if (key instanceof String) {  
//                finalKey = this.getPreKey() + (String) key;  
//            } else {  
//                finalKey = this.getPreKey() + key.toString();  
//            }  
//            
//            if (!StringUtils.isEmpty(finalKey)) {  
//                final Object finalValue = value;  
//                redisTemplate.execute(new RedisCallback<Boolean>() {  
//                    @Override  
//                    public Boolean doInRedis(RedisConnection connection) throws DataAccessException {  
//                    	
//                    	byte[] cacheKey = finalKey.getBytes();
//                    	byte[] cacheValue = toByteArray(finalValue);
//                    	
//                        connection.set( cacheKey , cacheValue );  
//                        // 设置超时间  
//                        connection.expire( cacheKey , timeout);  
//                        return true;  
//                    }  
//                });  
//            }  
//        }  
//    }  
//  
//    /* 
//     * 根据Key 删除缓存 
//     */  
//    @Override  
//    public void evict(Object key) {  
//        if (null != key) {  
//            final String finalKey;  
//            if (key instanceof String) {  
//                finalKey = this.getPreKey() + (String) key;  
//            } else {  
//                finalKey = this.getPreKey() + key.toString();  
//            }  
//            if (!StringUtils.isEmpty(finalKey)) {  
//                redisTemplate.execute(new RedisCallback<Long>() {  
//                    public Long doInRedis(RedisConnection connection) throws DataAccessException {  
//                        return connection.del(finalKey.getBytes());  
//                    }  
//                });  
//            }  
//        }  
//    }  
//  
//    /* 
//     * 清楚系统缓存 
//     */  
//    @Override  
//    public void clear() {  
//
//       System.out.println("clear key");  
//       redisTemplate.execute(new RedisCallback<String>() {    
//            public String doInRedis(RedisConnection connection)    
//                    throws DataAccessException {    
//              connection.flushDb();    
//                return "ok";    
//           }    
//       });    
//    }  
//    
//    
//  
//    public RedisTemplate<String, Object> getRedisTemplate() {  
//        return redisTemplate;  
//    }  
//  
//    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {  
//        this.redisTemplate = redisTemplate;  
//    }  
//  
//    public void setName(String name) {  
//        this.name = name;  
//    }  
//  
//    public long getTimeout() {  
//        return timeout;  
//    }  
//  
//    public void setTimeout(long timeout) {  
//        this.timeout = timeout;  
//    }
//    
//	public String getPreKey() {
//		return preKey;
//	}
//
//	public void setPreKey(String preKey) {
//		this.preKey = preKey;
//	}
//    
//    /** 
//     * 描述 : <byte[]转Object>. <br> 
//     * <p> 
//     * <使用方法说明> 
//     * </p> 
//     *  
//     * @param bytes 
//     * @return 
//     */  
//    private Object toObject(byte[] bytes) {  
//        Object obj = null;  
//        try {  
//            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);  
//            ObjectInputStream ois = new ObjectInputStream(bis);  
//            obj = ois.readObject();  
//            ois.close();  
//            bis.close();  
//        } catch (IOException ex) {  
//            ex.printStackTrace();  
//        } catch (ClassNotFoundException ex) {  
//            ex.printStackTrace();  
//        }  
//        return obj;  
//    }  
//    
//    /** 
//     * 描述 : <Object转byte[]>. <br> 
//     * <p> 
//     * <使用方法说明> 
//     * </p> 
//     *  
//     * @param obj 
//     * @return 
//     */  
//    private byte[] toByteArray(Object obj) {  
//        byte[] bytes = null;  
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
//        try {  
//            ObjectOutputStream oos = new ObjectOutputStream(bos);  
//            oos.writeObject(obj);  
//            oos.flush();  
//            bytes = bos.toByteArray();  
//            oos.close();  
//            bos.close();  
//        } catch (IOException ex) {  
//            ex.printStackTrace();  
//        }  
//        return bytes;  
//    }
//
//	/* (non-Javadoc)
//	 * @see org.springframework.cache.Cache#putIfAbsent(java.lang.Object, java.lang.Object)
//	 */
//	@Override
//	public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
//		// TODO Auto-generated method stub
//		return null;
//	}  
//}  
//
//
