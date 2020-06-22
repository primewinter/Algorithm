package programmers.level02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class NumberBaseball {
	/* ���ھ߱�
	 * https://programmers.co.kr/learn/courses/30/lessons/42841
	 * ���� ����
���� �߱� �����̶� 2���� ���ΰ� ������ ���ڸ� ���ߴ� �����Դϴ�. �����غ���

���� ���� �ٸ� 1~9���� 3�ڸ� ������ ���ڸ� ���� �� ���ο��� 3�ڸ��� ���ڸ� �ҷ��� ����� Ȯ���մϴ�. �׸��� �� ����� ���� ��밡 ���� ���ڸ� ������ �� �����ϴ�.

* ���ڴ� ������, ��ġ�� Ʋ���� ���� ��
* ���ڿ� ��ġ�� ��� ���� ���� ��Ʈ����ũ
* ���ڿ� ��ġ�� ��� Ʋ���� ���� �ƿ�
���� ���, �Ʒ��� ��찡 ������

A : 123
B : 1��Ʈ����ũ 1��.
A : 356
B : 1��Ʈ����ũ 0��.
A : 327
B : 2��Ʈ����ũ 0��.
A : 489
B : 0��Ʈ����ũ 1��.
�̶� ������ ���� 324�� 328 �� �����Դϴ�.

������ �� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ���� ���� 2���� �迭 baseball�� �Ű������� �־��� ��, ������ ���� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
������ ���� 1 �̻� 100 ������ �ڿ����Դϴ�.
baseball�� �� ���� [�� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ��] �� ��� �ֽ��ϴ�.
����� ��
baseball	return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
����� �� ����
������ ���� ���� �����ϴ�.
	 */

	
	// ���ڸ� Ǯ��
	public static int solution(int[][] baseball) {
		
		Stack<String> all = new Stack<>();
		for(int i=123; i<=987; i++) {
			String num = String.valueOf(i);
			if(num.contains("0")||num.charAt(0)==num.charAt(1)||num.charAt(1)==num.charAt(2)||num.charAt(0)==num.charAt(2)) {
				continue;
			} 
			all.add(num);
		}
		 // ���� �Ǵ� ���ڸ� ������ ArrayList answer 
        ArrayList<String> answer = new ArrayList<String>();

		 // ��� ����� ���� Ȯ��, ����Ž��
        while( !all.isEmpty() ) {
            // baseball�� ���� ���� target 
            String target = all.pop();
            
            boolean flag = false;
            
            for(int i = 0; i < baseball.length; i++) {
                // �־��� ����(baseball)�� ���� ���ϴ� ��(target)�� ��Ʈ����ũ ��ġ 
                int strike = strike(target, String.valueOf(baseball[i][0]));
                
                // �־��� ����(baseball)�� ���� ���ϴ� ��(target)�� �� ��ġ
                // ��Ʈ����ũ ���� ���ڴ� ���� ������ ���� ���ϱ� ���� ��Ʈ����ũ�� ���� 
                int ball = ball(target, String.valueOf(baseball[i][0])) - strike;
                
                // ��Ʈ����ũ�� �� �� �߿� �ϳ��� ���� ���� ��� ������ �� �� ���� 
                if( strike != baseball[i][1] || ball != baseball[i][2] ) {
                    flag = true;
                    break;
                }
            }
            
            // flag = false�� ���� 
            if(!flag) {
                answer.add(target);
            }
        }

        return answer.size();

	}
	
	// ��Ʈ����ũ�� ���ϴ� �޼ҵ� 
    // s1 = target, s2 = baseball[i, 0] 
    public static int strike(String s1, String s2) {
        int count = 0;
        
        for(int i = 0; i < 3; i++) {
            // ��ġ�� ���ڰ� ���� ��쿡�� ��Ʈ����ũ �� ���� 
            if ( s1.charAt(i) == s2.charAt(i) ) {
                count++;
            }
        }
        
        return count;
    }

    // ���� ���ϴ� �޼ҵ� 
    // s1 = target, s2 = baseball[i, 0] 
    public static int ball(String s1, String s2) {
        int count = 0;

        for(int i = 0; i < 3; i++) {
            // ��ġ�� ������� ���� ä ���ڰ� ���� ��쿡 �� �� ���� 
            // �� ��� ��Ʈ����ũ ���� ���ڰ� ���� ����̱� ������ count�� �� + ��Ʈ����ũ ���� �� 
            if ( s1.contains( Character.toString(s2.charAt(i) ) ) ) {
                count++;
            }
        }

        return count;
    }
	
	// �õ��ߴٰ� ����
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
			// ���� ����
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
			// ���� ����
			if(baseball[i][1]>0 && baseball[i][2]==0) { // n ��Ʈ����ũ, 0 ��
				first.add(hundred);
				first.remove(ten);
				first.remove(one);
				second.add(ten);
				second.remove(hundred);
				second.remove(one);
				third.add(one);
				third.remove(hundred);
				third.remove(ten);
			} else if (baseball[i][1]==0 && baseball[i][2]>0) { // 0��Ʈ����ũ, n��
				first.remove(hundred);
				first.add(ten);
				first.add(one);
				second.remove(ten);
				second.add(hundred);
				second.add(one);
				third.remove(one);
				third.add(hundred);
				third.add(ten);
			} else if (baseball[i][1]==0 && baseball[i][2]==0) { // 3�ƿ��϶�
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
			
			System.out.println("\n\n1�� �ڸ� �ĺ�");
			for(Integer a : first) {
				System.out.print(a+" ");
			}
			System.out.println("\n2�� �ڸ� �ĺ�");
			for(Integer a : second) {
				System.out.print(a+" ");
			}
			System.out.println("\n3�� �ڸ� �ĺ�");
			for(Integer a : third) {
				System.out.print(a+" ");
			}
		}
		
		return first.size()*second.size()*third.size();
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] baseball = new int[][] {{123, 1, 1}, {356,1,0}, {327,2,0}, {489,0,1}};
		System.out.println("\n ���ھ߱� ���� : "+solution(baseball)); //return 2

	}

}
