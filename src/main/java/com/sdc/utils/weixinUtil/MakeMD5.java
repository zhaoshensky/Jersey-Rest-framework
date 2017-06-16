package com.sdc.utils.weixinUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MakeMD5 {
	
	public static String md5(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return null;
		}
		byte[] resultByte = messageDigest.digest(str.getBytes());
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < resultByte.length; ++i) {
			result.append(Integer.toHexString(0xFF & resultByte[i]));
		}
		return result.toString();
	}

	public String EncoderByMd5(String str) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		// ȷ�����㷽��
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// ���ܺ���ַ�
		String newstr = base64en.encode(md5.digest(str.getBytes("GB2312")));
		return newstr;
	}
	


	/** */
	/**
	 * �ж��û������Ƿ���ȷ
	 * 
	 * @param newpasswd
	 *            �û����������
	 * @param oldpasswd
	 *            ��ݿ��д洢�����룭���û������ժҪ
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public boolean checkpassword(String newpasswd, String oldpasswd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncoderByMd5(newpasswd).equals(oldpasswd))
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		MakeMD5 make = new MakeMD5();
		
		System.out.println(make.EncoderByMd5("8"));
	}
	/**
	 * Base64����
	 * */
	 public static String encode(byte[] bstr){  
		     return new sun.misc.BASE64Encoder().encode(bstr);  
		     }  
		   
		     /** 
		      * ���� 
		      * @param str 
		      * @return string 
		      */  
		     public static byte[] decode(String str){  
		     byte[] bt = null;  
		     try {  
		         sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();  
		         bt = decoder.decodeBuffer( str );  
		     } catch (IOException e) {  
		         e.printStackTrace();  
		     }  
		   
		         return bt;  
		     }  


}
