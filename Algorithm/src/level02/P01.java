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
