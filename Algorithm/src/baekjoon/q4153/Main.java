package baekjoon.q4153;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	/**
	 * TITLE: BOJ Á÷°¢»ï°¢Çü 
	 * URL: https://www.acmicpc.net/problem/4153
	 */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        StringTokenizer st;

        int[] arr = new int[3];
        while(true) {
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if( arr[0]==0 && arr[1]==0 && arr[2]==0 ) break;

            Arrays.sort(arr);
            if( arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2] ) {
                answer.append("right");
            } else {
                answer.append("wrong");
            }

            answer.append("\n");
            
        }
        
        System.out.println(answer);
        br.close();
    }

}