package cloudStudying;

public class MyEnqueueTest {
	  public static void main(String[] args) {
	    MyQueue queue = new MyQueue();
	    queue.enqueue(5);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    queue.enqueue(5);
	    System.out.println(queue);
	    
	  }
	}

	class MyQueue {
	  private int[] elements;
	  private int capacity;
	  private int front; // 꺼내올 요소의 인덱스
	  private int rear; // 마지막 추가 요소의 인덱스
	  private int size; // 요소 개수

	  public MyQueue() {
	    this.elements = new int[5];
	    this.capacity = 5;
	    this.front = 0;
	    this.rear = 0;
	    this.size = 0;
	  }

	  public void enqueue(int data) {
		  /* 1번 문제 : 주어진 뼈대코드에 enqueue() 메소드를 구현하고, 그 결과를 출력 예와 비교하시오.
		    ---------------
			 1  2  3  ø  ø 
			---------------
			[0][1][2][3][4]
			front: [0], rear: [2], isEmpty?: false
		   * */
		  rear = size++;
		  elements[size-1] = data;
	  }
	  
	  public int front() {
	    return elements[front];
	  }

	  public int rear() {
	    return elements[rear];
	  }

	  public boolean isEmpty() {
	    return size == 0;
	  }

	  @Override
	  public String toString() {
	    StringBuffer sbuf = new StringBuffer("---------------\n");
	    for (int i = 0; i < capacity; i++) {
	      if (i >= front && i <= rear && !isEmpty())
	        sbuf.append(String.format("%2d ", elements[i]));
	      else
	        sbuf.append(String.format("%2s ", "ø"));
	    }
	    sbuf.append("\n---------------\n");
	    sbuf.append("[0][1][2][3][4]\n\n");
	    sbuf.append(String.format("front: [%d], rear: [%d], isEmpty?: %s", front, rear, isEmpty()));
	    return sbuf.toString();
	  }
	}
