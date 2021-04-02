package baekjoon.queue.q2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[2*n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		int frontIdx = 0;
		int backIdx = n-1;
		int size = n;
		
		while(size>1) {
			// 카드 버리기
			size--;
			frontIdx++;
			
			// 맨 위 카드 맨 밑으로 옮기기
			arr[++backIdx] = arr[frontIdx++];
		}
		
		System.out.println(arr[backIdx]);
	}
	
}

