package org.lanqiao.classical.recursion;

/**
 * 倒序输出单向链表的元素值
 * 用递归让单链表反转
 * @author 燕
 *
 */
public class LinkedNodeReverse {
	public static void main(String[] args){
		LinkedNode node=new LinkedNode(1);
		node.next=new LinkedNode(2);
		if(node!=null){
			System.out.println(node.value+"                      "+node.next.value);
		}
			printLinkedNodeReverse(node);
			
	}
	static void printLinkedNodeReverse(LinkedNode node){
		if(node==null){
			return;
		}
		printLinkedNodeReverse(node.next);
		System.out.println(node.value);
	}
	static class LinkedNode{
		int value;
		LinkedNode next;
		public LinkedNode(int value){
			this.value=value;
		}
   }
}
