package org.lanqiao.practice;

public class SearchKTest {

	public static void main(String[] args) {
		int arr[] = {7, 8, 9, 1, 2, 3, 6, 5, 4};  
		int size = arr.length;  
		int k = 8;  
		int kNum = SearchK.findKth(arr, size, k);
		System.out.println("第八大的元素是："+kNum);
	}

}
