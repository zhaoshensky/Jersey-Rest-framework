package com.sdc.utils;

public class UserName {
	
	public static boolean checkName(String s){
		String t = "^[()-_\\（\\）\\w\\d\\x{4e00}-\\x{9fa5}]{2,50}+$";
	    return s.matches(t);
	}
	
	public static void main(String[] args){
		System.out.println(checkName("用"));
	}
	
	
}
