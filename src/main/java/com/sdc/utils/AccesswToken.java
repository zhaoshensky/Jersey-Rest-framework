package com.sdc.utils;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.sdc.utils.weixinUtil.JsonUtil;




public class AccesswToken 
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AccesswToken.class);

	private static AccessTokenModel  accessTokenModel;
	private static long lastAccessTime=0;
	static { lastAccessTime=new Date().getTime(); }
	
	public static final AccessTokenModel gesAccessToken(String sapid,String skey)
			throws ClientProtocolException, IOException
	{
		if(AccesswToken.accessTokenModel==null)
		{
			synchronized(AccesswToken.class){
				if(null==AccesswToken.accessTokenModel){
				int count=3;
				AccesswToken.accessTokenModel=createAccessToken(sapid,skey) ;
				if(null==AccesswToken.accessTokenModel){
					for(int i=0;i<count;i++){
						AccesswToken.accessTokenModel=createAccessToken(sapid,skey) ;
						if(null!=AccesswToken.accessTokenModel){
							lastAccessTime=new Date().getTime();
							return AccesswToken.accessTokenModel;
						}
					}
				}
			 }
			}
		}
		long currentTime=new Date().getTime();
		if(currentTime-AccesswToken.lastAccessTime>6500000){
			synchronized(AccesswToken.class){
			if(currentTime-AccesswToken.lastAccessTime>6500000){
				int count=3;
				AccesswToken.accessTokenModel=createAccessToken(sapid,skey) ;
				if(null==AccesswToken.accessTokenModel){
					for(int i=0;i<count;i++){
						AccesswToken.accessTokenModel=createAccessToken(sapid,skey) ;
						if(null!=AccesswToken.accessTokenModel){
							lastAccessTime=new Date().getTime();
							return AccesswToken.accessTokenModel;
						}
					}
				}
				lastAccessTime=new Date().getTime();
			 }
			}
		}
		return AccesswToken.accessTokenModel;
	}
	
	private static AccessTokenModel createAccessToken(String sppId ,String skey)
			throws ClientProtocolException, IOException
	{
		logger.error("reload createAccessToken");
		StringBuffer buffer=new StringBuffer(200);
	    
		buffer.append("appid=").append(sppId).append("&secret=").append(skey)
	              .append("&grant_type=").append("client_credential");		
		CloseableHttpClient httpClient= HttpClientUtils.createHttpClient();
		  //HTTP Get璇锋眰(POST鍚�)
		HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?"+buffer.toString());
			
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000)
			 .setConnectTimeout(3000).setConnectionRequestTimeout(3000).build();//璁剧疆璇锋眰鍜屼紶杈撹秴鏃舵椂闂�
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse httpResponse = null;
		String result = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = httpResponse.getEntity();
				
				if (entity != null) {
					result = EntityUtils.toString(entity, "utf-8");					
				}
		     return (AccessTokenModel) JsonUtil.jsonToObject(result,AccessTokenModel.class);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
