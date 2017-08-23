package org.lanqiao.shellsort;

public class MyShellSort2 {
	static void ShellSort(int[] arr) {
		//第一次
		int gap=arr.length/2;//5
		while(gap>0){
			for(int j=0;j<gap;j++){//j每一组的初始位置
			
				for(int i=j+gap;i<arr.length;i=i+gap){
				
					 if(arr[i]<arr[i-gap]){//前一个数 比后一个数大
					
						int temp=arr[i];
					
						int k=i-gap;
					
						while(k>=0&&temp<arr[k]){
							arr[k+gap]=arr[k];
							k=k-gap;
						}
							arr[k+gap]=temp;
					}
			 }
		}
		gap=gap/2;
	}

   }
}
