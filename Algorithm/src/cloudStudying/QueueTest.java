package cloudStudying;

import java.lang.reflect.Method;

public class QueueTest {
  public static void main(String[] args) {
	  /*
	   * 문제
		아래의 큐 명세서와 클래스 다이어그램을 참고하여, Queue 인터페이스를 구현하고, 출력 예와 같은 결과를 얻으시오.
		
		출력 예
		dequeue() : Integer
		front() : Integer
		rear() : Integer
		isFull() : boolean
		isEmpty() : boolean
		enqueue(int) : void
		
		큐 명세서
		데이터를 추가 및 제거할 수 있다.
		가장 먼저 추가한 데이터가 가장 먼저 제거된다.
		front 데이터를 확인할 수 있다. (데이터가 없는 경우 null 값을 반환)
		rear 데이터를 확인할 수 있다. (데이터가 없는 경우 null 값을 반환)
		큐가 비어있는 경우 null 값을 반환한다.
		큐가 가득 찬 경우 경고문을 출력하며, 데이터는 추가되지 않는다.
	   */
    // 메소드 목록 획득
    Method[] methodList = Queue.class.getMethods();

    // 메소드 정보 출력
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

/* 아래의 Queue 인터페이스를 완성하시오. */
interface Queue {
  public void enqueue(int n);
  /* 1. dequeue() 메소드를 선언할 것. */
  public Integer dequeue();
  
  public Integer front();
  /* 2. rear() 메소드를 선언할 것. */
  public Integer rear();
  
  public boolean isEmpty();
  /* 3. isFull() 메소드를 선언할 것. */
  public boolean isFull();

}