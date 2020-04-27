package level01;

import java.util.Vector;

public class P12 {
	public static boolean solution(String s) {
	      boolean answer = true;
	      if( s.length() == 4 || s.length()==6) {
	          Integer.getInteger(s);
	      } else {
	          answer = false;
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String d = "a1234";
		System.out.println(Integer.getInteger(d));
		//System.out.println(solution(s));
		//System.out.println(3%10);
		
		//int[] answer = {};
		int[] arr= {1,1,3,3,0,0,1,1};
        Vector<Integer> a = new Vector<Integer>();
        
       
       for(int i = 1; i < arr.length; i++) {
           if(arr[i-1]!=arr[i]) {
               a.add(arr[i]);
           }
       }
       for(Integer tmp : a) {
    	   System.out.println("벡터에 담긴 수"+tmp);
       }
	}
}
	


