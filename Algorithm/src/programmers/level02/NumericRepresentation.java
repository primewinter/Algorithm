package programmers.level02;

public class NumericRepresentation {
	/* 숫자의 표현
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

	public static int solution3(int target) {
		if(target%2==0) {
			int midSum = target/2;
			int start = 0;
			if(midSum%2==1) {
				
			}
		}
		
		
		
		return 0;
	}
	
	
	public static int solution2(int target) {
        int answer = 0;
        int start = 1;
        while(start <= target/2) {
        	answer += represent2(start, target);
        	start++;
        }
        return answer+1;
    }
	
	public static int represent2(int start, int target) {
		int number = target/2;
		while(number>0) {
			if(number*(number+2*start-1) == 2*target) {
				return 1;
			} else {
				number--;
			}
		}
		return 0;
	}
	public static int solution(int target) {
        int answer = 0;
        int start = 1;
        int sum = 0;
        for(int i=start; i<=target; i++) {
        	sum += i;
        	if(sum==target) {
        		System.out.println("i = "+i);
        		answer++;
        		start++;
        		sum = 0;
        		i = start;
        		System.out.println(start+" "+i);
        	}
        }
        int cnt = target/2;
        while(cnt>=1) {
        	
        }
        System.out.println("중간 집계 "+answer);
        
        /*
        while(start <= target/2) {
        	int a = represent(number, start, target);
        	answer+=a;
        	start++;
        	if(a>0) {
        		number--;
        	}
        }
        */
        return answer;
    }
	
	public static int represent(int number, int start, int target) {
		if(number*(number+2*start-1) == 2*target) {
				return 1;
		}
		return 0;
	}
	
	public static int represent(int start, int target) {
		int number = target/2;
		while(number>0) {
			if(number*(number+2*start-1) == 2*target) {
				return 1;
			} else {
				number--;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(solution2(131));

	}

}
