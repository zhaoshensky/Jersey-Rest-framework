package com.sdc.system.servlet.shutdown.impl;

import java.util.Iterator;
import java.util.Set;

import com.sdc.system.servlet.shutdown.ServletShutDown;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年6月19日
* @Company: ediankai
*/
public class ThreadShutDown implements ServletShutDown {

	/* (non-Javadoc)
	 * @see com.sdc.system.servlet.shutdown.ServletShutDown#shutDown()
	 */
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

		System.out.println("******************* Threads ******************** ");  
		//获取栈内所有线程
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		Iterator<Thread> threadIterator = threadSet.iterator();
		while(threadIterator.hasNext()){
			Thread t = threadIterator.next();
//			System.out.println(t.getName());  
			String[] strAll = {
					"Abandoned connection cleanup thread",
					"commons-pool-EvictionTimer",
					"ActiveMQ",
					"New I/O",
//					"Dubbo",
					"MessageListener"  
					};     
			  
			for( String str :  strAll ){  
			   
				if( t.getName().contains( str ) ) {
					System.out.println("...... killed ... " + t.getName() );
//					synchronized(t) {
						t.setContextClassLoader(null); 
//						if( t.getName().contains("ZkClient")){
//							try {
//								t.wait();
//							} catch (InterruptedException e) { 
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}  
//						}

	                    t.stop();  
//	                }    
	                  
	            }
				
			}
			
		}    
		
	}

}
