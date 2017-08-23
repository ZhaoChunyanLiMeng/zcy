package org.lanqiao.recursion.practice;
/**
 * 练习一：求字符串中字符的所有排列组合，打印所有可能生成的新字符串
 * 字符串排列
 * @author 燕
 *
 */
public class Permutation {
	public static void main(String[] args){
		String s="abc";
		char[] str=s.toCharArray();
		stringPermutation(str,0,2);
	}
	static void stringPermutation(char[] str,int from,int to){
		if(to<=1){
			return;
		}
		if(from==to){  
			System.out.println(str);
		}else{
			for(int i=from;i<=to;i++){
				swap(str,i,from);//交换前缀，使其输出下一个前缀
				stringPermutation(str,from+1,to);
				swap(str,from,i);//再把前缀换过来，为了下一次排列
			}
		}
		
	}

	private static void swap(char[] str, int i, int j) {
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
}
