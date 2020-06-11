package programmers.level02;

public class Carpet {
	/* ī��(+2)
	 * https://programmers.co.kr/learn/courses/30/lessons/42842
	 * ���� ����
Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.

carpet.png

Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.

Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�.
����� ������ �� yellow�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�.
ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.
����� ��
brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]
��ó

�� ���� - 2020�� 2�� 3�� �׽�Ʈ���̽��� �߰��Ǿ����ϴ�.
�� ���� - 2020�� 5�� 11�� �����ټ��� ����Ͽ� �������� ��������� �����Ͽ����ϴ�.
	 */
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width;
        
        for(int height=1; height<=yellow/2; height++) {
        	if(yellow%height==0) {
        		width = yellow/height;
        		if(brown == (width+height)*2+4) {
        			answer[0] = width+2;
        			answer[1] = height+2;
        			return answer;
        		}
        	
        	}
        }
        
        answer[0] = yellow+2;
        answer[1] = yellow+2;
      
        return answer;
    }
	
	// �ٸ� ��� Ǯ��
	public int[] other(int brown, int red) {
	        int a = (brown+4)/2;
	        int b = red+2*a-4;
	        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
	        return answer;
	}
	
	// �ٸ� ��� Ǯ��2
	public int[] other2(int brown, int red) {
        for(int i=1; i<=red; i++) {
            if(red%i==0 && (red/i+i)*2+4==brown) {
                return new int[] {red/i+2, i+2};
            }
        }
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(24, 24));

	}

}
