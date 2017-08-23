package com.lanqiao.linkedlistpractice;


/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 *   编写函数对这两个整数求和，并用链表形式返回结果。 
 *  给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 *  测试样例：{1,2,3},{3,2,1}   返回：{4,4,4}
 * @author 燕
 *
 */
public class _4PlusLinkNode {
	public LinkedNode plusAB(LinkedNode a,LinkedNode b){//a 加数  b被加数  
		return plusAB(a,b,0);		
	}
	private LinkedNode plusAB(LinkedNode a,LinkedNode b,int i){  //a 加数  b被加数  i进位
		if(a==null&&b==null&&i==0){
			return null;
		}
		int value=i;  //先把进位赋给值
		if(a!=null){
			value+=a.value;
		}
		if(b!=null){
			value+=b.value;   //如果a,b有值，把a,b加到结果和里
		}
		/*LinkedNode result=new LinkedNode(value%10);   //结果 节点
	    result.next=plusAB(a.next==null?null:a.next,b.next==null?null:b.next,value>=10?1:0);*///继续计算结果集的下一个  !!注意，此处value是大于等于10吗
		LinkedNode result = new LinkedNode(value%10);
		    result.next = plusAB(a==null?null:a.next,   //注意！！！此处判断的是当前的a等于空吗，如果a等于空，则没有下一个节点，如果a不等于空，则返回下一个节点
		        b==null?null:b.next,
		        value>=10?1:0);
		return result;
	}
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(7);
	    node1.next = new LinkedNode(4);
	    node1.next.next = new LinkedNode(0);
	    node1.next.next.next = new LinkedNode(7);
	    node1.next.next.next.next = new LinkedNode(5);
	    //System.out.println(node1.value);

	    LinkedNode node2 = new LinkedNode(2);
	    node2.next = new LinkedNode(7);
	    node2.next.next = new LinkedNode(2);
	    node2.next.next.next = new LinkedNode(3);
	    node2.next.next.next.next = new LinkedNode(4);
	    //System.out.println(node2.value);
	    LinkedNode result = new _4PlusLinkNode().plusAB(node1, node2);

	   while(result.next!=null){
	    	System.out.print(result.value);
	    	result=result.next;
	    }
	    //assertThat(result.toString()).isEqualTo("913001");
	  }
}
