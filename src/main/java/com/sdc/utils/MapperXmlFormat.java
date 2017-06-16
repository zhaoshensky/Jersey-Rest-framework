package com.sdc.utils;

import java.io.*;

/**
 * Created by Administrator on 2016/12/30.
 */
public class MapperXmlFormat {

    public static void main(String[] args) {

        String originString = "Integer type,Integer coupon_activity_id, Date begin_at,Date end_at,Integer use_stores,String remark,String store_ids";
        paramsFormat(originString,2);
    }

    public static void PropertyFormat(String inputFile, String outputFile, String tableNickName) {
        //读文件
        File file = new File("C:\\Users\\Administrator\\Desktop\\" + inputFile);
        //写文件
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\" + outputFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempReader = "";
            int line = 1;
            //按行读文件
            while ((tempReader = reader.readLine()) != null) {
                //获取这一行的column的属性
                if (tempReader.contains("column=\"")) {
                    //获取到属性
                    String add = tempReader.substring(tempReader.indexOf("column=\""), tempReader.indexOf("\" jdbcType")).replace("column=\"", "");
                    //重命名属性 name_  是你表的别名
                    String reName = tableNickName + add;
                    tempReader = tempReader.replace(add, reName);
                    //重新写字符串
                    add = "property=\"" + add + "\"";
                    tempReader = tempReader.replace("\" jdbcType", "\" " + add + " jdbcType").replace("<arg", "<result");
                }
                fileWriter.write(tempReader + "\r\n");
                line++;
            }
            //写进文件
            fileWriter.flush();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给属性加上表别名 table.id  加别名 table_id
     *
     * @param originString
     * @param tableNickName
     */
    public static void TableStringFormat(String originString, String tableNickName) {
        originString = originString.replace(" ", "");
        String[] split = originString.split(",");
        //输出字符串
        String outString = "";
        for (int i = 0; i < split.length; i++) {
            outString += tableNickName + "." + split[i] + " " + tableNickName + "_" + split[i];
            if (i != split.length - 1) {
                outString += ",";
            }
        }
        System.out.println(outString);
    }

    /**
     * @param params
     * @param type   原来的格式Long supplierId
     *               0 转成@FormParam("supplierId") Long supplierId格式
     *               1 转成@Param("supplierId") Long supplierId
     *               2 转成supplierId
     *               3 转成<if test='supplierId!=null'> ,supplierId=#{supplierId}</if>
     *               4 转成<if test='supplierId!=null'> and supplierId=#{supplierId}</if>
     *               5 转成@QueryParam("supplierId") Long supplierId
     */
    public static void paramsFormat(String params, int type) {
        String[] split = params.split(",");
        String String0 = "";
        String String1 = "";
        String String2 = "";
        String String3 = "";
        String String4 = "";
        String String5="";
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].trim().split(" ");
            String0 += " @FormParam(\"" + split1[1] + "\") " + split[i] + ",";
            String1 += " @Param(\"" + split1[1] + "\") " + split[i] + ",";
            String2 += split1[1] + ",";
            String3 += "<if test='" + split1[1] + "!=null'>\r\n , " + split1[1] + "=#{" + split1[1] + "}\r\n" + "</if>\r\n";
            String4 += "<if test='" + split1[1] + "!=null'>\r\n and " + split1[1] + "=#{" + split1[1] + "}\r\n" + "</if>\r\n";
            String5 += " @QueryParam(\"" + split1[1] + "\") " + split[i] + ",";
        }
        if (type == 0) {
            System.out.println(String0.substring(0,String0.length()-1));
        }
        if (type == 1) {
            System.out.println(String1.substring(0,String1.length()-1));
        }
        if (type == 2) {
            System.out.println(String2.substring(0,String2.length()-1));
        }
        if (type == 3) {
            System.out.println(String3);
        }
        if (type == 4) {
            System.out.println(String4);
        }
        if(type==5){
            System.out.println(String5.substring(0,String5.length()-1));
        }
    }


}
