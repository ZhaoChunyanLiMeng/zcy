package org.lanqiao.practice;
/**
 * 
 * @author 燕
 *
 */
public class SearchArrMin {
	/**
     * 找出未出现的最小正整数
     */
    public static int findArrayMex(int[] a,int n){
        int count = n;
        int temp = 0;
        int dir = 1;
        int num = 0;
        for(int i = 0;i<count-1;i++){
            if(a[i]>a[i+1]){
                temp = a[i];
                a[i]= a[i+1];
                a[i+1] = temp;        
            }
            if(i==count-2){
                count--;
                i=-1;
            }
        }
        if(a[0]>1 || a[n-1]<1){
            return 1;
        }else {
            for(int i =0;i<n-1;i++){
                if(a[i]>0){
                    num = i;
                    break;
                }                
            }
            if(a[num]>1){
                return 1;
            }else if(a[num]==1) {
                for(int i =num+1;i<n-1;i++){
                    if(a[i]-a[num]>dir){
                        return a[num]+dir;
                    }else {
                        dir++;
                    }
                }
            }
        }
        return a[num]+dir;
    }
}
