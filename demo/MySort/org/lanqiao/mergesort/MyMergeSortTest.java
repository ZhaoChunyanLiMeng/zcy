package org.lanqiao.mergesort;

import java.util.Arrays;

public class MyMergeSortTest {

	public static void main(String[] args) {
		 int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		 MyMergeSort.megerSort(a, 0,a.length-1);
	       for (int i : a) {
			System.out.println(i);
		}
	}
}
