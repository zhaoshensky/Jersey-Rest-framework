package com.sdc.utils;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年3月11日
* @Company: ediankai
*/
public class ArrayUtil {

	
	/**
	* JAVA判断字符串数组中是否包含某字符串元素
	*
	* @param substring 某字符串
	* @param source 源字符串数组
	* @return 包含则返回true，否则返回false
	*/
	public static boolean isInArray(String substring, String[] source) {
		
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	* JAVA将字符串转成数组，并判断字符串是否存在
	*
	* @param substring 某字符串
	* @param source 源字符串数组
	* @return 包含则返回true，否则返回false
	*/
	public static boolean isAllown(String str,String type,String split){
    	
    	boolean isOk = false;
    	
    	String[] allowType = str.split(split);
    	if( ArrayUtil.isInArray(type, allowType) ){
    		isOk = true;
    	}
    	
    	return isOk;
    }
	
}
