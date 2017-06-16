package com.sdc.utils.weixinUtil;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**   
 * 创建人：user   
 * 创建时间：2013-11-29   
 * 修改人：user   
 * 修改时间：2013-11-29
 * 类描述：    
 * 修改备注：   
 * 版本:  
 *    
 */

public class Base64 {

	private static Base64 instance = new Base64();
    private static Lock lock=new ReentrantLock();
	public static  Base64 getInstance() {
		if (instance == null) {
			lock.lock();
			try {
		      if (instance == null) {
					instance = new Base64();
				}
			} finally {
				lock.unlock();
			}
		}
		return instance;
	}

	
	
	
	
	/**
	 * 将原始数据编码为base64编码
	 */
	public String encode(String str,String characterSet ) {

		if (str == null || "".equals(str.trim())) {
			return "";
		}
		byte[] data=null;
		try {
			data = str.getBytes(characterSet);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] out = new char[((data.length + 2) / 3) * 4];

		for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
			boolean quad = false;
			boolean trip = false;
			int val = (0xFF & (int) data[i]);
			val <<= 8;
			if ((i + 1) < data.length) {
				val |= (0xFF & (int) data[i + 1]);
				trip = true;
			}
			val <<= 8;
			if ((i + 2) < data.length) {
				val |= (0xFF & (int) data[i + 2]);
				quad = true;
			}
			out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 1] = alphabet[val & 0x3F];
			val >>= 6;
			out[index + 0] = alphabet[val & 0x3F];
		}
		return new String(out);
	}

	
	
	public String decode(String str,String characterSet) {
		if (str == null || "".equals(str.trim())) {
			return "";
		}
		char[] data = str.toCharArray();
		int len = ((data.length + 3) / 4) * 3;
		if (data.length > 0 && data[data.length - 1] == '=') {
			--len;
		}
		if (data.length > 1 && data[data.length - 2] == '=') {
			--len;
		}
		byte[] out = new byte[len];
		int shift = 0;
		int accum = 0;
		int index = 0;
		for (int ix = 0; ix < data.length; ix++) {
			int value = codes[data[ix] & 0xFF];
			if (value >= 0) {
				accum <<= 6;
				shift += 6;
				accum |= value;
				if (shift >= 8) {
					shift -= 8;
					out[index++] = (byte) ((accum >> shift) & 0xff);
				}
			}
		}
		if (index != out.length) {
			return null;
			// throw new Error("miscalculated data length!");
		}
		if(characterSet==null){
			characterSet="utf-8";
		}
		try {
			String strs=new String(out,characterSet);
			return strs;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		
		
	}
	
	
	

	static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
			.toCharArray();

	static private byte[] codes = new byte[256];
	static {
		for (int i = 0; i < 256; i++) {
			codes[i] = -1;
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			codes[i] = (byte) (i - 'A');
		}
		for (int i = 'a'; i <= 'z'; i++) {
			codes[i] = (byte) (26 + i - 'a');
		}
		for (int i = '0'; i <= '9'; i++) {
			codes[i] = (byte) (52 + i - '0');
		}
		codes['+'] = 62;
		codes['/'] = 63;
	}


	

}
