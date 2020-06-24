package programmers.level02;

public class MakeBiggestNumber {
	/* ū �� �����
	 * https://programmers.co.kr/learn/courses/30/lessons/42883
���� ����
� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.

���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.
����� ��
number	k	return
1924	2	94
1231234	3	3234
4177252841	4	775841
��ó
	 */
	public static String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        char max = '0';
        int count = 0;
        int startIdx = 0;
        int maxIdx = -1;
        for(int i=0; i<arr.length; i++) {
        	// ���� ������ k������ ���� �ȿ��� �ִ밪 ã��
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
        			System.out.print(" ������ ���� : "+count+"\n");
        		}
        	} else {
        		count++;
        	}
        	
        	
        	// k���� Ž���� ������ ��
        	if(count==k) {
        		System.out.println(arr[i]+"�� �̸����� �� �����Ѵ�.");
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
