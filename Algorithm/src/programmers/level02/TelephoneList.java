package programmers.level02;

import java.util.Arrays;

public class TelephoneList {
	/*��ȭ��ȣ ���
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * ���� ����
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
	��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
	
	������ : 119
	���ؿ� : 97 674 223
	������ : 11 9552 4421
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���� ����
	phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
	�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
	����� ����
	phone_book	return
	[119, 97674223, 1195524421]	false
	[123,456,789]	true
	[12,123,1235,567,88]	false
	����� �� ����
	����� �� #1
	�տ��� ������ ���� �����ϴ�.
	
	����� �� #2
	�� ��ȣ�� �ٸ� ��ȣ�� ���λ��� ��찡 �����Ƿ�, ���� true�Դϴ�.
	
	����� �� #3
	ù ��° ��ȭ��ȣ, ��12���� �� ��° ��ȭ��ȣ ��123���� ���λ��Դϴ�. ���� ���� false�Դϴ�.
	
	�˸�
	
	2019�� 5�� 13��, �׽�Ʈ ���̽��� ����Ǿ����ϴ�. �̷� ���� ������ ����ϴ� �ڵ尡 �� �̻� ������� ���� �� �ֽ��ϴ�.
	 */
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book, (a, b) -> Integer.compare(a.length(), b.length()));
		for(String a: phone_book) {
			System.out.println(a);
		}
		System.out.println();
		 for(int i=0; i<phone_book.length-1; i++) {
	        	int len = phone_book[i].length();
	        	for(int j=i+1; j<phone_book.length; j++) {        		
	                try {
	                    if( phone_book[i].equals(phone_book[j].substring(0, len)) ) {
	                        return false;
	                    }
	                } catch (Exception e) {
	                    //break;
		        continue;
	                }        		
	        	}
	        }        
	     return true;
        
    }
	
	// �ٸ� ��� Ǯ�� : �ξ� �� ȿ�����̰� ����ϴ� String Ŭ������ startsWith() ���
	public static boolean other(String[] phone_book) {
		for(int i=0; i<phone_book.length;i++) {
        	for(int j=i+1; j<phone_book.length; j++) {
        		if(phone_book[i].startsWith(phone_book[j])) return false;
        		if(phone_book[j].startsWith(phone_book[i])) return false;
        	}
        }
        
        return true;
	}
	 public static boolean solution2(String[] phone_book) {
	        boolean answer = true;
	        Arrays.sort(phone_book); // ù ��° �ε����� �� ���� �׳� � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��츦 üũ String => ������ ũ�� ���� ���ڿ��� ���̷� ����
	        String prefix = phone_book[0];  
	        
	        int num = phone_book.length;
	        
	        for(int i = 1; i < num; i++){
	            if(phone_book[i].startsWith(prefix)){
	                answer = false;
	                break;
	            }
	        }
	        
	        return answer;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(solution(new String[] {"119", "97674223", "1195524421"})); // false
//		System.out.println(solution(new String[] {"14","124","1235","567","88"})); // true
//		System.out.println(solution(new String[] {"1191","119","12"})); // false
		//System.out.println(solution(new String[] {"1191","12","119", "1190"})); 
		System.out.println(solution(new String[] {"118", "1191", "11912"})); //false

	}

}
