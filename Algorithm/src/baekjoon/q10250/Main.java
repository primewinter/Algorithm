package baekjoon.q10250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ ACM 호텔
 * URL: https://www.acmicpc.net/problem/10250
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int h, n; // w는 계산에 쓰이지 않는다.
		int floor;
		int number;
		StringTokenizer st;
		
		for(int i = 0; i < t ; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			st.nextToken(); // 쓰이지 않는 w 값
			n = Integer.parseInt(st.nextToken());
			
			// 층 구하기 : n을 h로 나눈 나머지
			floor =  (n-1) % h + 1;
			
			// 호수 구하기 : n을 h로 나눈 몫
			number = (n-1) / h + 1;
			
			sb.append(floor).append(String.format("%02d", number)).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
}
