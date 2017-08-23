package com.lanqiao.pattern;

public class SingleTon01 {
	private static SingleTon01 singleton=null;
	SingleTon01(){}
	public static SingleTon01 getInstance(){
		if(singleton==null){
			singleton=new SingleTon01();
		}
		return singleton;
	}
}
