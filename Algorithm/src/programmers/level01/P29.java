package programmers.level01;

public class P29 {
	/*
	 * �ݶ��� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/12943
	 * ���� ����
	1937�� Collatz�� ����� ���� ����� �� ������, �־��� ���� 1�� �ɶ����� ���� �۾��� �ݺ��ϸ�, ��� ���� 1�� ���� �� �ִٴ� �����Դϴ�. �۾��� ������ �����ϴ�.
	
	1-1. �Էµ� ���� ¦����� 2�� �����ϴ�. 
	1-2. �Էµ� ���� Ȧ����� 3�� ���ϰ� 1�� ���մϴ�.
	2. ����� ���� ���� ���� �۾��� 1�� �� ������ �ݺ��մϴ�.
	���� ���, �Էµ� ���� 6�̶�� 6>3>10>5>16>8>4>2>1 �� �Ǿ� �� 8�� ���� 1�� �˴ϴ�. �� �۾��� �� ���̳� �ݺ��ؾ��ϴ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��� �ּ���. ��, �۾��� 500���� �ݺ��ص� 1�� ���� �ʴ´ٸ� -1�� ��ȯ�� �ּ���.
	
	���� ����
	�Էµ� ��, num�� 1 �̻� 8000000 �̸��� �����Դϴ�.
	����� ��
	n	result
	6	8
	16	4
	626331	-1
	����� �� ����
	����� �� #1
	������ ����� �����ϴ�.
	
	����� �� #2
	16 -> 8 -> 4 -> 2 -> 1 �̵Ǿ� �� 4������ 1�� �˴ϴ�.
	
	����� �� #3
	626331�� 500���� �õ��ص� 1�� ���� ���ϹǷ� -1�� �����ؾ��մϴ�.
	 */
	public static int solution(int num) {
		int num2 = num;
	      
		System.out.println(num+" || "+num2);
		for(int answer=1; answer <= 500; answer++) {
			if(num==1) { 
				return answer-1;
			}
			num = num%2==0?num/2:num*3+1; // ���� : int�� ������ �Ѿ�� �� 2�� ������ �������� 0�� �ȴ�.(�����Ⱚ�� ����ȴ�.) �׷��Ƿ�
			num2 = num2%2==1?num2*3+1:num2/2; // ���� : n%2==1 �� ���� ���͸��� �ϴ� ���� ����.
			if(answer==106) { System.out.println(num%2); }
			System.out.println(num+" || "+num2+" ("+answer+")");
		}
		
		return -1;
	}
	
	
	public static int solution2(int num) {
		int answer = 0;
		while(answer!=500) {
			if(num==1) { return answer; }
			if(num%2==0) {
				num /= 2;
				answer++;
			} else {
				num = num*3+1;
				answer++;
			}
		}
		
		return answer==500?-1:answer;
	}
	
	// �ٸ� ��� Ǯ�� : long Ÿ������ ����� �ϸ� �ȴ�!!!
	public int collatz(int num) {
	    long n = (long)num;
	    for(int i =0; i<500; i++){      
	      if(n==1) return i;
	      n = (n%2==0) ? n/2 : n*3+1;            
	    }
	    return -1;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(626331);

	}

}
