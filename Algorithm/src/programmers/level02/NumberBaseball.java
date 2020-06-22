package programmers.level02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class NumberBaseball {
	/* 숫자야구
	 * https://programmers.co.kr/learn/courses/30/lessons/42841
	 * 문제 설명
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
입출력 예
baseball	return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
입출력 예 설명
문제에 나온 예와 같습니다.
	 */

	
	// 감자면 풀이
	public static int solution(int[][] baseball) {
		
		Stack<String> all = new Stack<>();
		for(int i=123; i<=987; i++) {
			String num = String.valueOf(i);
			if(num.contains("0")||num.charAt(0)==num.charAt(1)||num.charAt(1)==num.charAt(2)||num.charAt(0)==num.charAt(2)) {
				continue;
			} 
			all.add(num);
		}
		 // 답이 되는 숫자를 저장한 ArrayList answer 
        ArrayList<String> answer = new ArrayList<String>();

		 // 모든 경우의 수를 확인, 완전탐색
        while( !all.isEmpty() ) {
            // baseball과 비교할 숫자 target 
            String target = all.pop();
            
            boolean flag = false;
            
            for(int i = 0; i < baseball.length; i++) {
                // 주어진 숫자(baseball)과 현재 비교하는 수(target)의 스트라이크 수치 
                int strike = strike(target, String.valueOf(baseball[i][0]));
                
                // 주어진 숫자(baseball)과 현재 비교하는 수(target)의 볼 수치
                // 스트라이크 또한 숫자는 같기 때문에 볼을 구하기 위해 스트라이크를 제거 
                int ball = ball(target, String.valueOf(baseball[i][0])) - strike;
                
                // 스트라이크와 볼 둘 중에 하나라도 같지 않을 경우 정답이 될 수 없음 
                if( strike != baseball[i][1] || ball != baseball[i][2] ) {
                    flag = true;
                    break;
                }
            }
            
            // flag = false만 동작 
            if(!flag) {
                answer.add(target);
            }
        }

        return answer.size();

	}
	
	// 스트라이크를 구하는 메소드 
    // s1 = target, s2 = baseball[i, 0] 
    public static int strike(String s1, String s2) {
        int count = 0;
        
        for(int i = 0; i < 3; i++) {
            // 위치와 숫자가 같을 경우에만 스트라이크 값 증가 
            if ( s1.charAt(i) == s2.charAt(i) ) {
                count++;
            }
        }
        
        return count;
    }

    // 볼을 구하는 메소드 
    // s1 = target, s2 = baseball[i, 0] 
    public static int ball(String s1, String s2) {
        int count = 0;

        for(int i = 0; i < 3; i++) {
            // 위치는 고려하지 않은 채 숫자가 같을 경우에 볼 값 증가 
            // 이 경우 스트라이크 또한 숫자가 같은 경우이기 때문에 count는 볼 + 스트라이크 값이 됨 
            if ( s1.contains( Character.toString(s2.charAt(i) ) ) ) {
                count++;
            }
        }

        return count;
    }
	
	// 시도했다가 실패
	public static int fail(int[][] baseball) {
		int answer = 0;
		HashSet<Integer> first = new HashSet<>();
		HashSet<Integer> second = new HashSet<>();
		HashSet<Integer> third = new HashSet<>();
		for(int i=0; i<baseball.length; i++) {
			int nums = baseball[i][0];
			Integer hundred = nums/100;
			Integer ten = (nums%100)/10;
			Integer one = nums%10;
			/*
			// 따로 설정
			if(baseball[i][1]>0) {
				first.add(hundred);
				second.add(ten);
				third.add(one);
			} else if(baseball[i][1]==0) {
				first.remove(hundred);
				second.remove(ten);
				third.remove(one);
			}
			
			if(baseball[i][2]>0) {
				first.add(ten);
				first.add(one);
				second.add(hundred);
				second.add(one);
				third.add(hundred);
				third.add(ten);
			} else if (baseball[i][2]==0){
				first.remove(ten);
				first.remove(one);
				second.remove(hundred);
				second.remove(one);
				third.remove(hundred);
				third.remove(ten);
			}
			 */
			///*
			// 동시 설정
			if(baseball[i][1]>0 && baseball[i][2]==0) { // n 스트라이크, 0 볼
				first.add(hundred);
				first.remove(ten);
				first.remove(one);
				second.add(ten);
				second.remove(hundred);
				second.remove(one);
				third.add(one);
				third.remove(hundred);
				third.remove(ten);
			} else if (baseball[i][1]==0 && baseball[i][2]>0) { // 0스트라이크, n볼
				first.remove(hundred);
				first.add(ten);
				first.add(one);
				second.remove(ten);
				second.add(hundred);
				second.add(one);
				third.remove(one);
				third.add(hundred);
				third.add(ten);
			} else if (baseball[i][1]==0 && baseball[i][2]==0) { // 3아웃일때
				first.remove(hundred);
				first.remove(ten);
				first.remove(one);
				second.remove(ten);
				second.remove(hundred);
				second.remove(one);
				third.remove(one);
				third.remove(hundred);
				third.remove(ten);
			} else if (baseball[i][1]==1 && baseball[i][2]==2) {
				
			}
			//*/
			
			System.out.println("\n\n1의 자리 후보");
			for(Integer a : first) {
				System.out.print(a+" ");
			}
			System.out.println("\n2의 자리 후보");
			for(Integer a : second) {
				System.out.print(a+" ");
			}
			System.out.println("\n3의 자리 후보");
			for(Integer a : third) {
				System.out.print(a+" ");
			}
		}
		
		return first.size()*second.size()*third.size();
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] baseball = new int[][] {{123, 1, 1}, {356,1,0}, {327,2,0}, {489,0,1}};
		System.out.println("\n 숫자야구 정답 : "+solution(baseball)); //return 2

	}

}
