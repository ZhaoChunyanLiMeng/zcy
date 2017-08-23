package org.lanqiao.quicksort;

public class MyQuickSortTest {
	
	public static void main(String[] args) {
		int[] nums={3,6,2,8,1,10,0};
		MyQuickSort .sort(nums, 0, nums.length-1);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
