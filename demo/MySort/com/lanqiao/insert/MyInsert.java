package com.lanqiao.insert;

public class MyInsert {
	
	public static void InsertSort(int[] arr){
		for(int i=0;i<arr.length;i++){  //第一个元素是排序好的，从第一个往后开始 定位插入的x
			int target=arr[i];  //要寻找的目标
			int j=i;//i前面的一个元素
		    while(j>0&&arr[j-1]>target){   //当前面一个元素大于目标元素时，前面元素后移，逆向扫描     
		    	arr[j]=arr[j-1];//前一个元素后移
		    	j--; //j--,target再和它前面一个元素相比较
		    }
		    arr[j]=target;  //比较循环完，j为那个比目标元素小的元素，所以target插到j+1的位置
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
