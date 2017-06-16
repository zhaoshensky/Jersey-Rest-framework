package com.sdc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//比较器类  
public class MapSort{  
    //Map里按照key升序排列 
	public  Map<String, Object> sortMapByKey(Map<String, Object> oriMap) {  
		    if (oriMap == null || oriMap.isEmpty()) {  
		       return null;  
		    }  
		    Map<String, Object> sortedMap = new TreeMap<String, Object>(new Comparator<String>() {  
		        public int compare(String key1, String key2) {  
		            int intKey1 = 0, intKey2 = 0;  
		           try {  
		                intKey1 = getInt(key1);  
		                intKey2 = getInt(key2);  
		             } catch (Exception e) {  
		                 intKey1 = 0;   
		                 intKey2 = 0;  
		             }  
		             return intKey1 - intKey2;  
		         }});  
		     sortedMap.putAll(oriMap);  
		    return sortedMap;  
		 }  
		 
	 private int getInt(String str) {  
		     int i = 0;  
		     try {  
		         Pattern p = Pattern.compile("^\\d+");  
		         Matcher m = p.matcher(str);  
		         if (m.find()) {  
		            i = Integer.valueOf(m.group());  
		         }  
		    } catch (NumberFormatException e) {  
		         e.printStackTrace();  
		    }  
		    return i;  
	}  
 
	 /**
	  * 判断传入的map中的指定key的值是否为null
	  * @param map
	  * @return 为空返回false,否则返回true
	  */
	 public static boolean keyIsNotNull(Map map,String key){
		 if(ListUtil.isNotEmpty(map)&&map.containsKey(key)&&map.get(key)!=null){
			 return true;
		 }
		 return false;
	 }
	 
}