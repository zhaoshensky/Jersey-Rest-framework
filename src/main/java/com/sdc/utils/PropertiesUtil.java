package com.sdc.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;


public class PropertiesUtil {

	private static Properties properties = null;
	/**
	 * 载入属性文件
	 * @param propName 属性文件名称
	 * @return
	 */
	public static Properties loadProperties(String propName){
		if(null==properties)
			properties = new Properties();
		try {
			String pat = PropertiesUtil.class.getClassLoader().getResource("/spring/properties/"+propName).getFile();
			File file = new File(pat);
			InputStream fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
//			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/spring/properties/test/"+propName));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return properties;
	}
	
	/**
	 * 通过属性key获得其值
	 * @param keyName
	 * @return
	 */
	public static String getValueInfoByKey(String propName, String keyName){
		Properties pps = loadProperties(propName);
		return (String)pps.get(keyName);
	}
	
	/**
	 * 通过属性key获得其值
	 * @param keyName
	 * @return
	 */
	public static String getValueInfoByKey(String keyName){
		return (String)properties.get(keyName);
	}
	
	public static String setValueInfoByKey(String propName, String key, String value) {
			String pat = PropertiesUtil.class.getResource("/spring/properties/"+propName).getFile();
			Properties pps = loadProperties(propName);
			OutputStream fos = null;
			try {
				File file = new File(pat);
				fos = new FileOutputStream(file);
				// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
				// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
				String before = pps.getProperty(key);
//				System.out.println("修改前：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：："+before);
				pps.setProperty(key, value);
				// 以适合使用 load 方法加载到 Properties 表中的格式，
				// 将此 Properties 表中的属性列表（键和元素对）写入输出流
				pps.store(fos, "Update " + key + " name");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("修改后：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：："+pps.get(key));
		
		return value;
	}
	
}
