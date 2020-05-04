package level01;

import java.util.Arrays;

public class P23 {
	/* 프로그래머스 Lv1. 정수 내림차순으로 배치하기
	 * https://programmers.co.kr/learn/courses/30/lessons/12933
	 * 문제 설명
	함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
	
	제한 조건
	n은 1이상 8000000000 이하인 자연수입니다.
	입출력 예
	n	return
	118372	873211
	 */

	public static long solution(long n) {
		long answer = 0;
		String str = n+"";
		
		// <!---------리팩토링 후
		String[] strArr = str.split("");
		
		Arrays.parallelSort(strArr);
		for(int i=0; i<strArr.length; i++) {
			answer += Long.parseLong(strArr[i])*Math.pow(10, i);
		}
		// ----------------!>
		
		
		
		/*
		// <!---------리팩토링 전
		int len = str.length();

		String[] arr = new String[len];
		for(int i=0; i<str.length();i++) {
			arr[i] = str.charAt(i)+"";
		}
		
		Arrays.sort(arr);
		for(int i=arr.length-1; i>=0; i--) {
			answer += Integer.parseInt(arr[i])*Math.pow(10, --len);
		}
		// -----------------!>
		*/	      
		return answer;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(118372));

	}

}
