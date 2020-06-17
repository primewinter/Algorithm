package baekjoon.level11.q10872;

import java.util.Scanner;

public class Main {
	/* 팩토리얼
	 * https://www.acmicpc.net/problem/10872
	 * 문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.

예시
입력 10
출력 3628800
	 */

	public static long factorial(long n) {
		if(n<=1) {
			return 1;
		}
		return factorial(n-1)*n;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner (System.in);
		System.out.println(factorial(scan.nextInt()));

	}

}
