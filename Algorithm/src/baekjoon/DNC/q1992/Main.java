package baekjoon.DNC.q1992;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static int[][] matrix;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        matrix = new int[N][N];
        for(int i=0; i<N ; i++) {
        	String[] arr = br.readLine().split("");
            for(int j=0; j<N; j++) {
            	matrix[i][j] = Integer.parseInt(arr[j]);
            }
        }
        partition(0, 0, N);
        System.out.println(sb.toString());
    }
    
    public static void partition(int row, int col, int size) {
        if(isSameColor(row, col, size)) {
            int color = matrix[row][col];
            sb.append(color);
            return;
        }
        
        int newSize = size/2;
        sb.append("(");
        partition(row, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
        sb.append(")");
    }
    
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
