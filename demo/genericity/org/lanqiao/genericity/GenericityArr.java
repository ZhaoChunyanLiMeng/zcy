package org.lanqiao.genericity;

import java.util.ArrayList;
/**
 * 功能：不能创建一个确切的泛型类型的数组。
 */
import java.util.List;

public class GenericityArr {
	public static void main(String[] args){
		System.out.println(showArr());
	}
	public static int  showArr(){
		List<?>[ ] lsa=new List<?>[10 ];  //建立泛型数时，只能建立 通配符 似数组 List<?>[ ]，不能创建确切泛型类型数组
		Object o=lsa;  //创建一个对象接收泛型数组
		Object[ ] oa=(Object[ ] )o; //把泛型数组变为对象数组
		List<Integer> list=new ArrayList<Integer>();//建一个List对象    ，在此创建一个确切泛型类型的 对象
		list.add(new Integer(3)); //给list一个值
		oa[1]=list;  //把list放进数组
		Integer i=(Integer)lsa[1].get(0);
		int num=i;
		return num;
	}
}
