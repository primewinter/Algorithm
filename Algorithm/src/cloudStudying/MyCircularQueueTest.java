package cloudStudying;

public class MyCircularQueueTest {
	/*
	원형 큐 구현
	문제
	주어빈 뼈대코드를 수정하여 원형큐를 구현하고, 그 결과를 출력 예와 비교하시오.
	
	출력 예
	---------------
	 6  ø  3  4  5 
	---------------
	[0][1][2][3][4]
	front: [2], rear: [0], isEmpty?: false, isFull?: false
	
	 */
		public static void main(String[] args) {
		    MyCircleQueue queue = new MyCircleQueue();
		    int data = 1;
		    while (!queue.isFull()) {
		      queue.enqueue(data++);
		    }
		    queue.dequeue();
		    queue.dequeue();
		    queue.enqueue(data++);
		    System.out.println(queue);
		  }
		}
		class MyCircleQueue {
		  private int[] elements;
		  private int capacity;
		  private int front; // 꺼내올 요소의 인덱스
		  private int rear; // 마지막 추가 요소의 인덱스
		  private int size; // 요소 개수
		  public MyCircleQueue() {
		    this.elements = new int[5];
		    this.capacity = 5;
		    this.front = 0;
		    this.rear = 0;
		    this.size = 0;
		  }
		  public int dequeue() {
		    /* 해당 메소드를 구현하시오. */
			if(front == size) {
				front = 0;
			}
			size--;
			return elements[front++];
			  
		  }
		  public void enqueue(int data) {
		    /* 해당 메소드를 구현하시오. */
			  System.out.println("[enqueue] rear : "+rear+"|| front : "+front+"|| size : "+size);
			  size++;
			  if(rear == size && rear >= front) {
				  rear = 0;
				  size++;
				  elements[rear++]=data;
			  } else if (rear < size && rear < front) {
				  size++;
				  elements[++rear]=data;
			  }
		  }
		  public boolean isEmpty() {
		    return size == 0;
		  }
		  public boolean isFull() {
		    return size == capacity;
		  }
		  @Override
		  public String toString() {
		    StringBuffer sbuf = new StringBuffer("---------------\n");
		for (int i = 0; i < capacity; i++) {
		  if (!isEmpty() && (front <= rear && i >= front && i <= rear) || (front > rear && (i >= front || i <= rear)))
		    sbuf.append(String.format("%2d ", elements[i]));
		  else
		    sbuf.append(String.format("%2s ", "ø"));
		}
		sbuf.append("\n---------------\n");
		sbuf.append("[0][1][2][3][4]\n\n");
		sbuf.append(String.format("front: [%d], rear: [%d], isEmpty?: %s, isFull?: %s", front, rear, isEmpty(), isFull()));
		    return sbuf.toString();
		  }
}
