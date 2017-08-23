package org.lanqiao.recursionpractice;
/**1
 * 爬楼梯 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 * 请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 从上而下思考问题，当小孩抵达第n阶台阶时，他有可能是  从n-1阶走一步||从n-2阶走两步||从n-3阶走三步 ，
 * 其实就是n-1阶走法，n-2阶走法，n-3阶走法之和
 * @author 燕
 */
public class ClimbTheStairs {
	public static int countWays(int n){
		if(n<0){
			return 0;
		}else if(n==0){
			return 1;
		}else{
			return countWays(n-1)+countWays(n-2)+countWays(n-3);
		}
	}
	/**
	 * 写main()函数测试一下
	 */
	public static void main(String[] args){
		int waysCount=ClimbTheStairs.countWays(1);
		System.out.println("上楼梯的方法有多少种："+waysCount);
	}
}
