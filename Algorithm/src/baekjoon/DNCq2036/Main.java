package baekjoon.DNCq2036;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] matrix;
	public static int blue;
	public static int white;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// matrix에 입력값 채우기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		
	}
	
	/*
	 * row : 시작하는 행
	 * col : 시작하는 열
	 * size: 범위의 크기
	 * 해당 범위가 같은 색이면 해당 색종이의 개수를 변경하고, 아니면 범위를 4등분하여 재귀 호출
	 */
	public static void partition(int row, int col, int size) {
		
		// 해당 범위의 색이 모두 같다면
		if(isSameColor(row, col, size)) {
			
			if( matrix[row][col] == 0 ) {
				white++;
			} else {
				blue++;
			}
			// 더 이상 색종이를 나누지 않고 종료
			return;
			
		}
		
		// 크기를 반만큼 줄인다
		int newSize = size/2;
		
		// 해당 범위의 색이 모두 같지 않다면 4등분하여 각각 재귀 호출한다
		partition(row, col, newSize); // 2사분면
		partition(row, col+newSize, newSize); // 1사분면
		partition(row+newSize, col, newSize); // 3사분면
		partition(row+newSize, col+newSize, newSize); // 4사분면
	}
	
	/*
	 * row : 시작하는 행
	 * col : 시작하는 열
	 * size: 범위의 크기
	 * 해당 범위가 같은 색으로 이루어져 있으면 T, 아니면 F 반환
	 */
	public static boolean isSameColor(int row, int col, int size) {
		
		int color = matrix[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				
				if( matrix[i][j] != color ) {
					return false;
				}
			}
		}

		return true;
	}

}
