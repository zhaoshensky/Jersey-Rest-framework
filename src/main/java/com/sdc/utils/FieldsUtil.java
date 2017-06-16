package com.sdc.utils;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengxiang@ediankai.com on 2017/3/7.
 */
public class FieldsUtil {
    private static int ss;
    public int bbb;

    /**
     * 判断 Fields 是否合法  对应的表是否包含 fileds所有字段
     * @param classname 表名   例：类.class
     * @param fields 传入的参数 例：name,age,file    逗号分割
     * @return true 传入的类存在 且 类包含所有fileds中的字段
     */
    public static boolean containFields(Class classname,String fields){
        try {
            Class myclass = Class.forName(classname.getName());
            if (fields == null)
                return true;
            for (String s : fields.split(",")){
                myclass.getDeclaredField(s);
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchFieldException e){
            return false;
        } catch (SecurityException e){
            return false;
        }
    }

    public static List<String> findAllFields(Class clazz){
        List<Field> list = ReflectUtil.getFields(clazz);
        List<String> fields = new ArrayList<>(50);
        for (Field f:list
             ) {
            fields.add(f.getName());
        }
        return fields;
    }

    //针对 selectDynamicSingle 不能返回 null 值的解决办法
    public static void addIFNULL(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            list.set(i,"IFNULL(" + s + ",'') as " + s);
        }
    }

    public static void main(String[] args) {
//        boolean b = containFields(FieldsUtil.class,"ss,bbb");
//        System.out.println(b);

//        System.out.println(findAllFields(CoreSupplier.class));
    }
}
