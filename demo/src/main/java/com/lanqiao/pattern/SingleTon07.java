package com.lanqiao.pattern;
/**
 * 功能：静态内部类      单例模式
 * @author 燕
 *
 */

public class SingleTon07 {
	private  static class SinggleTonHolder{
		private final static SingleTon07 single=new SingleTon07();
	}
	private SingleTon07(){}
	/**
	 * 说明：因为SinggleTonHolder内部类私有的，只有调用getInstance()方法，才会真正被创建。
	 * @return
	 */
	public static SingleTon07 getInstance(){
		return SinggleTonHolder.single;
	}
}
