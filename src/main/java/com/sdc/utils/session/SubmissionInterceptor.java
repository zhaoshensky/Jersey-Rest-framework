package com.sdc.utils.session;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SubmissionInterceptor extends HandlerInterceptorAdapter
{
	/**
	 * Logger for this class
	 */
	   private static final Logger logger = Logger.getLogger(SubmissionInterceptor.class);

	 
	 	private boolean isRepeatSubmit(HttpServletRequest request) 
	 	{
	        String serverToken = (String) request.getSession(false).getAttribute("token");
	        if (serverToken == null) {
	            return true;
	        }
	        String clinetToken = request.getParameter("token");
	        if (clinetToken == null) {
	            return true;
	        }
	        if (!serverToken.equals(clinetToken)) {
	            return true;
	        }
	        return false;
	    }
}
