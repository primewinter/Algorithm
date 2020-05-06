package programmers.level01;

import java.util.Arrays;

public class P04 {

	public static void main(String[] args) {
		// Level 1 평균 구하기 :: int 는 소수점을 아예 버린다.. 고로 소수점을 포함한 연산은 double로 할것!!
		int[] arr = {1,2,3,4};
		double answer = 0;
	    double sum = 0;
	    
	      for(int i = 0; i<arr.length ; i++) {
	          sum += arr[i];
	      }
	      answer = sum/arr.length;
	      System.out.println(answer);
	      //다른 사람 풀이 :: 와우내..
	      int answerTwo =  (int) Arrays.stream(arr).average().orElse(0);
	      System.out.println(answerTwo);
	}

}
