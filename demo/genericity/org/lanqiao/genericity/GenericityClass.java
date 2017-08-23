package org.lanqiao.genericity;
/**
 * 泛型类 和 泛型方法
 * @author 燕
 *
 */
public class GenericityClass {
	
	static class FX<T>{  //定义一个泛型静态类
		private T ob;//定义泛型成员变量
		public FX(T ob){  //类的构造函数
			this.ob=ob;
		}
		public void showFx(){   //普通方法
			System.out.println("T的实际类型是："+ob.getClass().getName()); //数传泛型实际传入类型
		}
		public T getVal(){
			return ob;
		}
	}
	/**
	 * 用main()实际main方法来验证
	 */
	public static void main(String[] args){
		FX<Integer> intObj= new FX<Integer>(100);  //通过构造方法创建 一个传入类型的 实例对象
		intObj.showFx();
	        System.out.println("value= "+intObj.getVal());   //获取对象的值
	        System.out.println("----------------------------------"); 
	        
	        FX<String> intObj2= new FX<String>("java");  //通过构造方法创建 一个传入类型的 实例对象
			intObj2.showFx();
		        System.out.println("value= "+intObj2.getVal());   //获取对象的值

	}
}
