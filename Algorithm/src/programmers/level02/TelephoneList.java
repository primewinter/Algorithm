package programmers.level02;

import java.util.Arrays;

public class TelephoneList {
	/*전화번호 목록
	 * https://programmers.co.kr/learn/courses/30/lessons/42577
	 * 문제 설명
	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	
	구조대 : 119
	박준영 : 97 674 223
	지영석 : 11 9552 4421
	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	phone_book의 길이는 1 이상 1,000,000 이하입니다.
	각 전화번호의 길이는 1 이상 20 이하입니다.
	입출력 예제
	phone_book	return
	[119, 97674223, 1195524421]	false
	[123,456,789]	true
	[12,123,1235,567,88]	false
	입출력 예 설명
	입출력 예 #1
	앞에서 설명한 예와 같습니다.
	
	입출력 예 #2
	한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
	
	입출력 예 #3
	첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
	
	알림
	
	2019년 5월 13일, 테스트 케이스가 변경되었습니다. 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.
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
	
	// 다른 사람 풀이 : 훨씬 더 효율적이고 깔끔하다 String 클래스의 startsWith() 사용
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
	        Arrays.sort(phone_book); // 첫 번째 인덱스랑 비교 ㄴㄴ 그냥 어떤 번호가 다른 번호의 접두어인 경우를 체크 String => 숫자의 크기 말고 문자열의 길이로 정렬
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
