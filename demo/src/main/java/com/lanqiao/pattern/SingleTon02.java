package com.lanqiao.pattern;

public class SingleTon02 {
	private static SingleTon02 singleton=null;
	SingleTon02(){}
	public static SingleTon02 getInstance(){
		if(singleton==null){
			synchronized (SingleTon02.class) {//对多个线程进行同步 
				singleton=new SingleTon02();
			}
			
		}
		return singleton;
	}
}
