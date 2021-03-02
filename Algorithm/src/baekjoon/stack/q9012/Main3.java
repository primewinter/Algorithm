package baekjoon.stack.q9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//14668KB	144ms
public class Main3 {
	public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            if(check(input)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch:str.toCharArray()) {
            if(ch=='(') {
                stack.add(ch);
            } else if(ch==')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
