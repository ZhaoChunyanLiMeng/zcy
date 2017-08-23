package com.lanqiao.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 判断是否有注解
 * @author 燕
 *
 */
public class WorkerFactory {
	 public static IWorker getWorkerByJdkDynamicProxy(Class<? extends IWorker> claz) {
		 class Handler  implements InvocationHandler{
			 private IWorker  target; //原声对象
			
			 public Handler(IWorker  target){  //构造方法，把原生对象当作参数传入
				 
			 }

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				 ShowDuration ann = method.getAnnotation(ShowDuration.class);  //获取注解，看是否有注解
				 Object result; //在下面用
				 if(ann != null && ann.value()){ //如果获取的注解不为空
					 long startTime = System.nanoTime();  //记录注解出事时间
					 result = method.invoke(target, args);//反射调用目标方法即  IWorker加有注释的方法
					 long estimatedTime = System.nanoTime() - startTime;//记录注解注解时间
					 System.out.println(method.toGenericString() + "-持续：" + TimeUnit.NANOSECONDS.toSeconds(estimatedTime) + "秒");//注解执行多长时间
				 }else{
					 result = method.invoke(target, args);//  方法上面没有该注解或值为false，就直接调用被代理对象的方法
				   }
				return result;
			}
		}
		  //原生对象
		 try {
			final IWorker target = claz.newInstance(); //生成原生对象
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;	 
	 }
	
}
