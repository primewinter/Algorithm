package level01;

public class P19 {
	
	/* ���α׷��ӽ� Lv1. ���� ������ �Ǻ�
	 * https://programmers.co.kr/learn/courses/30/lessons/12934
	���� ����
	������ ���� ���� n�� ����, n�� � ���� ���� x�� �������� �ƴ��� �Ǵ��Ϸ� �մϴ�.
	n�� ���� ���� x�� �����̶�� x+1�� ������ �����ϰ�, n�� ���� ���� x�� ������ �ƴ϶�� -1�� �����ϴ� �Լ��� �ϼ��ϼ���.
	
	���� ����
	n�� 1�̻�, 50000000000000 ������ ���� �����Դϴ�.
	����� ��
	n	return
	121	144
	3	-1
	����� �� ����
	����� ��#1
	121�� ���� ���� 11�� �����̹Ƿ�, (11+1)�� ������ 144�� �����մϴ�.
	
	����� ��#2
	3�� ���� ������ ������ �ƴϹǷ�, -1�� �����մϴ�.
	 * 
	 */
	
	 public long solution(long n) {
	      long answer = 0;
	      double root = Math.sqrt(n);
	      if(root==Math.round(root)) {
	          answer += (root+1)*(root+1);
	          // answer = (root+1)*(root+1);
	          // error: incompatible types: possible lossy conversion from double to long         
	      } else {
	          return -1;
	      }
	      return answer;
	  }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
