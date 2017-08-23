package org.lanqiao.shellsort;

public class MyShellSortTest {

	public static void main(String[] args) {
		//int[] nums={3,6,2,8,1,10,0,22,56,89,13};
		int[] nums={8,9,1,7,2,3,5,4,6,0};
		MyShellSort.shellSort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
