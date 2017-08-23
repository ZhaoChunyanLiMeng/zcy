package org.lanqiao.practice;

import org.lanqiao.select.MySelect;

/**
 * 题一：给定一个整数序列，求第K大的元素
 * 找第K大元素，其实就是顺序排序找第 n-k 个元素！！！！！！
 * @author 燕
 *
 */
public class SearchK {
	// 利用快速排序寻找第k大元素  
	public static int findKth(int arr[], int n, int k)  
	{  
	  int position = -1;  
	  int i = 0;  
	  int j = n-1;  
	  while(true)  
	  {  
	      position = MyQuickSort.partition(arr, i, j);
	      if(position < n-k)    //当基准元素在n-k左边时，则需要到 [position+1,n-1]区间找第K大元素
	     {  
	          i = position+1;     
	          j = n-1;  
        }  
       else if(position >n- k)  //当基准元素在n-k右边时，则需要到 [0,position-1]区间找第K大元素
       {  
	          i = 0;  
	          j = position-1;  
        }  
      else return arr[position];  //最后第 n-k 与 position 重合，返回 n-k下标元素
	   }
}  

}
