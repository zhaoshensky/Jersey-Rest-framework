package com.sdc.utils.weixinUtil;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
* ###################################################
* @创建日期：2012－12－21
* @开发人员：李广彬
* @功能描述：
* @修改日志： 
* ###################################################
*/
public class UtilsObject {
    public final static String CONTENTTYPE_JSON = "application/json";
    public final static String CONTENTTYPE_TEXT = "text/html";
    public final static String ENCODING_UTF8 = "UTF-8";
    /**
     * @创建日期：2012－12－21
     * @开发人员：李广彬
     * @功能描述：以指定的格式回写ajax信息
     * @传入参数：
     */
    public static void writeOutInfo(HttpServletResponse response, String jsonStr, String contentType) throws Exception {
        // 设置字符集
        response.setContentType(contentType);
        response.setCharacterEncoding(ENCODING_UTF8);
        response.setHeader("Cache-Control", "no-cache"); // 清除缓存
        response.setStatus(HttpServletResponse.SC_OK); 
        response.flushBuffer();
        PrintWriter out = response.getWriter();
        // 直接输入响应的内容
        out.write(jsonStr);
        out.flush();
        out.close();
    }

	

	public static void writeAjaxInfo(HttpServletResponse response, String jsonStr, String contentType) throws Exception {
		// 设置字符集
		response.setContentType(contentType);
		response.setCharacterEncoding(ENCODING_UTF8);
		response.setHeader("Cache-Control", "no-cache"); // 清除缓存
		PrintWriter out = response.getWriter();
		// 直接输入响应的内容
		out.write(jsonStr);
		out.flush();
		out.close();
	}
    

}
