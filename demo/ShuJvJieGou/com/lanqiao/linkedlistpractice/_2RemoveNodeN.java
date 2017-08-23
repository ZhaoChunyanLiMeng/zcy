package com.lanqiao.linkedlistpractice;
/**
 * 2、实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
* @author 燕
 *
 */
public class _2RemoveNodeN {
	public boolean removeNode(LinkedNode node){
		if(node.next==null){
			return false;
		}
		node.value=node.next.value;//把当前元素移除后，下一个元素代替当前元素
		node.next=node.next.next;
		return true;
	}
}
