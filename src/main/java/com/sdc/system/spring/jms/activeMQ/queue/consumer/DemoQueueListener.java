package com.sdc.system.spring.jms.activeMQ.queue.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
* description: demounque 队列监听 消费
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年3月16日
* @Company: ediankai
*/
public class DemoQueueListener implements MessageListener{

	private static final Logger logger = Logger.getLogger(DemoQueueListener.class);
    
    //处理消息
    public void onMessage(Message message) {
    	
    	try{
    		if (message instanceof TextMessage) {            
    	           
                this.dealText(message);

            }else if(message instanceof ObjectMessage){  
            	
            	this.dealObject(message);
                
            }  
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }

    }
    
    private void dealText( Message message){
    	
    	try{
    		
    		String msg=((TextMessage) message).getText();
        	System.out.println("从DemoQueue收到消息:"+msg);
    		
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    	
    }
    
    
    private void dealObject( Message message){
    	
    	try{
    		
    		ObjectMessage objMsg = (ObjectMessage) message;  
        	System.out.println("从DemoQueue收到消息:"+objMsg.toString());
    		
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    	
    }
    
	
}
