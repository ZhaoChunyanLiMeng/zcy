package org.lanqiao.binarysearch;
/**
 * 二分法查找
 * @author 燕
 *
 */
public class MyBinarySearch {
	
	public static int binarySearch(int[ ] nums,int num){
		int low = 0;
		int high = nums.length-1;
		while(low<high){
			int mid=(low+high)/2;
			if(num>nums[mid]){
				low=mid+1;
			}else if(num<nums[mid]){
				high=mid-1;
			}else{
				return  mid;
			}
		}
		return  -1;
		 
	 }
}
