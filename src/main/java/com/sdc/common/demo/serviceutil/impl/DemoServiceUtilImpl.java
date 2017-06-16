/**
* <p>Description: </p>
* <p>Company: diankai</p>
* @author today
* @date 2016骞�11鏈�26鏃�
*/
package com.sdc.common.demo.serviceutil.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sdc.common.demo.mapper.DemoMapper;
import com.sdc.common.demo.model.Demo;
import com.sdc.common.demo.mongo.DemoMongo;
import com.sdc.common.demo.redis.DemoRedis;
import com.sdc.common.demo.service.DemoService;
import com.sdc.common.demo.serviceutil.DemoServiceUtil;


/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016骞�11鏈�26鏃�
* @Company: diankai
*/
@Service
public class DemoServiceUtilImpl implements DemoServiceUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DemoServiceUtilImpl.class);
	
	@Autowired
	private DemoMapper demoMappger;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
	 	
		return demoMappger.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Demo record) {
		// TODO Auto-generated method stub
		return demoMappger.insert(record);
	}

	@Override
	public Demo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return demoMappger.selectByPrimaryKey(id);
	}

	@Override
	public List<Demo> selectAll() {
		// TODO Auto-generated method stub
		return demoMappger.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Demo record) {
		// TODO Auto-generated method stub
		return demoMappger.updateByPrimaryKey(record);
	}

	

	
	
	

}
