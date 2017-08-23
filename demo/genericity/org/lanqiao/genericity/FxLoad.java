package org.lanqiao.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证泛型重载
 * 这样重载是错误的，如下是错误的
 * void apply(List<Object> list){}
 * void apply(List<?> list){}
 * @author 燕
 *
 */
public class FxLoad {
	
	/*void apply(List<Object> list){
		
	}
	void apply(List<?> list){}    //这样重载是错误的
	}*/
	static class FX<T>{  //定义一个泛型静态类   里面包含了void apply(List<?> list){}方法
		private T ob;//定义泛型成员变量
		public FX(T ob){  //类的构造函数
			this.ob=ob;
		}
		public void showFx(){
			System.out.println("T的实际类型是："+ob.getClass().getName()); //数传泛型实际传入类型
		}
		public T getVal(){
			return ob;
		}
		void apply(List<?> list){   //List<?>是一切 List<XXX>的父类                注意！！！
			                                    //此为父类方法，在main()方法中可以用apply(new ArrayList<String>())
		}
	}
	// apply(new ArrayList<String>()){}
	
	public static void main(String[] args) {
		//List<Object> list=new ArrayList<Object>();
		 FX<Object> f=new FX<Object>(new ArrayList<Object>());
		 f.apply(new ArrayList<Object>());
	}

}
