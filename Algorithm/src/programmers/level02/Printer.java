package programmers.level02;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Printer {
	/* 프린터
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 * 문제 설명
	일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
	
	1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	3. 그렇지 않으면 J를 인쇄합니다.
	예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
	
	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
	
	현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
	인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
	location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
	입출력 예
	priorities	location	return
	[2, 1, 3, 2]	2	1
	[1, 1, 9, 1, 1, 1]	0	5
	입출력 예 설명
	예제 #1
	
	문제에 나온 예와 같습니다.
	
	예제 #2
	
	6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
	 */
	
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int elem : priorities) {
        	list.add(elem);
        }
        

        while(list.size()>0) {
        	int high = Collections.max(list);
        	System.out.println("현재 가장 중요도 높은 문서는 ["+high+"]이다");
        	for(int i=1; i<list.size(); i++) {
        		System.out.println("=======["+list.get(0)+"]을 "+i+"번째 요소인 ["+list.get(i)+"]와 비교 중");
        		if(list.get(0)<list.get(i)) {
        			list.add(list.get(0));
        			list.remove();
        			//System.out.print(location+"에 있었던 ");
        			if(location==0) {
        				location = list.size()-1;
        			} else {
        				location--;
        			}
        			System.out.println("0번째 요소를 맨 뒤로 보냈다 >> 현재 location : "+location);
        			break;
        		}
        	}
        	//System.out.println("현재 가장 중요도 높은 문서는 ["+high+"]이고 0번째 요소는 ["+list.get(0)+"]이다");
//        	if(0==location) {
//        		//System.out.println("\t드디어 location을 인쇄했다 >> answer : "+answer);
//        		return answer+1;
//        	}
        	
        	if(high==list.get(0)) {
        		System.out.print(">>"+list.get(0)+"인쇄");
	        	list.remove();
	        	high=Collections.max(list);
	        	location--;
        		answer++;
        		System.out.println("("+answer+"번 인쇄했다 >> 현재 location :"+location+")");
        	}
//        	else if (high==0) {
//        		System.out.print(">>"+list.get(0)+"인쇄");
//        		list.remove();
//        		location--;
//        		answer++;
//        		System.out.println("("+answer+"번 인쇄했다 >> 현재 location :"+location+")");
//        	}
        	
        	
        	System.out.println("시도 끝 :::: 리스트 사이즈 : "+list.size());
        }
        
        
        
        /*
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<list.size(); j++) {
    			if(i!=j && list.get(i) < list.get(j)) { // 첫번째 문서보다 j번째 문서가 더 중요도가 높으면
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
	
	
	// 감자면쓰 풀이
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
