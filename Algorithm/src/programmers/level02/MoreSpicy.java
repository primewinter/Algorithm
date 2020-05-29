package programmers.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MoreSpicy {
	/* �� �ʰ�
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * ���� ����
	�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. ��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.
	
	���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
	Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
	Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���� ����
	scoville�� ���̴� 2 �̻� 1,000,000 �����Դϴ�.
	K�� 0 �̻� 1,000,000,000 �����Դϴ�.
	scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
	��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.
	����� ��
	scoville	K	return
	[1, 2, 3, 9, 10, 12]	7	2
	����� �� ����
	���ں� ������ 1�� ���İ� 2�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
	���ο� ������ ���ں� ���� = 1 + (2 * 2) = 5
	���� ������ ���ں� ���� = [5, 3, 9, 10, 12]
	
	���ں� ������ 3�� ���İ� 5�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
	���ο� ������ ���ں� ���� = 3 + (5 * 2) = 13
	���� ������ ���ں� ���� = [13, 9, 10, 12]
	
	��� ������ ���ں� ������ 7 �̻��� �Ǿ��� �̶� ���� Ƚ���� 2ȸ�Դϴ�.
	 */
	
	private static List<Integer> list;
	
	
	// PriorityQueue �̿�
	public static int solution3(int[] scoville, int K) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int s : scoville) {
			pq.offer(s);
		}
		int answer = 0;
		while(pq.peek()<K) {
			if(pq.size()<2) {
				return -1;
			}
			
			int head = pq.poll();
			int second = pq.poll();
			
			pq.offer(head+second*2);
			answer++;
		}
		
		return answer;
	}
	
	// ���� �����Ϸ��� ������
	public static int solution2(int[] scoville, int K) {
		int answer = 0;
		Arrays.sort(scoville);
		List<Integer> list = new ArrayList<>();
		for(int s : scoville) {
			list.add(s);
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)<K) {
				list.set(i+1, list.get(i)+list.get(i+1)*2);
				list.remove(i);
				Collections.sort(list);
				answer++;
				i--;
			} else {
				break;
			}
		}
		
		if(list.get(0)<K) {
	          return -1;
	    }
	        
	    return answer;
	}

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        System.out.print("���� �� ");
        printAll(scoville);

        for(int i=scoville.length-1; i>0; i--) {
        	// 0 ��° ���� ������ �� ������
        	int temp = scoville[0];
        	scoville[0] = scoville[i];
        	scoville[i] = temp;
        	
        	heap(scoville, i);
        	//printAll(scoville);
        }
        
        System.out.print("���� �� ");
        printAll(scoville);
        
//        for(int i=scoville.length-1; i>0; i--) {
//        	// 0 ��° ���� ������ �� ������
//        	if(scoville[0] < K) {
//	        	int temp = scoville[0];
//	        	scoville[0] = scoville[i];
//	        	scoville[i] = temp;
//	        	
//	        	heap(scoville, i);
//	        	printAll(scoville);
//        	}
//        }
        
        list = new ArrayList<>();
        for(int i :scoville) {
        	list.add(i);
        }
        
        System.out.println("���� ��----------------------");
        for(int i=0; i<list.size(); i++) {
        	if(list.get(i)<K) {
        		list.set(i+1, list.get(i)+list.get(i+1)*2);
        		list.remove(i);
        		answer++;
        		
        		int idx = i;
        		while(idx<list.size()) {
        			if(list.get(idx)>list.get(idx+1)) {
        				int temp = list.get(idx);
        				list.set(idx, list.get(idx+1));
        				list.set(idx+1, temp);
        				idx++;
        			} else {
        				break;
        			}
        		}
        		i--;
        		
        		
        		printAll(list);
        	} else {
        		continue;
        	}
        }
//        
//        for(int i=list.size()-1; i>0; i--) {
//        	if(list.get(0) < K) {
//	        	int temp = list.get(0);
//	        	list.set(i, list.get(i)*2+temp);
//	        	list.remove(0);
//	        	answer++;
//	        	heap(list, i);
//	        	printAll(list);
//        	} else {
//        		continue;
//        	}
//        }
        System.out.println("------------------------");
        System.out.println("���ں����� ��� ��");
        printAll(list);
        
        
        
        int pos = 1;
        
        
        
        //printAll(list);

        int i = 1;
        while(answer<scoville.length-1) {
        	if(list.get(i)<K) {
        		list.set(i+1, list.get(i) + (list.get(i+1)*2));
        		list.remove(i);
        		i=1;
        		answer++;
        		sort(list);
        	} else {
        		i++;
        		break;
        	}
        }
        
