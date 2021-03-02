package baekjoon.stack.q4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//32120KB	396ms
public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line.equals(".")) break;
            if(check(line)) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb.toString());
    }
    
    static boolean check(String str) {
        String refined = str.replaceAll("[^()\\[\\]]","");
        Stack<Character> brackets = new Stack<>();
        for(char ch: refined.toCharArray()) {
            if(ch=='('||ch=='[') {
                brackets.add(ch);
            } else if(ch==')') {
            	if(brackets.isEmpty()) return false;
                else if(brackets.pop()!='(') return false;
             } else if(ch==']') {
                if(brackets.isEmpty()) return false;
                else if(brackets.pop()!='[') return false;
            }
        }
        if(brackets.isEmpty()) return true;
        return false;
    }
}
