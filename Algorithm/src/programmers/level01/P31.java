package programmers.level01;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P31 {
	/* 다트게임
	 * https://programmers.co.kr/learn/courses/30/lessons/17682
	 * 카카오 해설: https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
	 * 문제 설명
	다트 게임
	카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
	
	Game Star
	
	카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
	갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
	
	다트 게임은 총 3번의 기회로 구성된다.
	각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
	점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
	옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
	스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
	스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
	스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
	스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
	
	입력 형식
	점수|보너스|[옵션]으로 이루어진 문자열 3세트.
	예) 1S2D*3T
	
	점수는 0에서 10 사이의 정수이다.
	보너스는 S, D, T 중 하나이다.
	옵선은 *이나 # 중 하나이며, 없을 수도 있다.
	출력 형식
	3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
	예) 37
	
	입출력 예제
	예제	dartResult	answer	설명
	1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
	2	1D2S#10S	9	12 + 21 * (-1) + 101
	3	1D2S0T	3	12 + 21 + 03
	4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
	5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
	6	1T2D3D#	-4	13 + 22 + 32 * (-1)
	7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
	 */

	// 한 글자씩 잘라서 계산
	public static int solution(String dartResult) {
	    double[] score = new double[3];
        char[] chArr = dartResult.toCharArray();
        int idx = 0;
        for(int i=0; i<chArr.length; i++) {
        	System.out.println(idx+"번째 점수 ::");
        	
        	if(chArr[i]>='0' && chArr[i]<='9') {
        		if(i<=chArr.length-1&&chArr[i+1]=='0') {
        			//score[idx] = Character.getNumericValue(chArr[i])*10+Character.getNumericValue(chArr[i+1]);
        			score[idx] = 10;
        			System.out.println(score[idx]);
        			idx++;
        			i++;
        		} else {
        			score[idx] = Character.getNumericValue(chArr[i]);
        			System.out.println(score[idx]);
        			idx++;
        		}
        	} else if(chArr[i]=='S'||chArr[i]=='D'||chArr[i]=='T') {
        		
        		if(chArr[i]=='D') {
        			score[idx-1] = Math.pow(score[idx-1], 2);
        			System.out.println("["+(idx-1)+"]를 제곱 :"+score[idx-1]);
        		}
        		if(chArr[i]=='T') {
        			score[idx-1] = Math.pow(score[idx-1], 3);
        			System.out.println("["+(idx-1)+"]를 세제곱 :"+score[idx-1]);
        		}
        	} else {
        		
        		if(chArr[i]=='*') {
        			score[idx-1] *=2;
        			System.out.println("** ["+(idx-1)+"]를 2배로 : "+score[idx-1]);
        			if(idx>=2) {
        				score[idx-2] *=2;
        				System.out.println("** ["+(idx-2)+"]도 2배로: "+score[idx-2]);
        			}
        		} else if(chArr[i]=='#') {
        			score[idx-1] *= -1;
        			System.out.println("## ["+(idx-1)+"]를 음수로 : "+score[idx-1]);
        		}
        	}
        	
        }
        
        for(int i=0; i<3;i++) {
        	System.out.println("최종:"+score[i]);
        }
        
        return (int)(score[0]+score[1]+score[2]);
    }
	
	// 정규표현식 이용한 한솔쓰 풀이
	  public static int other(String dartResult) {
	        int answer = 0;
	        Pattern pattern = Pattern.compile("\\d+|[SDT]|\\#|\\*");
	        Matcher matcher = pattern.matcher(dartResult);
	        int num = 0;
	        List<Integer> calcList = new ArrayList<>();;
	        
	        while(matcher.find()){
	            String letter = matcher.group();
	            System.out.println(letter);
	            int clSize = calcList.size();
	            
	            if(letter.matches("\\d+")) {
	                num = Integer.parseInt(letter);
	            } else if(letter.matches("[SDT]")) { 
	                answer = num;
	                if(letter.equals("D")){
	                    answer = num * num;
	                } else if(letter.equals("T")){
	                    answer = num * num * num;
	                }
	                calcList.add(answer);
	            } else if(letter.equals("*")){
	                if(clSize != 1) {
	                    calcList.set(clSize - 2, calcList.get(clSize - 2) * 2);
	                }
	                calcList.set(clSize - 1, calcList.get(clSize - 1) * 2);
	            } else if(letter.equals("#")){
	                calcList.set(clSize - 1, calcList.get(clSize - 1) * (-1));
	            }
	        }
	        return calcList.get(0) + calcList.get(1) + calcList.get(2);
	    }

	
	// 정규표현식 이용해서 풀어보기 
	public static int solution2(String dartResult) {
	    String regExp = "[A-Z]";
	    String[] shots = dartResult.split(regExp);
	    for(int i=0; i<shots.length;i++) {
	    	System.out.println(shots[i]);
	    }
	    
	    return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("정답 :"+solution("1S2D*3T"));
		System.out.println("정답 :"+other("10S*2T*3S"));
	}

}
