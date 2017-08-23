package org.lanqiao.sort;
/**
 * 计数排序
 * 思路：领建一个数组C，数组下标即为待排序下标的值，如果值重复，则C此下标的的值++
 * 时间复杂度:N+K
 * 空间复杂度：K
 * @author 燕
 *
 */
public class _8CounterSort {
	private static int  max(int[] arr){
		int max=arr[0];//先认为待排序数组最大元素是第一个，然后逐步求出最大值元素
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
	/**
	 * 排序数组
	 */
	private static void sort(int[] arr){
		int maxValue=max(arr);
		int count[] =new int[maxValue+1];//用待排序数组最大值为长度，建立一个数组   !!!注意，建的这个数组比原数组长度加1
		for (int i : arr) {
			count[i]++;
		}
		//给原来数组排序
		int k=0;
		for(int j=0;j<count.length;j++){//如果count[j]内还有,则说明原数组 j 值还没结束
			while(count[j]>0){
				arr[k++]=j;
				count[j]--;
			}
		}
	}
	public static void main(String[] args){
		int[] arr={16, 64, 60, 97, 10};
		sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
