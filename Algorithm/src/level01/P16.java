package level01;

import java.util.ArrayList;

public class P16 {
	/*
	 * * https://programmers.co.kr/learn/courses/30/lessons/12921
	 * ���α׷��ӽ� Lv.1 �Ҽ�ã��
	 * ���� ����
	1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.
	
	�Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
	(1�� �Ҽ��� �ƴմϴ�.)
	
	���� ����
	n�� 2�̻� 1000000������ �ڿ����Դϴ�.
	����� ��
	n	result
	10	4
	5	3
	����� �� ����
	����� �� #1
	1���� 10 ������ �Ҽ��� [2,3,5,7] 4���� �����ϹǷ� 4�� ��ȯ
	
	����� �� #2
	1���� 5 ������ �Ҽ��� [2,3,5] 3���� �����ϹǷ� 3�� ��ȯ
	 */
	
	
	 // �� Ǯ�� : ����
	 public int solution(int n) {
	      int answer = 0;
	      boolean isPrime = true;
	      for(int i=2; i<=n; i++) {
	          if(i%2!=0) {
	              isPrime = true;
	              for(int j=3; j<i; j++) {
	                  if(i%j==0) { 
	                      isPrime = false;
	                      break;
	                  }
	              }
	              if(isPrime) {
	                  answer++;
	              }
	          }
	      }
	      return answer+1;
	  }

	
	
	// �ٸ� ��� Ǯ��1
	  public int solution2(int n) {
	      ArrayList<Integer> a = new ArrayList<Integer>();
	      a.add(2);
	      for(int i = 3; (n % 2 != 0) ? i <= n : i < n; i += 2) {
    	  // for���� ���� �� �ִ�!
	      // i) 3�� ������ ����	ii) i+=2(2�� ����)
	    	  
	          boolean flag = true;
	          for(int j = 0; j < a.size(); j++) {
	              if(i % a.get(j) == 0) {
	                  flag = false;
	                  break;
	              }
	          }
	          if(flag == true) {
	              a.add(i);
	          }
	      }
	      
	      return a.size();
	  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
