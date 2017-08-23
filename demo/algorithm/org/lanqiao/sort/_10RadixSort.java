package org.lanqiao.sort;

import java.util.ArrayList;

/**
 * 基数排序     先根据除以10的数，逐个入桶，然后再压入原数组
 * @author 燕
 *
 */
public class _10RadixSort {
	//十个桶，每个桶装的个数不固定
	private static ArrayList[] bucket=new ArrayList[10];
	//初始化桶
	static{
		for(int i=0;i<bucket.length;i++){
			bucket[i]=new ArrayList();
		}
	}
	public static void sort(int[] arr,int d){
		//全部入桶
		for(int i=0;i<arr.length;i++){
			putInBucket(arr[i],getDigitOn(arr[i],d));
		}
		//每个桶中的元素依次进入原数组
		int k=0;
		for(int j=0;j<bucket.length;j++){
			for (Object m  : bucket[j]) {     // ！！！注意这里遍历的是每个桶里的元素，然后把每个桶里的元素强制转换为整形，存回原数组
				arr[k++] = (Integer) m;         //把桶中的元素依次强制转换为整形，存到原数组中
			}
		}
		clearALL();
	}
	public static void sort(int[] arr){
		int d=1;  //进制先为10
		int max=max(arr);
		int dNum=1;
		while(max/10!=0){
			dNum++;
			max=max/10;
		}
		while(d<=dNum){
			sort(arr,d++);
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
	public static void main(String[] args){
		int[] arr={65, 3, 61, 62, 98, 93, 38, 15, 11, 4};
		sort(arr);
	}
	/**
	 * 求最大值的方法
	 * @param arr
	 * @return
	 */
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
	 * 清除桶中的元素,以供下次继续用
	 */
	private static void clearALL() {
		
		for(ArrayList b:bucket){
			b.clear();
		}
	}
	/**
	 * 获得除以10或10 的n次方后的数
	 * @param src
	 * @param d
	 * @return
	 */
	public static int getDigitOn(int src, int d) {
	    return src / (int) (Math.pow( 10, d - 1 )) % 10;
	  }
	/**
	 * 根据当前数除以 10..10²..10³ 等，得到的结果   选择进入那个桶
	 * @param current  当前数
	 * @param digitOn   进制
	 */
	private static void putInBucket(int current, int digitOn) {
	    switch (digitOn) {
	      case 0:
	        bucket[0].add( current );
	        break;
	      case 1:
	        bucket[1].add( current );
	        break;
	      case 2:
	        bucket[2].add( current );
	        break;
	      case 3:
	        bucket[3].add( current );
	        break;
	      case 4:
	        bucket[4].add( current );
	        break;
	      case 5:
	        bucket[5].add( current );
	        break;
	      case 6:
	        bucket[6].add( current );
	        break;
	      case 7:
	        bucket[7].add( current );
	        break;
	      case 8:
	        bucket[8].add( current );
	        break;
	      default:
	        bucket[9].add( current );
	        break;
	    }
	  }
     
}
