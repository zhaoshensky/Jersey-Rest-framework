/**
* <p>Description: </p>
* <p>Company: diankai</p>
* @author today
* @date 2016骞�11鏈�26鏃�
*/
package com.sdc.common.demo.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.sdc.system.spring.jms.activeMQ.queue.MyJmsSender;
import com.sdc.utils.SerializeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sdc.common.demo.mapper.DemoMapper;
import com.sdc.common.demo.model.Demo;
import com.sdc.common.demo.mongo.DemoMongo;
import com.sdc.common.demo.redis.DemoRedis;
import com.sdc.common.demo.service.DemoService;


/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016骞�11鏈�26鏃�
* @Company: diankai
*/
@Service
public class DemoServiceImpl implements DemoService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DemoServiceImpl.class);

	@Autowired
	private DemoRedis demoRedis;
	@Autowired
	private DemoMongo demoMongo;
	@Autowired
	private MyJmsSender jmsSenderMessageLoggerQueue;


	/* (non-Javadoc)
	 * @see com.sdc.common.demo.service.DemoService#testDemo()
	 * 
	 * 同学你好：
	 * 相关的redis 基础类型请自行参考
	 * com.sdc.utils.redis.RedisBase 为基础类
	 */
	@Override
	public void demoRedis() throws Exception {
		// TODO Auto-generated method stub
		demoRedis.setDemo();
	}


	/* (non-Javadoc)
	 * @see com.sdc.common.demo.service.DemoService#demoCache()
	 * 
	 * 同学你好：
	 * 可以参考  http://tom-seed.iteye.com/blog/2104430
	 * 请注意区分 @Cacheable @CachePut @CacheEvict
	 * sdc为cache命名空间  会自动生成cachekey无需指定
	 */
	@Override
	@Cacheable(value="demo")
	public String demoCache(int ppp) throws Exception {
		// TODO Auto-generated method stub
		logger.info("进入demoCache了");
		return "Hello Cache！！！";
	}


	/* (non-Javadoc)
	 * @see com.sdc.common.demo.service.DemoService#demoMongo()
	 */
	@Override
	public void demoMongo() throws Exception {
		// TODO Auto-generated method stub
		//demoMongo.setMongo();

	}
	@Override
	public void insertMongo(HashMap hm)  {
		// TODO Auto-generated method stub
		Serializable serializableObject = SerializeUtil.serialize(hm);
		jmsSenderMessageLoggerQueue.sendSerializableObject(serializableObject);

	}

	

}
