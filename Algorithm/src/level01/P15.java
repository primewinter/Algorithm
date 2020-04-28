package level01;

public class P15 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12926
	 * ���α׷��ӽ� Lv.1 ������ȣ
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
	
	public static void main(String[] args) {
		System.out.println(solution(("a B z"), 4));
	}

}
