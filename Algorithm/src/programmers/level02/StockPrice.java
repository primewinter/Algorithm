package programmers.level02;

import java.util.ArrayList;

public class StockPrice {
	/* �ֽİ��� +7
	 * https://programmers.co.kr/learn/courses/30/lessons/42584
	 * ���� ����
	�� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, ������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	
	���ѻ���
	prices�� �� ������ 1 �̻� 10,000 ������ �ڿ����Դϴ�.
	prices�� ���̴� 2 �̻� 100,000 �����Դϴ�.
	����� ��
	prices	return
	[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
	����� �� ����
	1�� ������ 1�� ������ ������ �������� �ʾҽ��ϴ�.
	2�� ������ 2�� ������ ������ �������� �ʾҽ��ϴ�.
	3�� ������ 3�� 1�ʵڿ� ������ �������ϴ�. ���� 1�ʰ� ������ �������� ���� ������ ���ϴ�.
	4�� ������ 2�� 1�ʰ� ������ �������� �ʾҽ��ϴ�.
	5�� ������ 3�� 0�ʰ� ������ �������� �ʾҽ��ϴ�.
	�� ���� - 2019�� 2�� 28�� ������ ������Ǿ����ϴ�.
	 */
	
	// �� Ǯ��
	public static int[] solution(int[] prices) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<prices.length;i++) {
        	int time = 0;
        	boolean isFallen = false;
        	for(int k=i+1; k<prices.length;k++) {
        		time++;
        		if(prices[i]>prices[k]) {
        			arr.add(time);
        			isFallen = true;
        			break;
        		}
        	}
        	if(!isFallen) {
        		arr.add(prices.length-i-1);
        	}
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = arr.get(i);
        }
        return answer;
    }
	
	// �� Ǯ�� : ť/���� �̿�
	public static int[] solution2(int[] prices) {
        int[] answer = {};
        
        return answer;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,2,3,2,3}));

	}

}
