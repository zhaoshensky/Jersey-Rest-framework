package com.sdc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.Logger;

import com.sdc.utils.weixinUtil.MyX509TrustManager;


public class HttpClientUtils
{	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HttpClientUtils.class);

	public static String smsSend(final Map<String, String> map) 
	{

		final int count=3;
		String url=map.get("url").toString().trim();
		String result = null;
		PostMethod postMethod = null;  
		HttpClient httpClient =new HttpClient();  

         httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
	     postMethod = new PostMethod(url);
         postMethod.addParameter("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
         if (map != null && map.size() > 0)
         {  
             NameValuePair[] datas = new NameValuePair[map.size()];  
             int index = 0;  
             for (String key : map.keySet())
             {  
                 datas[index++] = new NameValuePair(key,map.get(key));  
             }
             postMethod.setRequestBody(datas);  
             logger.debug("=======发送短信接口内容:"+datas);
         }

             HttpClientParams httparams = new HttpClientParams(); 			            
             httparams.setSoTimeout(60000);
             postMethod.setParams(httparams);		       
         try {  
             int statusCode = httpClient.executeMethod(postMethod);  
             if (statusCode == HttpStatus.SC_OK) { //200 
                 result = postMethod.getResponseBodyAsString();  
                 System.out.println(" ~~~短信发送成功~~~:"+result);
                 logger.info("发送成功！"); 
             	if (result .equals( "-1")) 
    		  	{
    		  		logger.error("没有该用户账户");
    			} else if (result .equals("-2"))
    			{
    				logger.error("接口密钥不正确");								
    			} else if (result .equals( "-21"))
    			{
    				logger.error("接口密钥不正确");
    			} else if (result .equals( "-3"))
    			{
    				logger.error("短信数量不足");
    			} else if (result .equals( "-11"))
    			{
    				logger.error("短信数量不足");
    			} else if (result .equals( "-14"))
    			{
    				logger.error("短信内容出现非法字符");									
    			} else if (result .equals( "-4"))
    			{
    				logger.error("手机号格式不正确");									
    			} else if (result .equals( "-41"))
    			{
    				logger.error("手机号码为空");									
    			} else if (result .equals( "-42"))
    			{
    				logger.error("短信内容为空");									
    			} else if (result .equals( "-51"))
    			{
    				logger.error("短信签名格式不正确");									
    			} else if (result .equals( "-6"))
    			{
    				logger.error("IP限制");									
    			}else if(result .equals( "0"))
    			{
    				logger.error("短信发送数量");	
    			}
             } else {  
            	 logger.error(" http response status is " + statusCode);  
             }		       
         } catch (HttpException e) {  
        	 logger.error("error url=" + url, e);  
         } catch (IOException e) {  
        	 logger.error("error url=" + url, e);  
         } finally {  
             if (postMethod != null) {  
                 postMethod.releaseConnection();  
             }  
         } 		
		return result;
	}
	
	
	private static final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	static {
		// Increase max total connection to 200
		cm.setMaxTotal(50);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		Thread demo=new Thread(new IdleConnectionMonitorThread(cm));
		demo.setDaemon(true);
		demo.start();
	}
	
	public static  CloseableHttpClient createHttpClient(){
		CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager(cm).build();
	    return httpClient;
	}
	
	public static class IdleConnectionMonitorThread implements Runnable {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// 关闭失效的连接
						connMgr.closeExpiredConnections();
						// 可选的, 关闭30秒内不活动的连接
						connMgr.closeIdleConnections(50, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
				// terminate
			}
		}
    }
	
	 /**
		 * 发起https请求并获取结果
		 * 
		 * @param requestUrl 请求地址
		 * @param requestMethod 请求方式（GET、POST）
		 * @param outputStr 提交的数据
		 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
		 */
		public static boolean httpRequest(String requestUrl, String requestMethod, String outputStr) 
		{
			
			StringBuffer buffer = new StringBuffer();
			try {
				// 创建SSLContext对象，并使用我们指定的信任管理器初始化
				TrustManager[] tm = { new MyX509TrustManager() };
				SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
				sslContext.init(null, tm, new java.security.SecureRandom());
				// 从上述SSLContext对象中得到SSLSocketFactory对象
				SSLSocketFactory ssf = sslContext.getSocketFactory();

				URL url = new URL(requestUrl);
				HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
				httpUrlConn.setSSLSocketFactory(ssf);
				httpUrlConn.addRequestProperty("Content-Type", "application/json");
	            httpUrlConn.addRequestProperty("encoding", "utf-8");
				httpUrlConn.setDoOutput(true);
				httpUrlConn.setDoInput(true);
				httpUrlConn.setUseCaches(false);
				// 设置请求方式（GET/POST）
				httpUrlConn.setRequestMethod(requestMethod);

				if ("GET".equalsIgnoreCase(requestMethod))
					httpUrlConn.connect();

				// 当有数据需要提交时
				if (null != outputStr) {
					OutputStream outputStream = httpUrlConn.getOutputStream();
					// 注意编码格式，防止中文乱码
					outputStream.write(outputStr.getBytes("UTF-8"));
					outputStream.close();
				}

				// 将返回的输入流转换成字符串
				InputStream inputStream = httpUrlConn.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				logger.error("httpRequest:"+buffer.toString());
				// 释放资源
				inputStream.close();
				inputStream = null;
				httpUrlConn.disconnect();
				
			} catch (ConnectException ce) {
				logger.error("Weixin server connection timed out.");
			} catch (Exception e) {
				logger.error("https request error:{}", e);
			}
			
			return true;
		}
}
