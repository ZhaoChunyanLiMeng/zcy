package com.lanqiao.pattern;
/**
 * 双重检查锁定  双重检验锁
 * 这种写法考虑了线程安全，将对singleton的null判断以及new的部分使用synchronized进行加锁。
 * 同时，对singleton对象使用volatile关键字进行限制，保证其对所有线程的可见性，并且禁止对其进行指令重排序优化。
 * 在单例中new的情况非常少，绝大多数都是可以并行的读操作。因此在加锁前多进行一次null检查就可以减少绝大多数的加锁操作，执行效率提高的目的也就达到了
 * 注意：双重检查锁法，不能在jdk1.5之前使用，
 * 而在Android平台上使用就比较放心了，一般Android都是jdk1.6以上，不仅修正了volatile的语义问题，还加入了不少锁优化，使得多线程同步的开销降低不少
 * @author 燕
 *
 */
public class SingleTon05 {
	private static volatile SingleTon05 singleton=null;
	SingleTon05(){}
	public static SingleTon05 getInstance(){
		if(singleton==null){ //如果实例创建了，就不需要同步了
			synchronized (SingleTon05.class) {//对多个线程进行同步
				if(singleton==null){//被同步的线程中有一个线程创建了对象，别的线程则不需再创建
				singleton=new SingleTon05();
				}
			}
			
		}
		return singleton;
	}
}
