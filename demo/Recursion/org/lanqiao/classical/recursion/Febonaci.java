package org.lanqiao.classical.recursion;
/**
 * 斐波那契数列
 * @author 燕
 *
 */
public class Febonaci {
	public static void main(String[] args){
		System.out.println(febonaci(4));;
	}
	static int febonaci(int N){
		if(N==1||N==2){
			return 1;
		}
		return febonaci(N-1)+febonaci(N-2);
	}
}
