package org.lanqiao.stackpractice;

import java.util.Stack;

/**2
 *  用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *  push()时正常用栈压栈即可，当pop()时，先把最先进去的元素，从栈底移到栈顶，然后再移除，使其满足队列的先进先出
 * @author 燕
 *
 */
public class _2QueueByTwoStack {
	Stack<Integer> stack1=new Stack(); //线建两个栈，一个用来push和pop元素，实现队列的先进先出，一个用来辅助
	Stack<Integer> stack2=new Stack();
	public void push(int node){ //往栈stack1里添加元素
		stack1.push(node);
	}
	public int pop(){
		move(stack1,stack2);//此时，stack2顶部为先进去的元素
		int result=stack2.pop(); //获得先进去的元素     这个操作后，result获得了先进去的元素，同时把先进去的元素删除了
		move(stack2,stack1);//然后，再把stack2里的元素放回stack1里
	    return result;
	}
	private void move(Stack source,Stack target){//移动方法，把栈stack1里的 先进去 的压在底部的元素，移动到顶上来
		while(!source.empty()){
			target.push(source.pop());//stack1移出一个，stack2移进一个，帮助stack1先进去的移到表面来
		}
	}
	
	/**
	 * 写主函数，测试结果
	 */
	public static void main(String[] args){
		_2QueueByTwoStack queue=new _2QueueByTwoStack();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
	}
}
