package org.lanqiao.genericity;

import java.util.ArrayList;

/**
 * 功能：泛型只在编译阶段有效
 * @author 燕
 *
 */
public class GenericityCompile {
	public static void main(String args[]){
	ArrayList<String> a=new ArrayList<String>(); //a为一个只能存放String类型元素的集合
	ArrayList b=new ArrayList(); //b为一个可以存放Object对象的集合
	Class c1=a.getClass();
	Class c2=b.getClass();
	System.out.println("a和b是否是同一个对象："+(a==b));
	/**
	 * 结果c1和c2都是获取得到的class java.util.ArrayList类，因为编译之后，程序会采取去泛型化的措施，
	 * ，成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。
	 */
	System.out.println("c和d是否是同一个类："+(c1==c2));
	System.out.println(c1);
	}	
}
