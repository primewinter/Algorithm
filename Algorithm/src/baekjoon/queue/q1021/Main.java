package baekjoon.queue.q1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		LinkedList<Integer> deque = new LinkedList<>();
		for(int i=0; i<N; i++) {
			deque.add(i+1);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int now;
		int count = 0;
		for(int i=0; i<M; i++) {
			now = Integer.parseInt(st.nextToken());
			if (deque.peekFirst()!=now) {
				// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
				int targetIdx = deque.indexOf(now);
				int halfIdx;
				/*
				 *  만약 현재 덱의 원소가 짝수 개라면 중간 지점을 
				 *  현재 덱의 절반 크기에서 -1 감소시킨다. 
				 *  
				 *  {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면
				 *  인덱스는 1이기 때문
				 */
				if(deque.size()%2 == 0) {
					halfIdx = deque.size()/2-1;
				} else {
					halfIdx = deque.size()/2;
				}
				
				if (targetIdx <= halfIdx) { // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
					// idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
					for(int j=0; j < targetIdx; j++) {
						deque.addLast(deque.pollFirst());
						count++;
					}
				} else { // 중간 지점보다 원소의 위치가 뒤에 있는 경우
					// idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
					for(int j = 0; j < deque.size() - targetIdx; j++) {
						deque.addFirst(deque.pollLast());
						count++;
					}
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
		br.close();
	}

}
