package com.lanqiao.linkedlistpractice;
/**
 * 输入一个链表，输出该链表中倒数第K个节点
 * 倒数第k个节点，就是正数第n-k个
 * @author 燕
 *
 */
/**
 * 链表
 *
 */
public class _1FindTheKthNode {
	public LinkedNode  findKthTail(LinkedNode head,int k){
		if(head==null||k<=0){  //如果链表为空，返回空，函数退出
			return null;
		}
		LinkedNode _head=head;
		int count=0;
		while(_head!=null){  //统计链表里一共有多少个元素
			count++;
			_head=_head.next;
		}
		if(count<k){  //count-k<0时，是找不到倒数第k个元素的
			return null;
		}
		LinkedNode p_head=head;
		for(int i=0;i<count-k;i++){  //遍历找出倒数第K个，即正数第count-k个元素
			p_head=p_head.next;
		}
		return p_head;
	}
	/**
	 * 主函数进行测试
	 */
	public static void main(String[] args){
		LinkedNode list=new LinkedNode(2);
		list.next=new LinkedNode(3);
		_1FindTheKthNode findK=new _1FindTheKthNode();
		System.out.println("倒数第二个元素的值为："+findK.findKthTail(list, 2).value);
	}
}
