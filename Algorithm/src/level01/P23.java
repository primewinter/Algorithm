package level01;

import java.util.Arrays;

public class P23 {
	/* ���α׷��ӽ� Lv1. ���� ������������ ��ġ�ϱ�
	 * https://programmers.co.kr/learn/courses/30/lessons/12933
	 * ���� ����
	�Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���. ������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.
	
	���� ����
	n�� 1�̻� 8000000000 ������ �ڿ����Դϴ�.
	����� ��
	n	return
	118372	873211
	 */

	public static long solution(long n) {
		long answer = 0;
		String str = n+"";
		
		// <!---------�����丵 ��
		String[] strArr = str.split("");
		
		Arrays.parallelSort(strArr);
		for(int i=0; i<strArr.length; i++) {
			answer += Long.parseLong(strArr[i])*Math.pow(10, i);
		}
		// ----------------!>
		
		
		
		/*
		// <!---------�����丵 ��
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
