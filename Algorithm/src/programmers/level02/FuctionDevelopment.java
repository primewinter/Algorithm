package programmers.level02;

import java.util.ArrayList;
import java.util.LinkedList;

public class FuctionDevelopment {
	/* ��ɰ���
	 * https://programmers.co.kr/learn/courses/30/lessons/42586
	 * ���� ����
	���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
	
	��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
	
	���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	
	���� ����
	�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
	�۾� ������ 100 �̸��� �ڿ����Դϴ�.
	�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
	������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.
	����� ��
	progresses	speeds	return
	[93,30,55]	[1,30,5]	[2,1]
	����� �� ����
	ù ��° ����� 93% �Ϸ�Ǿ� �ְ� �Ϸ翡 1%�� �۾��� �����ϹǷ� 7�ϰ� �۾� �� ������ �����մϴ�.
	�� ��° ����� 30%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 30%�� �۾��� �����ϹǷ� 3�ϰ� �۾� �� ������ �����մϴ�. ������ ���� ù ��° ����� ���� �ϼ��� ���°� �ƴϱ� ������ ù ��° ����� �����Ǵ� 7��° �����˴ϴ�.
	�� ��° ����� 55%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 5%�� �۾��� �����ϹǷ� 9�ϰ� �۾� �� ������ �����մϴ�.
	
	���� 7��°�� 2���� ���, 9��°�� 1���� ����� �����˴ϴ�.
	 */

	public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> answer = new LinkedList<>();
        LinkedList<Integer[]> q = new LinkedList<>();
        for(int i=0; i<progresses.length;i++) {
        	q.add(new Integer[] {progresses[i], speeds[i]});
        }
        
        while(!q.isEmpty()) {
        	int completed = 0;
        	for(int i=0; i<q.size();i++) {
        		Integer progress = q.get(i)[0]+q.get(i)[1];
        		q.set(i, new Integer[] {progress, q.get(i)[1]});
        	}

        	while(q.peekFirst()!=null && q.peek()[0]>=100) {
        		q.poll();
        		completed++;
        	}
        	
        	if(completed>0) {
        		answer.add(completed);
        	}
        }
        
        int[] aa = new int[answer.size()];
        for(int i=0; i<answer.size();i++) {
        	aa[i] = answer.get(i);
        }
        
        return aa;
    }
	
	public static int[] solution2(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<>();
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=0; i<speeds.length;i++) {
			progresses[i] = (int) Math.ceil((100-progresses[i])/speeds[i]);
			q.add(progresses[i]);
		}
		
		while(!q.isEmpty()) {
			int endDate = q.poll();
			int endTasks = 1;
			
			while(q.peek()!=null && endDate>=q.peek()) {
				q.poll();
				endTasks++;
			}
			
			answer.add(endTasks);
		}
	
		int[] aa = new int[answer.size()];
	    for(int i=0; i<answer.size();i++) {
	    	aa[i] = answer.get(i);
	    }
		    
		return aa;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution2(new int[] {93,30,55}, new int[] {1,30,5}));
		//System.out.println(solution);

	}

}
