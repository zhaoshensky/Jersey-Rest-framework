package com.sdc.scheduling;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdc.common.logger.queue.LogConsumer;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年2月25日
* @Company: ediankai
*/
public class EverySecondScheduling {

	private static final Logger logger = Logger.getLogger(EverySecondScheduling.class);
	
//	@Autowired	
//	private LogConsumer logConsumer;
	
	public void  doScheduling(){  
        /**业务逻辑*/  
//        logger.info("这是个Scheduling -- 每小时 ");
//        System.out.println("Hello EveryHourScheduling ");
		
//		doLogger();
    }  
	
	
	private void doLogger(){
		
//		logConsumer.dealLog();
		
	}
}
