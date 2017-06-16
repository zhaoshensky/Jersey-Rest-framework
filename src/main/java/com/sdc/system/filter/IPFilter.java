package com.sdc.system.filter;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月3日
* @Company: ediankai
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.DBObject;
import com.sdc.system.spring.mongo.MongoBaseImpl;
import com.sdc.utils.ClientConstant;
import com.sdc.utils.Response;

public class IPFilter implements Filter {
	protected FilterConfig filterConfig;
	protected String FilteredIP;
	
	private static final Logger logger = Logger.getLogger(IPFilter.class);
	/**
	 * 初始化
	 */
	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.filterConfig = conf;//过滤器初始化
		FilteredIP = conf.getInitParameter("filterIPs");//获取被过滤的Ip
		if (FilteredIP==null) {
			FilteredIP="";
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,			
		FilterChain chain) throws IOException, ServletException {
		
		//读出本地Ip
		String remoteIP = request.getRemoteAddr();

//		MongoBaseImpl mongoDBDaoImpl=MongoBaseImpl.getMongoDBDaoImpl();
//        ArrayList<DBObject> list=new ArrayList<DBObject>();
//        Document document = new Document( ); 
//        
//        HttpServletRequest httpRequest=(HttpServletRequest)request;  
//        
//        String strBackUrl = "http://" + request.getServerName() //服务器地址  
//                            + ":"   
//                            + request.getServerPort()           //端口号  
//                            + httpRequest.getContextPath()      //项目名称  
//                            + httpRequest.getServletPath()      //请求页面或其他地址  
//                        + "?" + (httpRequest.getQueryString()); //参数  
//        document.append("requestUrl", strBackUrl);
//        document.append("IP", remoteIP);
//        
//        
//		Enumeration enu = request.getParameterNames();
//        while(enu.hasMoreElements()){  
//        	String paraName = (String)enu.nextElement();  
//        	document.append(paraName, request.getParameter(paraName).toString());
//        }		
//        mongoDBDaoImpl.inSert("druid", "log", "visit_log",document );
        logger.info("访问IP:"+remoteIP);
        logger.info("IP:"+FilteredIP.toString());
		if ( FilteredIP.indexOf(remoteIP) >= 0 ) {
			 logger.info("访问IP通过:"+remoteIP + "sucess");
			 chain.doFilter(request, response); 
		}else {
			 response.setContentType("text/html;charset=UTF-8");
			 logger.info("访问IP 禁止:"+remoteIP + "stop");
//			 response.getWriter().println(Response.info().setCode(ClientConstant.FILTER_ERROR_900001_STATUS).setMsg(ClientConstant.FILTER_ERROR_900001_STATUSNAME).toJSON());
			 response.flushBuffer();
		}
	}
	
	@Override
	public void destroy() {
		this.filterConfig = null;
	}
}