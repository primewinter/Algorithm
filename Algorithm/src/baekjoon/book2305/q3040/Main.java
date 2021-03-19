package baekjoon.book2305.q3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int diff = sum-100;
		try {
			for(int i=0; i<9; i++) {
				int sumOfTwo = 0;
				for(int j=0; j<9; j++) {
					if(i!=j) {
						sumOfTwo = arr[i]+arr[j];
						if(sumOfTwo==diff) {
							arr[i] = 0;
							arr[j] = 0;
							throw new Exception();
						}
					}
				}
			}
		} catch(Exception e) {
			for(int i=0; i<9; i++) {
				if(arr[i]==0) continue;
				System.out.println(arr[i]);
			}
		}
		
	}

}
