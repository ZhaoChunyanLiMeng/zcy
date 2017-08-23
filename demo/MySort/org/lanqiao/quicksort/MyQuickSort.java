package org.lanqiao.quicksort;
/**
 * 快速排序算法
 * @author 燕
 *
 */
public class MyQuickSort {
	public static int partition(int[] arr,int lo,int hi){
		int key=arr[lo];  //选择一个基准点  可选第一个为基准点
		while(lo<hi){
			while(arr[hi]>key&&hi>lo){  //在基准右边找一个小于基准的元素，当基准右边元素都大于基准时，hi--
				hi--;
			}
			arr[lo]=arr[hi];//当基准右边找到一个小于基准的元素时，arr[hi]与arr[lo] 交换,目的把比基准小的都调到基准左边去
			while(arr[lo]<key&&hi>lo){
				lo++;//在基准左边找一个大于基准的元素，当基准右边元素都大于基准元素时，lo++
			}
			arr[hi]=arr[lo];//当基准左边找到一个大于基准的元素时，arr[h]与arr[lo] 交换,目的把比基准小大的都调到基准左边去
		}
		arr[hi]=key; //当hi--与基准重合时，把基准赋给arr[hi]，并返回基准的下标，这样即基准左边都比基准元素小，右边都比基准元素大
		return hi;
	}
	/**
	 * 写一个函数，调用partition(int[] arr,int lo,int hi)来实现排序
	 */
	public static void sort(int[] arr,int lo,int hi){
		if(hi<=lo){  //记清是当 hi<=lo
			return ;
		}
		int index=partition( arr,lo, hi);  //用下标元素来接收 返回的基准下标
		sort(arr,lo,index-1);//第一次调用partition( arr,lo, hi); 函数后，把数组分成了两份，然后继续 递归调用函数sort
		sort(arr,index+1,hi);
	}
}

