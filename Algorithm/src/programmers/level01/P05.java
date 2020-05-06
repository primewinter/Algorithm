package level01;

public class P05 {
	 public static String solution(String phone_number) {
	     //Level1 핸드폰 번호 가리기
		 String answer = "";   
	      for(int i = 0; i<phone_number.length()-4; i++) {
	          answer +="*";
	      }
	     answer += phone_number.substring(phone_number.length()-4);
	      //return answer;
	      
	      //다른 사람 코딩 :: String.valueOf(ch) 에 주목 하시라
	      char[] ch = phone_number.toCharArray();
	      for(int i = 0; i < ch.length - 4; i ++){
	          ch[i] = '*';
	      }
	      return String.valueOf(ch);
	  }
	public static void main(String[] args) {
		// 뒷자리 네개 말고 
		String a = "01033334444";
		String b = "027778888";
		System.out.println(solution(a));
		System.out.println(solution(b));
		
	}

}
