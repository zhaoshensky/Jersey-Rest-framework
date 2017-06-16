package com.sdc.common.logger.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.spi.container.ContainerRequest;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月23日
* @Company: ediankai
*/
public interface RequestLog {
	
	//添加 request Log日志
	public ContainerRequest addRequestLog( ContainerRequest containerRequest,HttpServletRequest request ) throws Exception;
	//未授权日志处理
//	public void addUnAuthoLog( ContainerRequest containerRequest,HttpServletRequest request);
	
}
