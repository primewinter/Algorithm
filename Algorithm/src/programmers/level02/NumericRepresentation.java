package programmers.level02;

public class NumericRepresentation {
	/* 숫자의 표현(+4)
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 * 	문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
입출력 예 설명
문제에 나온 예와 같습니다.
	 */

	public static int solution(int target) {
		int answer = 0;
        int count = 2;
        while(count <= target/2) {
        	answer += represent(count, target);
        	count++;
        }
        return answer+1;
	}
	
	public static int represent(double count, double target) {
		double startNum = -count/2+0.5+target/count;
		if(startNum>0 && startNum == (int)startNum) {
			System.out.println(startNum);
			return 1;
		} else {
			return 0;
		}
	}
	
	
	// 다른 사람의 풀이 : 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다.
	public int expressions(int num) {
	        int answer = 0;
	        for (int i = 1; i <= num; i += 2) {
	            if (num % i == 0) {
	                answer++;
	            }
	        }
	        return answer;
	}
	
	// 다른 사람 풀이 2
	public int other2(int num) {
        int answer = 0;

	    for(int fNum=1; fNum <= num; fNum++){
	    	int chkNum = 0;
	        for(int sNum=fNum; sNum <=num; sNum++){
	         chkNum = chkNum + sNum;
	
	         if(chkNum == num){
	             answer++;
	             break;
	         }else if(chkNum > num){
	             break;
	         }
	      }
	      //chkNum = 0;
	    }

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println("답 : "+solution(18));

	}

}
