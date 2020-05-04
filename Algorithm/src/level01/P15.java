package level01;

public class P15 {
	/* 프로그래머스 Lv.1 시저암호
	 * https://programmers.co.kr/learn/courses/30/lessons/12926
	 * 문제 설명
	어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
	
	제한 조건
	공백은 아무리 밀어도 공백입니다.
	s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
	s의 길이는 8000이하입니다.
	n은 1 이상, 25이하인 자연수입니다.
	입출력 예
	s	n	result
	AB	1	BC
	z	1	a
	a B z	4	e F d
	 */
	public static String solution(String s, int n) {
	      String answer = "";
	      String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lower = "abcdefghijklmnopqrstuvwxyz";
	      
	      for(int i=0; i<s.length(); i++) {
	          
	    	  char letter = s.charAt(i);
	    	  if(letter==' ') {
	    		  answer += letter;
	    	  } else {
	    		  
	    		  int before = upper.indexOf((letter+"").toUpperCase());
    			  int after = before+n>=26?before+n-26:before+n;
	    		  
	    		  if(upper.contains(letter+"")) { //대문자인 경우
	    			  answer += upper.charAt(after);  
		    	  } else { //소문자인 경우
		    		  answer += lower.charAt(after);
		    	  }
  
	    	  }
	      }
	      
	      return answer;
	}
	
	// 다른 사람 풀이
	public static String caesar(String s, int n) {
        String result = "";
	    n = n % 26; //문제에서 n은 25이하의 자연수라고 했으므로 생략 가능
	    
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i);
	      
	      if (Character.isLowerCase(ch)) {
	    	  // char의 Wrapper Class <<Character>> API 확인
	        ch = (char) ((ch - 'a' + n) % 26 + 'a');
	        // ch - 'a' : 아스키코드 a 시작 지점을 0으로 설정
	        // ch-'a' + n : a에서 n만큼 이동 
	        // (ch-'a'+n) % 26 : z 이후로 넘어갔을 경우 계산
	        // 암호화가 끝난 알파벳의 위치값 (0<=n<26)

	        // (ch-'a'+n)%26 + 'a' : 아스키코드표 안에서의 위치값
	        
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      
	      result += ch;
	      //공백인 경우 그대로 concat
	    }
        
	    return result;
    }
	
	
	// 다른 사람 풀이2
	public static String caesar2(String s, int n) {
        StringBuilder builder = new StringBuilder();
        // String은 불변 클래스이므로 StringBuilder로 했을 때 연산이 훨씬 빠르다.
        // 그 이유에 대한 설명 → https://cjh5414.github.io/why-StringBuffer-and-StringBuilder-are-better-than-String/
        
        char[] array =s.toCharArray();
        // 대문자는 65 ~ 90    90 - 25 +1 = 총 26개
        // 소문자는 97 ~ 122   122- 97 +1 = 총 26개
        // 공백은 32
        int number = 0;

        for(int i=0; i<array.length; i++) {
            // 대문자의 경우
            if(array[i]>=65 && array[i] <=90){
                number = array[i] + n%26;    
                if(number>90){
                    number = number - 26;
                }                
            }

            // 소문자의 경우
            if(array[i]>=97 && array[i] <=122){
                number = array[i] + n%26;
                if(number>122){
                    number = number - 26;
                }
            }

            // 공백의 경우
            if(array[i]==32) {
                number = 32;
            }

            builder.append( (char)number );
        }

        return builder.toString();
}

	
	public static void main(String[] args) {
		System.out.println(solution(("a B z"), 4));
	}

}
