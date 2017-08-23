package com.lanqiao.commons_beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import com.lanqiao.sql.jdbc.SimpleDataSource;

/**
 * BeanUtils工具的使用
 * 功能：BeanUtils主要是用于将对象的属性封装到对象中
 * @author 燕
 *
 */
public class TestBeanUtils {
	/**
	 * 自定义日期类型转换器
	 * 此方法目标：将字符串转换成日期格式
	 * @param type  目前需要转换的数据类型
	 * @param value  目前参数的值
	 * @return
	 * @throws NoSuchMethodException 
	 */
	public  static void main(String args[]) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		set();
	}
	
	private static void set() throws IllegalAccessException, InvocationTargetException{
		ConvertUtils.register(new convert(), Date.class);//Date.class表示要转换的成引用类型，Date类型不是基本数据类型，所以需要一个转换器进行相应的转换
		String id ="110";  //我们用这个三个String类型的属性代表从配置文件中读取到的数据，实际编程过程中这些数据直接从properties文件中读取
        String name = "朱君鹏";
        String salary = "1000";
        String birthday = "2015-01-30";  //该格式可以实现使用工具提供的转换器类将字符串正确的转换，
        Emp p = new Emp();  //读取到数据之后，对该对象的属性进行设置，使用BeanUtils工具可以避免强制类型的转换，但是在Emp类中的每个属性都要有getter和setter方法
        //因为BeanUtils工具实际上是对内省的封装，使其更加的好用，所以其底层还是依赖getter和setter方法
        
        BeanUtils.setProperty(p, "id", 1);  //其中p代表的是要设置的对象
        BeanUtils.setProperty(p, "name","zhangsan");//中间一个参数代表的是要设置的属性
        BeanUtils.setProperty(p, "salary", 3000.00); //第三个参数代表的属性的值
        BeanUtils.setProperty(p, "data",birthday);
        
        System.out.println(p);
	}
	
}
