package com.sdc.utils.sdcUtil;

import java.text.ParseException;

import com.alibaba.druid.util.StringUtils;

/**
 * description:
 *
 * @author   jiachenghao@ediankai.com
 * @date     2017年1月17日 下午7:32:52
 * @Company  ediankai
 *
 */
public class StringValidateUtil {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return 为空返回false,非空返回true
	 */
	public static boolean isNotEmpty(String str){
		if(null!=str&&!str.equals("")&&!str.equals("null")){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为空
	 * @param obj
	 * @return 为空返回true,非空返回false(主要针对json串，获取到的字段为Object情况)
	 */
	public static boolean isEmptyString(Object obj){
		if(null==obj||(obj+"").equals("")||obj.equals("null")){
			return true;
		}
		return false;
	}
	
	/** 
     * 将emoji表情替换成* 
     *  
     * @param source 
     * @return 过滤后的字符串 
     */  
    public static String filterEmoji(String source) {  
        if( isNotEmpty(source) ){  
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");  
        }else{  
            return source;  
        }  
    }  
    
    /**
     * 判断字符串是否是空 是空 返回ture
     * @param number
     * @return
     */
    public static Boolean isNullString(Object number) {
        if(number==null||StringUtils.isEmpty(number.toString()))
            return  true;
        return  false;
    }
    /**
     * 判断字符串是否是空 如果空 返回0
     * @param number
     * @return
     */
    public static String isNullAndInit0(String number) {
        if(StringUtils.isEmpty(number.toString()))
            return "0";
        return  number;
    }
    /**
     * 判断字符串是否是空 如果空 返回null
     * @param number
     * @return
     */
    public static String isNullAndInitString(Object number) {
        if(number==null||StringUtils.isEmpty(number.toString()))
            return null;
        return  number.toString();
    }
    
    /**  
     * 验证一个字符串是否是Double类型  
     *   
     * @param s 要验证的字符串  
     * @return 如果是Double类型则返回true,否则返回false  
     */   
    public static boolean isDouble(String s) {    
        if (s == null || s.equals(""))    
            return false;    
        String num = "0123456789.";    
        if (s.indexOf('.') >= 0)    
            if (s.indexOf('.', s.indexOf('.') + 1) > 0)    
                return false;    
        for (int i = 0; i < s.length(); i++) {    
            if (num.indexOf(s.charAt(i)) < 0) {    
                return false;    
            } else {    
                try {    
                    Double.parseDouble(s);    
                } catch (NumberFormatException e) {    
                    return false;    
                }    
            }    
        }    
        return true;    
    }
    
    /**  
     * 验证一个字符串是否是Float类型  
     *   
     * @param s 要验证的字符串  
     * @return 如果是Float类型则返回true,否则返回false  
     */   
    public static boolean isFloat(String s) {    
        if (s == null || s.equals(""))    
            return false;    
        String num = "0123456789.";    
        if (s.indexOf('.') >= 0)    
            if (s.indexOf('.', s.indexOf('.') + 1) > 0)    
                return false;    
        for (int i = 0; i < s.length(); i++) {    
            if (num.indexOf(s.charAt(i)) < 0) {    
                return false;    
            } else {    
                try {    
                    Float.parseFloat(s);    
                } catch (NumberFormatException e) {    
                    return false;    
                }    
            }    
        }    
        return true;    
    } 
    
    /**  
     * 验证一个字符串是否是整形  
     *   
     * @param s 要验证的字符串  
     * @return 如果是整形则返回true,否则返回false  
     */   
    public static boolean isInteger(String s) {    
        if (s == null || s.length() == 0) {    
            return false;    
        } else {    
            String str = "0123456789";    
            String num = "-0123456789";    
            if (num.indexOf(s.charAt(0)) < 0)    
                return false;    
            for (int i = 1; i < s.length(); i++) {    
                if (str.indexOf(s.charAt(i)) < 0) {    
                    return false;    
                } else {    
                    try {    
                        Integer.parseInt(s);    
                    } catch (NumberFormatException e) {    
                        return false;    
                    }    
                }    
            }    
        }    
        return true;    
    }
    
    /**  
     * 验证一个字符串是否一个合法日期,日期格式：yyyy-MM-dd  
     *   
     * @param date 要验证的字符串日期  
     * @return 如果字符串是一个合法的日期返回true,否则返回false  
     */   
    public static boolean isDate(String date) {    
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");    
        try {    
            df.setLenient(false);    
            df.parse(date);    
            return true;    
        } catch (ParseException e) {    
            return false;    
        }    
    }
    
    /**  
     * 验证一个字符串是否是数字组成  
     *   
     * @param s 要验证的字符串  
     * @return 如果字符串是数字组成的则返回true,否则返回false  
     */   
    public static boolean isNumber(String s) {    
        if (s == null || s.equals(""))    
            return false;    
        String num = "0123456789";    
        for (int i = 0; i < s.length(); i++) {    
            if (num.indexOf(s.charAt(i)) < 0)    
                return false;    
        }    
        return true;    
    }
}

