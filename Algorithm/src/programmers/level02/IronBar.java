package programmers.level02;

import java.util.Stack;

public class IronBar {
	/* �踷���
	 * https://programmers.co.kr/learn/courses/30/lessons/42585#
	 * ���� ����
	���� ���� �踷��⸦ �������� �����Ϸ��� �մϴ�. ȿ������ �۾��� ���ؼ� �踷��⸦ �Ʒ����� ���� ���� ����, �������� ������ �������� �߻��Ͽ� �踷������ �ڸ��ϴ�. �踷���� �������� ��ġ�� ���� ������ �����մϴ�.
	
	- �踷���� �ڽź��� �� �踷��� ������ ���� �� �ֽ��ϴ�.
	- �踷��⸦ �ٸ� �踷��� ���� ���� ��� ������ ���Եǵ��� ����, ������ ��ġ�� �ʵ��� �����ϴ�.
	- �� �踷��⸦ �ڸ��� �������� ��� �ϳ� �����մϴ�.
	- �������� � �踷����� �� �������� ��ġ�� �ʽ��ϴ�.
	�Ʒ� �׸��� �� ������ �����ϴ� ���� �����ݴϴ�. �������� �׷��� ���� �Ǽ��� �踷����̰�, ���� �������� ��ġ, �������� �׷��� ���� ȭ��ǥ�� �������� �߻� �����Դϴ�.
	
	image0.png
	
	�̷��� �������� �踷����� ��ġ�� ������ ���� ��ȣ�� �̿��Ͽ� ���ʺ��� ������� ǥ���� �� �ֽ��ϴ�.
	
	(a) �������� ���� ��ȣ�� �ݴ� ��ȣ�� ������ �� '()'���� ǥ���մϴ�. ���� ��� '()'�� �ݵ�� �������� ǥ���մϴ�.
	(b) �踷����� ���� ���� ���� ��ȣ '('��, ������ ���� ���� ��ȣ ')'�� ǥ���˴ϴ�.
	�� ���� ��ȣ ǥ���� �׸� ���� �־��� �ֽ��ϴ�.
	�踷���� �������� ���� �� ���� �������� �߸��µ�, �� ������ ���� ���� �ִ� �� ���� �踷���� ���� 3���� 2���� �������� �߸���, �̿� ���� ������� �־��� �踷������ �� 17���� �������� �߸��ϴ�.
	
	�踷���� �������� ��ġ�� ǥ���� ���ڿ� arrangement�� �Ű������� �־��� ��, �߸� �踷��� ������ �� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	arrangement�� ���̴� �ִ� 100,000�Դϴ�.
	arrangement�� ���� ��ȣ�� �ݴ� ��ȣ�� �׻� ���� �̷�ϴ�.
	����� ��
	arrangement	return
	()(((()())(())()))(())	17
	����� �� ����
	������ ���� ���� �����ϴ�.
	 */
	
	// ��Ģ�� �̿��Ͽ� �� ���������� ���� ���̶�� �� �� ����..
	public static int solution(String arrangement) {
		int answer = 0;
		char[] chArr = arrangement.toCharArray();
		int depth = 0;
		for(int i=0; i<chArr.length-1;i++) {
			if(chArr[i]=='(' && chArr[i+1]==')') {
				depth++;
			} else if(chArr[i]==')' && chArr[i+1]==')') {
				depth--;
				answer++;
			} else if(chArr[i]=='('&&chArr[i+1]==')') {
				answer += depth;
			}
 		}	
		return answer;
    }
	
	// �ٸ� ��� Ǯ��
	public static int other(String arrangement) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') {
                st.push(i);
            } else if (arrangement.charAt(i) == ')') {
                if (st.peek() + 1 == i) {
                    st.pop();
                    answer += st.size();
                } else {
                    st.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("()(((()())(())()))(())");

	}

}
