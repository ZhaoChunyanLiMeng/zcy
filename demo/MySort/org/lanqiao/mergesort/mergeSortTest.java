package org.lanqiao.mergesort;

public class mergeSortTest {

	public static void main(String[] args) {
		 int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		 int[] temp=new int[a.length];
		 QmergeSort.mergeSort(a, 0, a.length-1, temp);
		 for (int i : temp) {
			System.out.println(i);
		}
	}

}
