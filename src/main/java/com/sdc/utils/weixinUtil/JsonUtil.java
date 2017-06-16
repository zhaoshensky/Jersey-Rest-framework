package com.sdc.utils.weixinUtil;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * 
 * @author user
 *
 */
public class JsonUtil {

	private static Gson gson = null;
	private static GsonBuilder gb ;

	static {
		if (null==gson) {
			gson = new Gson();
		}
		if(null==gb){
			gb =new GsonBuilder();
			gb.disableHtmlEscaping();
		}
		
	}

	private JsonUtil() {

	}
	
	
	/**
	 * 将对象转换成json格式
	 * 
	 * @param ts
	 * @return
	 */
	public static String objectToJson(Object ts) {
		String jsonStr = null;
		if (gson != null) {
			jsonStr = gson.toJson(ts);
			
		}
		return jsonStr;
	}

	/**
	 * 将对象转换成json格式
	 * 
	 * @param ts
	 * @return
	 */
	public static String objectToJson(Object ts,Type type) {
		String jsonStr = null;
		if (gson != null) {
			jsonStr = gson.toJson(ts, type);
			
		}
		return jsonStr;
	}

	

	/**
	 * 将json转换成bean对象
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Object jsonToObject(String jsonStr,Type type) {
		Object obj = null;
		if (gson != null) {
			obj = gson.fromJson(jsonStr,type);
		}
		return obj;
	}
	
	
	/**
	 * 将json转换成bean对象
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Object jsonToObject(String jsonStr, Class<?> cl) {
		Object obj = null;
		if (gson != null) {
			obj = gson.fromJson(jsonStr, cl);
			
		}
		return obj;
	}
	
	/**
	 * 将json转换成bean对象
	 * 
	 * @param jsonStr
	 * @param cl
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBeanDateSerializer(String jsonStr, Class<T> cl,
			final String pattern) {
		Object obj = null;
		gson = new GsonBuilder().registerTypeAdapter(Date.class,
				new JsonDeserializer<Date>() {
					public Date deserialize(JsonElement json, Type typeOfT,
							JsonDeserializationContext context)
							throws JsonParseException {
						SimpleDateFormat format = new SimpleDateFormat(pattern);
						String dateStr = json.getAsString();
						try {
							return format.parse(dateStr);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						return null;
					}
				}).setDateFormat(pattern).create();
		if (gson != null) {
			obj = gson.fromJson(jsonStr, cl);
		}
		return (T) obj;
	}
   
	
	/**
	 * 将对象转换成json格式
	 * 
	 * @param ts
	 * @return
	 */
	public static String objectToJsonByGsonBuilder(Object ts) {
		String jsonStr = null;
		jsonStr = gb.create().toJson(ts);
		return jsonStr;
	}
	

	
}
