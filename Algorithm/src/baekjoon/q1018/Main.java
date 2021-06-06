package baekjoon.q1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/**
	 * TITLE: BOJ ü���� �ٽ� ĥ�ϱ�
	 * URL: https://www.acmicpc.net/problem/1018
	 * HINT: ���Ʈ����
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
		
		// ������ �� �ùٸ� ü���� ����
		// ���� ü������ B�� �����ϴ� �Ͱ� W�� �����ϴ� ���� ���� ������ �ʰ� �ϳ��� �����Ѵ�.
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
	 * ����ڰ� �Է��� n*m ü������ 8*8�� �ɰ� ��, ���� ü���ǰ� ���Ͽ� �ּҷ� ��ĥ�ؾ� �ϴ� ������ ���Ѵ�.
	 * @param ü���� �ڸ� ���� rowIndex
	 * @param ü���� �ڸ� ���� colIndex
	 * @return ��ĥ�ؾ� �ϴ� �ּ� ����
	 */
	public static int getCountToBePainted(int row, int col) {
		int same = 0; // ���� ü����
		int diff = 0; // ���� ü������ ����
		
		for(int i = row ; i < row+8 ; i++) {
			for(int j = col ; j < col+8 ; j++) {
				if( board[i][j] == standard[i-row][j-col] ) same++;
				else diff++;
			}
		}
		
		return Math.min(same, diff);
	}

}
