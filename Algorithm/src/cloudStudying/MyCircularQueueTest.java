package cloudStudying;

public class MyCircularQueueTest {
	/*
	���� ť ����
	����
	�־�� �����ڵ带 �����Ͽ� ����ť�� �����ϰ�, �� ����� ��� ���� ���Ͻÿ�.
	
	��� ��
	---------------
	 6  ��  3  4  5 
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
		  private int front; // ������ ����� �ε���
		  private int rear; // ������ �߰� ����� �ε���
		  private int size; // ��� ����
		  public MyCircleQueue() {
		    this.elements = new int[5];
		    this.capacity = 5;
		    this.front = 0;
		    this.rear = 0;
		    this.size = 0;
		  }
		  public int dequeue() {
		    /* �ش� �޼ҵ带 �����Ͻÿ�. */
			if(front == size) {
				front = 0;
			}
			size--;
			return elements[front++];
			  
		  }
		  public void enqueue(int data) {
		    /* �ش� �޼ҵ带 �����Ͻÿ�. */
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
		    sbuf.append(String.format("%2s ", "��"));
		}
		sbuf.append("\n---------------\n");
		sbuf.append("[0][1][2][3][4]\n\n");
		sbuf.append(String.format("front: [%d], rear: [%d], isEmpty?: %s, isFull?: %s", front, rear, isEmpty(), isFull()));
		    return sbuf.toString();
		  }
}
