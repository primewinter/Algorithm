package programmers.level02;

public class RightBrackets {
	/* �ùٸ� ��ȣ(+5)
	 * https://programmers.co.kr/learn/courses/30/lessons/12909
	 * ���� ����
��ȣ�� �ٸ��� ¦�������ٴ� ���� '(' ���ڷ� �������� �ݵ�� ¦��� ')' ���ڷ� ������ �Ѵٴ� ���Դϴ�. ���� ���

()() �Ǵ� (())() �� �ùٸ� ��ȣ�Դϴ�.
)()( �Ǵ� (()( �� �ùٸ��� ���� ��ȣ�Դϴ�.
'(' �Ǵ� ')' �θ� �̷���� ���ڿ� s�� �־����� ��, ���ڿ� s�� �ùٸ� ��ȣ�̸� true�� return �ϰ�, �ùٸ��� ���� ��ȣ�̸� false�� return �ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
���ڿ� s�� ���� : 100,000 ������ �ڿ���
���ڿ� s�� '(' �Ǵ� ')' �θ� �̷���� �ֽ��ϴ�.
����� ��
s	answer
()()	true
(())()	true
)()(	false
(()(	false
����� �� ����
����� �� #1,2,3,4
������ ���ÿ� �����ϴ�.
	 */

	static boolean solution(String s) {
        char[] chArr = s.toCharArray();
        int flag = 0;
        for(char ch : chArr) {
        	if(ch=='(') {
        		flag++;
        	} else if (ch==')') {
        		flag--;
        	}
        	if(flag<0) { return false; }
        }
        
        return flag==0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
