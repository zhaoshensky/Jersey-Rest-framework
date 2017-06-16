package com.sdc.utils.weixinUtil;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:<类功能描述-必填> Copyright: 北京当代金融培训有限公司 (c)2014
 * 
 * @author: user
 * @version: 1.0 Create at: 2014-4-9 下午01:28:07 Modification History: Date
 *           Author Version Description 2014-4-9 user 1.0 如果修改了;必填
 * 
 */

public class ToolUtils {

	
	/**
	 * 数字格式化
	 * @param number
	 * @return
	 */
	public static String numberFormat(Object number){
		
		if(number==null){
			return "";
		}
		String style="###.##";
		DecimalFormat	df = new DecimalFormat(style); // 实例化对象，传入模板
        return df.format(number);
	}
	
	public static String numberFormatBak(Object number){
		
		if(number==null){
			return "";
		}
		String style="###,###.##";
		DecimalFormat	df = new DecimalFormat(style); // 实例化对象，传入模板
        return df.format(number);
	}
	
	
	
	/**
	 * 检查是否是手机号
	 * 
	 * @param mobileno
	 * @return
	 */
	public static boolean checkIsMobileno(String mobileno) {
		mobileno = mobileno.trim();
		Pattern pattern = Pattern
				.compile("^1[3,4,5,8][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(mobileno);
		boolean bool = matcher.matches();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查是否是邮箱
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkIsEmail(String email) {
		email = email.trim();
		Pattern pattern = Pattern
				.compile("^([a-zA-Z0-9]+[_\\|_\\|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$");
		Matcher matcher = pattern.matcher(email);
		boolean bool = matcher.matches();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}
	
	private static final char[] chars={'0','1','2','3','4','5','6','7','8','9'};
	public static String randomCode(int number){
		StringBuffer buffer = new StringBuffer(number);
		for (int i = 0; i < number; i++) {
			int index = (int) (Math.random() * 10);
			buffer.append(chars[index]);
		}
		return buffer.toString();
	}
	
}
