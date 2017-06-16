package com.sdc.system.spring.redis.cache.key;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import com.sdc.utils.BaseMapper;
import com.sdc.utils.ReflectUtil;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月16日
* @Company: ediankai
*/
/**
 * Spring cache key 生成策略
 * 类名+方法名+参数信息
 * 如果key的hashCode与equals一致,认为是同一个Key
 * 如果传入对象是BaseModel,那么便利它所有的一级属性,如果所有一级属性的hashCode一致,
 * 则认为Key相同
 * @author lisuo
 */
public class MyCacheKey  implements Serializable{


	/**
	* <p>Description: </p>
	* <p>Company: diankai</p>
	* @author today
	* @date 2016年12月17日
	*/
	private static final long serialVersionUID = -268857070365741656L;
	/** 调用目标对象全类名 */
	private String targetClassName;
	/** 调用目标方法名称 */
	private String methodName;
	/** 调用目标参数 */
	private Object[] params;
	
	private int hashCode;
	
//	private String values;
	
	private static final Logger logger = Logger.getLogger(MyCacheKey.class);

	
	/**
	 * @return the methodName
	 */
	public Map keyHash() {
		
		Map map = null;
		
		if( this.params != null ){
//			logger.error(StringUtils.join(this.params, ","));
			map = new HashMap();
			map.put("methodName", methodName);
			map.put("params", StringUtils.join(this.params, ","));
		
		}
		
		return map;
	}
	
	
	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		if( this.params != null ){
//			logger.error(StringUtils.join(this.params, ","));
			return methodName+":" + StringUtils.join(this.params, ",");
		}else{
			return null;
		}
	}

	public MyCacheKey(Object target, Method method, Object[] elements) {
		/*	logger.info(target.toString());
			logger.info(method.toString());
			logger.info(elements.toString());*/
			this.targetClassName = target.getClass().getName();
			this.methodName = generatorMethodName(method);
			
//			if(ArrayUtils.isNotEmpty(elements)){
			try{
				this.params = new Object[elements.length];
				for(int i =0;i<elements.length;i++){
					Object ele = elements[i];
					if(ele instanceof BaseMapper){
						this.params[i] = ReflectUtil.beanToMap(ele);
					}else{
						this.params[i] = ele;
					}
				}
//			}else{
				
			}catch (Exception e) {
				logger.error("不允许传入为空的缓存！！！！！！！");
				this.params = null;
			}
			
//			this.values = generatorHashCode();

		}
	
//	public MyCacheKey(Object target, Method method, Object[] elements) {
//	/*	logger.info(target.toString());
//		logger.info(method.toString());
//		logger.info(elements.toString());*/
//		this.targetClassName = target.getClass().getName();
//		this.methodName = generatorMethodName(method);
//		
//		if(ArrayUtils.isNotEmpty(elements)){
//			this.params = new Object[elements.length];
//			for(int i =0;i<elements.length;i++){
//				Object ele = elements[i];
//				if(ele instanceof BaseMapper){
//					this.params[i] = ReflectUtil.beanToMap(ele);
//				}else{
//					this.params[i] = ele;
//				}
//			}
//		}
//		this.hashCode = generatorHashCode();
//
//	}
	
	private String generatorMethodName(Method method){
		StringBuilder builder = new StringBuilder(method.getName());
		Class<?>[] types = method.getParameterTypes();
		/*if(ArrayUtils.isNotEmpty(types)){
			builder.append("(");
			for(Class<?> type:types){
				String name = type.getName();
				builder.append(name+",");
			}
			builder.append(")");
		}*/
		return builder.toString();
	}

	//生成hashCode
	private int generatorHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hashCode;
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		result = prime * result + Arrays.hashCode(params);
		result = prime * result + ((targetClassName == null) ? 0 : targetClassName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyCacheKey other = (MyCacheKey) obj;
		if (hashCode != other.hashCode)
			return false;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		if (!Arrays.equals(params, other.params))
			return false;
		if (targetClassName == null) {
			if (other.targetClassName != null)
				return false;
		} else if (!targetClassName.equals(other.targetClassName))
			return false;
		return true;
	}
	
	@Override
	public final int hashCode() {
		return hashCode;
	}
	
	
	

}