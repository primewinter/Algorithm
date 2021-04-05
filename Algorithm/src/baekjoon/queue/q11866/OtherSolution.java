package baekjoon.queue.q11866;

import java.util.LinkedList;
import java.util.Scanner;

public class OtherSolution {

	public static void main(String[] args) {

		// better solution
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt()-1;
		int idx = K;
        
		StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i =1; i<=N; i++) queue.add(i);
        
        while(queue.size()!=1){
            sb.append(queue.get(idx).toString()+", ");
            queue.remove(idx);
            idx = (idx + K)%queue.size();
        }
        sb.append(queue.pop().toString() + ">");
        System.out.print(sb);
		

	}

}
