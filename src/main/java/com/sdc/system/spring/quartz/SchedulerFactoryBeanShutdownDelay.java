package com.sdc.system.spring.quartz;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.sdc.common.logger.service.RequestLog;

/**
* description: 解决Tomcat出现"线程未关闭，出现内存泄漏"错误 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年2月9日
* @Company: ediankai
*/
public class SchedulerFactoryBeanShutdownDelay extends SchedulerFactoryBean {

	private static final Logger logger = Logger.getLogger(SchedulerFactoryBeanShutdownDelay.class);
	@Override  
    public void destroy() throws SchedulerException {  
		
        super.destroy();  
  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            throw new RuntimeException(e);  
        }  
    }  
	
}
