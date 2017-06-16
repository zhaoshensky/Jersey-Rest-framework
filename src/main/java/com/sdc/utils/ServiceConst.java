package com.sdc.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年1月7日
* @Company: ediankai
*/
public class ServiceConst {

	
	public static InetAddress getInetAddress(){  
		  
        try{  
            return InetAddress.getLocalHost();  
        }catch(UnknownHostException e){  
            System.out.println("unknown host!");  
        }  
        return null;  
  
    }  
  
    public static String getHostIp(InetAddress netAddress){  
        if(null == netAddress){  
            return null;  
        }  
        String ip = netAddress.getHostAddress(); //get the ip address  
        return ip;  
    }  
  
    public static String getHostName(InetAddress netAddress){  
        if(null == netAddress){  
            return null;  
        }  
        String name = netAddress.getHostName(); //get the host address  
        return name;  
    }  
	
}
