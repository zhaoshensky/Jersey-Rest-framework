package com.sdc.common.logger.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdc.common.logger.service.RequestLog;

import com.sdc.utils.DateUtil;
import com.sdc.utils.JsonMapper;
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.spi.container.ContainerRequest;


/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月23日
* @Company: ediankai
*/
@Service
public class RequestLogImpl implements RequestLog {
	
	private static final Logger logger = Logger.getLogger(RequestLog.class);
	
	private Map<String, Object> map = null;
	
	@Value("${const.JerseyRequestParam}")
	private String jerseyRequestParam;
	
//	@Value("${const.JerseyAPIParam}")
//	private String jerseyAPIParam;
	
	/* (non-Javadoc)
	 * @see com.sdc.common.logger.mongo.serviceutil.RequestLog#addRequestLog(javax.ws.rs.core.MultivaluedMap)
	 */
	@Override
	public ContainerRequest addRequestLog( ContainerRequest containerRequest,HttpServletRequest request) {
		// TODO Auto-generated method stub
	
    	map = new ConcurrentHashMap<String,Object>();
    	//当前时间
    	long requestTimes = System.currentTimeMillis() ;
    	String requestTime = DateUtil.Symdhms();
    	//请求类型
    	String requestType = request.getMethod().toUpperCase();
    	//请求ip地址
    	String requestIp = getRemoteHost(request);
    	//请求URL路径
    	String requestUrl = containerRequest.getRequestUri().toString();
    	//请求方法
    	String requestService = this.getServiceName(requestUrl,containerRequest.getBaseUri().toString())+"-"+requestType;
    	
    	
    	
    	//请求类型
    	map.put("type", requestType );
    	map.put("bTime", requestTime);
    	map.put("bTimes",requestTimes );
    	map.put("ip", requestIp);
    	map.put("port",  request.getRemotePort());
    	map.put("requestUrl", requestUrl);
    	map.put("requestService", requestService);
    	map.put("computer", this.getCurrentRunningServerComputerName() + ":" + request.getLocalPort());
    	map.put("threadInfo", Thread.currentThread().getId() );
//    	 System.out.println(requestService);
    	if( request.getAttribute("SDCPARAMCODE") != null && request.getAttribute("SDCSIGN") != null && request.getAttribute("SDCSUPPLIERID") != null){
	   
			String sdcParam = this.replacer(request.getAttribute("SDCPARAMCODE").toString());
			map.put("param",sdcParam);
			String sdcSign = this.replacer(request.getAttribute("SDCSIGN").toString());
			map.put("sign",sdcSign);
			String supplierId = this.replacer(request.getAttribute("SDCSUPPLIERID").toString());
			map.put("supplierId",supplierId );
	//    		logger.info(URLDecoder.decode(request.getAttribute("SDCPARAMCODE").toString(), "UTF-8"));
			
	    	//移除request参数
	    	request.removeAttribute("SDCPARAMCODE");
	    	request.removeAttribute("SDCSIGN");
    	}
		
    	//写入请求头
    	InBoundHeaders inBoundHeaders = new InBoundHeaders();
		inBoundHeaders.addObject( jerseyRequestParam ,JsonMapper.toJson(map) );
    	containerRequest.setHeaders(inBoundHeaders);
    	
    	return containerRequest;
    	
	}
	
	
	/** 
     * 获取访问者IP 
     *  
     * @param request 
     * @return 
     */  
    public String getRemoteHost( HttpServletRequest request ){
    	
        String ip = request.getHeader("x-forwarded-for");
        
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
    
    // it also doesn't decode things like %20 (space) because you are taking out the percent before decoding.
    public  String replacer(String data) {
//        String data = outBuffer.toString();
        try {
           data = data.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
           data = data.replaceAll("\\+", "%2B");
           data = URLDecoder.decode(data, "utf-8");
        } catch (Exception e) {
           e.printStackTrace();
        }
        return data;
     }
    
    public String getServiceName(String requestUrl,String baseUrl){
    	
    	String serviceStr = "";
    	//截取？前边的字符
    	int loc = requestUrl.indexOf("?");
    	if( loc > -1) requestUrl = requestUrl.substring(0, loc);
    	String[] serviceArr = null;
    	if( requestUrl != null ) serviceArr = requestUrl.replace(baseUrl, "").split("/");
    	
    	if( serviceArr != null &&  serviceArr[0] != null && serviceArr[1] != null ){
    		serviceStr = serviceArr[0].toString() + "-" + serviceArr[1].toString();
    	}
    	
    	return serviceStr;
    }
    
    public String getCurrentRunningServerComputerName () {  
        // Windows  
        String computerName = System.getenv().get("COMPUTERNAME");  
          
        if (computerName == null) {  
          // Linux  
          String tempHostName = System.getenv().get("HOSTNAME");  
          if (tempHostName != null && tempHostName.split("\\.").length > 0) {  
            computerName = tempHostName.split("\\.")[0];  
          } else {  
            computerName = tempHostName;  
          }  
        }  
          
        return computerName;  
      }  

}
