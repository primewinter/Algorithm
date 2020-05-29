package programmers.level02;

import java.util.Arrays;

public class H_index {
	/* H-index (+7)
	 * https://programmers.co.kr/learn/courses/30/lessons/42747
	 * ���� ����
	H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
	
	� �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index�Դϴ�.
	
	� �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	�����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
	���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
	����� ��
	citations	return
	[3, 0, 6, 1, 5]	3
	����� �� ����
	�� �����ڰ� ��ǥ�� ���� ���� 5���̰�, ���� 3���� ���� 3ȸ �̻� �ο�Ǿ����ϴ�. �׸��� ������ 2���� ���� 3ȸ ���� �ο�Ǿ��� ������ �� �������� H-Index�� 3�Դϴ�.
	
	�� ���� - 2019�� 2�� 28�� �׽�Ʈ ���̽��� �߰��Ǿ����ϴ�.
	 * 
	 */

	 public static int solution(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++) {
        	if( citations[i] >= answer ) {
        		break;
        	}
    		answer--;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {3, 0, 6, 1, 5})); // 3

	}

}
