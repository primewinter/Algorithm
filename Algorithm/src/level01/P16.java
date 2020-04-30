package level01;

import java.util.ArrayList;

public class P16 {
	/*
	 * * https://programmers.co.kr/learn/courses/30/lessons/12921
	 * 프로그래머스 Lv.1 소수찾기
	 * 문제 설명
	1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
	
	소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
	(1은 소수가 아닙니다.)
	
	제한 조건
	n은 2이상 1000000이하의 자연수입니다.
	입출력 예
	n	result
	10	4
	5	3
	입출력 예 설명
	입출력 예 #1
	1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
	
	입출력 예 #2
	1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
	 */
	
	
	 // 내 풀이 : 실패
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

	
	
	// 다른 사람 풀이1
	  public int solution2(int n) {
	      ArrayList<Integer> a = new ArrayList<Integer>();
	      a.add(2);
	      for(int i = 3; (n % 2 != 0) ? i <= n : i < n; i += 2) {
    	  // for문에 넣을 수 있다!
	      // i) 3항 연산자 가능	ii) i+=2(2씩 증가)
	    	  
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
