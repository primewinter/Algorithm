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
				// ������ �̰��� �ϴ� ������ ��ġ(index) ã�� 
				int targetIdx = deque.indexOf(now);
				int halfIdx;
				/*
				 *  ���� ���� ���� ���Ұ� ¦�� ����� �߰� ������ 
				 *  ���� ���� ���� ũ�⿡�� -1 ���ҽ�Ų��. 
				 *  
				 *  {1, 2, 3, 4} �� ��, 2�� �߰��������� �ϸ�
				 *  �ε����� 1�̱� ����
				 */
				if(deque.size()%2 == 0) {
					halfIdx = deque.size()/2-1;
				} else {
					halfIdx = deque.size()/2;
				}
				
				if (targetIdx <= halfIdx) { // �߰� ���� �Ǵ� �߰� �������� ������ ��ġ�� �տ� ���� ���
					// idx ���� �տ� �ִ� ���ҵ��� ��� �ڷ� ������. (2�� ����)
					for(int j=0; j < targetIdx; j++) {
						deque.addLast(deque.pollFirst());
						count++;
					}
				} else { // �߰� �������� ������ ��ġ�� �ڿ� �ִ� ���
					// idx�� ������ �ڿ� �ִ� ���ҵ��� ��� ������ ������. (3�� ����)
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
