package programmers.level01;

public class P28 {
	/*x��ŭ ������ �ִ� n���� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/12954
	 * ���� ����
	�Լ� solution�� ���� x�� �ڿ��� n�� �Է� �޾�, x���� ������ x�� �����ϴ� ���ڸ� n�� ���ϴ� ����Ʈ�� �����ؾ� �մϴ�. ���� ���� ������ ����, ������ �����ϴ� �Լ�, solution�� �ϼ����ּ���.
	
	���� ����
	x�� -10000000 �̻�, 10000000 ������ �����Դϴ�.
	n�� 1000 ������ �ڿ����Դϴ�.
	����� ��
	x	n	answer
	2	5	[2,4,6,8,10]
	4	3	[4,8,12]
	-4	2	[-4, -8]
	 */
	 public long[] solution(int x, int n) {
	      long[] answer = new long[n];
	      for(int i=0; i<n; i++) {
	          answer[i] = (long)x*(i+1);
	      }
	      return answer;
	  }
	 
	 // �ٸ���� Ǯ��
	 public static long[] other(int x, int n) {
	        long[] answer = new long[n];
	        answer[0] = x;

	        for (int i = 1; i < n; i++) {
	            answer[i] = answer[i - 1] + x;
	        }

	        return answer;

	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
