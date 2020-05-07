package programmers.level01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P13 {
	/*ü����
	 * https://programmers.co.kr/learn/courses/30/lessons/42862
	 * ���� ����
	���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.
	
	��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�.
	ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
	������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
	���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�.
	���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.
	����� ��
	n	lost	reserve	return
	5	[2, 4]	[1, 3, 5]	5
	5	[2, 4]	[3]	4
	3	[3]	[1]	2
	����� �� ����
	���� #1
	1�� �л��� 2�� �л����� ü������ �����ְ�, 3�� �л��̳� 5�� �л��� 4�� �л����� ü������ �����ָ� �л� 5���� ü�������� ���� �� �ֽ��ϴ�.
	
	���� #2
	3�� �л��� 2�� �л��̳� 4�� �л����� ü������ �����ָ� �л� 4���� ü�������� ���� �� �ֽ��ϴ�.
	
	��ó
	
	�� ���� - 2019�� 2�� 18�� ������ ������Ǿ����ϴ�.
	�� ���� - 2019�� 2�� 27��, 28�� �׽�Ʈ���̽��� �߰��Ǿ����ϴ�.
	 */
	
	// �ٽ� Ǭ ��
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
	
	// ó�� Ǯ���� �� �� Ǭ ��
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
		 int[] a = {11,12,2,4}; // �Ҿ���� �ֵ�
		 int[] b = {10,9}; // ���� �ִ� �ֵ�
		System.out.println("���� : "+solution(n, a, b));
		System.out.println("���� ; "+solution(10, new int[] {1,2,3}, new int[] {8,9,10}));
		
//		System.out.println("���� : "+solution(5, new int[] {2,4}, new int[] {1,3,5}));
//		System.out.println("���� : "+solution(5, new int[] {2,4}, new int[] {3}));
//		System.out.println("���� : "+solution(3, new int[] {3}, new int[] {1}));
//		System.out.println("���� : "+solution(2, new int[] {1}, new int[] {1}));
	}

}
