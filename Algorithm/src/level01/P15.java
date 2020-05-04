package level01;

public class P15 {
	/* ���α׷��ӽ� Lv.1 ������ȣ
	 * https://programmers.co.kr/learn/courses/30/lessons/12926
	 * ���� ����
	� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. ���� ��� AB�� 1��ŭ �и� BC�� �ǰ�, 3��ŭ �и� DE�� �˴ϴ�. z�� 1��ŭ �и� a�� �˴ϴ�. ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.
	
	���� ����
	������ �ƹ��� �о �����Դϴ�.
	s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�.
	s�� ���̴� 8000�����Դϴ�.
	n�� 1 �̻�, 25������ �ڿ����Դϴ�.
	����� ��
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
	    		  
	    		  if(upper.contains(letter+"")) { //�빮���� ���
	    			  answer += upper.charAt(after);  
		    	  } else { //�ҹ����� ���
		    		  answer += lower.charAt(after);
		    	  }
  
	    	  }
	      }
	      
	      return answer;
	}
	
	// �ٸ� ��� Ǯ��
	public static String caesar(String s, int n) {
        String result = "";
	    n = n % 26; //�������� n�� 25������ �ڿ������ �����Ƿ� ���� ����
	    
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i);
	      
	      if (Character.isLowerCase(ch)) {
	    	  // char�� Wrapper Class <<Character>> API Ȯ��
	        ch = (char) ((ch - 'a' + n) % 26 + 'a');
	        // ch - 'a' : �ƽ�Ű�ڵ� a ���� ������ 0���� ����
	        // ch-'a' + n : a���� n��ŭ �̵� 
	        // (ch-'a'+n) % 26 : z ���ķ� �Ѿ�� ��� ���
	        // ��ȣȭ�� ���� ���ĺ��� ��ġ�� (0<=n<26)

	        // (ch-'a'+n)%26 + 'a' : �ƽ�Ű�ڵ�ǥ �ȿ����� ��ġ��
	        
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      
	      result += ch;
	      //������ ��� �״�� concat
	    }
        
	    return result;
    }
	
	
	// �ٸ� ��� Ǯ��2
	public static String caesar2(String s, int n) {
        StringBuilder builder = new StringBuilder();
        // String�� �Һ� Ŭ�����̹Ƿ� StringBuilder�� ���� �� ������ �ξ� ������.
        // �� ������ ���� ���� �� https://cjh5414.github.io/why-StringBuffer-and-StringBuilder-are-better-than-String/
        
        char[] array =s.toCharArray();
        // �빮�ڴ� 65 ~ 90    90 - 25 +1 = �� 26��
        // �ҹ��ڴ� 97 ~ 122   122- 97 +1 = �� 26��
        // ������ 32
        int number = 0;

        for(int i=0; i<array.length; i++) {
            // �빮���� ���
            if(array[i]>=65 && array[i] <=90){
                number = array[i] + n%26;    
                if(number>90){
                    number = number - 26;
                }                
            }

            // �ҹ����� ���
            if(array[i]>=97 && array[i] <=122){
                number = array[i] + n%26;
                if(number>122){
                    number = number - 26;
                }
            }

            // ������ ���
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
