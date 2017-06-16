package com.sdc.utils;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Service
public class TokenService extends HandlerInterceptorAdapter 
{

	@Override  
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{  
	         if (handler instanceof HandlerMethod) 
	         {  
	            HandlerMethod handlerMethod = (HandlerMethod) handler;  
	            Method method = handlerMethod.getMethod();  
	            Token annotation = method.getAnnotation(Token.class );  
	             if (annotation != null )
	             {  
	                 boolean needSaveSession = annotation.Save();  
	                 if (needSaveSession)
	                 {  
	                    request.getSession( false ).setAttribute( "token" , 
	                    		UUID.randomUUID().toString());  
	                }  
	                boolean needRemoveSession = annotation.Remove();  
	                 if (needRemoveSession) {  
	                     if (isRepeatSubmit(request)) {  
	                        return false ;  
	                     }  
	                     request.getSession( false ).removeAttribute( "token" );  
	                }  
	            }  
             return true ;  
	        } else {  
	             return super .preHandle(request, response, handler);  
	        }  
	 }  
		    
	  private boolean isRepeatSubmit(HttpServletRequest request)
	  {  
	         String serverToken = (String) 
	        		request.getSession( false ).getAttribute( "token" );  
	         if (serverToken == null ) 
	         {  
	            return true ;  
	         }  
	         String clinetToken = request.getParameter( "token" );  
	         if (clinetToken == null )
	         {  
	             return true ;  
	         }  
	         if (!serverToken.equals(clinetToken)) 
	         {  
	             return true ;  
	         }  
	       return false ;  
	    }  
}
