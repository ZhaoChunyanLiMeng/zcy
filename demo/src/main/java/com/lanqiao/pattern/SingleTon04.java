package com.lanqiao.pattern;

public class SingleTon04 {
	private static SingleTon04 singleton=null;
	SingleTon04(){}
	public static SingleTon04 getInstance(){
		if(singleton==null){ //如果实例创建了，就不需要同步了
			synchronized (SingleTon04.class) {//对多个线程进行同步
				if(singleton==null){//被同步的线程中有一个线程创建了对象，别的线程则不需再创建
				singleton=new SingleTon04();
				}
			}
			
		}
		return singleton;
	}
}
