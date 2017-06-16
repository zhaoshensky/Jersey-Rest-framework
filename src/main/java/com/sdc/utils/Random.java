package com.sdc.utils;

import com.github.pagehelper.StringUtil;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;

public class Random {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(Random.class);
    private static int a = 0;

    //获取三位
    public static final int Rand() {
        a = (int) (Math.random() * 1000);
        return a;
    }

    //获取四位参数
    public static final int threeRand() {
        a = (int) (Math.random() * 10000);
        return a;
    }

    //获取二位
    public static final int R_Rand() {
        a = (int) (Math.random() * 100);
        return a;
    }

    public static final String R_RandDateUtil() {
        String rd = DateUtil.Ridrand() + Random.R_Rand();
        logger.debug("～～生成房源编号:" + rd);
        return rd;
    }

    public static final String RandDateUtil() {
        String rd = DateUtil.idrand() + Random.Rand();
        logger.debug("随机产生代码:" + rd);
        return rd;
    }
//	public static void main(String[] args)
//	{
//		logger.debug(Random.R_RandDateUtil());
////		logger.debug("随机数:"+Random.Rand());	    
//	}

    public static boolean bstr(String str1, String str2) {
        boolean str = false;

        if (((str1 != null && !"".equals(str1)) || str1.length() >= 0)
                && (str2 != null && !"".equals(str2)) || str2.length() >= 0) {
            int ising = str1.lastIndexOf("=");
            if (ising != 9)
                str = false;
            else {
                String st = str1.substring(ising + 1);
                if (!"".equals(st) && st != null) {
                    int sistr = Integer.parseInt(st);
                    String str1s = str1.substring(0, str1.lastIndexOf("="));
                    String s1tr = str2.substring(sistr, sistr + 1);
                    str2 = str2.replace(s1tr, "");
                    if (str1s.equals(str2))
                        str = true;
                    else
                        str = false;
                } else
                    str = false;
            }
        } else
            str = false;
        return str;
    }

    /**
     * 随机生成字母加数字
     *
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        java.util.Random random = new java.util.Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
    	String rdm1 = Random.getStringRandom(4);
    	System.out.println(rdm1);
        double max = 22.0;
        double min = 11.0;

    }

    public static double genDouble(final double min, final double max) throws Exception {
        if (max < min) {
            throw new Exception("min < max");
        }
        if (min == max) {
            return min;
        }
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("0.00");
        double v = min + ((max - min) * new java.util.Random().nextDouble());
     return   Double.valueOf(df.format(v));
    }

}
