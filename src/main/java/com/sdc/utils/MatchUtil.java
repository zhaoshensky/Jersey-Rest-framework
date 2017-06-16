package com.sdc.utils;

import java.util.ArrayList;
import java.util.List;

public class MatchUtil {

	/**
	 * 
	 * @param chushu 经纪人总数
	 * @param beichushu 未匹配房源总数
	 * @return 第一位置是余数，第二位置是商
	 */
	public static List<Integer> chufa(int chushu,int beichushu){
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	arrayList.add(chushu%beichushu);
    	arrayList.add(chushu/beichushu);
    	return arrayList;
    }
	
	public static void main(String[] args) {
		System.out.println(chufa(2, 5));
	}
}
