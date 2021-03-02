package baekjoon.stack.q9012;

import java.util.Scanner;

// 18456KB 248ms
public class Main1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0;
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            flag = 0;
            char[] arr = sc.next().toCharArray();
            for(int j=0; j<arr.length; j++) {
                if(arr[j]=='(') {
                    flag++;
                } else if(arr[j]==')') {
                    flag--;
                }
                
                if(flag<0) break;
            }
            if(flag==0) { 
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }
        }
        System.out.println(answer.toString());
    }
}
