package baekjoon.DNC.q1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int[][] matrix;
    private static int[] result;

    public static void main(String[]  args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][N];
        result = new int[3];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        divide(0, 0, N);
        
        StringBuilder sb = new StringBuilder();
        for(int n : result) {
        	sb.append(n+"\n");
        }
        System.out.println(sb);
        br.close();
    }
    
    public static void divide(int row, int col, int size) {
        
        if(isSame(row, col, size)) {
            result[matrix[row][col]+1]++;
            return;
        }
        
        int newSize = size/3;

        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		divide(row+(i*newSize), col+(j*newSize), newSize);
        	}
        }
        
    }
    
    public static boolean isSame(int row, int col, int size) {
        
    	for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if( matrix[i][j] != matrix[row][col] ) return false;
            }
        }
    	
        return true;
    }
}
