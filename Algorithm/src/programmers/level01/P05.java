package level01;

public class P05 {
	 public static String solution(String phone_number) {
	     //Level1 �ڵ��� ��ȣ ������
		 String answer = "";   
	      for(int i = 0; i<phone_number.length()-4; i++) {
	          answer +="*";
	      }
	     answer += phone_number.substring(phone_number.length()-4);
	      //return answer;
	      
	      //�ٸ� ��� �ڵ� :: String.valueOf(ch) �� �ָ� �Ͻö�
	      char[] ch = phone_number.toCharArray();
	      for(int i = 0; i < ch.length - 4; i ++){
	          ch[i] = '*';
	      }
	      return String.valueOf(ch);
	  }
	public static void main(String[] args) {
		// ���ڸ� �װ� ���� 
		String a = "01033334444";
		String b = "027778888";
		System.out.println(solution(a));
		System.out.println(solution(b));
		
	}

}
