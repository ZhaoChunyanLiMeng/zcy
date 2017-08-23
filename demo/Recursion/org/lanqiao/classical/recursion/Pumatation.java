package org.lanqiao.classical.recursion;

public class Pumatation {
	
	    public void  getPermutation(String A) {
	       char[] str=A.toCharArray();
	        int len=str.length;
	        int from=0;
	        int to=len-1;
	        Permutation(str,from,to);
	    }

		private void Permutation(char[] str, int from, int to) {
			if(to<=1){
	            return;
	        }
	        if(from==to){
	            System.out.println(str);
	        }else{
	            for(int i=from;i<=to;i++){
	                swap(str,from,i);
	                Permutation(str,from+1,to);
	                swap(str,i,from);
	            }
	        }
			
		}

		private void swap(char[] str, int i, int j) {
			char temp=str[i];
	        str[i]=str[j];
	        str[j]=temp;
			
		}

		

}
