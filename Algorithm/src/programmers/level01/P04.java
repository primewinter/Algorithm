package programmers.level01;

import java.util.Arrays;

public class P04 {

	public static void main(String[] args) {
		// Level 1 ��� ���ϱ� :: int �� �Ҽ����� �ƿ� ������.. ��� �Ҽ����� ������ ������ double�� �Ұ�!!
		int[] arr = {1,2,3,4};
		double answer = 0;
	    double sum = 0;
	    
	      for(int i = 0; i<arr.length ; i++) {
	          sum += arr[i];
	      }
	      answer = sum/arr.length;
	      System.out.println(answer);
	      //�ٸ� ��� Ǯ�� :: �Ϳ쳻..
	      int answerTwo =  (int) Arrays.stream(arr).average().orElse(0);
	      System.out.println(answerTwo);
	}

}
