package org.lanqian.heap_sort;
/**
 * 堆排序
 * @author 燕
 *
 */
public class MyHeap_Sort {
	/**
	 * 先写一个调整堆的方法
	 */
	private void heapSort(int[] arr,int start,int end){
		int temp=arr[start];//先保存下当前父节点
		int i=2*start+1;//子节点在数组中下标
		while(i<end){
			if(i<end&&arr[i+1]>arr[i]){  //寻找最大子节点
				i++;
			}
			if(arr[i]<temp){
				break;   //如果当前父节点元素为最大元素，则跳出
			}
		}
	}
}
