package com.sdc.system.spring.jms.activeMQ.queue;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
* description: JmsSender
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年3月16日
* @Company: ediankai
*/
public class MyJmsSender {

	// JMS模板    
    private JmsTemplate jmsTemplate;

    // 目的地
    private Destination destination;
    
    public void sendString(final String text){
    	
    	jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return (Message) session.createTextMessage(text);
            }
        });
    	
    }
    
    public void sendSerializableObject(final Serializable serializableObject){
    	
    	jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return (Message) session.createObjectMessage(serializableObject);
            }
        });
    	
    }

//    public void send(final Message message) {
//    	
//    	if (message instanceof TextMessage) {            
//	        String myMessage;
//			try {
//				myMessage = ((TextMessage) message).getText();
//				jmsTemplate.send(destination, new MessageCreator() {
//	                public Message createMessage(Session session) throws JMSException {
//	                    return (Message) session.createTextMessage(myMessage);
//	                }
//	            });
//			} catch (JMSException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}   
//
//        }else if(message instanceof ObjectMessage){  
//        	
//        	Serializable myObject;
//			try {
//				myObject = ((ObjectMessage) message).getObject();
//				jmsTemplate.send(destination, new MessageCreator() {
//	                public Message createMessage(Session session) throws JMSException {
//	                    return (Message) session.createObjectMessage(myObject);
//	                }
//	            });
//			} catch (JMSException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}   
//            
//        }  
//        
//    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
	
}
