package com.sdc.system.servlet.shutdown.impl;

import com.sdc.system.servlet.shutdown.ServletShutDown;
import com.sdc.system.spring.SpringBeanFactoryUtils;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年6月19日
* @Company: ediankai
*/
public class QuertzShutDown implements ServletShutDown {

	/* (non-Javadoc)
	 * @see com.sdc.system.servlet.shutdown.ServletShutDown#shutDown()
	 */
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

		System.out.println("******************* Scheduler ******************** ");
		//手动关闭Quertz
		org.quartz.impl.StdScheduler stdScheduler = (org.quartz.impl.StdScheduler)SpringBeanFactoryUtils.getBean("startQuertz");
		if( stdScheduler != null ){
			
				stdScheduler.shutdown();
				System.out.println("..... stop .....  Quertz !!!!");
	
		}
		
	}

}
