package org.lanqiao.mergesort;
/**
 * 正确的归并排序
 * @author 燕
 *
 */
public class QmergeSort {
	public static void mergeSort(int[] arr,int first,int last,int[] temp) {
		if(first>=last) {
			return;
		}else {
			int mid = (first+last)/2;
			mergeSort(arr, first, mid, temp);
			mergeSort(arr, mid+1, last, temp);
			merge(arr,first,last,mid,temp);
		}
	}

	private static void merge(int[] arr, int first, int last, int mid, int[] temp) {

		int k = 0;//临时数组初始下标
		int i =first;
		int j = last;
		int m = mid;
		int n = mid+1;
		while(i<=m&&n<=j) {
			if(arr[i]<=arr[n]) {
				temp[k++]=arr[i];
				i++;
			}else {
				temp[k++]=arr[n];
				n++;
			}
		}
		while(i<=m) {
			temp[k++]=arr[i];
			i++;
		}
		while(n<=j) {
			temp[k++]=arr[n];
			n++;
		}
		int v=0;
		for (int q = first; q <= last;q++) {
			arr[q] = temp[v++];
		}
	}


}
