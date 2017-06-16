package com.sdc.utils.sdcUtil;

import java.util.UUID;

public class IDUtils {
	
	 //uuid
    public static  String  getId(){
          return UUID.randomUUID().toString().replace("-", "");
    }
     //订单ID
    public static String getOrderId(String node){
        return  "P"+node+System.currentTimeMillis()+(int)(Math.random()*9000+1000);
    }
    
    public static void main(String[] args) {
		System.out.println(getOrderId("2"));
	}
}
