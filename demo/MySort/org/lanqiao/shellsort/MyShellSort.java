package org.lanqiao.shellsort;
/**
 * 希尔排序
 * @author 燕
 *
 */
public class MyShellSort {
	public static void shellSort(int[] arr){
		if(arr==null||arr.length<=1){
			return;
		}
		int increment = arr.length/2;
		while(increment>=1){
			for(int i=0;i<arr.length;i++){
			//进行插入排序
				for(int j=i;j<arr.length-increment;j=j+increment){
					if(arr[j]>arr[j+increment]){   //对步长内元素进行插入排序
						int temp=arr[j];
						arr[j]=arr[j+increment];
						arr[j+increment]=temp;
					}
				}
			}
		//一次分组 插入排序完成后 换步长
		increment = increment/2;
		}
	}
}
