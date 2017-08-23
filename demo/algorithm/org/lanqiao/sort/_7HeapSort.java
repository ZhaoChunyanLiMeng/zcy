package org.lanqiao.sort;
/**
 * 堆排序
 * 思路：堆就是一个二叉数，对于堆排序来说，有把数组变成堆（有小井堆和大井堆），调整堆，对堆进行排序
 * 
 * @author 燕
 *
 */
public class _7HeapSort {
	/**
	 *建小井堆
	 */
	private static void  makeHeap(int[] arr){
		int length=arr.length;
		if(length==1){
			return;
		}else{
			for(int i=length/2-1;i>=0;i--){//i=length/2-1是叶子节点开始位置
				heapAdjust(arr,i,length);//调整叶子节点，形成小井堆
			}
		}
		
	}
	/**
	 * 对堆进行调整
	 */
	private static void heapAdjust(int[] arr,int index,int length){ //当前数组，以及当前顶元素下标，数组长度   length：为了控制边界
		int j=index*2+1;//左孩子下标
		int temp=arr[index];//保存下当前顶元素
		while(j<length){
			if(j+1<length&&arr[j+1]<arr[j]){
				j++;//寻找最小元素
			}
			if(arr[j]<temp){//如果有比顶元素更小的元素，则更小的元素代替当前顶元素
				arr[index]=arr[j];
				index=j;//记下更小元素的下标
				j=index*2+1;//继续往下寻找
			}else{//当前元素已经为最小元素，则跳出循环
				break;
			}
		}//循环走完，index就是temp该放的位置
	    arr[index]=temp;
	}
	/**
	 *利用小顶堆进行排序
	 *1、先整体建堆，后交换元素，把堆顶挪到数组的最末尾
	 *2、以堆顶为起点往下调整，边界为N-1
	 */
	private static void sort(int[] arr){
		makeHeap(arr);
		for(int i=arr.length-1;i>=1;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapAdjust(arr,0,i);//调整小顶堆，边界递减
		}	
	}
	public static void main(String[] args){
		int[] arr={26, 100, 30, 43, 43};
		sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
