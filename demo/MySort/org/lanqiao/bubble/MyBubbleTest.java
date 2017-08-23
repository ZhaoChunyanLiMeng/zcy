package org.lanqiao.bubble;

public class MyBubbleTest {

	public static void main(String[] args) {
		int[] nums={3,6,2,8,1,10,0};
		//MyBubble my=new MyBubble();
		//my.bubbleSearch(nums);
		MyBubble.bubbleSearch(nums);//冒泡排序方法设成静态方法后，用类名.方法名调用冒泡排序方法，把nums传入即可
	}

}
