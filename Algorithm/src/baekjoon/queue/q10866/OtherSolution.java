package baekjoon.queue.q10866;

import java.io.*;
import java.util.StringTokenizer;

public class OtherSolution {
	
	/*
	 * Deque 배열에서 front가 최종적으로 가리키는 위치는 항상 비워둔다.
	 * 즉, 가장 앞에있는 원소는 front + 1이 된다.
	 * 
	 * 이유는 만약 front의 최종 위치에 원소를 넣게 되면 다음과 같
	 * 예외가 발생한다.
	 * 
	 * 예로들어  push_front(3) 을 실행하려 하는데 아무 원소도 없을 때  
	 * front--; 감소시킨 뒤 deque[front] = 3; 이 되면
	 * deque[9999] = 3; 이 된다. 이때 front = 9999; back = 0 이 된다.
	 * 
	 * 하지만, 원소가 한 개만 있을 경우 해당 원소는 front 이자 back 원소가 된다.
	 * 이러한 경우를 방지하기 위해 deque[front] 에 원소를 넣은 뒤, 
	 * front = (front - 1 + array.length) % array.length; 을 해준다.
	 * 
	 * 결과적으로 front 요소 자체는 deque[(front + 1) % array.length] 위치에 자리한다.
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
        	// 원소를 먼저 넣은 뒤 front을 감소시킨다.
    		deque[front] = num;
    		// 음수가 되지 않도록 배열 크기만큼 더해준다.
    		front = (front - 1 + 10000) % 10000;
        	
//            front = (front-1 + DEQUE_SIZE) % DEQUE_SIZE;
//            deque[(front+1) % DEQUE_SIZE] = num;
        }

        public void pushBack(int num) {
        	/*
    		 *  deque[DEQUE_SIZE] 까지 꽉 찼을 경우 0으로 가리키기 위해
    		 *  배열 크기만큼 나눠 나머지를 구한다.
    		 */
            rear = (rear + 1) % DEQUE_SIZE;
            deque[rear] = num;
        }

        public int popFront() {
            if (empty() == 1) return -1;
            /*
    		 *  front + 1이 front 원소이므로 해당 원소를 임시 변수에 둔 뒤 
    		 *  front 을 +1 증가시킨다.
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
