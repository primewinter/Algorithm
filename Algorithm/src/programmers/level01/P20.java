package programmers.level01;

import java.util.Arrays;

public class P20 {
	/* ���α׷��ӽ� Lv1. ���� 
	 * https://programmers.co.kr/learn/courses/30/lessons/12982
	 * ���� ����
	S�翡���� �� �μ��� �ʿ��� ��ǰ�� ������ �ֱ� ���� �μ����� ��ǰ�� �����ϴµ� �ʿ��� �ݾ��� �����߽��ϴ�. �׷���, ��ü ������ ������ �ֱ� ������ ��� �μ��� ��ǰ�� ������ �� ���� �����ϴ�. �׷��� �ִ��� ���� �μ��� ��ǰ�� ������ �� �� �ֵ��� �Ϸ��� �մϴ�.
	
	��ǰ�� ������ �� ���� �� �μ��� ��û�� �ݾ׸�ŭ�� ��� ������ ��� �մϴ�. ���� ��� 1,000���� ��û�� �μ����� ��Ȯ�� 1,000���� �����ؾ� �ϸ�, 1,000������ ���� �ݾ��� ������ �� ���� �����ϴ�.
	
	�μ����� ��û�� �ݾ��� ����ִ� �迭 d�� ���� budget�� �Ű������� �־��� ��, �ִ� �� ���� �μ��� ��ǰ�� ������ �� �ִ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	���ѻ���
	d�� �μ����� ��û�� �ݾ��� ����ִ� �迭�̸�, ����(��ü �μ��� ����)�� 1 �̻� 100 �����Դϴ�.
	d�� �� ���Ҵ� �μ����� ��û�� �ݾ��� ��Ÿ����, �μ��� ��û �ݾ��� 1 �̻� 100,000 ������ �ڿ����Դϴ�.
	budget�� ������ ��Ÿ����, 1 �̻� 10,000,000 ������ �ڿ����Դϴ�.
	����� ��
	d	budget	result
	[1,3,2,5,4]	9	3
	[2,2,3,3]	10	4
	����� �� ����
	����� �� #1
	�� �μ����� [1��, 3��, 2��, 5��, 4��]��ŭ�� �ݾ��� ��û�߽��ϴ�. ���࿡, 1��, 2��, 4���� ��û�� �μ��� ��ǰ�� �������ָ� ���� 9������ 7���� �Һ�Ǿ� 2���� �����ϴ�. �׻� ��Ȯ�� ��û�� �ݾ׸�ŭ ������ ��� �ϹǷ� ���� 2������ ������ �μ��� ������ ���� �ʽ��ϴ�. �� ��� �ܿ� 3�� �μ��� ������ �� ������� ������ �����ϴ�.
	
	1��, 2��, 3���� ��û�� �μ��� ��ǰ�� �������ַ��� 6���� �ʿ��մϴ�.
	1��, 2��, 5���� ��û�� �μ��� ��ǰ�� �������ַ��� 8���� �ʿ��մϴ�.
	1��, 3��, 4���� ��û�� �μ��� ��ǰ�� �������ַ��� 8���� �ʿ��մϴ�.
	1��, 3��, 5���� ��û�� �μ��� ��ǰ�� �������ַ��� 9���� �ʿ��մϴ�.
	3�� �μ����� �� ���� �μ��� ��ǰ�� ������ �� ���� �����Ƿ� �ִ� 3�� �μ��� ��ǰ�� ������ �� �� �ֽ��ϴ�.
	
	����� �� #2
	��� �μ��� ��ǰ�� �������ָ� 10���� �˴ϴ�. ���� �ִ� 4�� �μ��� ��ǰ�� ������ �� �� �ֽ��ϴ�.
	 */
	
	// �� Ǯ��
	public static int solution(int[] d, int budget) {
        int answer = d.length;
        int sum = 0;
        for(int demand : d) {
        	sum += demand;
        }
        
        Arrays.sort(d);
        int part = 0;
        
        if(sum == budget || sum < budget) {
        	return d.length;
        } else {
        	for(int i=d.length-1; i>=0; i--) {
        		part += d[i];
        		answer--;
        		if(sum-budget <= d[i]) {
        			return d.length-1;
        		} else if (sum-budget < part) {
        			return answer;
        		}
			}
        }
        
        
        return answer;
    }
	
	//�ٸ� ��� Ǯ��
	public int other(int[] d, int budget) {
	      int answer = 0;

	        Arrays.sort(d);

	        for (int i = 0; i < d.length; i++) {
	            budget -= d[i];

	            if (budget < 0) break;

	            answer++;
	        }

	        return answer;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,7,9};
		int b = 8;
		
		System.out.println(solution(a,b));
		
		int[] c = {1,3,2,5,4};
		int d = 9;
		System.out.println(solution(c,d));
		

	}
	

}