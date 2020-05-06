package programmers.level01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P13 {
	
	 public static int solution(int n, int[] lost, int[] reserve) {
		 	List<Integer> losts = new ArrayList<>();
	        for(int i=0; i<lost.length; i++) {
	           losts.add(lost[i]);
	        }
    
	        List<Integer> reserves = new ArrayList<>();
	        for(int i=0; i<reserve.length; i++) {
	           reserves.add(reserve[i]);
	        }
	       
	        Iterator<Integer> iters = losts.iterator();
	        Iterator<Integer> iters2 = reserves.iterator();
    
	        Integer num;
	        Integer num2;
	         while(iters.hasNext()) {
	        	 boolean flag = false;
	        	 num = iters.next();
	             while(iters2.hasNext()) {
	                 num2 = iters2.next();
	                 System.out.println(num+", "+num2);
	                 if(num-1 == num2 || num+1 == num2 || num == num2){
	                     iters2.remove();
	                     flag = true;
	                     System.out.println(flag);
	                     break;
	                 }
	             }
	             if(flag==true) {
	            	 iters.remove();
	            	 System.out.println("losts : "+losts);
	             }
	         }
	        return n-losts.size();
	    }
	 
	 public static void main(String[] args) {
		 int n = 30;
		 int[] a = {11,12,2,4};
		 int[] b = {10,9};
		System.out.println("Á¤´ä : "+solution(n, a, b));
		}

}
