package com.sdc.utils.weixinUtil;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 定义获取产量方法
 * @author admin
 *
 */
public class ContantsUtils {
	
	private static final int MOBILE_TIME_INTERVAL=10;
	private static final KeyPairs EMPTY_KEY_PAIRS=new KeyPairs("","");
    private static final int PAY_TIME_OUT=30;
	private static final int MEET_TIME_LOCK=1000*60*30;
	

	/**
	 * 支付限时
	 * @return
	 */
	public static final int getPayTimeOut(){
		return ContantsUtils.PAY_TIME_OUT;
	}
	
	/**
	 * 获取手机验证码有钱期(分钟)
	 * @return
	 */
	public static final int  getSmsCodeValidity(){
		
		return ContantsUtils.MOBILE_TIME_INTERVAL;
	}
	
	
	
	/**
	 * 获取会议锁时间长度（毫秒）
	 * @return
	 */
	public static final int getMeetLockTime(){
		return ContantsUtils.MEET_TIME_LOCK;
	}
	
	/**
	 * 初始化消息数据
	 */
	private static List<KeyPairs> MESSAGE_TYPE = new ArrayList<KeyPairs>(3);
	static{
		MESSAGE_TYPE.add(new KeyPairs("短信", "DX_01"));
		MESSAGE_TYPE.add(new KeyPairs("邮件", "YJ_01"));
		MESSAGE_TYPE.add(new KeyPairs("系统消息", "XTXX_01"));
		MESSAGE_TYPE.add(new KeyPairs("会议场地", "HYCD_01"));
		PROVICE_LIST=Collections.unmodifiableList(MESSAGE_TYPE);
	}
	/**
	 * 获取消息类型
	 * @return
	 */
	public static final List<KeyPairs> getMessageType(){
		return MESSAGE_TYPE;
	}
	
	/**
	 * 初始化订单支付状态
	 */
	private static List<KeyPairs> PAY_STATUS = new ArrayList<KeyPairs>(4);
	static{
		PAY_STATUS.add(new KeyPairs("待支付", "0"));
		PAY_STATUS.add(new KeyPairs("支付中", "1"));
		PAY_STATUS.add(new KeyPairs("支付成功", "2"));
		PAY_STATUS.add(new KeyPairs("支付失败", "3"));
		PAY_STATUS.add(new KeyPairs("超时", "4"));
		PROVICE_LIST=Collections.unmodifiableList(PAY_STATUS);
	}
	
	/**
	 * 获取支付状态
	 * @return
	 */
	public static final List<KeyPairs> getpayStatus(){
		return PAY_STATUS;
	}
	
	/**
	 * 初始化订单退费状态
	 */
	private static List<KeyPairs> BACK_TIME = new ArrayList<KeyPairs>(4);
	static{
		BACK_TIME.add(new KeyPairs("未退费", "0"));
		BACK_TIME.add(new KeyPairs("退费中", "1"));
		BACK_TIME.add(new KeyPairs("退费失败", "2"));
		BACK_TIME.add(new KeyPairs("退费成功", "3"));
		PROVICE_LIST=Collections.unmodifiableList(BACK_TIME);
	}
	
	/**
	 * 获取订单退费状态
	 * @return
	 */
	public static final List<KeyPairs> getbackStatus(){
		return BACK_TIME;
	}
	
	/**
	 * 初始化省数据
	 */
	private static  List<KeyPairs> PROVICE_LIST=new ArrayList<KeyPairs>(5);
	static{
		PROVICE_LIST.add(new KeyPairs("北京","BJ_01"));
		PROVICE_LIST.add(new KeyPairs("上海","SH_01"));
		PROVICE_LIST.add(new KeyPairs("广州","GZ_01"));
		PROVICE_LIST.add(new KeyPairs("深圳","SZ_01"));
		PROVICE_LIST.add(new KeyPairs("杭州","HZ_01"));
		PROVICE_LIST.add(new KeyPairs("其他","QT_01"));
		PROVICE_LIST=Collections.unmodifiableList(PROVICE_LIST);
	}
	/**
	 * 获取省份数据
	 * @return
	 */
	public static final List<KeyPairs> getProvices(){
		return PROVICE_LIST;
	}
	
