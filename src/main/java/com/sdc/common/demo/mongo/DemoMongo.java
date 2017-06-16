package com.sdc.common.demo.mongo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdc.system.spring.mongo.MongoBaseImpl;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月19日
* @Company: ediankai
*/
@Component
public class DemoMongo {
	
//	@Autowired
//	private MongoBaseImpl mongoBase;
	//指定mongo表明
	private String mongoTable = "demo";
	
	public void setMongo(){
		//mongoBase.inSert(mongoTable, "test", "123");
		
	}
	
}
