package programmers.level02;

import java.math.BigInteger;

public class Fibonacci {
	/* 피보나치 수(+10)
	 * https://programmers.co.kr/learn/courses/30/lessons/12945
	 * 문제 설명
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
* n은 1이상, 100000이하인 자연수입니다.

입출력 예
n	return
3	2
5	5
입출력 예 설명
피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
	 */
	public static int solution(int n) {
		BigInteger[] fArr = new BigInteger[n+1];
		fArr[0] = BigInteger.valueOf(0);
		fArr[1] = BigInteger.valueOf(1);
		for(int i=2; i<=fArr.length-1; i++) {
			fArr[i] = fArr[i-1].add(fArr[i-2]);
		}
		
		BigInteger answer = fArr[n].remainder(BigInteger.valueOf(1234567)); 
		return answer.intValue();
	}
	
	
	// 다른 사람 풀이
	public static int other(int n) {
        int answer = 0;
        long[] pib=new long[n+1];
        pib[0]=0L;
        pib[1]=1L;
        for(int i=2; i<=n; i++){
            pib[i]=(pib[i-1]+pib[i-2])%1234567L; // 처음부터 나눈 값을 배열에 넣어서 long 범위 안에서 풀리도록 했다.
            System.out.println(i+"번째 : "+pib[i]);
        }
        answer=(int)(pib[n]);
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(other(500));
		System.out.println(solution(500));

	}

}
