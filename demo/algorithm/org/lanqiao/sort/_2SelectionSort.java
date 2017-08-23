package org.lanqiao.sort;
/**
 * 选择排序
 * 思路：第一趟，在数组中，选择出一个最小的数，和第一个数交换，如此下去
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 稳定性：考虑如332211，第一次循环完后，最后一个1与第一个3交换，第二趟循环，倒数第二个1与第二个3交换，两个1的相对位置发生了变化，所以不稳定
 * 选择排序：不稳定
 * 原址排序
 * @author 燕
 *
 */
public class _2SelectionSort {
	private static void sort(int[] arr,int low,int high){
		for(int i=low;i<high;i++){
			int min=i;
			for(int j=i+1;j<=high;j++ ){
				if(arr[min]>arr[j]){
					min=j;//覆盖
				}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			}
		}
	}
	public static void main(String[] args){
		int[] arr={16, 30, 10, 79, 3, 24, 61, 67, 3, 15, 87, 91, 46, 42, 7, 28, 16, 12, 75, 5};
		sort(arr,0,arr.length-1);
        for (int i : arr) {
			System.out.println(i);
		}
	}
}
