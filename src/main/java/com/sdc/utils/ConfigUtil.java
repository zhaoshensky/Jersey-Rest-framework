package com.sdc.utils;

import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取properties文件
 * earl
 *
 */
public class ConfigUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ConfigUtil.class);
	
	private static String filename="/sms.properties";
	
	private static String proname="/pro.properties";
	
	public  Properties getProperties() throws IOException
	{
		Properties p = new Properties();  
		try {
			InputStream in=getClass().getResourceAsStream(filename);//短信
			p.load(in); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}   
		return p;
	}
	
	public  Properties getProProperties() throws IOException //ftp
	{
		Properties p = new Properties();  
		try {
			InputStream in=getClass().getResourceAsStream(proname);
			p.load(in); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}   
		return p;
	}
	
//	public  Properties getDomainName() throws IOException
//	{
//		Properties p = new Properties();  
//		try {
//			InputStream in=getClass().getResourceAsStream(filename);
//			p.load(in); 
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}   
//		return p;
//	}
	
	public static void main(String[] args)
	{
		Properties pros=new Properties();
		String chinese=null;
		String chinese1=null;
	 try 
	 {
		 pros=new ConfigUtil().getProperties();
		 chinese=pros.getProperty("note").toString();
		 chinese=new String(chinese.getBytes("ISO-8859-1"), "UTF-8");
		 chinese1=pros.getProperty("sttnote").toString();
		 chinese1=new String(chinese1.getBytes("ISO-8859-1"), "UTF-8");
		  
	 } catch (IOException e)
	 {
			e.printStackTrace();
	 }
	
	 	logger.info(":"+pros.getProperty("usrl")+"\n :"+pros.getProperty("Uid")
	 			+"\n:"+chinese+"\n"+chinese1);
	}
	
	
}
