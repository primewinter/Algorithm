package Line;

import java.util.*;

public class q1 {

	public static void main(String[] args) {
		
    }
	
	public int solution(String inputString) {
        char[] charArray = inputString.toCharArray();
		List<Integer> open = new ArrayList<>();
		List<Integer> close = new ArrayList<>();
        
        for(int i=0; i<charArray.length;i++) {
        	if( charArray[i]=='(' || charArray[i]=='{' || charArray[i]=='[' || charArray[i]=='<') {
        		open.add(i);
        	} else if( charArray[i]==')' || charArray[i]=='}' || charArray[i]==']' || charArray[i]=='>') {
        		close.add(i);
        	}
        }
        
         if(open.size()==close.size() && open.size()>0) {
        	for(int i=0; i<open.size(); i++) {
        		if( open.get(i) > close.get(i)) {
        			return -1;
        		} 
        	}
    		return open.size();
        } else {
            return 0;
        }
    }
        
        /*
         * ���� ����
�ϻ󿡼� ��ȣ�� ������ ǥ���ϰų�, �ΰ� ������ �����ϰų�, Ư�� ������ �ΰ��ϴ� ���� �뵵�� ���˴ϴ�.
��ȣ�� ���� ��ȣ�� �ݴ� ��ȣ�� �� ������ �̷��� �ϴ� Ư¡�� ������ ������ �پ��� ��ȣ�� �����մϴ�.
�Ʒ��� ��Ģ�� ���߾� ������ ���ڿ��� ���� �پ��� ��ȣ�� �ùٸ��� ���Ǿ����� Ȯ���� �� �ִ� �ذ���� ������ ���ô�.

���� ����
������ ���ڿ� inputString�� �Էµ˴ϴ�
�������θ� �̷���� ���ڿ��� �Էµ��� �ʽ��ϴ�
�Է� ���ڿ��� ���̴� 1 �̻��Դϴ�
�ִ� ���̴� ��õ��� �ʽ��ϴ�
��ȣ���� ���������� ���Ǿ����� ������ ����� ��ȯ�մϴ�
��ȣ�� �Ʒ��� ���� �� ������ �ִٰ� �����մϴ�
( ), { }, [ ], < >
��ȣ�� ���ݴ� Ư¡���� �����ϸ�, ���� �ִ� � ��ȣ�� ���ؼ� ¦�� �ٸ� ������ ��ȣ�� ������ ���� �ʽ��ϴ�
���� ��� ([])�� ([)] ��� �� ���� �� �ݾұ� ������ �����Դϴ�
�����̶�� �� ��ȣ ���� ��, ������(��ȣ ���� �������� ������ ǥ������ ���� ���)�̶�� -1�� ��ȯ�մϴ�
����� ��
inputString	result
Hello, world!	0
line [plus]	1
if (Count of eggs is 4.) {Buy milk.}	2
>_<	-1
         */
        
        


}
