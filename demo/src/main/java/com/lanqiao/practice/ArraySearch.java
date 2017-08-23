package com.lanqiao.practice;

import java.util.Scanner;

/**2017-7-27  1
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author 燕
 *
 */
public class ArraySearch {

	public static void main(String[] args) {
		int[][] intArr=new int[3][];
		intArr[0]=new int[]{3,6,9};
		intArr[1]=new int[]{4,7,10};
		intArr[2]=new int[]{5,8,11};
		ArraySearch arrSearch=new ArraySearch();
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你要寻找的数：");
		int num=input.nextInt();
		boolean searchResult=arrSearch.Find(num, intArr);
		if(searchResult){
			System.out.println("数组中有该整数");
		}else{
			System.out.println("对不起，寻找未果");
		}
		
	}
	boolean Find(int target, int[][] array) {
		boolean flag=false;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				if(array[i][j]==target){
				 flag=true;	
				}
			}
		}
		return  flag;
    }

}
//题库解题思路
/*public class Solution {
    public boolean Find(int target, int [][] array) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;

    }
}
*/