package com.lanqiao.reflection;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 任务二实现;
 * 利用第三方包下 Commons包下的 BeanUtils 简易实现 把Map中的键和值 按键值对方式填充到object
 * @author 燕
 *
 */
public class ReflectMap2 {
	  public static <T> T map2Bean(Map<String, String> map, Class<T> claz) throws Exception{
		    T obj = claz.newInstance();    //新建一个传入类的对象
		    
		    for (Entry<String, String> entry : map.entrySet()) {    //遍历map键值对
		      String key = entry.getKey();               //取map的键
		      String value = entry.getValue();          //取map的值
		      BeanUtils.copyProperty(obj, key, value);      //把map的键和map的值填充到对象 obj中;key为将要设置的对象的属性名； value为将要设置的对象的属性值
		    }
		    
		    return obj;
		  }

}
