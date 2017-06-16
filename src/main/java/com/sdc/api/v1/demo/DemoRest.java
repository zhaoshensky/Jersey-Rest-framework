package com.sdc.api.v1.demo;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.resource.spi.AuthenticationMechanism;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016锟斤拷11锟斤拷25锟斤拷
* @Company: diankai
*/

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdc.common.demo.service.DemoService;
import com.sdc.system.spring.jms.activeMQ.queue.MyJmsSender;
import com.sdc.utils.ClientConstant;
import com.sdc.utils.Response;
import com.sdc.utils.SerializeUtil;
import com.sun.jersey.api.spring.Autowire;




@Autowire
@Path("demoservice")
public class DemoRest {
	
	private static final Logger logger = Logger.getLogger(DemoRest.class);
	
	@Autowired	
	private DemoService demoService;
	@Resource
	private MyJmsSender jmsSenderMessageLoggerQueue;
	
	//请求方式
	@GET
	//请求映射路径
	@Path("/getall")
	//接口返回的类型
	@Produces(MediaType.APPLICATION_JSON)
	public String getall( ){
		logger.info("demoservice-getall请求");
//		JSONObject JSONobject =null;
		try {
			HashMap<String, String> hm = new HashMap<>();
			hm.put("asdas", "asdasdsa");
			//table
			hm.put("table", "test");
			Serializable serializableObject = SerializeUtil.serialize(hm);
			jmsSenderMessageLoggerQueue.sendSerializableObject(serializableObject);
			//demoService.demoRedis();
			demoService.demoCache(123);
			demoService.demoMongo();
//			
		} catch (Exception e) {
//			// TODO Auto-generated catch block
			return Response.info().setCode(ClientConstant.QUERY_ERROR).setMsg(ClientConstant.QUERY_ERROR_MSG).toJSON();
		}  
		
		
		return Response.info().setCode(ClientConstant.ERROR_0_STATUS).setMsg(ClientConstant.ERROR_0_STATUSNAME).toJSON();
	}
	
	
	//请求方式
		@GET
		//请求映射路径
		@Path("/test")
		//接口返回的类型
		@Produces(MediaType.APPLICATION_JSON)
		public String test( ){
			
			return Response.info().setCode(ClientConstant.ERROR_0_STATUS).setMsg(ClientConstant.ERROR_0_STATUSNAME).toJSON();
		}

	
	 /** 
     * Constants operating with images 
     */  
    private static final String ARTICLE_IMAGES_PATH = "c:/Newsportal/article_images/";  
    private static final String JPG_CONTENT_TYPE = "image/jpeg";  
    private static final String PNG_CONTENT_TYPE = "image/png";  
  
    /** 
     * 第一种方式上传 
     * 
     * @param fileInputStream 
     * @param disposition 
     * @return 
     */  
//    @POST  
//    @Path("uploadimage1")  
//    @Consumes(MediaType.MULTIPART_FORM_DATA)  
//    public String uploadimage1(@FormParam("file") InputStream fileInputStream,  
//        @FormParam("file") FormDataContentDisposition disposition) {  
//    String imageName = Calendar.getInstance().getTimeInMillis()  
//        + disposition.getFileName();  
//  
//    File file = new File(ARTICLE_IMAGES_PATH + imageName);  
//    try {  
//        //使用common io的文件写入操作  
//        FileUtils.copyInputStreamToFile(fileInputStream, file);  
//        //原来自己的文件写入操作  
//        //saveFile(fileInputStream, file);  
//    } catch (IOException ex) {  
//    	logger.error(ex.getMessage());
//    }  
//  
//    return "images/" + imageName;  
//    }  
    


}



//@Path("myresource")
//public class MyResource {
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String result = veryExpensiveOperation();
//                asyncResponse.resume(result);
//            }
//            
//            private String veryExpensiveOperation() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "Got it!";
//            }
//        }).start();
//
//    }
//
//}

