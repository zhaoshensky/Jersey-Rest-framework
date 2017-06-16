package com.sdc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CompareUtil {

	/**
	 * 一套房源单个经纪人情况下用于分配房源的方法
	 * @param treeList 用于存储TreeMap的集合，TreeMap是以发房量为key值，ID号为value的TreeMap
	 * @return 
	 * objectMap.put(0, 0)这是发房量全都相等的情况下返回的值，即key跟value都是0;
	 * 		否则，当key跟value都不是0时，key值是最大的发房量，value是对应ID
	 */
	public static Map<Integer, Integer> sortMap(List<TreeMap<Integer, Integer>> treeList){
//		List<TreeMap<Integer, Integer>> treeList = new ArrayList<TreeMap<Integer,Integer>>();
		List<Integer> entryhoursList = new ArrayList<Integer>();
		for (TreeMap<Integer, Integer> treeMap : treeList) {
			Iterator<Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
			while(iterator.hasNext()){
				entryhoursList.add(iterator.next().getKey());
			}
		}
		Integer[] a = entryhoursList.toArray(new Integer[entryhoursList.size()]);
//	    int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
	    
	    int temp=0;
	    int equalcount = 0;
//	    Integer retuArray[] = null; 
	    ArrayList<Integer> arrayList = null;
	    for(int i=0;i<treeList.size()-1;i++){  
	        for(int j=0;j<treeList.size()-1-i;j++){  
	        if(a[j]>a[j+1]){  
	            temp=a[j];  
	            a[j]=a[j+1];  
	            a[j+1]=temp;  
	            arrayList = new ArrayList<Integer>();
	            for (int k = 0; k < a.length; k++) {
	            	arrayList.add(a[k]);
	            }
//	            retuArray = arrayList.toArray(new Integer[arrayList.size()]);
	        }else if(a[j]==a[j+1]){
	        	equalcount++;
	        }  
	        }  
	    } 
	    HashMap<Integer, Integer> objectMap = new HashMap<Integer, Integer>();
	    //奇数时候
	    if(0!=treeList.size()%2){
	    	if(equalcount==(treeList.size()*(treeList.size()-1))/2){
	    		objectMap.put(0, 0);
	    	}else{
	    		Integer objeMapvalue = null;
	    		for (TreeMap<Integer, Integer> treeMap : treeList) {
	    			objeMapvalue = treeMap.get(arrayList.get(arrayList.size()));
	    		}
//	    		arrayList.get(arrayList.size());//发房量
	    		objectMap.put(arrayList.get(arrayList.size()), objeMapvalue);
	    	}
	    //偶数时候
	    }else{
	    	if(equalcount==(treeList.size()/2)*(treeList.size()-1)){
	    		objectMap.put(0, 0);
	    	}else{
	    		Integer objeMapvalue = null;
	    		for (TreeMap<Integer, Integer> treeMap : treeList) {
	    			if(treeMap.containsKey(arrayList.get(arrayList.size()-1))){
	    				objeMapvalue = treeMap.get(arrayList.get(arrayList.size()-1));
	    			}
	    		}
//	    		arrayList.get(arrayList.size());//发房量
	    		objectMap.put(arrayList.get(arrayList.size()-1), objeMapvalue);
	    	}
	    }
	    return objectMap;
	}
	
	
	public static Integer bubbleSort(){
		
//		int a[]={38,38,65,97,76,13,27,9,78,33,12,64,4,6,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		int a[]={8,8,8,8,8,8,8,8,8,8};
		int temp=0;
		int equalcount = 0;
		Integer retuArray[] = null; 
		for(int i=0;i<a.length-1;i++){  
			for(int j=0;j<a.length-1-i;j++){  
				if(a[j]>a[j+1]){  
					temp=a[j];  
					a[j]=a[j+1];  
					a[j+1]=temp;  
					ArrayList<Integer> arrayList = new ArrayList<Integer>();
					for (int k = 0; k < a.length; k++) {
						arrayList.add(a[k]);
					}
					retuArray = arrayList.toArray(new Integer[arrayList.size()]);
				}else if(a[j]==a[j+1]){
					equalcount++;
				}  
			}
		}
		return equalcount;
	}  
	
	public static void main(String[] args) {
		Integer bubbleSortr = bubbleSort();
		System.out.println(bubbleSortr);
		/*for (Integer integer : bubbleSortr) {
			System.out.println(integer);
		}*/
	}
}
