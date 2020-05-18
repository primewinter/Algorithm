package programmers.level02;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Printer {
	/* ������
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 * ���� ����
	�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.
	
	1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
	2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
	3. �׷��� ������ J�� �μ��մϴ�.
	���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.
	
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.
	
	���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
	�μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
	location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.
	����� ��
	priorities	location	return
	[2, 1, 3, 2]	2	1
	[1, 1, 9, 1, 1, 1]	0	5
	����� �� ����
	���� #1
	
	������ ���� ���� �����ϴ�.
	
	���� #2
	
	6���� ����(A, B, C, D, E, F)�� �μ� ����Ͽ� �ְ� �߿䵵�� 1 1 9 1 1 1 �̹Ƿ� C D E F A B ������ �μ��մϴ�.
	 */
	
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int elem : priorities) {
        	list.add(elem);
        }
        

        while(list.size()>0) {
        	int high = Collections.max(list);
        	System.out.println("���� ���� �߿䵵 ���� ������ ["+high+"]�̴�");
        	for(int i=1; i<list.size(); i++) {
        		System.out.println("=======["+list.get(0)+"]�� "+i+"��° ����� ["+list.get(i)+"]�� �� ��");
        		if(list.get(0)<list.get(i)) {
        			list.add(list.get(0));
        			list.remove();
        			//System.out.print(location+"�� �־��� ");
        			if(location==0) {
        				location = list.size()-1;
        			} else {
        				location--;
        			}
        			System.out.println("0��° ��Ҹ� �� �ڷ� ���´� >> ���� location : "+location);
        			break;
        		}
        	}
        	//System.out.println("���� ���� �߿䵵 ���� ������ ["+high+"]�̰� 0��° ��Ҵ� ["+list.get(0)+"]�̴�");
//        	if(0==location) {
//        		//System.out.println("\t���� location�� �μ��ߴ� >> answer : "+answer);
//        		return answer+1;
//        	}
        	
        	if(high==list.get(0)) {
        		System.out.print(">>"+list.get(0)+"�μ�");
	        	list.remove();
	        	high=Collections.max(list);
	        	location--;
        		answer++;
        		System.out.println("("+answer+"�� �μ��ߴ� >> ���� location :"+location+")");
        	}
//        	else if (high==0) {
//        		System.out.print(">>"+list.get(0)+"�μ�");
//        		list.remove();
//        		location--;
//        		answer++;
//        		System.out.println("("+answer+"�� �μ��ߴ� >> ���� location :"+location+")");
//        	}
        	
        	
        	System.out.println("�õ� �� :::: ����Ʈ ������ : "+list.size());
        }
        
        
        
        /*
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<list.size(); j++) {
    			if(i!=j && list.get(i) < list.get(j)) { // ù��° �������� j��° ������ �� �߿䵵�� ������
    				list.add(list.get(i));
    				list.remove(0);
    				if(i==location) {
    					location = list.size();
    				} else {
    					location--;
    				}
    				break;
    			}
        	}
        	list.remove(0);
        	if(i==location) {
        		return i+1;
        	} else {
        		location--;
        		answer++;
        	}
        }
        */
        
        return answer+1;
    }
	
	public static int solution2(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for(int elem : priorities) {
        	q.add(elem);
        }
        
        while(!q.isEmpty()) {
        	int priority = q.poll();
        	boolean printed = true;
        	
        	for(int i=0; i<q.size();i++) {
        		if(q.get(i)>priority) {
        			q.add(priority);
        			printed = false;
        			break;
        		}
        	}
        	
        	if(printed) {
        		answer++;
        	}
        	
    		if(location==0) {
    			if(printed) {
    				return answer;
    			} else {
    				location = q.size()-1;
    			}
    		} else {
    			location--;
    		}
        	
        }
        
        return answer;
    }
	
	
	// ���ڸ龲 Ǯ��
	public int other1(int[] priorities, int location) {
        int answer = 0;

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        Arrays.sort(priorities); 
        int length = priorities.length - 1; 

        while(!queue.isEmpty()){
            int dummy = queue.poll();

            if(dummy == priorities[length - answer]){
                answer++;
                location--;
                if(location < 0){
                    break;
                }
            }
            else {
                queue.add(dummy);
                location--;
                if(location < 0){
                    location = queue.size() - 1;
                }
            }
        }
        
        return answer;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,3,2};
		int b = 2;
		System.out.println(solution2(a,b));
//		System.out.println();
//		System.out.println();
		int[] c = {1, 1, 9, 1, 1, 1};
		int d = 0;
		System.out.println(solution2(c,d));
//		int[] e = {9,2,4,1,5,3};
//		int f = 4;
//		System.out.println("\n");
//		System.out.println(solution(e,f));
//		int[] g = {1,5,1,4,1,1,3};
//		int h = 5;
//		System.out.println("\n");
//		System.out.println(solution(g,h));
			

	}
	
	

}
