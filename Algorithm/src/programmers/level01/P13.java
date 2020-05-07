package programmers.level01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P13 {
	/*체육복
	 * https://programmers.co.kr/learn/courses/30/lessons/42862
	 * 문제 설명
	점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
	
	전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	전체 학생의 수는 2명 이상 30명 이하입니다.
	체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
	여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
	입출력 예
	n	lost	reserve	return
	5	[2, 4]	[1, 3, 5]	5
	5	[2, 4]	[3]	4
	3	[3]	[1]	2
	입출력 예 설명
	예제 #1
	1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
	
	예제 #2
	3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
	
	출처
	
	※ 공지 - 2019년 2월 18일 지문이 리뉴얼되었습니다.
	※ 공지 - 2019년 2월 27일, 28일 테스트케이스가 추가되었습니다.
	 */
	
	// 다시 푼 거
	public static int solution(int n, int[] lost, int[] reserve) {
		int[] clothes = new int[n];
		for(int r : reserve) {
			clothes[r-1]++;
		}
		for(int l : lost) {
			clothes[l-1]--;
		}
		
		
		int answer = 0;
		for(int i=0; i<n-1; i++) {
			if(clothes[i]+clothes[i+1]==0) {
				clothes[i] = 0;
				clothes[i+1] = 0;
			}
		}
		
		for(int i=0; i<n-1; i++) {
			if(clothes[i]+clothes[i+1]==-1) {
				answer--;
				clothes[i]=0;
				clothes[i+1]=0;
			} else if(clothes[i]+clothes[i+1]==-2) {
				answer -= 2;
				clothes[i]=0;
				clothes[i+1]=0;
			}
		}
		
		return n+answer;
	}
	
	// 처음 풀었을 때 못 푼 거
	 public static int solution1(int n, int[] lost, int[] reserve) {
		 	List<Integer> losts = new ArrayList<>();
	        for(int i=0; i<lost.length; i++) {
	           losts.add(lost[i]);
	        }
    
	        List<Integer> reserves = new ArrayList<>();
	        for(int i=0; i<reserve.length; i++) {
	           reserves.add(reserve[i]);
	        }
	       
	        Iterator<Integer> iters = losts.iterator();
	        Iterator<Integer> iters2 = reserves.iterator();
    
	        Integer num;
	        Integer num2;
	         while(iters.hasNext()) {
	        	 boolean flag = false;
	        	 num = iters.next();
	             while(iters2.hasNext()) {
	                 num2 = iters2.next();
	                 System.out.println(num+", "+num2);
	                 if(num-1 == num2 || num+1 == num2 || num == num2){
	                     iters2.remove();
	                     flag = true;
	                     System.out.println(flag);
	                     break;
	                 }
	             }
	             if(flag==true) {
	            	 iters.remove();
	            	 System.out.println("losts : "+losts);
	             }
	         }
	        return n-losts.size();
	    }
	 
	 public static void main(String[] args) {
		 int n = 30;
		 int[] a = {11,12,2,4}; // 잃어버린 애들
		 int[] b = {10,9}; // 여분 있는 애들
		System.out.println("정답 : "+solution(n, a, b));
		System.out.println("정답 ; "+solution(10, new int[] {1,2,3}, new int[] {8,9,10}));
		
//		System.out.println("정답 : "+solution(5, new int[] {2,4}, new int[] {1,3,5}));
//		System.out.println("정답 : "+solution(5, new int[] {2,4}, new int[] {3}));
//		System.out.println("정답 : "+solution(3, new int[] {3}, new int[] {1}));
//		System.out.println("정답 : "+solution(2, new int[] {1}, new int[] {1}));
	}

}
