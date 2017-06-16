package com.sdc.utils;

import java.text.DecimalFormat;

public class Usingareapriceid
{
	//=====面积等级===
	private static final double sUsingArea0=0;
	private static final double sUsingArea100=100;
	private static final double sUsingArea300=300;
	private static final double sUsingArea500=500;
	private static final double sUsingArea1000=1000;
//	private static final long sUsingArea_1000=1000;
	//=====租办公间等级===元/平米/天
	private static final double sPriceid0=0;
	private static final double sPriceid1=1;
	private static final double sPriceid2=2;
	private static final double sPriceid3=3;
	private static final double sPriceid5=5;
	private static final double sPriceid7=7;
	private static final double sPriceid10=10;
//	private static final long sPriceid_10=10;	
	private static final double sPriceid20=20;
	private static final double sPriceid30=30;
	private static final double sPriceid40=40;
	private static final double sPriceid50=50;
	private static final double sPriceid60=60;
	private static final double sPriceid70=70;
	private static final double sPriceid80=80;	
	private static final double sPriceid90=90;
	//租工位================单位*个
	private static final double sPriceid100=100;
	private static final double sPriceid200=200;
	private static final double sPriceid300=300;
	private static final double sPriceid500=500;
	private static final double sPriceid700=700;
	private static final double sPriceid900=900;
	private static final double sPriceid_1000=1000;
	//租==================元/月
	private static final double sPriceid_3000=3000;
	private static final double sPriceid_5000=5000;
	private static final double sPriceid_10000=10000;
	private static final double sPriceid_30000=30000;
	private static final double sPriceid_60000=60000;
	private static final double sPriceid_80000=80000;
	
	
	/**
	 * 面积范围区间
	 * @param sConstructionArea
	 * @return
	 */
	public static long SConstruction(String sConstructionArea)
	{
		long iuprice=0;		
		double lUsingAreaNumber=Double.parseDouble(sConstructionArea);		
		if(lUsingAreaNumber  >=sUsingArea0 && lUsingAreaNumber <= sUsingArea100)
		{
			 iuprice=1;
		}else if (lUsingAreaNumber >sUsingArea100 && lUsingAreaNumber <=sUsingArea300)
		{
			 iuprice=2;
		}			
		else if (lUsingAreaNumber >sUsingArea300 && lUsingAreaNumber <=sUsingArea500)
		{
			 iuprice=3;
		}else if (lUsingAreaNumber >sUsingArea500 && lUsingAreaNumber <=sUsingArea1000)
		{
			 iuprice=4;
		}else if(lUsingAreaNumber >sUsingArea1000)//sUsingArea_1000
		{
			 iuprice=5; //大于等于10000+
		}
		return iuprice;
	}
	/**
	 * 价格范围区间
	 * @param sRent
	 * @return
	 */
	public static long SRent(String sRent,int leasetype)
	{
		long iRent=0;
		double lPriceid=Double.parseDouble(sRent);
		if(leasetype == 0)//元/平米/天0
		{
			  if (lPriceid >sPriceid0 && lPriceid <= sPriceid3)  //0~3
				{
					 iRent=1;
				}else if (lPriceid > sPriceid3 && lPriceid <= sPriceid5) //3~5
				{
					 iRent=2;
				}else if (lPriceid > sPriceid5 && lPriceid <= sPriceid7) //5~7
				{
					 iRent=3;
				}else if (lPriceid > sPriceid7 && lPriceid <=sPriceid10) //7~10
				{
					 iRent=4;
				}else 
					 iRent=5;
		} 
		else  if(leasetype == 1)//元/位/月1
		{			
			   if(lPriceid > sPriceid0 && lPriceid <= sPriceid300)
				{
					 iRent=6;
				}else if(lPriceid > sPriceid300 && lPriceid <= sPriceid500)
				{
					 iRent=7;				
				}
				else if(lPriceid > sPriceid500 && lPriceid <= sPriceid700)
				{
					 iRent=8;
				}
				else if(lPriceid > sPriceid700 && lPriceid <= sPriceid_1000)
				{
					 iRent=9;			
				} 
				else
					 iRent=10; 
		}else //元/月 2
		{
			if(lPriceid > sPriceid0 && lPriceid <= sPriceid_5000)
			{
				 iRent=11;			 
			}else if(lPriceid > sPriceid_5000 && lPriceid <= sPriceid_10000)
			{
				 iRent=12;
			}else if(lPriceid > sPriceid_10000 && lPriceid <= sPriceid_30000)
			{
				 iRent=13;
			}else if(lPriceid > sPriceid_30000 && lPriceid <= sPriceid_60000)
			{
				 iRent=14;
			}else if(lPriceid > sPriceid_60000 && lPriceid <= sPriceid_80000)
			{
				 iRent=15;
			}else
				 iRent=16;
		}
		return iRent;
	}
	/**
	 * 面积*30.42*单价	
	 * @param sRent
	 * @param sUsableArea
	 * @return
	 */
	public static String PSRent(String sRent,String sUsableArea)
	{
		String sUsab="";
		if (sRent != null && sRent.length() >= 1) 
	    {
			sUsab = sRent.replaceAll(",", "");
			double	dsRent=Double.parseDouble(sUsab);
			double dUsableArea=Double.parseDouble(sUsableArea);
			DecimalFormat df = new DecimalFormat("######0.00"); 
			sUsab=df.format((dsRent*dUsableArea)*30.42);
	    }else 
	    	sUsab="";
		return sUsab;
	}
	/**
	 * 工位*价格
	 * @param sRent
	 * @param sUsableArea
	 * @return
	 */
	public static String PPos(String sRent,String sPosition)
	{	
		String sPos ="";
	    if (sRent != null && sRent.length() >= 1) 
	    {
	    	sPos = sRent.replaceAll(",", "");
	    	//System.out.println("formatStr:"+sPos);
	    	double	dsRent=Double.parseDouble(sPos);
			double dPosition=Double.parseDouble(sPosition);
			DecimalFormat df = new DecimalFormat("######0.00"); 			
			sPos=df.format(dsRent*dPosition);
	    }else
	    	sPos="";
		return sPos;	
	}
	/**
	 * 所有价格保留两位小数.00
	 * @param money
	 * @return
	 */
	public static String money(double money)
	{
		DecimalFormat  df = new DecimalFormat("###,###,###,##0.00");
		String sMoney = df.format(money);
		return sMoney;
	}
	
	public static String moneym(double money)
	{
		DecimalFormat  df = new DecimalFormat("###,###,###,##0");
		String sMoney = df.format(money);
		return sMoney;
	}
	
	/**
	 * 金额格式化
	 * @param s 金额
	 * @param len 小数位数
	 * @return 格式后的金额
	 */
	public static String delmoenyomma(String s,String sPosition) 
	{
	    String formatStr ="";
	    if (s != null && s.length() >= 1) 
	    {
	    	formatStr = s.replaceAll(",", "");	 
	    	formatStr=PSRent(formatStr,sPosition);
	    }	 
	    return formatStr;
	}
}
