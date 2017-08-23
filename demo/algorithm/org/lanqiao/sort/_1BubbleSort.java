package org.lanqiao.sort;

import java.util.Arrays;


/**
 * 冒泡排序算法
 * 思路：通过第一趟排序，将最大元素移动到最后
 *             第二趟排序，。。。，将次大元素移动到倒数第二个位置，如此
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 稳定性：有相同元素，排序前和排序后相对位置不变，稳定。
 * @author 燕
 *
 */
public class _1BubbleSort {
	static void sort1(int[] arr){
		for(int j=0;j<arr.length;j++){
			for(int i=0;i<arr.length-j-1;i++){
				if(arr[i]>arr[i+1]){
					int temp=arr[i+1];
					arr[i+1]=arr[i];
					arr[i]=temp;
				}
			}
		}
	}
	/**
	 * 写一个main()方法进行验证
	 */
	 public static void main(String[] args) {
		    int[] arr ={16, 30, 10, 79, 3, 24, 61, 67, 3, 15, 87, 91, 46, 42, 7, 28, 16, 12, 75, 5};
		   sort1(arr);
		    for (int i : arr) {
				System.out.println(i);
			}
		 }
}
