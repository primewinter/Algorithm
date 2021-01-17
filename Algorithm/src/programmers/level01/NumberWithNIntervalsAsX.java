package programmers.level01;

public class NumberWithNIntervalsAsX {

	public static void main(String[] args) {
		solution(-4, 3);
		
	}
	
	public static long[] solution(int x, int n) {
		long[] answers = new long[n];
		answers[0] = x;

		for(int i=1; i<n; i++) {
			answers[i] = answers[i-1]+x; 
		}
		return answers;
	}

}
