package programmers.level02;

public class NextLargerNumber {
	/* ���� ū ����(+3)
	 * https://programmers.co.kr/learn/courses/30/lessons/12911
	 * ���� ����
�ڿ��� n�� �־����� ��, n�� ���� ū ���ڴ� ������ ���� ���� �մϴ�.

���� 1. n�� ���� ū ���ڴ� n���� ū �ڿ��� �Դϴ�.
���� 2. n�� ���� ū ���ڿ� n�� 2������ ��ȯ���� �� 1�� ������ �����ϴ�.
���� 3. n�� ���� ū ���ڴ� ���� 1, 2�� �����ϴ� �� �� ���� ���� �� �Դϴ�.
���� �� 78(1001110)�� ���� ū ���ڴ� 83(1010011)�Դϴ�.

�ڿ��� n�� �Ű������� �־��� ��, n�� ���� ū ���ڸ� return �ϴ� solution �Լ��� �ϼ����ּ���.

���� ����
n�� 1,000,000 ������ �ڿ��� �Դϴ�.
����� ��
n	result
78	83
15	23
����� �� ����
����� ��#1
���� ���ÿ� �����ϴ�.
����� ��#2
15(1111)�� ���� ū ���ڴ� 23(10111)�Դϴ�.
	 */
	public static int solution(int n) {
        int cnt = Integer.bitCount(n);
        int answer = n;
        while(true) {
        	answer++;
        	if(cnt == Integer.bitCount(answer)) {
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���� : "+solution(78));

	}

}