	/**
	 * 省的准确数据
	 * @param key
	 * @return
	 */
	public static final KeyPairs getProvicesByCode(String key){
		 return ContantsUtils.getKeyPairsByCode(key,0);
	}
	
	

	
	/**
	 * 初始化市数据
	 */
	
	private static final Map<String,KeyPairs[]> CITY_MAP=new HashMap<String,KeyPairs[]>();
	static{
		CITY_MAP.put("BJ_01", new KeyPairs[]{
				new KeyPairs("东城区","BJ_01_DC"),
				new KeyPairs("西城区","BJ_01_XC"),
				new KeyPairs("朝阳区","BJ_01_CY"),
				new KeyPairs("海淀区","BJ_01_HD"),
				new KeyPairs("丰台区","BJ_01_FT"),
				new KeyPairs("石景山区","BJ_01_SJS"),
				new KeyPairs("门头沟区","BJ_01_MTG"),
				new KeyPairs("房山区","BJ_01_FS"),
				new KeyPairs("大兴区","BJ_01_DX"),
				new KeyPairs("通州区","BJ_01_TZ"),
				new KeyPairs("顺义区","BJ_01_SY"),
				new KeyPairs("昌平区","BJ_01_CP"),
				new KeyPairs("平谷区","BJ_01_PG"),
				new KeyPairs("怀柔区","BJ_01_HR"),
				new KeyPairs("密云县","BJ_01_MY"),
				new KeyPairs("延庆县","BJ_01_YQ")
		});
		CITY_MAP.put("SH_01", new KeyPairs[]{
				new KeyPairs("黄埔区","SH_01_HP"),
				new KeyPairs("徐汇区","SH_01_XH"),
				new KeyPairs("长宁区","SH_01_CN"),
				new KeyPairs("静安区","SH_01_JA"),
				new KeyPairs("普陀区","SH_01_PT"),
				new KeyPairs("闸北区","SH_01_ZB"),
				new KeyPairs("虹口区","SH_01_HK"),
				new KeyPairs("杨浦区","SH_01_YP"),
				new KeyPairs("宝山区","SH_01_BS"),
				new KeyPairs("闵行区","SH_01_MH"),
				new KeyPairs("嘉定区","SH_01_JD"),
				new KeyPairs("浦东新区","SH_01_PDXQ"),
				new KeyPairs("松江区","SH_01_SJ"),
				new KeyPairs("金山区","SH_01_JS"),
				new KeyPairs("青浦区","SH_01_QP"),
				new KeyPairs("南汇区","SH_01_NH"),
				new KeyPairs("奉贤区","SH_01_FX"),
				new KeyPairs("崇明县","SH_01_CMX"),
		});
		CITY_MAP.put("GZ_01", new KeyPairs[]{
				new KeyPairs("越秀区","GZ_01_YX"),
				new KeyPairs("海珠区","GZ_01_HZ"),
				new KeyPairs("荔湾区","GZ_01_LW"),
				new KeyPairs("天河区","GZ_01_TH"),
				new KeyPairs("白云区","GZ_01_BY"),
				new KeyPairs("黄埔区","GZ_01_HP"),
				new KeyPairs("花都区","GZ_01_HD"),
				new KeyPairs("番禺区","GZ_01_PY"),
				new KeyPairs("萝岗区","GZ_01_LG"),
				new KeyPairs("南沙区","GZ_01_NS")			
		});
		CITY_MAP.put("SZ_01", new KeyPairs[]{
				new KeyPairs("福田区","SZ_01_FT"),
				new KeyPairs("罗湖区","SZ_01_LH"),
				new KeyPairs("南山区","SZ_01_NS"),
				new KeyPairs("盐田区","SZ_01_YT"),
				new KeyPairs("宝安区","SZ_01_BA"),
				new KeyPairs("龙岗区","SZ_01_LG"),
				new KeyPairs("光明新区","SZ_01_GMX"),
				new KeyPairs("龙华新区","SZ_01_LHX"),
				new KeyPairs("坪山新区","SZ_01_PSX"),
				new KeyPairs("大鹏新区","SZ_01_DPX")
		
		});
		CITY_MAP.put("HZ_01", new KeyPairs[]{
				new KeyPairs("西湖区","HZ_01_BG"),
				new KeyPairs("上城区","HZ_01_SC"),
				new KeyPairs("下城区","HZ_01_XC"),
				new KeyPairs("拱墅区","HZ_01_GS"),
				new KeyPairs("江干区","HZ_01_JG"),
				new KeyPairs("萧山区","HZ_01_XS"),
				new KeyPairs("滨江区","HZ_01_BJ"),
				new KeyPairs("余杭区","HZ_01_YH")
		});
		CITY_MAP.put("QT_01", new KeyPairs[]{new KeyPairs("其他","QT_01")});
	}
	
	
	/**
	 * 获取省份下面的城市
	 * @param provicesCode
	 * @return
	 */
	public static final List<KeyPairs> getCitys(String provicesCode){
		KeyPairs[] keyPairs=CITY_MAP.get(provicesCode);
		if(keyPairs==null){
			return new ArrayList<KeyPairs>(0);
		}
		List<KeyPairs> kpList=new ArrayList<KeyPairs>(keyPairs.length);
		int length=keyPairs.length;
		for(int i=0;i<length;i++){
			kpList.add(keyPairs[i]);
		}
		return kpList;
	}
	
