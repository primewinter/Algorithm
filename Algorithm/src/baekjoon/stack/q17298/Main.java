package baekjoon.stack.q17298;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] answer = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] =sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		
		for(int i=0; i<n; i++) {
			sb.append(answer[i]+" ");
		}
		
		System.out.println(sb.toString());
	}
	
	
	
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        
//        String[] arr = br.readLine().split(" ");
//        
//        boolean hasNGE = false;
//        for(int i=0; i<n-1; i++) {
//            hasNGE = false;
//            for(int j=i; j<n; j++) {
//                if(Integer.parseInt(arr[i])<Integer.parseInt(arr[j])) {
//                    hasNGE = true;
//                    sb.append(arr[j]+" ");
//                    break;
//                }
//            }
//            if(!hasNGE) sb.append("-1 ");
//        }
//        System.out.println(sb.toString());
//    }
}