//        for(int i=1; i<list.size()-1; i++) {
//        	if(list.get(i)<K && list.get(i)>-1) {
//        		list.set(i+1, list.get(i) + (list.get(i+1)*2));
//        		list.remove(i);
//        		answer++;
//        		sort(list);
//        	} else {
//        		continue;
//        	}
//        }
        
        //printAll(list);
        
        
        
//		for(int i=0; i<scoville.length-1; i++) {
//		    if(scoville[i]<K && scoville[i]>-1) {
//		        scoville[i+1] = scoville[i] + (scoville[i+1]*2);
//		        answer++;
//		    } else {
//		    	continue;
//		    }
//		}
//		printAll(list);
        
        return answer;
    }
	
	public static void heap(int[] data, int number) { 
		for(int i=1; i<number; i++) { 
			int child = i; 
			while(child > 0) { 
				int parent = (child-1)/2;
				if(data[child] > data[parent]) { 
					int temp = data[parent]; 
					data[parent] = data[child]; 
					data[child] = temp; 
				} 
				child = parent; 
			} 
		} 
	}
	
	public static void heap(List<Integer> data, int number) { 
		for(int i=1; i<number; i++) { 
			int child = i; 
			while(child > 0) { 
				int parent = (child-1)/2;
				if(data.get(child) > data.get(parent)) { 
					int temp = data.get(parent); 
					data.set(parent, data.get(child));
					data.set(child, temp);
				} 
				child = parent; 
			} 
		} 
	}
	
	
	public static void insert(int val) {
		list.add(val);
		int p = list.size()-1;
        // (list ������ - 1)�� 1���� �۾��� ������ ���� -> root�� �̵�
        while(p>1 && list.get(p/2) > list.get(p)) {
        	// �θ𺸴� �ڽ� ��尡 �� ������ ����
        	int tmp = list.get(p/2);
        	list.set(p/2, list.get(p));
        	list.set(p, tmp);
        	
        	// p�� �θ����� ���� (�θ� ��� �ε����� �̵�)
        	p = p/2;
        }
	}
	
	public static void sort(List<Integer> list) {
		int p = list.size()-1;
        // (list ������ - 1)�� 1���� �۾��� ������ ���� -> root�� �̵�
        while(p>1 && list.get(p/2) > list.get(p)) {
        	// �θ𺸴� �ڽ� ��尡 �� ������ ����
        	int tmp = list.get(p/2);
        	list.set(p/2, list.get(p));
        	list.set(p, tmp);
        	
        	// p�� �θ����� ���� (�θ� ��� �ε����� �̵�)
        	p = p/2;
        }
	}
	
	public static int delete() {
		if(list.size()-1 < 1) {
			return 0;
		}
		
		// ������ ���� ��Ʈ ���
		int deleteItem = list.get(1);
		
		// root�� ���� ������ ���� �ְ� ������ �� ����
		list.set(1,  list.get(list.size()-1));
		list.remove(list.size()-1);
		
		int pos = 1;
		while( (pos*2) < list.size() ) {
			
			int min = list.get(pos*2);
			int minPos = pos * 2;
			
			if( ((pos*2+1) < list.size()) && min > list.get(pos*2+1) ) {
				min = list.get(pos*2 + 1);
				minPos = pos*2+1;
			}
			
			if(list.get(pos) < min) {
				break;
			}
			
			// �θ� �ڽ� ��� ��ȯ
			int tmp = list.get(pos);
			list.set(pos, list.get(minPos));
			list.set(minPos, tmp);
			pos = minPos;
		}
		
		return deleteItem;
	}
	
	public static void printAll(List<Integer> arr) {
		System.out.println("print ::");
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	
	public static void printAll(int[] arr) {
		System.out.println("print ::");
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("answer : "+solution2(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}

}
