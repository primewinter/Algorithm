package programmers.level01;

public class Subaksubaksu {

	public static void main(String[] args) {
		System.out.println(solution(6));
	}
	
	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<n/2;i++) {
			answer.append("¼ö¹Ú");
		}
		if(n%2==1) {
			answer.append("¼ö");
		}
		
		return answer.toString();
	  }

}
