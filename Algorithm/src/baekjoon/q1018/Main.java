package baekjoon.q1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/**
	 * TITLE: BOJ 체스판 다시 칠하기
	 * URL: https://www.acmicpc.net/problem/1018
	 * HINT: 브루트포스
	 */
	
	final static boolean B_VALUE = true;
	final static boolean W_VALUE = false;
	static boolean[][] board;
	static boolean[][] standard;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new boolean[n][m];
		String str;
		for(int i = 0 ; i < n ; i++) {
			str = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				board[i][j] = str.charAt(j)=='B'?B_VALUE:W_VALUE;
			}
		}
		
		// 기준이 될 올바른 체스판 생성
		// 기준 체스판은 B로 시작하는 것과 W로 시작하는 것을 따로 만들지 않고 하나만 생성한다.
		standard = new boolean[8][8];
		standard[0][0] = B_VALUE;
		for(int i = 0 ; i < 8; i++) {
			if( i > 0 ) standard[i][0] = !standard[i-1][0];
			for(int j = 1 ; j < 8; j++) {
				standard[i][j] = !standard[i][j-1];
			}
		}
		
		int count;
		int answer = n*m;
		for(int i = 0; i <= n-8 ; i++) {
			for(int j = 0 ; j <= m-8 ; j++) {
				count = getCountToBePainted(i, j);
				if( answer > count ) answer = count;
			}
		}
		
		System.out.println(answer);
	}
	
	/**
	 * 사용자가 입력한 n*m 체스판을 8*8로 쪼갠 뒤, 기준 체스판과 비교하여 최소로 색칠해야 하는 개수를 구한다.
	 * @param 체스판 자를 시작 rowIndex
	 * @param 체스판 자를 시작 colIndex
	 * @return 색칠해야 하는 최소 개수
	 */
	public static int getCountToBePainted(int row, int col) {
		int same = 0; // 기준 체스판
		int diff = 0; // 기준 체스판의 반전
		
		for(int i = row ; i < row+8 ; i++) {
			for(int j = col ; j < col+8 ; j++) {
				if( board[i][j] == standard[i-row][j-col] ) same++;
				else diff++;
			}
		}
		
		return Math.min(same, diff);
	}

}
