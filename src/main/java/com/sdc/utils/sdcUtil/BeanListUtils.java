package com.sdc.utils.sdcUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.sdc.common.demo.model.Demo;

public class BeanListUtils {
	
    
    /**
     * 将源对象转换至指定类型对象
     * @param source 源数据对象
     * @param targetClazz 目标数据类型对象
     */
    public static <T> Object copyObject(Object source, Object target){
       
    	BeanUtils.copyProperties(source, target);
    	
        return target;
    }
   
    //List集合间的copy
    public static List copyList(List source, List target){
        
    	for(Object o : source){
    		target.add(o);
    	}
        return target;
    }
    
    
    public static void main(String[] args) {
    	
    	  List<String> src = new ArrayList<String>();  
    	  src.add("111");  
    	  src.add("222");  
    	  src.add("333");  
    	  src.add("444");  
    	  List<String> dest1  =   new  ArrayList<String>();  
    	  copyList(src,dest1);
    	  
		System.out.println(dest1);
	}
    
    
    
}
