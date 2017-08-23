package org.lanqiao.stackpractice;

import java.util.ArrayList;

/**1
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 * 该数据结构应支持与普通栈相同的push和pop操作。
 * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，
 * 后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。请返回一个int[][](C++为vector&ltvector&ltint>>)，
 * 为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 * @author 燕
 *
 */
public class _1SetOfStacks {
	public ArrayList<ArrayList<Integer>>  setOfStacks(int[][] obe,int size){  //int[] obe 操作数组，size 栈的大小
		ArrayList<ArrayList<Integer>>  list=new ArrayList<ArrayList<Integer>>();  //代表数据结构，有多个栈组成，其中存储的内容就是多个栈
		ArrayList<Integer> currentStack=new ArrayList<Integer>(size);  //栈
		list.add(currentStack);
		for (int[] opAndValue : obe) {
			int op=opAndValue[0];//操作   1--压栈  0--出栈
			int value=opAndValue[1]; //要操作的数值
			if(op==1){//要进行压栈操作
				if(currentStack.size()==size){ //当前栈已满，则需要建一个新栈，存到数据结构里
					currentStack=new ArrayList<Integer>(size);
					list.add(currentStack);
				}
				currentStack.add(value);
			}else if(op==0){//要进行出栈操作
				if(currentStack.size()==0){  //如果栈为空，从数据结构里把此栈移除
					list.remove(currentStack);
					currentStack=list.get(list.size()-1); //移除旧栈之后，重新给新栈
				}
			}			
			currentStack.remove(currentStack.size()-1);//从当前栈里移除元素
		}
		return list;	
	}
	/**
	 * 用主函数进行测试
	 * @param args
	 */
	/*public static void main(String[] args){
		int[][] obe=new int[2][];
		int[] obe1={1,1,1};
		int[] obe2={1,2,3};
		obe[0]=obe1;
		obe[1]=obe2;
		SetOfStacks setofStacks=new SetOfStacks();
		ArrayList<ArrayList<Integer>> list=setofStacks.setOfStacks(obe, 3);
		for (ArrayList<Integer> arrayList : list) {
			int length=arrayList.size();
		     for(int i=0;i<length;i--){
		    	 System.out.println(arrayList.get(i));
		     }
		}
	}*/
}
