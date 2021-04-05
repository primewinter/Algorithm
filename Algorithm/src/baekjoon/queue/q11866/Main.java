package baekjoon.queue.q11866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			que.add(i+1);
		}
		
		int count = 0;
		while(!que.isEmpty()) {
			int top = que.poll();
			count++;
			if(count==K) {
				sb.append(top+", ");
				count = 0;
			} else {
				que.add(top);
			}
		}
		System.out.println(sb.substring(0, sb.length()-2)+">");
		br.close();
		
		
	}
}
