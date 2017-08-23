package com.lanqiao.pattern;
/**
 * 
 * @author 燕
 *功能：单例模式之饿汉模式
 */
public class SingleTon06 {
	//在加载此类事就可以实例化，切只可以实例化一次
	private final static SingleTon06 single=new SingleTon06();
	SingleTon06(){}
	public static SingleTon06 getInstance(){
		return single;
	}
}
