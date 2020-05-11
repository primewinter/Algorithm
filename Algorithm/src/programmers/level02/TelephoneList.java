package programmers.level02;


public class TelephoneList {
	public static boolean solution(String[] phone_book) {
        for(int i=0; i<phone_book.length; i++) {
        	int len = phone_book[i].length();
        	for(int j=0; j<phone_book.length; j++) {
        		if(i!=j) {
        			try {
	        			if( phone_book[i].equals(phone_book[j].substring(0, len)) ) {
	        				return false;
	        			}
        			} catch (Exception e) {
        				break;
        			}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"})); // false
		System.out.println(solution(new String[] {"14","124","1235","567","88"})); // true

	}

}
