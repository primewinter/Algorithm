package baekjoon.level11.q10872;

import java.util.Scanner;

public class Main {
	/* ���丮��
	 * https://www.acmicpc.net/problem/10872
	 * ����
0���� ũ�ų� ���� ���� N�� �־�����. �̶�, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.

���
ù° �ٿ� N!�� ����Ѵ�.

����
�Է� 10
��� 3628800
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
