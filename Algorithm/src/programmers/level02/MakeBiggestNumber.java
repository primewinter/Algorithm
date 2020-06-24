package programmers.level02;

public class MakeBiggestNumber {
	/* 큰 수 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/42883
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number	k	return
1924	2	94
1231234	3	3234
4177252841	4	775841
출처
	 */
	public static String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        char max = '0';
        int count = 0;
        int startIdx = 0;
        int maxIdx = -1;
        for(int i=0; i<arr.length; i++) {
        	// 삭제 개수가 k이하인 범위 안에서 최대값 찾기
        	System.out.println(arr[i]+" vs "+max);
        	if(arr[i] > max) {
        		if(count <= k) {
        			max = arr[i];
        			if(i!=startIdx) {
        				count++;
        			}
        			maxIdx = i;
        			System.out.print("max : "+max);
        			System.out.print(" idx : "+maxIdx);
        			System.out.print(" k : "+k);
        			System.out.print(" 제외한 개수 : "+count+"\n");
        		}
        	} else {
        		count++;
        	}
        	
        	
        	// k범위 탐색이 끝났을 때
        	if(count==k) {
        		System.out.println(arr[i]+"에 이르렀을 때 리턴한다.");
        		answer += max;
        		i = maxIdx;
        		startIdx = maxIdx+1;
        		max = '0';
        		count = i-answer.length()+1;
        		System.out.println("answer : "+answer+"|idx:"+maxIdx+"|count : "+count+"|k : "+k+"\n");
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1924", 2));
		System.out.println();
		//System.out.println(solution("1231234", 3));
		System.out.println();
		System.out.println(solution("4177252841", 4));
		

	}

}
