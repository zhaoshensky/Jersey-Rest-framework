package com.sdc.system.servlet.shutdown.impl;

import org.apache.activemq.pool.PooledConnectionFactory;

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
public class JmsShutDown implements ServletShutDown {

	/* (non-Javadoc)
	 * @see com.sdc.system.servlet.shutdown.ServletShutDown#shutDown()
	 */
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

		System.out.println("******************* Jms ******************** ");
		//手动关闭activeMq连接
		PooledConnectionFactory pooledConnectionFactory = (PooledConnectionFactory)SpringBeanFactoryUtils.getBean("pooledConnectionFactory");
		if( pooledConnectionFactory != null ){
			
			pooledConnectionFactory.clear();
			pooledConnectionFactory.stop();   
			System.out.println("..... stop .....  ActiveMqPool !!!!");
	
		}
		
	}

}
