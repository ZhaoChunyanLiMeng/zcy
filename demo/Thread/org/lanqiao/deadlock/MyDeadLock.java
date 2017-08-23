package org.lanqiao.deadlock;
/**
 *   死锁    
 * @author 燕
 *
 */
public class MyDeadLock {
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
	Object a=new Object();
	Object b=new Object();
	@Override
	public void run() {
		if(flag){
			synchronized (a) {
				System.out.println(Thread.currentThread().getName()+"抢到了a筷子");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (b) {
					System.out.println(Thread.currentThread().getName()+"又抢到了b筷子,可以吃饭了");
				}
			}
		}else{
			synchronized (b) {
				System.out.println(Thread.currentThread().getName()+"抢到了b筷子");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 }
			synchronized (a) {
				System.out.println(Thread.currentThread().getName()+"又抢到了a筷子,可以吃饭了");
			}
	}
}
}