package org.lanqiao.mergesort;

import java.util.Arrays;

/**
 * 归并排序
 * @author 燕
 *
 */
public class MyMergeSort {
	public static void merger(int[] arr,int left,int mid,int right){
		int[ ] temp=new int[arr.length];//建一个临时数组
		int tIndex=left;//tIndex虚拟数组下标
		int j=mid+1;
		int k=left;
		int aleft=left;//真实数组左端
		//把较小的数先移到数组里
		while((tIndex<=mid)&&(j<=right)){
			if(arr[tIndex]<arr[j]){//如果左边那组 小于右边那组
				temp[k]=arr[ tIndex];
				k++;
				tIndex++;
			}else{//如果右边那组小， 放到临时数组里
				temp[k]=arr[j];
				k++;
				j++;
			}
		}
			//把左边剩余数移到数组里
			while(tIndex<=mid){
				temp[k]=arr[tIndex];
				k++;
				tIndex++;
			}
			//把右边剩余数移到数组里
			while(j<=right){
				temp[k]=arr[j];
				k++;
			    j++;
			}
		  int k2=0;
	      for(int p=left;p<right;p++){
			arr[left]=temp[k2];
			k2++;
		  }
	}
	/**
	 * 利用merger(int[] arr,int low,int mid,int high)进行排序
	 */
	public static int[] megerSort(int[] arr,int low,int high){
		int mid=(low+high)/2;
		if(low<high){
			megerSort(arr,low,mid);
			megerSort(arr,mid+1,high);
			merger(arr,low,mid,high);
		}
		return arr;
	}
}
