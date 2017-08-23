package com.lanqiao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注释
 * @author 燕
 *
 */
@Target(ElementType.METHOD)  //元注释：表示作用地
@Retention(RetentionPolicy.RUNTIME)  //元注释，表示作用时间
public @interface ShowDuration {
	  boolean value() default true;  //注释内方法 实际是 注释参数
}
