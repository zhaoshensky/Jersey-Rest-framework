package com.sdc.utils;

import java.util.Random;

/**
* description:
*
* @author maolixia@ediankai.com
* @date 2017年3月22日
* @company ediankai
*/
public class PublicKeyUtil {
	/**
	 * 获取应用公钥
	 * @return
	 */
	public static String getAppPublicKey(){
		String str = "ABCDEFGHIJKLMNOPQISTUVWXYZ0123456789";
		String temp = "";
		Random random = new Random();
		for(int i = 0; i < 16; i++){
			int num = random.nextInt(str.length());
			char c1 = str.charAt(num);
			temp += c1;
		}
		return temp;
	}
	
	/**
	 * 获取应用私钥
	 * @return
	 */
	public static String getAppSecret(){
		String str = "ABCDEFGHIJKLMNOPQISTUVWXYZ~!@#$%^&0123456789";
		String temp = "";
		Random random = new Random();
		for(int i = 0; i < 16; i++){
			int num = random.nextInt(str.length());
			char c1 = str.charAt(num);
			temp += c1;
		}
		return temp;
	}
}
