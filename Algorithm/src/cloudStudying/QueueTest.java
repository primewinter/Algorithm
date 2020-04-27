package cloudStudying;

import java.lang.reflect.Method;

public class QueueTest {
  public static void main(String[] args) {
	  /*
	   * ����
		�Ʒ��� ť ������ Ŭ���� ���̾�׷��� �����Ͽ�, Queue �������̽��� �����ϰ�, ��� ���� ���� ����� �����ÿ�.
		
		��� ��
		dequeue() : Integer
		front() : Integer
		rear() : Integer
		isFull() : boolean
		isEmpty() : boolean
		enqueue(int) : void
		
		ť ����
		�����͸� �߰� �� ������ �� �ִ�.
		���� ���� �߰��� �����Ͱ� ���� ���� ���ŵȴ�.
		front �����͸� Ȯ���� �� �ִ�. (�����Ͱ� ���� ��� null ���� ��ȯ)
		rear �����͸� Ȯ���� �� �ִ�. (�����Ͱ� ���� ��� null ���� ��ȯ)
		ť�� ����ִ� ��� null ���� ��ȯ�Ѵ�.
		ť�� ���� �� ��� ����� ����ϸ�, �����ʹ� �߰����� �ʴ´�.
	   */
    // �޼ҵ� ��� ȹ��
    Method[] methodList = Queue.class.getMethods();

    // �޼ҵ� ���� ���
    for (Method m : methodList) {
      System.out.printf("%s(", m.getName());
      Class<?>[] paramTypes = m.getParameterTypes();
      for (Class<?> paramType : paramTypes) {
        System.out.printf("%s", paramType.getName());
      }
      System.out.printf(") : %s\n", m.getReturnType().getSimpleName());
    }
  }
}

/* �Ʒ��� Queue �������̽��� �ϼ��Ͻÿ�. */
interface Queue {
  public void enqueue(int n);
  /* 1. dequeue() �޼ҵ带 ������ ��. */
  public Integer dequeue();
  
  public Integer front();
  /* 2. rear() �޼ҵ带 ������ ��. */
  public Integer rear();
  
  public boolean isEmpty();
  /* 3. isFull() �޼ҵ带 ������ ��. */
  public boolean isFull();

}