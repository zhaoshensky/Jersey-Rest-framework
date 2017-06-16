package com.sdc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile
{
	private String code;
	private long lastTime;
	public Mobile(String code,long lastTime)
	{
		this.code=code;
		this.lastTime=lastTime;
	}	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getLastTime() {
		return lastTime;
	}
	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}
	
	/**
	 * 验证码相关数据
	 * **/
	public static boolean checkIsMobileno(String mobileno) {
		mobileno = mobileno.trim();
		Pattern pattern = Pattern.compile("^1[3,4,5,8,7][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(mobileno);
		boolean bool = matcher.matches();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 验证手机必须是阿拉伯数字
	 * **/
	private static final char[] chars={'0','1','2','3','4','5','6','7','8','9'};
	public static String randomCode(int number){
		StringBuffer buffer = new StringBuffer(number);
		for (int i = 0; i < number; i++) {
			int index = (int) (Math.random() * 10);
			buffer.append(chars[index]);
		}
		return buffer.toString();
	}
	
	//校验手机号码
	public static boolean isMobileNOb(String mobiles){
	    Pattern p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
	    Matcher m = p.matcher(mobiles);
	    return m.matches();
	}
	
	public static void main(String[] args){
		   Pattern p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
		   Matcher m = p.matcher("19110133250");
		   System.out.println(m.matches()+"---");
	}
}
