package org.lanqiao.sort;
/**
 * 插入排序
 * 思路：假设某元素之前的子序列有序，该元素如果大于子序列末端元素则可继续下一个元素
 *             如果该元素小于子序列末端，则往前插入到指定位置
 *时间复杂度：Q(n²)=1+2+3+.....+n-1 = n²
 *空间复杂度：Q(1)
 * @author 燕
 */
public class _3InsertionSort {
	static void sort(int[] arr,int low,int high){
		for(int j=low+1;j<=high;j++){
			int key=arr[j];
			int pre=j-1;
			//*套路：大的元素往后移直到前方没有大的，这时插入待排元素
			while(pre>=low&&arr[pre]>key){
				arr[pre+1]=arr[pre];
				pre--;      //往前扫描
			}
			arr[pre+1]=key;
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
