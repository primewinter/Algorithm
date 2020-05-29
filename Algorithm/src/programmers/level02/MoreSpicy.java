package programmers.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MoreSpicy {
	/* 더 맵게
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * 문제 설명
	매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
	
	섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
	Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	scoville의 길이는 2 이상 1,000,000 이하입니다.
	K는 0 이상 1,000,000,000 이하입니다.
	scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
	모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	입출력 예
	scoville	K	return
	[1, 2, 3, 9, 10, 12]	7	2
	입출력 예 설명
	스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
	새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
	가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
	
	스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
	새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
	가진 음식의 스코빌 지수 = [13, 9, 10, 12]
	
	모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
	 */
	
	private static List<Integer> list;
	
	
	// PriorityQueue 이용
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
	
	// 직접 구현하려다 실패함
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
        
        System.out.print("정렬 전 ");
        printAll(scoville);

        for(int i=scoville.length-1; i>0; i--) {
        	// 0 번째 값과 마지막 값 스와프
        	int temp = scoville[0];
        	scoville[0] = scoville[i];
        	scoville[i] = temp;
        	
        	heap(scoville, i);
        	//printAll(scoville);
        }
        
        System.out.print("정렬 후 ");
        printAll(scoville);
        
//        for(int i=scoville.length-1; i>0; i--) {
//        	// 0 번째 값과 마지막 값 스와프
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
        
        System.out.println("정렬 중----------------------");
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
        System.out.println("스코빌지수 계산 후");
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
        // (list 사이즈 - 1)이 1보다 작아질 때까지 진행 -> root로 이동
        while(p>1 && list.get(p/2) > list.get(p)) {
        	// 부모보다 자식 노드가 더 작으면 스왑
        	int tmp = list.get(p/2);
        	list.set(p/2, list.get(p));
        	list.set(p, tmp);
        	
        	// p는 부모값으로 변경 (부모 노드 인덱스로 이동)
        	p = p/2;
        }
	}
	
	public static void sort(List<Integer> list) {
		int p = list.size()-1;
        // (list 사이즈 - 1)이 1보다 작아질 때까지 진행 -> root로 이동
        while(p>1 && list.get(p/2) > list.get(p)) {
        	// 부모보다 자식 노드가 더 작으면 스왑
        	int tmp = list.get(p/2);
        	list.set(p/2, list.get(p));
        	list.set(p, tmp);
        	
        	// p는 부모값으로 변경 (부모 노드 인덱스로 이동)
        	p = p/2;
        }
	}
	
	public static int delete() {
		if(list.size()-1 < 1) {
			return 0;
		}
		
		// 삭제할 노드는 루트 노드
		int deleteItem = list.get(1);
		
		// root에 가장 마지막 값을 넣고 마지막 값 삭제
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
			
			// 부모 자식 노드 교환
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
