package baekjoon.q10250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ ACM ȣ��
 * URL: https://www.acmicpc.net/problem/10250
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int h, n; // w�� ��꿡 ������ �ʴ´�.
		int floor;
		int number;
		StringTokenizer st;
		
		for(int i = 0; i < t ; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			st.nextToken(); // ������ �ʴ� w ��
			n = Integer.parseInt(st.nextToken());
			
			// �� ���ϱ� : n�� h�� ���� ������
			floor =  (n-1) % h + 1;
			
			// ȣ�� ���ϱ� : n�� h�� ���� ��
			number = (n-1) / h + 1;
			
			sb.append(floor).append(String.format("%02d", number)).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
}
