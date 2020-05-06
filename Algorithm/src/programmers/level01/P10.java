package programmers.level01;

public class P10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= 3;
		int b= 5;
		long answer = 0;
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		if(a == b) {
	          System.out.println(a);
	      } else {
	    	while(min <= max) {
	          answer += min;
	          min++;
	    	}
	      }
	}
}
