package org.lanqiao.bubble;
/**
 * 冒泡排序算法
 * @author 燕
 *
 */
public class MyBubble {
	
	public  static void bubbleSearch(int[] nums){
		for(int i=0;i<nums.length;i++){  //比对趟数     冒泡多少趟
			for(int j=0 ;j<nums.length-1-i;j++){//进行比较，排序
				int temp;
				if(nums[j]>nums[j+1]){//如果前面一个元素比后面元素大，则交换，把大的放在后面
					temp=nums[j];  //把前面一个大的元素给临时变量
					nums[j]=nums[j+1]; //把后面元素赋给前面一个元素
					nums[j+1]=temp;  //把大的元素赋值给后面一个元素
				}
			}
		}
		for (int i : nums) {
			System.out.println(i);
		}
	}
	
}
