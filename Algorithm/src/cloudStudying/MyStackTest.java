package cloudStudying;


public class MyStackTest {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);
    int removed = stack.pop();
    int topData = stack.peek();
    System.out.printf("pop: %d\n", removed);
    System.out.printf("peek: %d\n", topData);
    System.out.println(stack);
  }
}
class MyStack {
  private int[] array;
  private int capacity;
  private int top;
  public MyStack() {
    this.array = new int[5];
    this.capacity = 5;
    this.top = -1;
  }
  public int pop() {
    /* 해당 메소드를 구현하시오. */
	  int answer = array[-1+top--];
	  System.out.println("[-1+top] : "+answer+" // top : "+top);
	  return array[-1+top--];    
  }
  public int peek() {
    /* 해당 메소드를 구현하시오. */
    return array[top];
  }
  public void push(int data) {
    array[++top] = data;
  }
  @Override
  public String toString() {
    StringBuffer sbuf = new StringBuffer("\n");
    for (int i = capacity - 1; i >= 0; i--) {
      Integer data = (i <= top) ? array[i] : null;
      sbuf.append(String.format("| %4s |%s\n", data, (i == top) ? " <- top " : ""));
    }
    return sbuf.append("--------\n").toString();
  }
}