package org.lanqiao.mylock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   死锁    
 * @author 燕
 *
 */
public class MyDeadLock2 {
	public static void main(String[] args){
		MyDeadLockThread runner=new MyDeadLockThread();
		Thread th01=new Thread(runner,"张三");
		Thread th02=new Thread(runner,"李四");
		th01.start();
		System.out.println("改变状态");
		th02.start();
	}
}
class MyDeadLockThread implements Runnable{
	boolean flag=true;
	private Object a=new Object();
	private Object b=new Object();
	
	public Object getA() {
		return a;
	}

	public void setA(Object a) {
		this.a = a;
	}

	public Object getB() {
		return b;
	}

	public void setB(Object b) {
		this.b = b;
	}

	@Override
	public void run() {
		MyDeadLockThread  person=new MyDeadLockThread ();
		Lock lock=new ReentrantLock();
		Condition condition=lock.newCondition();
		
		if(flag){
			lock.lock();
		   try{
			    person.getA();
				System.out.println(Thread.currentThread().getName()+"抢到了a筷子");
				
				/*if(!flag){
				try {
					condition.await();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			   }*/
				lock.lock();
				try{
					person.getB();
					System.out.println(Thread.currentThread().getName()+"又抢到了b筷子,可以吃饭了");
					//condition.signalAll();
				}finally{
					lock.unlock();
					
				}
			}finally{
				lock.unlock();
			}
		}else{
			lock.lock();
			try {
				person.getB();
				System.out.println(Thread.currentThread().getName()+"抢到了b筷子");
				/*try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				lock.lock();
				try{
					person.getA();
					System.out.println(Thread.currentThread().getName()+"又抢到了a筷子,可以吃饭了");
				}finally{
					lock.unlock();
				}
		 }finally{
			 lock.unlock();
		 }
			
	}
}
}