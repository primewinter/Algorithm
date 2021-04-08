package baekjoon.queue.q10866;

import java.io.*;
import java.util.StringTokenizer;

public class OtherSolution {
	
	/*
	 * Deque �迭���� front�� ���������� ����Ű�� ��ġ�� �׻� ����д�.
	 * ��, ���� �տ��ִ� ���Ҵ� front + 1�� �ȴ�.
	 * 
	 * ������ ���� front�� ���� ��ġ�� ���Ҹ� �ְ� �Ǹ� ������ ��
	 * ���ܰ� �߻��Ѵ�.
	 * 
	 * ���ε��  push_front(3) �� �����Ϸ� �ϴµ� �ƹ� ���ҵ� ���� ��  
	 * front--; ���ҽ�Ų �� deque[front] = 3; �� �Ǹ�
	 * deque[9999] = 3; �� �ȴ�. �̶� front = 9999; back = 0 �� �ȴ�.
	 * 
	 * ������, ���Ұ� �� ���� ���� ��� �ش� ���Ҵ� front ���� back ���Ұ� �ȴ�.
	 * �̷��� ��츦 �����ϱ� ���� deque[front] �� ���Ҹ� ���� ��, 
	 * front = (front - 1 + array.length) % array.length; �� ���ش�.
	 * 
	 * ��������� front ��� ��ü�� deque[(front + 1) % array.length] ��ġ�� �ڸ��Ѵ�.
	 * ((front + 1) % array.length == (front + 1) % 10000)
	 */
	
    public static class Deque {
        static final int DEQUE_SIZE = 100005;
        private int[] deque;
        private int front;
        private int rear;

        public Deque() {
            deque = new int[DEQUE_SIZE];
            front = rear = 0;
        }

        public void pushFront(int num) {
        	// ���Ҹ� ���� ���� �� front�� ���ҽ�Ų��.
    		deque[front] = num;
    		// ������ ���� �ʵ��� �迭 ũ�⸸ŭ �����ش�.
    		front = (front - 1 + 10000) % 10000;
        	
//            front = (front-1 + DEQUE_SIZE) % DEQUE_SIZE;
//            deque[(front+1) % DEQUE_SIZE] = num;
        }

        public void pushBack(int num) {
        	/*
    		 *  deque[DEQUE_SIZE] ���� �� á�� ��� 0���� ����Ű�� ����
    		 *  �迭 ũ�⸸ŭ ���� �������� ���Ѵ�.
    		 */
            rear = (rear + 1) % DEQUE_SIZE;
            deque[rear] = num;
        }

        public int popFront() {
            if (empty() == 1) return -1;
            /*
    		 *  front + 1�� front �����̹Ƿ� �ش� ���Ҹ� �ӽ� ������ �� �� 
    		 *  front �� +1 ������Ų��.
    		 */
            front = (front + 1) % DEQUE_SIZE;
            return deque[front];
        }

        public int popBack() {
            if (empty() == 1) return -1;
            int num = deque[rear];
            rear = (rear -1 + DEQUE_SIZE) % DEQUE_SIZE;
            return num;
        }

        public int size() {
            int size = 0;
            if (front > rear) {
                size = (DEQUE_SIZE - front + rear) % DEQUE_SIZE;
            } else {
                size = rear - front;
            }

            return size;
        }

        public int empty() {
            return front == rear ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) return -1;
            return deque[(front+1)%DEQUE_SIZE];
        }

        public int back() {
            if (empty() == 1) return -1;
            return deque[rear];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque deque = new Deque();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    int num = Integer.parseInt(st.nextToken());
                    deque.pushFront(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.pushBack(num);
                    break;
                case "pop_front":
                    sb.append(deque.popFront()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.popBack()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}