	/**
	 * 查询准确的类型
	 * @param provicesCode
	 * @param cityCode
	 * @return
	 */
	public static final KeyPairs getCitysByCode(String provicesCode,String cityCode){
		if(StringUtils.isEmpty(cityCode)){
			 return ContantsUtils.EMPTY_KEY_PAIRS;
		 }
		KeyPairs[] keyPairs=CITY_MAP.get(provicesCode);
		if(keyPairs==null){
			return ContantsUtils.EMPTY_KEY_PAIRS;
		}
		int size=keyPairs.length;
		for(int i=0;i<size;i++){
			if(keyPairs[i].getValue().equals(cityCode)){
				return keyPairs[i];
			}
		}
		return ContantsUtils.EMPTY_KEY_PAIRS;
	}
	
	
	
	
	private static List<KeyPairs> PERSON_NUMBER_COUNT_CODE=new ArrayList<KeyPairs>(7);
	static{
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("10人以下", "PERSON_COUNT_0_10"));
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("10-60人", "PERSON_COUNT_10_30"));
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("60-100人", "PERSON_COUNT_60_100"));
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("100-200人", "PERSON_COUNT_100_200"));
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("200-300人", "PERSON_COUNT_200_300"));
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("300-500人", "PERSON_COUNT_300_500"));
		PERSON_NUMBER_COUNT_CODE.add(new KeyPairs("500人以上", "PERSON_COUNT_ABOVE_500"));
		PERSON_NUMBER_COUNT_CODE=Collections.unmodifiableList(PERSON_NUMBER_COUNT_CODE);
	}
	/** 
	 * 人数范围
	 */
	public  static final List<KeyPairs> getPersonNumberCounts(){
		return PERSON_NUMBER_COUNT_CODE;
	}
	
	public  static final KeyPairs getPersonNumberCountsByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,1);
	}
	
	
	
	private static List<KeyPairs> MEET_TYPE=new ArrayList<KeyPairs>(10);
	static{
		MEET_TYPE.add(new KeyPairs("公司年会", "GONGSHI_MEET"));
		MEET_TYPE.add(new KeyPairs("培训/讲座", "TRAIN_MEET"));
		MEET_TYPE.add(new KeyPairs("工作会/总结会", "WORKING_MEET"));
		MEET_TYPE.add(new KeyPairs("研讨/交流/论坛", "JIAOLIU_MEET"));
		MEET_TYPE.add(new KeyPairs("同学会/好友聚会", "STUDENY_MEET"));
		MEET_TYPE.add(new KeyPairs("经销商会议/招商会/推介会", "ZHAOSHANG_MEET"));
		MEET_TYPE.add(new KeyPairs("答谢会", "DAXIE_MEET_01"));
		MEET_TYPE.add(new KeyPairs("团队建设/拓展/休闲会议", "XIUXIANG_MEET"));
		MEET_TYPE.add(new KeyPairs("发布会/颁奖/庆典", "FABU_MEET"));
		MEET_TYPE.add(new KeyPairs("沙龙", "SHALONG_MEET"));
		MEET_TYPE.add(new KeyPairs("其他", "OTHER_MEET"));
		MEET_TYPE=Collections.unmodifiableList(MEET_TYPE);
	}
	
	/**
	 * 会议类型
	 */
	public static List<KeyPairs> getMeetTypes(){
		return MEET_TYPE;
	}
	
	public static KeyPairs getMeetTypesByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,2);
	}
	
	
	private static List<KeyPairs> MEET_TIME=new ArrayList<KeyPairs>(10);
	static{
		MEET_TIME.add(new KeyPairs("一晚", "YIWANG"));
		MEET_TIME.add(new KeyPairs("半天", "HALF_DAY"));
		MEET_TIME.add(new KeyPairs("一天", "ONE_DAY"));
		MEET_TIME.add(new KeyPairs("两天", "TWO_DAY"));
		MEET_TIME.add(new KeyPairs("3-4天", "THREE_FOUR_DAY"));
		MEET_TIME.add(new KeyPairs("5-7天", "FIVE_SEVEN_DAY"));
		MEET_TIME.add(new KeyPairs("7-14天", "SEVEN_FOURTEEN_DAY"));
		MEET_TIME.add(new KeyPairs("14天以上", "ABOVE_FOURTEEN_DAY"));
		MEET_TIME=Collections.unmodifiableList(MEET_TIME);
	}
	
	/**
	 * 
	 * 会议时长
	 */
	public final static List<KeyPairs> getMeetTimes(){
		return MEET_TIME;
	}
	
	public final static KeyPairs getMeetTimesByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,3);
	}
	
	
	
	private static List<KeyPairs> HOTEL_LEVEL=new ArrayList<KeyPairs>(10); 
	static{
		HOTEL_LEVEL.add(new KeyPairs("三星级","HOTEL_LEVEL_3"));
		HOTEL_LEVEL.add(new KeyPairs("四星级","HOTEL_LEVEL_4"));
		HOTEL_LEVEL.add(new KeyPairs("五星级","HOTEL_LEVEL_5"));
		HOTEL_LEVEL.add(new KeyPairs("五星级以上","HOTEL_LEVEL_ABOVE_5"));
		HOTEL_LEVEL=Collections.unmodifiableList(HOTEL_LEVEL);
	}
	
	/**
	 * 酒店星级
	 */
	public final static List<KeyPairs> getHotelLevels(){
		return HOTEL_LEVEL;
	}
	
	public final static KeyPairs getHotelLevelsByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,4);
	}
	
	
	private static List<KeyPairs> BUDGET_LEVEL=new ArrayList<KeyPairs>(10); 
	static{
		BUDGET_LEVEL.add(new KeyPairs("3000以下","BUDGET_LEVEL_LESS_3"));
		BUDGET_LEVEL.add(new KeyPairs("3-5千","BUDGET_LEVEL_LESS_3_5"));
		BUDGET_LEVEL.add(new KeyPairs("5-8千","BUDGET_LEVEL_LESS_5_8"));
		BUDGET_LEVEL.add(new KeyPairs("8千-1.2万","BUDGET_LEVEL_LESS_8_12"));
		BUDGET_LEVEL.add(new KeyPairs("1.2-1.5万","BUDGET_LEVEL_LESS_12_15"));
		BUDGET_LEVEL.add(new KeyPairs("1.5-2万","BUDGET_LEVEL_LESS_15_20"));
		BUDGET_LEVEL.add(new KeyPairs("2-3万","BUDGET_LEVEL_LESS_20_30"));
		BUDGET_LEVEL.add(new KeyPairs("3-5万","BUDGET_LEVEL_LESS_30_50"));
		BUDGET_LEVEL.add(new KeyPairs("5-8万","BUDGET_LEVEL_LESS_50_80"));
		BUDGET_LEVEL.add(new KeyPairs("8-12万","BUDGET_LEVEL_LESS_80_120"));
		BUDGET_LEVEL.add(new KeyPairs("12-20万","BUDGET_LEVEL_LESS_120_200"));
		BUDGET_LEVEL.add(new KeyPairs("20-30万","BUDGET_LEVEL_LESS_200_300"));
		BUDGET_LEVEL.add(new KeyPairs("30万以上","BUDGET_LEVEL_LESS_ABOVE_300"));
		BUDGET_LEVEL=Collections.unmodifiableList(BUDGET_LEVEL);
	}
	
	
	/**
	 * 会议预算
	 */
	public static final List<KeyPairs> getDudgetLevels(){
		return BUDGET_LEVEL;
		
	}
	
	public static final KeyPairs getDudgetLevelsByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,5);
	}
	
	
	
	private static List<KeyPairs> GOOD_ITYPE=new ArrayList<KeyPairs>(10);
	static{
		GOOD_ITYPE.add(new KeyPairs("首页","INDEX"));
		GOOD_ITYPE.add(new KeyPairs("特惠场地","TH"));
		GOOD_ITYPE.add(new KeyPairs("特惠客房","ROOM"));
		GOOD_ITYPE=Collections.unmodifiableList(GOOD_ITYPE);
	}
	

	
	
	
	/**
	 * 商品栏目类别
	 * @return
	 */
	public final static List<KeyPairs> getGoodType(){
		return GOOD_ITYPE;
	}
	
	
	public final KeyPairs getGoodTypeByCode(String code){
		return getKeyPairsByCode(code,6);
	}
	
	
	private static List<KeyPairs> PERSON_RANG=new ArrayList<KeyPairs>(10);
	static{
		PERSON_RANG.add(new KeyPairs("10人以下", "RANG_1_10"));
		PERSON_RANG.add(new KeyPairs("10-30人", "RANG_10_30"));
		PERSON_RANG.add(new KeyPairs("60-100人", "RANG_60_100"));
		PERSON_RANG.add(new KeyPairs("100-200人", "RANG_100_200"));
		PERSON_RANG.add(new KeyPairs("200-300人", "RANG_200_300"));
		PERSON_RANG.add(new KeyPairs("300-500人", "RANG_300_500"));
		PERSON_RANG.add(new KeyPairs("500人以上", "RANG_500_+"));
		PERSON_RANG=Collections.unmodifiableList(PERSON_RANG);
	}
	
	/** 
	 * 商品人数范围
	 */
	public  static final List<KeyPairs> getPersonRang(){
		return PERSON_RANG;
	}
	
	public  static final KeyPairs getPersonRangByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,7);
	}
	
	private static List<KeyPairs> IMAGE_LOCATION=new ArrayList<KeyPairs>(10);
	static{
		IMAGE_LOCATION.add(new KeyPairs("首页", "INDEX_01"));
		IMAGE_LOCATION.add(new KeyPairs("详情", "DETAIL_01"));
		IMAGE_LOCATION=Collections.unmodifiableList(IMAGE_LOCATION);
	}
	
	/**
	 * 图片位置
	 * @return
	 */
	public static final List<KeyPairs> getImageLocation(){
		return IMAGE_LOCATION;
	}
	
	public static final KeyPairs getImageLocationByCode(String code){
		return ContantsUtils.getKeyPairsByCode(code,8);
	}
	
	
	
	/**
	 * 支付订单编号
	 * @param userId
	 * @return
	 */
	public final static String getPayOrderNumber(int userId){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String strDate = sdf.format(new Date());
		StringBuilder builder=new StringBuilder();
		builder.append(strDate);
		//补充数据
		if(userId<10){
			builder.append("00000");
			builder.append(userId);
		}else if(userId<100){
			builder.append("0000");
			builder.append(userId);
		}else if(userId<1000){
			builder.append("000");
			builder.append(userId);
		}else if(userId<10000){
			builder.append("00");
			builder.append(userId);
		}else if(userId<100000){
			builder.append("0");
			builder.append(userId);
		}else{
			builder.append(userId);
		}
		return builder.toString();
	}
	
	
	
	/**
	 * 通过编码和类型查找数据
	 * @param code
	 * @param type
	 * @return
	 */
	private static final KeyPairs getKeyPairsByCode(String code,int type){
       if(StringUtils.isEmpty(code)){
    	   return ContantsUtils.EMPTY_KEY_PAIRS;
       }
		List<KeyPairs> kpList=null;
		switch(type){
		   case 0:kpList=PROVICE_LIST;break;
		   case 1:kpList=PERSON_NUMBER_COUNT_CODE;break;
		   case 2:kpList=MEET_TYPE;break;
		   case 3:kpList=MEET_TIME;break;
		   case 4:kpList=HOTEL_LEVEL;break;
		   case 5:kpList=BUDGET_LEVEL;break;
		   case 6:kpList=GOOD_ITYPE;break;
		   case 7:kpList=PERSON_RANG;break;
		   case 8:kpList=IMAGE_LOCATION;break;
		   
		}
		if (kpList == null) {
			return ContantsUtils.EMPTY_KEY_PAIRS;
		}
		int size = kpList.size();
		for (int i = 0; i < size; i++) {
			KeyPairs kp = kpList.get(i);
			if (kp.getValue().equals(code)) {
				return kp;
			}
		}
		return ContantsUtils.EMPTY_KEY_PAIRS;
	}
	
	
	
	/**
	 * 判断填写的是手机号码
	 * @return
	 */
	private static final String MOBILE_REG="^((\\+86)|(86))?(1[3|4|5|7|8|9][0-9]{9})$";
	public static final  boolean isMobileTel(String str){
		Pattern pattern = Pattern.compile(ContantsUtils.MOBILE_REG);
		Matcher matcher = pattern.matcher(str);
        return matcher.find();
	}
	
	/**
	 * 判断是否是固定电话
	 * @param str
	 * @return
	 */
	private static final String FIXED_REG="^(\\d{3,4}-)?\\d{7,8}$";
	public static final boolean isFixedTel(String str){
		Pattern pattern = Pattern.compile(ContantsUtils.FIXED_REG);
		Matcher matcher = pattern.matcher(str);
        return matcher.find();
	}
	
	
	/**
	 * 验证手机号码
	 * @param email
	 * @return
	 */
	public static final boolean isFiexedEmail(String email){
		if (StringUtils.isEmpty(email)) {
			return false;
		}
		int index = email.lastIndexOf('@');
		int length = email.length();
		if (index == length - 1) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 获取一个月的天数
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth(int year,int month){
		switch (month) {
		case Calendar.JANUARY:
			return 31;
		case Calendar.FEBRUARY:
			if (year % 4 == 0 && year % 100 != 0) {
				return 29;
			} else {
				return 28;
			}
       case Calendar.MARCH:
			return 31;
		case Calendar.APRIL:
			return 30;
		case Calendar.MAY:
			return 31;
		case Calendar.JUNE:
			return 30;
		case Calendar.JULY:
			return 31;
		case Calendar.AUGUST:
			return 31;
		case Calendar.SEPTEMBER:
			return 30;
		case Calendar.OCTOBER:
			return 31;
		case Calendar.NOVEMBER:
			return 30;
		case Calendar.DECEMBER:
			return 31;
		}
		throw new RuntimeException("传入的月不在[0-11]之间");
	}
	
	
	/**
	 * 整形格式化
	 * @param numbers
	 * @return
	 */
	public final static String formatLongNumberUtil(long number){
		 DecimalFormat df = new DecimalFormat("###.##");
		 return df.format(number);
	}
	
	public final static String formatTwoDoubleNumberUtil(double number){
		 DecimalFormat df = new DecimalFormat("###.#");
		 return df.format(number);
	}
	
	/**
	 * 格式化DOUBLE
	 * @param number
	 * @return
	 */
	public final static  String formatDoubleNumberUtil(double number){
		 DecimalFormat df = new DecimalFormat("###,###,###,###,###.##");
		 return df.format(number);
	}
	
	//private static final String[] BUSSINESS_USER=new String[]{"18101328228","15011379921"};
	private static final String[] BUSSINESS_USER=new String[]{"13810801413"};
	public static final String[] getBussinessUser(){
		return BUSSINESS_USER;
	}
	//微信OPEN ID
	private static final String[] WEIXIN_OPENID={"oiq2gjh-3I6sZNxQSsOvG9nova7A"};
	//private static final String[] WEIXIN_OPENID={"oiq2gjvqRzWhq7QFWiDOSSuGBVis"};
	public static final String[] getWeiXinOpenId() {

		return WEIXIN_OPENID;

	}
	
	
	private static final String[] MAIL_BUSSINESS_USER=new String[]{"zzx@cdh100.com","service@cdh100.com"};
	//private static final String[] MAIL_BUSSINESS_USER=new String[]{"zhangming@cdh100.com"};
	public static final String[] getMailBussinessUser(){
		return MAIL_BUSSINESS_USER;
	}
	 
	public static void main(String[]args){
		//System.out.println(ContantsUtils.getPayOrderNumber(897));
		System.out.println(ContantsUtils.isFiexedEmail("8sdskl@"));
	}
	
}
