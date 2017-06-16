package com.sdc.utils.session;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




public class APIInterceptor extends HandlerInterceptorAdapter
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(APIInterceptor.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info(request);
		
		String token = request.getParameter("token");
		
		// token is not needed when debug
		if(token == null) return true;  // !! remember to comment this when deploy on server !!
		
		Enumeration paraKeys = request.getParameterNames();
		String encodeStr = "";
		while (paraKeys.hasMoreElements()) {
			String paraKey = (String) paraKeys.nextElement();
			if(paraKey.equals("token")) 
				break;
			String paraValue = request.getParameter(paraKey);
			encodeStr += paraValue;
		}
		//encodeStr += Default.TOKEN_KEY;
		logger.info(encodeStr);
		
		if ( ! token.equals(DigestUtils.md5Hex(encodeStr))) {
			response.setStatus(500);
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{
			logger.info(request);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception
			{
		
			}
}
