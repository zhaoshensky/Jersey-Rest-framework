package com.sdc.utils;

import java.lang.annotation.*;
/**
 * @ClassName: Token
 * @Description: TODO
 * @author Comsys-earl
 * @date 2016年6月2日 上午9:42:39
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) 
public @interface Token
{
//	 boolean needSaveToken () default false ;  	 
//	 boolean needRemoveToken () default false ;
	
	 boolean Save () default false ;  	 
	 boolean Remove() default false ;
}
