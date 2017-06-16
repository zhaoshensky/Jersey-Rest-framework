package com.sdc.utils;

public class HoursingCustomerConstant {
	
	/**
	 * 字段描述
	 */
	public static final String RENT_STRING ="1";
	public static final String AREA_STRING = "2";

	/**
	 * (面积，租金)升降序描述
	 */
	public static final String AREAASC_CODE = "1";//面积升序
	public static final String AREAASC = "ASC";
	
	public static final String AREZDESC_CODE = "2";//面积降序
	public static final String AREZDES = "DESC";
	
	public static final String RENTASC_CODE = "3";//租金升序
	public static final String RENTAS = "ASC";
	
	public static final String RENTDESC_CODE = "4";//租金降序
	public static final String RENTDESC = "DESC";
/**********************************************************************************************/
	/**
	 * 办公间面积
	 */
	public static final String INTEROFFICEAREA_100_CODE = "1";//面积0~100编码
	public static final String INTEROFFICEAREA_100 = "0to100";
	
	public static final String INTEROFFICEAREA_300_CODE = "2";//面积100~300编码
	public static final String INTEROFFICEAREA_300 = "100to300";
	
	public static final String INTEROFFICEAREA_500_CODE = "3";//面积300~500编码
	public static final String INTEROFFICEAREA_500 = "300to500";
	
	public static final String INTEROFFICEAREA_1000_CODE = "4";//面积500~1000编码
	public static final String INTEROFFICEAREA_1000 = "500to1000";
	
	public static final String INTEROFFICEAREA_H1000_CODE = "5";//面积大于1000编码
	public static final String INTEROFFICEAREA_H1000 = "1000to111111";
/**********************************************************************************************/
	/**
	 * 办公间租金
	 */
	public static final String INTEROFFICERENT_1_CODE = "1";//租金<1
	public static final String INTEROFFICERENT_1 = "0to1.001";
	
	public static final String INTEROFFICERENT_2_CODE = "2";//租金<2
	public static final String INTEROFFICERENT_2 = "1.001to3.001";
	
	public static final String INTEROFFICERENT_5_CODE = "3";//租金<5
	public static final String INTEROFFICERENT_5 = "3.001to5.001";
	
	public static final String INTEROFFICERENT_7_CODE = "4";//租金<7
	public static final String INTEROFFICERENT_7 = "5.001to7.001";
	
	public static final String INTEROFFICERENT_10_CODE = "5";//租金<10
	public static final String INTEROFFICERENT_10 = "7.001to10.001";
	
	public static final String INTEROFFICERENT_H10_CODE = "6";//租金>10
	public static final String INTEROFFICERENT_H10 = "10.001to111111";
/**********************************************************************************************/	
	/**
	 * 办公位数量
	 */
	public static final String FILEDOFFICECOUNT_10_CODE = "1";//办公位<10编号
	public static final String FILEDOFFICECOUNT_10 = "1to10";
	
	public static final String FILEDOFFICECOUNT_20_CODE = "2";//办公位<20编号
	public static final String FILEDOFFICECOUNT_20 = "10to20";
	
	public static final String FILEDOFFICECOUNT_30_CODE = "3";//办公位<30编号
	public static final String FILEDOFFICECOUNT_30 = "20to30";
	
	public static final String FILEDOFFICECOUNT_H30_CODE = "4";//办公位>30编号
	public static final String FILEDOFFICECOUNT_H30 = "30to333333";
/**********************************************************************************************/
	/**
	 * 办公位租金
	 */
	public static final String FILEDOFFICERENT_300_CODE = "7";
	public static final String FILEDOFFICERENT_300 = "0to300";
	
	public static final String FILEDOFFICERENT_500_CODE = "8";
	public static final String FILEDOFFICERENT_500 = "300to500";
	
	public static final String FILEDOFFICERENT_700_CODE = "9";
	public static final String FILEDOFFICERENT_700 = "500to700";
	
	public static final String FILEDOFFICERENT_900_CODE = "10";
	public static final String FILEDOFFICERENT_900 = "700to900";
	
	public static final String FILEDOFFICERENT_H900_CODE = "11";
	public static final String FILEDOFFICERENT_H900 = "900to999999";
	
	/**
	 * 匹配类型说明
	 * 
	 */
	public static final int UNMATCHEDHOURS = 1;//未匹配房源
	public static final int MATCHEDHOURS = 0;//已匹配房源
}
