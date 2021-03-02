package baekjoon.stack.q9012;

import java.util.Scanner;
import java.util.Stack;

//18496KB	264ms
public class Main2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            String input = sc.next();
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