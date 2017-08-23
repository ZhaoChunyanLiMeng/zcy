package com.lanqiao.linkedlistpractice;
/**
 * 3、 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *  给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 *   不要开辟新的空间，即不要新建节点
 * @author 燕
 *
 */
public class _3PartitionLinkNode {
	public LinkedNode LinkNodePartitoin(LinkedNode head,int x){
		LinkedNode leftTail=null; //左尾
		LinkedNode rightTail=null;//右尾
		LinkedNode p_head=head;
		LinkedNode leftHead=null;
		LinkedNode rightHead=null;
		while(p_head!=null){
			int p_val=p_head.value;
			if(p_val<x){
				if(leftTail==null){ //p_val<x,p_head加到左边
					leftHead=p_head;
					leftTail=p_head;
				}else{
					leftTail.next=p_head;
					leftTail=leftTail.next;
				}
			}else{//p_val>x
				if(rightTail==null){
					rightHead=p_head;
					rightTail=p_head;
				}else{
					rightTail.next=p_head;
					rightTail=rightTail.next;
				}
			}
			p_head=p_head.next;//换链表里下一个元素比较
		}
		if(leftHead==null){ //把比x小的都移到x左边，比x大的都移到x右边之后， 返回头元素
			return rightHead;
		}
		leftTail.next=rightHead;
		if(rightTail!=null)
			rightTail.next=null;
			return leftHead;	
	}
	
	public static void main(String[] args){
		LinkedNode list=new LinkedNode(8);
		list.next=new LinkedNode(6);
		list.next.next=new LinkedNode(2);
		list.next.next.next=new LinkedNode(3);
		_3PartitionLinkNode pnode=new _3PartitionLinkNode ();
		System.out.println("重新排列后的链表的头指针值是："+pnode.LinkNodePartitoin(list, 4).value);
	}
}
