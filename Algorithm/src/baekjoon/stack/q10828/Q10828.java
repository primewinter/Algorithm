package baekjoon.stack.q10828;

import java.util.*;
public class Q10828 {

    static int top;
    static int size;
    static int[] stack;
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // initialize
        top = -1;
        size= sc.nextInt();
        stack = new int[size];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<size; i++) {
            String cmd = sc.next();
            switch(cmd) {
                case "push":
                    int num = sc.nextInt();
                    stack[++top] = num;
                    break;
                case "top":
                    if(top>-1) {
                        sb.append(stack[top]+"\n");    
                    } else {
                        sb.append(-1+"\n");
                    }
                    break;
                case "pop":
                    if(top==-1) {
                        sb.append(top+"\n");
                    } else {
                        sb.append(stack[top--]+"\n");    
                    }
                    break;
                case "size":
                    sb.append((top+1)+"\n");
                    break;
                case "empty":
                    if(top>-1) {
                        sb.append(0+"\n");
                    } else {
                        sb.append(1+"\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
	}	
}
