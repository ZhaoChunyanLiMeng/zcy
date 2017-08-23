package org.lanqiao.select;
/**
 * 选择排序，没尽兴一次选择，把最小的数放在选择圈数i位置
 * @author 燕
 *
 */
public class MySelect {
	public static void selectSort(int[] nums){
		int position=0;
		for(int i=0;i<nums.length;i++){  //第i次转圈选择，选择趟数 
			int j=i+1;
			position=i; //用来记录最小元素位置，起始赋值为第几圈选择
			int temp=nums[i];
			for(;j<nums.length;j++){
				if(nums[j]<temp){
					temp=nums[j]; //把最小的元素赋给temp
					position=j;//记录下这一圈循环最小元素的位置
				}
		    }     //到此才循环完一圈，要注意
			nums[position]=nums[i];//循环完这一圈，把最小元素位置换成nums[i]
			nums[i]=temp;//把这次循环的头元素，换成最小元素
		}
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
