package com.lanqiao.pattern;

public class SingleTon03 {
	private static SingleTon03 singleton=null;
	SingleTon03(){}
	public static SingleTon03 getInstance(){
	
			synchronized (SingleTon03.class) {//对多个线程进行同步
				if(singleton==null){
				singleton=new SingleTon03();
				}
			}
			
		
		return singleton;
	}
}
