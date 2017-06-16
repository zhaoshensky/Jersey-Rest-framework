package com.sdc.common.logger.service;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月23日
* @Company: ediankai
*/
public interface ResponseLog {

	//添加  Log日志
	public void addResponseLog( ContainerRequest arg0,ContainerResponse arg1 ) throws Exception;
	
}
