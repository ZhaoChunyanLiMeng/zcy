package org.lanqiao.classical.recursion;

import java.util.HashMap;
import java.util.Map;

public class Febonaci3 {
	public static double febonaci(double n,Map<Double,Double> map){
		if(n==1||n==2){
			return 1;
		}
		double n1=(map.get(n-1)==null)?febonaci(n-1,map):map.get(n-1);//如果map里没有n-1项斐波那契数，就用函数求出来，有就直接用
		double n2=(map.get(n-2)==null)?febonaci(n-2,map):map.get(n-2);
		double result = n1+n2;
		map.put(n, result);
		return result;
		
	}
	public static void main(String[] args){
		Map<Double,Double> map=new HashMap<Double,Double>();
		System.out.println(febonaci(47,map));
	}
}
