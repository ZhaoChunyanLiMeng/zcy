package org.lanqiao.stackpractice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 双栈排序
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，
 * 但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 *  返回：[5,4,3,2,1]
 * @author 燕
 *
 */
public class _3TwoStacksSort {
	public ArrayList<Integer> twoStackSort(int[] numbers){
		Stack<Integer> source=new Stack<>();
		//初始化栈
		for(int i=numbers.length-1;i>=0;i--){
			source.push(numbers[i]);
		}
		Stack<Integer> target=twoStackSort(source);//排序好的source放到target中
		ArrayList<Integer>  list=new ArrayList<> ();
		while(!target.empty()){  //把从大到小的元素放到list 中，进行返回
			list.add(target.pop());
		}
		return list;
	}

	private Stack<Integer> twoStackSort(Stack<Integer> source) {
		Stack<Integer> target=new Stack<>();
		sortToTarget(source,target);//把source中的元素排序到target中
		return target;
	}
	/**
	 * 把source 原栈中的元素 按从大到小排序到 新栈中，并返回新栈
	 * @param source
	 * @param target
	 */
	private void sortToTarget(Stack<Integer> source, Stack<Integer> target) {
		while(!source.empty()){   //注意！！！栈为空 为 stack.empty()
			int v1=source.pop();
			if(target.empty()){ //如果target为空，直接放进去
				target.push(v1);
			}else{ //如果source的栈顶元素 大于 target 中的元素，则放进去   如果小于，则把大元素回收
				int v2=target.peek();  //查看目标栈的 顶元素，比较大小
				if(v1>=v2){
					target.push(v1);
				}else{  //目标临时栈中元素大时，则回收
					source.push(target.pop());
					while(!target.empty()&&v1<target.peek()){
					source.push(target.pop());
					}
					target.push(v1);
				}
			}
		}
	}
	/**
	 * 写一个main 函数进行验证
	 */
	public static void main(String[] args){
		int[] numbers={1,2,3,4,5};
		_3TwoStacksSort stackSort=new _3TwoStacksSort();
		ArrayList<Integer> list=stackSort.twoStackSort(numbers);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
