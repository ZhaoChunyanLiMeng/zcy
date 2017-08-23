package org.lanqiao.shellsort;

public class MyShellSort2Test {

	public static void main(String[] args) {
		int[] nums={8,9,1,7,2,3,5,4,6,0};
		MyShellSort2.ShellSort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
