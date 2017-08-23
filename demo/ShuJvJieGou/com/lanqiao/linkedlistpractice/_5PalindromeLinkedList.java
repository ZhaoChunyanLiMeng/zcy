package com.lanqiao.linkedlistpractice;

import java.util.Stack;

/**
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：{1,2,3,2,1}  返回：true
 * @author 燕
 *
 */
public class _5PalindromeLinkedList {
	public boolean isPalindrom(LinkedNode head){
		if(head==null){
			return false;   //如果链表为空，则不是回文链表
		}
		if(head.next==null){
			return true;  //如果链表只有一个元素，则此链表是回文链表
		}
		LinkedNode slower=head;
		LinkedNode faster=head;
		Stack<LinkedNode> stack=new Stack<>();
		boolean isOdd=true;  //用来标记两边个数是否是奇数个
		while(faster!=null&&faster.next!=null){
			stack.push(slower); //把元素压栈
			slower=slower.next;
			faster=faster.next.next;
			if(faster==null){
				isOdd=false;  //如果头和slower成对出现，而faster为空，则书名元素个数是偶数个
			}
		}
		if(isOdd)
			slower=slower.next;  //slower当前是头元素
		while(!stack.empty()){ //如果栈不为空
			if(stack.pop().value!=slower.value){  //元素出栈，元素是按链表元素倒序输出
				return false;
			}
			slower=slower.next;
		}
		return true;
		
	}
	/**
	 * 用main函数，进行测试
	 * @param args
	 */
	public  static void main(String[] args){
		LinkedNode  node=new LinkedNode(1);
		node.next=new LinkedNode(2);
		node.next.next=new LinkedNode(3);
		node.next.next.next=new LinkedNode(2);
		node.next.next.next.next=new LinkedNode(1);
		boolean is=new _5PalindromeLinkedList().isPalindrom(node);
		if(is){
			System.out.println("此链表是回文链表");
		}else{
			System.out.println("此链表不是回文链表");
		}
	}
}
