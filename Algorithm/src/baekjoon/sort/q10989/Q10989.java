package baekjoon.sort.q10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * TITLE: BOJ 수 정렬하기3
 * URL: https://www.acmicpc.net/problem/10989
 */
public class Q10989 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		quickSort(arr, 0, n-1);
		
		for(int el : arr) {
			bw.write(String.valueOf(el));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	/**
	 * pivot 중심으로 왼쪽에는 pivot보다 작은 숫자, 오른쪽에는 pivot보다 큰 숫자 두기
	 */
	static int partition(int[] array,int start, int end) { 
		
		int pivot = array[(start + end) / 2]; 
		
		while( start <= end ) { 
			// 오른쪽에서부터 pivot보다 작은 숫자 탐색
			while( array[start] < pivot ) start++;
			// 왼쪽에서부터 pivot보다 큰 숫자 탐색
			while( array[end] > pivot ) end--; 
			// 자리 바꾸기
			if( start <= end ) { 
				int tmp = array[start]; 
				array[start] = array[end]; 
				array[end] = tmp; 
				start++; 
				end--; 
			} 
		}
		
		return start; 
	} 
	
	static int[] quickSort(int[] array,int start, int end) { 

		int p = partition(array, start, end); 
		
		if(start < p-1) 
			quickSort(array, start, p-1); 
		
		if(p < end) 
			quickSort(array, p, end); 
		
		return array; 
	}

}
