package cloudStudying;


import java.util.Stack;
public class Reversing {
  public static void main(String[] args) {
    Stack<Character> stack = new Stack<Character>();
    String str = "?���Ǵ¸� ���ý�";
    /* �˰����� �����Ͻÿ�. */
    for(int i=str.length()-1; i >=0 ; i--) {
    	System.out.print(str.charAt(i));
    }
    for(int i=0; i < str.length(); i++) {
    	stack.push(str.charAt(i));
    }
    for(int i=0; i<str.length(); i++) {
    	System.out.print(stack.pop());
    }
  }
}