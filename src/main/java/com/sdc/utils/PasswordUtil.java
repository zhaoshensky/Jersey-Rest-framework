package com.sdc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtil {
	
	
public static boolean checkString(String s) {
    //^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$  正则表达式：必须包含数字和字母，长度为6位-20位
//    return s.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
	String r = "^(?=.*\\d.*)(?=.*[a-zA-Z].*)(?=.*[-`~!@#$%^&*()_+\\|\\\\=,./?><\\{\\}\\[\\]].*).*$";
    return s.matches(r);
}
//校验整数
public static boolean isInteger(String input){  
    Matcher mer = Pattern.compile("^[0-9]+$").matcher(input);  
    return mer.find();  
}  

public static void main(String[] args) {
	//校验密码
	System.out.println(isInteger("1232.3"));
	
}


}
