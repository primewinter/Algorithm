package baekjoon.q2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * TITLE: BOJ 수 정렬하기2
 * URL: https://www.acmicpc.net/problem/2751
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[2000001]; // -1,000,000 ~ 1,000,000
		
		int n = Integer.parseInt(br.readLine());
		int num;
		for(int i = 0 ; i < n ; i++) {
			num = Integer.parseInt(br.readLine());
			arr[ num + 1000000 ]++; 
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			if( arr[i] > 0 ) {
				bw.write( String.valueOf(i-1000000) );
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
