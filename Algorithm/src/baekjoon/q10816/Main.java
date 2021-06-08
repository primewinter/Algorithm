package baekjoon.q10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 숫자 카드2
 * URL: https://www.acmicpc.net/problem/10816
 */
public class Main {

	static final int MAX = 10000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] positive = new int[MAX+1];
		int[] negative = new int[MAX];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num;
		for(int i = 0; i < n ; i++) {
			num = Integer.parseInt(st.nextToken());
			if( num >= 0 ) positive[num]++;
			else negative[num*(-1)-1]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < m ; i++) {
			num = Integer.parseInt(st.nextToken());
			if( num >= 0 ) sb.append(positive[num]);
			else sb.append(negative[num*(-1)-1]);
			sb.append(" ");
		}
		
		System.out.println(sb);

	}

}
