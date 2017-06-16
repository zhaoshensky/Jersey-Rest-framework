package com.sdc.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class Strupper
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Strupper.class);

	/***
	 * 转换手写字母为大写
	 * @param sA
	 * @return
	 */
	public static String Stringuper(String sA)
	{
		String stra=sA;	
		String strcase=null;	
		stra=sA.substring(0,1).toUpperCase();
		String stra1=sA.substring(1);		
		strcase=stra+stra1;
		logger.info("城市首字母转换大写:"+stra);	
		return strcase;
	}
	/** 
	  * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回 
	  * @param sourceDate 
	  * @param formatLength 
	  * @return 重组后的数据 
	  */  
	 public static String frontCompWithZore(int sourceDate,int formatLength)  
	 {  
	  // 0 指前面补充零 formatLength 字符总长度为 formatLength  d 代表为正数。 
		 String newString = String.format("%0"+formatLength+"d", sourceDate); 
		 logger.info("固定位数左不零:"+newString);	
	  return  newString;  
	 } 
	 /**
	  * long类型长度
	  * @param sourceDate
	  * @param formatLength
	  * @return
	  */
	 public static String frontCompWithZore(long sourceDate,int formatLength)  
	 {  
	  // 0 指前面补充零 formatLength 字符总长度为 formatLength  d 代表为正数。 
		 String newString = String.format("%0"+formatLength+"d", sourceDate); 
		 logger.info("固定位数左不零:"+newString);	
	  return  newString;  
	 }  
	 public static String leftzoe(int datalegth,String stdata)
	 {
		String sdate="";
		if(datalegth !=0 || !"".equals(stdata) )
		{
			int length=stdata.toString().length();
	        for(int i=0;i<datalegth-length;i++)
	        {
	        	sdate+="0";
	        }
	        sdate=sdate+stdata;
		}
		logger.info("@@@左补零:"+sdate);	
		return sdate;	 
	 }
	 
	 /**
	  * 判断文件夹是否存在，不存在创建文件夹
	  * @param strfile
	  * @return
	  */
	 public static boolean mkdirb(String strfile)
	{
			boolean str=false;
			if(null !=strfile)
			{
				File file =new File(strfile); //如果文件夹不存在则创建  
				if  (!file .exists()  && !file .isDirectory())    
				{     
				   // System.out.println("//不存在");
				    file.mkdir(); 
				    str=true;
				} else 
				{
				   // System.out.println("//目录存在");
				    str=false;
				}	
			}else  str=false;		
			return str;
		}
	 /***
	  * 
	  * @param sindexof
	  * @param leght
	  * @return
	  */
	 public static String Sindexof(String sindexof,int leght)
	{
		String str=null;
		if(leght >0 && leght !=0)
		{
			int indexof=sindexof.indexOf("=");
			if(indexof >= 0)
				str=sindexof.substring(indexof);	
			else	//str=sindexof.substring(indexof+1);
				str="";
		}
		return str;	
	}
	 /**
	  * 数据截取字符类型
	  * @param count
	  * @param strcom
	  * @param leght
	  * @return
	  */
  public static int ssplit(int count,String strcom,int leght)
	{
		String str=null;
		if(leght >=0 && leght != 0)
		{
			String[] s = strcom.split("-");
			for (int i = 0; i < s.length; i++)
			{
				str=s[count];
				logger.info("获取相关字符串字段 sRole:"+str);
			}
		}
		return Integer.parseInt(str);	
	}
  
   /**
    * 实际参数时间
    * @param ssmmdd
    * @param leght
    * @return
    */
  	public static int iminute(String ssmmdd,int leght,int sminute,int ihourofday)
	{
  		int ireStr=0;
		try {
			if(leght !=0 && leght >=8)
			{			
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");	       
		        Date dt=sdf.parse(ssmmdd);
		       // System.out.println("xxxxx :"+dt);
		        Calendar rightNow = Calendar.getInstance();
		        rightNow.setTime(dt);			        
		        rightNow.add(Calendar.MINUTE,sminute);
		        Date dt1=rightNow.getTime();
		       // String reStr = sdf.format(dt1).substring(3,5);
		        //System.out.println("!!!"+reStr);
		        ireStr=Integer.parseInt(sdf.format(dt1).substring(3,5));
		       logger.info("预计最终时间 :"+ireStr);
		       // System.out.println("有效30分钟时间 :"+ireStr);
		       
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ireStr;
	}
  	
  	/**
  	 *系统时间
  	 * @return
  	 */
  	public static int systemminute()
	{
		int isystem=0;
		try {
		 	Date now = new Date(); 
	       // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		 	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");//可以方便地修改日期格式 
	        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
	        c.setTime(now);
	        Date dt1=c.getTime();
	        String reStr = dateFormat.format(dt1).substring(3,5);
	        //System.out.println("系统 时间 22 :"+dateFormat.format(dt1));
	        isystem=Integer.parseInt(reStr);
	        //System.out.println("xx22 :"+isystem);
	        
//	        int year = c.get(Calendar.YEAR); 
//	        int month = c.get(Calendar.MONTH); 
//	        int date = c.get(Calendar.DATE); 
//	        int hour = c.get(Calendar.HOUR_OF_DAY); 
//	        int minute = c.get(Calendar.MINUTE); 
//	        int second = c.get(Calendar.SECOND); 
//	        System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second); 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return isystem;
			
	}
  	
  	 public static String addDateMinut(String day, int x)//返回的是字符串型的时间，输入的
	 {   
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制  
	        Date date = null;   
	        try {   
	            date = format.parse(day);   
	        } catch (Exception ex) {   
	            ex.printStackTrace();   
	        }   
	        if (date == null)   
	            return "";   
	        // System.out.println("front:" + format.format(date)); //显示输入的日期  
	        Calendar cal = Calendar.getInstance();   
	        cal.setTime(date);   
	        cal.add(Calendar.MINUTE, x);// 24小时制   
	        date = cal.getTime();   
	      //  System.out.println("after:" + format.format(date));  //显示更新后的日期 
	        cal = null;   
	        return format.format(date);   
	    }
	
  	public static String systemtime()
  	{
  		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获取时间格式化工具
  		String sdate = sFormat.format(System.currentTimeMillis());
  		return sdate;
  	}
  	
  	 public static int timeCompare(String t1,String t2)
  	 {  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Calendar c1=Calendar.getInstance();  
        Calendar c2=Calendar.getInstance();  
        try {  
            c1.setTime(formatter.parse(t1));  
            c2.setTime(formatter.parse(t2));  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } 
        int result=c1.compareTo(c2);  
        return result;  
	  }  
}
