package org.lanqiao.classical.recursion;


/**
 * 汉诺塔  有N个盘子，从大到小排放， 把这N个盘子从柱子A移动到柱子C，移动到C后，也是从小到大排序
 * @author 燕
 *
 */
public class TowerOfHanoi {
	 public static void main(String[] args) {
	        new TowerOfHanoi().printHanoiTower(3, "A", "B", "C");
	    }

	void printHanoiTower(int N,String source,String helpe,String target){
		if(N==1){
			System.out.println("move"+N+"from"+source+"to"+target);//N的时候，直接把N放到target里
		}else{
			printHanoiTower(N-1,source,target,helpe);//先把N-1个从source移到helpe
			System.out.println("move"+N+"from"+source+"to"+target);
			printHanoiTower(N-1,helpe,source,target);//然后把这N-1个从helpe里移动到target
		}
	}
}
