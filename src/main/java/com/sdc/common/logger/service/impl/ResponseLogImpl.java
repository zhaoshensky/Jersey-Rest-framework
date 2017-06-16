package com.sdc.common.logger.service.impl;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//import com.sdc.common.logger.mongo.MongoLog;
import com.sdc.common.logger.service.RequestLog;
import com.sdc.common.logger.service.ResponseLog;
import com.sdc.system.spring.jms.activeMQ.queue.MyJmsSender;
import com.sdc.utils.DateUtil;
import com.sdc.utils.JsonMapper;
import com.sdc.utils.SerializeUtil;
import com.sdc.utils.ServiceConst;
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
@Service
public class ResponseLogImpl implements ResponseLog {

	
private static final Logger logger = Logger.getLogger(RequestLog.class);
	
	private Map<String, Object> map = null;

	@Value("${const.JerseyRequestParam}")
	private String jerseyRequestParam;
	@Resource
	private MyJmsSender jmsSenderLoggerQueue;
	//mongo表
	private String mongoTable = "JerseyRestLog"; 
	
	
	/**
	 * 
	 */
	public ResponseLogImpl() {
		// TODO Auto-generated constructor stub
//		mongoTable = "JerseyRestLog";
		
//		if( LoggerConst.linkedBlockingQueue == null )  linkedBlockingQueue = new LinkedBlockingQueue<Map>( );
	}
	
	/* (non-Javadoc)
	 * @see com.sdc.common.logger.service.ResponseLog#addResponseLog(com.sun.jersey.spi.container.ContainerRequest, com.sun.jersey.spi.container.ContainerResponse)
	 */
	@Override
	public void addResponseLog(ContainerRequest arg0, ContainerResponse arg1) {
		// TODO Auto-generated method stub
		String mapString = arg0.getHeaderValue(jerseyRequestParam);
//		System.out.println("begin***********"+mapString);
		Object mapObject = JsonMapper.parseJSON2ConMap(mapString) ;   //先转换成Object
		map = (ConcurrentHashMap<String,Object>)mapObject;  
		if( map == null ) return;
		
		String responseTime = DateUtil.Symdhms();
    	map.put("oTime", responseTime);
    	
    	Long restTime = 0l;
    	if( map.get("bTimes")!=null && !(map.get("bTimes").toString()).trim().equals("")){
			Long requestTimeS = Long.parseLong( map.get("bTimes").toString() );
	    	restTime = System.currentTimeMillis() - requestTimeS ; 	
	    	map.remove("bTimes");
    	}
    	
//    	Float restTime = DateUtil.betweenS(requestTime,responseTime);
    	map.put("restTime", restTime );
    	//数据返回状态码
    	map.put("httpStatus", String.valueOf(arg1.getStatus()) );
    	
    	//添加线程信息
		
//    	InetAddress netAddress = ServiceConst.getInetAddress();
//    	if( netAddress != null ){
//    		String HostIp = ServiceConst.getHostIp(netAddress);
//    		String HostName = ServiceConst.getHostName(netAddress);
//    		if( HostIp != null ) map.put("HostIp", HostIp );
//        	if( HostName != null )map.put("HostName", HostName );
//    		
//    	}

    	String responseString = arg1.getEntity()+"";
		map.put("Result",responseString);
	
		
//		logger.info(map.toString());;
//		LogResource.linkedBlockingQueue.add(map);
//		LogProducer.putLogger(map);
		String myMongoTable = DateUtil.Symd() + "--" + mongoTable;
		map.put("table", myMongoTable);

		Serializable serializableObject = SerializeUtil.serialize(map);
		
//		System.out.println(Thread.currentThread().getId()+"队列开始时间:"+ System.currentTimeMillis()  );
		jmsSenderLoggerQueue.sendSerializableObject(serializableObject);
//		System.out.println(Thread.currentThread().getId()+"队列结束时间:"+ System.currentTimeMillis() );
//		logRule( map );
		
	}
	

    
	

	
}
