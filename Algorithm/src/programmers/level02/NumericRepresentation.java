package programmers.level02;

public class NumericRepresentation {
	/* ������ ǥ��
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 * 	���� ����
n���� ���� �ƴ� ������ �ֽ��ϴ�. �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�. ���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־��� �� ���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�־����� ������ ������ 2�� �̻� 20�� �����Դϴ�.
�� ���ڴ� 1 �̻� 50 ������ �ڿ����Դϴ�.
Ÿ�� �ѹ��� 1 �̻� 1000 ������ �ڿ����Դϴ�.
����� ��
numbers	target	return
[1, 1, 1, 1, 1]	3	5
����� �� ����
������ ���� ���� �����ϴ�.
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
        System.out.println("�߰� ���� "+answer);
        
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
