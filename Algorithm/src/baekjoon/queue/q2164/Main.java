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
			// ī�� ������
			size--;
			frontIdx++;
			
			// �� �� ī�� �� ������ �ű��
			arr[++backIdx] = arr[frontIdx++];
		}
		
		System.out.println(arr[backIdx]);
	}
	
}

