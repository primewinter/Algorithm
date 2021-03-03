package baekjoon.stack.q1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        int prev = 0;
        int now = 0;
        int count = 1;
        boolean isNo = false;
        
        for(int i=0; i<n; i++) {
            now = Integer.parseInt(br.readLine());
            if(prev<now) {
                while(count <= now) {
                    stack.add(count++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if(stack.pop()==now) {
                    sb.append("-\n");
                } else {
                    isNo = true;
                }
            }
            prev = now;
        }
        
        if(isNo) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }
    }
}

