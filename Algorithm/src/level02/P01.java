package level02;

import java.util.Collections;
import java.util.LinkedList;

public class P01 {
	
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,3,2};
		int b = 2;
		System.out.println(solution(a,b));
		System.out.println();
		System.out.println();
		int[] c = {1, 1, 9, 1, 1, 1};
		int d = 0;
		System.out.println(solution(c,d));
		int[] e = {9,2,4,1,5,3};
		int f = 4;
		System.out.println("\n");
		System.out.println(solution(e,f));
		int[] g = {1,5,1,4,1,1,3};
		int h = 5;
		System.out.println("\n");
		System.out.println(solution(g,h));
			

	}
	
	

}
