package com.lanqiao.pattern;
/**
 * 功能：证明不能通过反射来创建枚举对象，
 * 所以这种单例模式可以抵御恶意客户端通过反射的攻击。
 * 此外，枚举类的单例模式也不必担心反序列化的时候多次创建实例。
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestEnumSingleTon {

	public static void main(String[] args)throws InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException  {
		 Constructor<?>[] array= EnumSingleTon.class.getDeclaredConstructors();  
         for (Constructor<?> c : array){  
             c.setAccessible(true);  
             //此处会抛出异常  
             c.newInstance();
		}  
	}

}
