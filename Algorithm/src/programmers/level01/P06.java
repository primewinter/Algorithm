package programmers.level01;

import java.util.Arrays;
import java.util.stream.Stream;

public class P06 {
	//Level1 ���� ���� �� �����ϱ�
	public static int[] solution(int[] arr) {
		//���ڵ�
		if(arr.length == 1) {
			int[] answer = {-1};
			return answer;
		} else {
			int[] answer = new int[arr.length-1];
			
			return answer;
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,3,2,1};
		int[] b = {10};
		//System.out.println(solution(a));
		System.out.println(solution(b));

	}

}
