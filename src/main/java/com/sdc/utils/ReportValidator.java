package com.sdc.utils;

/**
 * @Title: ReportValidator.java
 * @Copyright: 北京点开云商科技有限公司
 * @package: com.sdc.utils  
 * @Description: TODO 
 * @author: liligeng
 * @date: 2017年4月21日 下午4:25:34  
 * @version V1.0
*/

public class ReportValidator {

    public static boolean isAllown(String limit, String type) {

        boolean isOk = false;

        String[] allowType = limit.split(",");
        if (ArrayUtil.isInArray(type, allowType)) {
            isOk = true;
        }

        return isOk;
    }
}
