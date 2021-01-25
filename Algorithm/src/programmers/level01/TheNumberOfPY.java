package programmers.level01;

public class TheNumberOfPY {
	boolean solution(String s) {
        int diff = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='p'||ch=='P') diff++;
            if(ch=='y'||ch=='Y') diff--;
        }
        return diff==0;
    }
}
