package com.sdc.common.logger.mongo;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdc.system.spring.mongo.MongoBaseImpl;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月19日
* @Company: ediankai
*/
@Repository 
public class MongoLog {
	
	private static final Logger logger = Logger.getLogger(MongoLog.class);
	
	@Autowired
	private MongoBaseImpl mongoBase;

	public void addLog( String mongoTable,Map<String, Object> hm ){
		
		if( !mongoTable.equals("")  && hm != null){
	
			mongoBase.inSert(mongoTable, hm);
			
			
		}
		
	}
	
}
