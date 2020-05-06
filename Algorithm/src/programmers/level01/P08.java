package programmers.level01;

import java.util.Arrays;

public class P08 {

	public static void main(String[] args) {
		// 행렬의 덧셈
		//int[][] arr1= {{1,2}, {2,3}};
		int[][] arr1 = {{1},{2}};
		//int[][] arr2 = {{3,4}, {5,6}};
		int[][] arr2 = {{3}, {4}};
		//내코딩
		int[][] answer = new int[arr1.length][arr1[0].length];
		System.out.println(answer[0].length);
		
		for(int j = 0; j < arr1.length ; j++) {
			int i = 0;
				while (i < answer[0].length) {
				    answer[j][i] = arr1[j][i] + arr2[j][i];
				    System.out.println("answer["+j+"]["+i+"] : "+answer[j][i]);
				    i++;				
				}
		}
		//다른사람 코딩
//		int row = Math.max(A.length, B.length);
//	    int col = Math.max(A[0].length, B[0].length);
//	        //int[][] answer = {{0, 0}, {0, 0}};
//	    int[][] answer = new int[row][col];
//	    for(int i=0; i<row ; i++){
//	      for(int j=0; j<col; j++){
//	        answer[i][j] = A[i][j] + B[i][j];
//	      }
//	    }


	}

}
