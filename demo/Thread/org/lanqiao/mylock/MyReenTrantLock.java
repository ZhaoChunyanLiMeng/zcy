package org.lanqiao.mylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 重入锁
 * @author 燕
 *
 */
//鸡蛋篮子里装有鸡蛋
class LinkedNode{
	int value;
	LinkedNode next;
	LinkedNode head;
	int size;
	public LinkedNode(){}
	public LinkedNode(int value){
		this.value=value;
	}
	public int  getsize(){
		if(head==null){
			return 0;
		}else{
			int count =0;
			LinkedNode p=head;
			while(p!=null){
				count++;
			}
			return count;
		}
	}
	public void put(LinkedNode newNode){
		if(size==0){
			head=newNode;
		}else{
			LinkedNode p=head;
			while(p.next!=null){
				p=p.next;
			}
			p.next=newNode;
		}
		size++;
	}
	public LinkedNode get(){
		if(size==0){
			return null;
		}else{
			LinkedNode temp=head;
			head=head.next;
			return temp;
		}	
	}
}
/**
 * 第一个需要鸡蛋做番茄炒蛋的线程
 * @author 燕
 *
 */
class thread01 implements Runnable{
	@Override
	public void run() {
		LinkedNode eag=new LinkedNode();
		if(eag.size>0){
			eag.get();//得到一个鸡蛋
			System.out.println(Thread.currentThread().getName()+":哈哈，我拿到一个鸡蛋，我可以做番茄炒蛋了");
		}else{
			System.out.println(Thread.currentThread().getName()+":唉，鸡蛋没了");
		}
	}
}
/**
 * 第一个需要鸡蛋做番茄炒蛋的线程
 * @author 燕
 *
 */
class thread02 implements Runnable{

	@Override
	public void run() {
		LinkedNode eag=new LinkedNode();
		while(eag.size>0){
			eag.get();//坏的 把鸡蛋拿没
		}
		System.out.println(Thread.currentThread().getName()+":哈哈，我把鸡蛋拿没了");
	}
	
}
public class MyReenTrantLock {
	
	public static void main(String[] args){
		LinkedNode head=new LinkedNode(1);
		
		
		thread01 one=new thread01();
		thread02 two=new thread02();
		Thread th01=new Thread(one,"厨子1"); 
		Thread th02=new Thread(two,"厨子2");
		th01.start();
		try {
			th01.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th02.start();
		}
}
