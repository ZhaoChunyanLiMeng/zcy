package org.lanqiao.classical.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列用map
 * @author 燕
 *
 */
public class Febonaci2 {
	public static int febonaci(int n,Map<Integer,Integer> map){
		if(n==1||n==2){
			return 1;
		}
		int n1=(map.get(n-1)==null)?febonaci(n-1,map):map.get(n-1);//如果map里没有n-1项斐波那契数，就用函数求出来，有就直接用
		int n2=(map.get(n-2)==null)?febonaci(n-2,map):map.get(n-2);
		int result = n1+n2;
		map.put(n, result);
		return result;
		
	}
	public static void main(String[] args){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		System.out.println(febonaci(4,map));
	}
}
