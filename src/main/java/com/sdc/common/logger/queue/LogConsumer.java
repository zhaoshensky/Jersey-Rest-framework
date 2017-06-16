package com.sdc.common.logger.queue;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdc.common.logger.mongo.MongoLog;
import com.sdc.utils.SendEmail;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年2月25日
* @Company: ediankai
*/
@Service
public class LogConsumer {

	@Autowired
	private MongoLog mongoLog;
	//接口超时时间 5s
	@Value("${const.JerseyAPITIMEOUT}")
	private Long signTime;
	//mongo表
//	private String mongoTable = "JerseyRestLog"; 

	public void logRule(Map<String, Object> map){
//		System.out.println(map.toString());
		if( map == null ) return;
		String mongoTable = "";
		if( map.get("table")!=null && map.get("table").toString().trim().length() > 0 ){
			mongoTable = map.get("table").toString();
		} else{
			return ;
		}
		//如果执行超时
		if(map.get("restTime")!=null&&!(map.get("restTime")+"").equals("null")&&!(map.get("restTime")+"").equals("")){
		Long restTime = (Long)map.get("restTime") ;
		if( restTime > signTime  ) mongoLog.addLog(mongoTable + "_OVERTIME", map);	
		}
		
		//如果Http执行失败
		String httpStatus = map.get("httpStatus").toString();
		if( !httpStatus.equals( "200" ) ){
			
			if( httpStatus.equals( "401" ) ){
				
				mongoLog.addLog(mongoTable + "_HTTP_UNAUTHO", map);
				
			}else{
			
				mongoLog.addLog(mongoTable + "_HTTP_FAIL", map);
			}
			
		}  
		
//		String myMessage = map.toString();
//		try {  
//            SendEmail.sendMessage("SMTP.ym.163.com", "alarm@ediankai.com",  
//                    "alarm666666", "zhaojintian@ediankai.com", "OverTIME-----超时日志",  
//                    myMessage,  
//                    "text/html;charset=gb2312");  
//        } catch (MessagingException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//        }  
		//正常
		mongoLog.addLog(mongoTable, map);
		
	}
	
	public void insertMogoLog(Map<String, Object> map){
		
		String mongoTable = "";
		if( map.get("table")!=null && map.get("table").toString().trim().length() > 0 ){
			mongoTable = map.get("table").toString();
		} else{
			return ;
		}
	
		
		//正常
		mongoLog.addLog(mongoTable, map);
	}
	
//	//异步插入队列
//	public void dealLog(){
//		
//		
//		if( LogResource.linkedBlockingQueue != null ){
//			
//			beginStatus();
//			
//			try {
//                while (true) {
//                	
//                	 while (LogResource.linkedBlockingQueue.peek() != null) {
//                		 
//                		 Map<String,Object> mlog = LogResource.linkedBlockingQueue.poll();
//                		 logRule( mlog );
//                	 } 
//                    // 休眠10ms
//                    Thread.sleep(10);
//                }
//            } catch (InterruptedException ex) {
//            	ex.printStackTrace();
//            	
//            }finally {
//            	LogResource.setLogStatus(0);
//			}
//			
//		}
//		
//		
//	}
//
//	
//	private synchronized void beginStatus(){
//		
//		if( LogResource.getLogStatus() > 0){
//			//doing  return
//			return;
//		}
//		//beginning
//		LogResource.setLogStatus(1);
//		
//		
//	}
	
	
}
