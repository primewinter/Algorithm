package baekjoon.stack.q10773;

import java.util.Scanner;

public class Q10773 {
	 public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        
	        int[] arr = new int[n];
	        int topIdx = -1;
	        for(int i=0; i<n; i++) {
	            int num = sc.nextInt();
	            if(num==0) {
	                arr[topIdx--] = 0;
	            } else {
	                arr[++topIdx] = num;
	            }
	        }
	        int answer = 0;
	        for(int i=0; i<n;i++) {
	            answer += arr[i];
	        }
	        System.out.println(answer);
	        
	    }
}
