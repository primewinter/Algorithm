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
		
		// matrix�� �Է°� ä���
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		
	}
	
	/*
	 * row : �����ϴ� ��
	 * col : �����ϴ� ��
	 * size: ������ ũ��
	 * �ش� ������ ���� ���̸� �ش� �������� ������ �����ϰ�, �ƴϸ� ������ 4����Ͽ� ��� ȣ��
	 */
	public static void partition(int row, int col, int size) {
		
		// �ش� ������ ���� ��� ���ٸ�
		if(isSameColor(row, col, size)) {
			
			if( matrix[row][col] == 0 ) {
				white++;
			} else {
				blue++;
			}
			// �� �̻� �����̸� ������ �ʰ� ����
			return;
			
		}
		
		// ũ�⸦ �ݸ�ŭ ���δ�
		int newSize = size/2;
		
		// �ش� ������ ���� ��� ���� �ʴٸ� 4����Ͽ� ���� ��� ȣ���Ѵ�
		partition(row, col, newSize); // 2��и�
		partition(row, col+newSize, newSize); // 1��и�
		partition(row+newSize, col, newSize); // 3��и�
		partition(row+newSize, col+newSize, newSize); // 4��и�
	}
	
	/*
	 * row : �����ϴ� ��
	 * col : �����ϴ� ��
	 * size: ������ ũ��
	 * �ش� ������ ���� ������ �̷���� ������ T, �ƴϸ� F ��ȯ
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
