package com.sdc.common.logger.queue;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdc.system.spring.mongo.MongoBaseImpl;
import com.sdc.utils.SerializeUtil;

/**
* description: demounque 队列监听 消费
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年3月16日
* @Company: ediankai
*/
public class LoggerMessageQueueListener implements MessageListener{

	private static final Logger logger = Logger.getLogger(LoggerMessageQueueListener.class);
	@Autowired
	private LogConsumer logConsumer;
    
    //处理消息
    public void onMessage(Message message) {
    	
    	try{
    		if (message instanceof ObjectMessage){  
            	
            	this.dealObject(message);
                
            }  
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }

    }
    
    
    private void dealObject( Message message){
    	
//    	System.out.println("从DemoQueue收到消息:"+message.toString());
    	try{
    		ObjectMessage objMsg = (ObjectMessage) message; 
    		byte[] objectByte = (byte[]) objMsg.getObject();
    		Map<String, Object> map = (Map<String, Object>)SerializeUtil.unserialize(objectByte);
    		logConsumer.insertMogoLog(map); 
    		
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    	
    }
    
	
}
