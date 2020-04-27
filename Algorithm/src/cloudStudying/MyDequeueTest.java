package cloudStudying;

public class MyDequeueTest {
	  public static void main(String[] args) {
	    MyDequeue queue = new MyDequeue();
	    int data = 1;
	    while (!queue.isFull()) {
	      queue.enqueue(data++);
	    }
	    System.out.println(queue);
	    while (!queue.isEmpty()) {
	      System.out.println(queue.dequeue());
	    }
	    System.out.println(queue);
	  }
	}
	class MyDequeue {
	  private int[] elements;
	  private int capacity;
	  private int front; // ������ ����� �ε���
	  private int rear; // ������ �߰� ����� �ε���
	  private int size; // ��� ����
	  public MyDequeue() {
	    this.elements = new int[5];
	    this.capacity = 5;
	    this.front = 0;
	    this.rear = 0;
	    this.size = 0;
	  }
	  public int dequeue() {
	    /* �ش� �޼ҵ带 �����Ͻÿ�. */
		if(isEmpty())
			return -1;
		else
			size--;
			return elements[front++];
	  }
	  public void enqueue(int data) {
	    if (isEmpty()) // size == 0
	      elements[rear] = data;
	    else
	      elements[++rear] = data;
	    size++;
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
	      if (i >= front && i <= rear && !isEmpty())
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
