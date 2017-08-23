package org.lanqiao.sort;

import java.util.Arrays;
/**
 * 桶排序     
 * 用LinkedList链表来做桶  
 * @author 燕
 *
 */
public class _9BucketSort{
	private static int hash(int element,int max,int length){
		return (element*length)/(max+1);  //element是元素值， length是数组长度，max是数组最大值
	}
	public static void main(String[] args) {
	    int[] arr ={17, 78, 30, 25, 73, 72, 45, 33, 56, 25};
	    new _9BucketSort().sort(arr);

	    
	  }
	private static int  max(int[] arr){
		int max=arr[0];//先认为待排序数组最大元素是第一个，然后逐步求出最大值元素
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
	private void sort(int[] arr){
		int length=arr.length;
		LinkedNode[] bucket=new LinkedNode[length];//建立一个链表指针数组来当做桶
		int max=max(arr);
		//元素入桶
		for(int i=0;i<length;i++){
			int value=arr[i];//数组下标为i的元素的值
			int hash=hash(arr[i],max,length);  //元素的hash值
			if(bucket[hash]==null){  //如果桶里没有元素
				bucket[hash]=new LinkedNode( value );//初始化链表表头
			}else{
				insertInto(value,bucket[hash],bucket,hash);//把新元素插入链表
			}
		}
		int k=0;//记录数组下标
		for (LinkedNode node : bucket) {
			if(node !=null){
				while(node!=null){
					arr[k++]=node.value;
					node=node.next;
				}
			}
		}
	}
	/**
	 * 写一个用来往桶里插入元素的方法
	 * @param value
	 * @param head
	 * @param bucket
	 * @param hash
	 */
	private  void insertInto(int value,LinkedNode head,LinkedNode[] bucket,int hash){
		LinkedNode newNode=new LinkedNode(value);
		if(value<head.value){  //如果加入元素的值小于链表桶头元素的值，则此元素来做头
			newNode.next=head; //取代原来的头元素
			bucket[hash]=newNode;//桶元素的头元素为新加入的元素
			return;
		}
		//新要插入的元素，要是小于头元素
		LinkedNode p=head;//建立一个中间元素p用来寻找新填入元素的合适位置
		LinkedNode pre=p;
	    while(p!=null&&value>head.value){//当头元素不为空，且元素值大于头元素值是，把头元素赋给它前面那个，往下寻找
	    	pre=p;
	    	p=p.next;
	    }  
	    if(p==null){// 如果 跑到末尾了
	    	pre.next=newNode;
	    }else{
	    	pre.next=newNode;
	    	newNode.next=p;
	    }   
	}
	
	/**
	 *建立一个链表指针类来当做桶用
	 */
	class LinkedNode{
		int value;
		LinkedNode next;
		public LinkedNode(int value){
			this.value=value;
		}
   }
	
}
//建立一个链表指针类来当做桶用
/*class LinkedNode{
	int value;
	LinkedNode next;
	LinkedNode(int value){
		this.value=value;
	}
}*/
