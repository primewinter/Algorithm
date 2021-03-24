package baekjoon.book2305.q14541;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// fail : NumberFormat Exception
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==-1) break;
			long miles = 0;
			int totalTime = 0;
			for(int i=0; i<n; i++) {
				String[] str = br.readLine().split(" ");
				int s = Integer.parseInt(str[0]);
				int t = Integer.parseInt(str[1]);
				miles += (t-totalTime)*s;
				totalTime = t;
			}
			sb.append(miles+" miles\n");
		}
		
		System.out.println(sb.toString());
	}

}
