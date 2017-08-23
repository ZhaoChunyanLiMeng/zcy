package org.lanqiao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK动态代理的基本示例 注意动态代理必须使用接口，因为是基于接口的代理
 * 还有一种是cglib之类的，直接修改字节码的代理方式，不需要目标对象所属类实现任何接口
 * 
 * @author zhengwei
 *
 */
/**
 * 建一个类，用main 方法来测试（相当于客户 client）
 * @author 燕
 *
 */
public class ProxyDemo {
  public static void main(String[] args) {
    // 创建一个原生对象
    Target target = new Target();  //建立一个目标对象
    // 实际处理代理行为
    InvocationHandler handler = new DemoHandler(target);  //InvocationHandler是一个接口,通过多态 创建一个实现接口 的对象
    ClassLoader loader = TargetInterface.class.getClassLoader();   //原生对象的类加载器
    TargetInterface proxyObject = (TargetInterface) Proxy.newProxyInstance(   //代理对象
        loader, new Class[] { TargetInterface.class }, handler);
    proxyObject.f();
  }
}




/**
 * 接口
 * @author 燕
 *
 */
interface TargetInterface {  //共同的接口
	void f();
}
/**
 * 原生类（代理目标类）
 * @author 燕
 *
 */
class Target implements TargetInterface {    //目标类
  @Override
 	public void f() {
	  System.out.println("我是目标对象的f方法");
  	}
}
/**
 * 自己写一个****Handler 用来 实现JDK的InvocationHandler接口
 * 基于接口来代理，改变原生对象（注意：动态代理，必须使用接口）
 * 手写 handler增强
 * @author 燕
 *
 */
class DemoHandler implements InvocationHandler {  //自己写一个****Handler 用来 实现JDK的InvocationHandler接口
	Target target;   //原目标对象

  	public DemoHandler(Target target) {  //构造函数，把target目标传进去
  		this.target = target;
  	}

  // 调用行为写在这里      重载了原生对象的方法:前置方法  原方法   后置方法
  @Override
  	 public Object invoke(Object proxy, Method method, Object[] args)
  			throws Throwable {
    // 增加前置的代理行为
	  System.out.println("目标对象正在调用" + method + ",我是前置通知");
    //    调用原始对象的行为
    //method.invoke(target, args);//  这句话相当于target.method(args);
    //    增加后置的代理行为
	  System.out.println("该方法的参数是："
        + (null == args ? "没有参数" : Arrays.asList(args).toString()) + ",我是后置通知");
	  	return null;
  	 }
  
  
}
