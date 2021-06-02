package baekjoon.q2447;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {
	
	/*
	 * TITLE: BOJ º°Âï±â10
	 * URL: https://www.acmicpc.net/problem/2447
	 * HINT: Àç±ÍÇÔ¼ö
	 */

    static int[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        matrix = new int[n][n];
        printStar(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int[] row : matrix) {
            for(int col : row) {
                if( col == 1 ) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        
        br.close();
        System.out.println(sb);
    }
    
    public static void printStar(int row, int col, int size) {
        if( size <= 3 ) {
            for(int i = row ; i < row+3 ; i++) {
                for(int j = col ; j < col+3 ; j++) {
                    if( i != row+1 || j != col+1 ) matrix[i][j] = 1;
                }
           }

           return;
        }

        int newSize = size / 3;
        
        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                if( i == 1 && j == 1 ) continue;
                else printStar(row+i*newSize, col+j*newSize, newSize);
            }
        }
    }
}

