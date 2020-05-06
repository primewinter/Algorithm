package programmers.level01;

public class P09 {
	
	public static void main(String[] args) {
	    //자연수 뒤집어 배열 만들기
		int n = 12345;
		String num = ""+n;
	    int[] answer = new int[num.length()];
		int leng = num.length()-1;
		
		for(int i = 0; i < num.length() ; i++) {
		    	char a = num.charAt(leng);
		    	answer[i] = Integer.parseInt(a+"");
		    	leng--;
		}
		Math.min(3, 5);
	}
}

