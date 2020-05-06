package programmers.level01;

import java.util.Arrays;
import java.util.stream.Stream;

public class P06 {
	//Level1 제일 작은 수 제거하기
	public static int[] solution(int[] arr) {
		//내코딩
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
