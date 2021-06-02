package baekjoon.q11729;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	/*
	 * TITLE: BOJ 하노이 탑 이동순서
	 * URL: https://www.acmicpc.net/problem/11729
	 * HINT: 재귀함수
	 */
 
    static int count;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        hanoi(n, 1, 2, 3);

        System.out.println(count+"\n"+sb);
        br.close();

    }
    
    /*
     * 하노이의 탑 
     * N개의 원반을 기둥A에서 기둥C로 옮기기 위해서는 다음의 과정을 거친다.
     * 
     * 1) N-1개의 원반을 A에서 B로 이동시켜야 한다.
     * 2) N번째 원반을 A에서 C로 이동시킨다.
     * 3) N-1개의 원반을 B에서 C로 이동시킨다.
     * 
     */
    static void hanoi(int target, int from, int via, int to) {                
    	
        if( target == 0 ) {
            return;
        }
        else {
            hanoi(target-1, from, to, via); // 1)
            sb.append(from+" "+to).append("\n");
            count++; // 2)
            hanoi(target-1, via, from, to); // 3)
        }
                
        
    }
   
}

