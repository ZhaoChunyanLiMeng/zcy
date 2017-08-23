package org.lanqiao.recursion.practice;
/**
 * 练习二：在堆排中，是否可以找到用递归的地方
 * 在调整堆的地方，可以用到递归
 * @author 燕
 *
 */
public class HeapSort {
	public  static void main(String[] args){
		int[] arr={26, 100, 30, 43, 43};
		HeapSort(arr,5);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	static void HeapAdjust(int arr[], int len, int unleaf)
	{
	    if(len<=0 || unleaf<=0)
	    return;
	    if(unleaf>len/2) //非叶子节点为小于等于len/2-1  的元素   如果unleaf>len/2，则exit of recursive 退出递归
	    return;
	    int lchild=2*unleaf+1;
	    int rchild=2*unleaf+2;
	    int max=unleaf;
	    int tmp;

	    if(lchild<len && arr[lchild]>arr[max])
	    max=lchild;
	    if(rchild<len && arr[rchild]>arr[max])
	    max=rchild;

	    if(max!=unleaf)
	    { 
	       tmp=arr[unleaf];
	       arr[unleaf]=arr[max];
	       arr[max]=tmp;
	       HeapAdjust(arr,len,max); //in case of invalid heap due to adjust 
	    }
	}

	static void BigHeapBuild(int arr[], int len)
	{
	   for(int i=len/2-1; i>=0; i--) //from the 1st un-leaf node
	    HeapAdjust(arr,len,i);
	}

	static void HeapSort(int arr[], int len)
	{
	   int tmp;
	   if(arr==null || len<=0)
	    return;

	   BigHeapBuild(arr,len);
	   //adjust heap
	   for(int i=len-1; i>1; i--)//when i=2, no need to adjust again
	   {
	     //exchange root with the i node
	       tmp=arr[i];
	       arr[i]=arr[0];
	       arr[0]=tmp;
	     //Adjust heap
	        HeapAdjust(arr,i-1,1);
	   }
	}
}
