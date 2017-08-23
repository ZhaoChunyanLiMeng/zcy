package org.lanqiao.sort;
/**
 * 希尔排序
 * 思路： 根据步进把数组分成各个不同步进间隔序列，然后对步进间隔序列进行希尔插入排序，缩小步进，继续进行
 * 时间复杂度：不确定O(nlgn)~O(n²)
 * 空间复杂度：O(1)
 * 原址排序
 * 不稳定：因为有可能分到不同补步进序列进行比较
 * @author 燕
 *
 */
public class _4ShellSort {
	 static void sort(int[] arr) {
		    if (arr.length == 1)
		      return;
		    /*选择增量为length/2，每次除以2*/
		    for (int interval = arr.length / 2; interval >= 1; interval/=2) {
		      sort( arr, 0, arr.length - 1, interval );
		    }
		  }

		  public static void sort(int[] arr, int low, int high, int interval) {
		    // 初始化i为0+interval，往前做插排
		    for (int i = low+interval; i < high+1; i++) {
		      int key = arr[i];
		      int pre = i-interval;
		      while(pre>=low&&arr[pre]>key){
		        arr[pre+interval] = arr[pre];
		        pre -= interval;
		      }
		      arr[pre+interval]=key;
		    }
		  }
}
