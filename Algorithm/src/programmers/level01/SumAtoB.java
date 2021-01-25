package programmers.level01;

public class SumOfTwoIntegers {
	 public long solution(int a, int b) {
        if(a==b) return a;
        int large = Math.max(a,b);
        int small = Math.min(a,b);
        long answer = 0;
        for(int i=small;i<=large;i++) {
            answer+=i;
        }
        return answer;
    }
}
