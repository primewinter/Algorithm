package Line;

import java.util.*;
import java.util.stream.Collectors;

public class q2 {
	public static int solution(String road, int n) {
        int answer = -1;
        int count = 0;
        char[] charArray = road.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i]=='0') {
            	count++;
            }
        }
        
        if( count > n || count == n) {
        	return charArray.length;
        }
        
        
        
        //System.out.println(list);
        System.out.println(road.indexOf("0"));
        //System.out.println(list.lastIndexOf("0"));
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����"+solution("11011101", 3));

	}
	/*
	 * �������� �ջ�� ���ΰ� �ֽ��ϴ�. �� ���θ� �����ϰ� �����Ͽ�, �ڵ��� ���� ��ȸ�� ������ �մϴ�. �ڵ��� ���� ��ȸ�� ��������, �ջ���� ���� �ִ��� �� ������ �ʿ��մϴ�. �Ʒ��� ������ �ջ�� �κ��� 0, �������� �κ��� 1�� ��Ÿ�� �����Դϴ�.

111011110011111011111100011111
���� ������ �ջ�� �κ��� �ִ� 3�������� ������ �� �ִ� ��ᰡ �ִٸ�, �Ʒ��� ���� ���θ� �����Ͽ� ���̰� 18�� ���� ���� ������ ���� �� �ֽ��ϴ�.

1110(111111111111111111)00011111
���θ� �����ؼ� ���� �� �ִ� ���� �� ���� ���� ������ ���̸� �����ּ���.

���� ����
road�� ������ ���¸� ��Ÿ���ϴ�.
road�� ���� 1 �̻� 300,000 ������ ���ڿ��Դϴ�.
road�� 0�� 1�θ� �̷���� �ֽ��ϴ�.
������ �ջ�� �κ��� 0, ���� �κ��� 1�� ��Ÿ���ϴ�.
n�� ���� ������ �ִ� Ƚ���� �ǹ��մϴ�.
n�� 0 �̻� 300,000 ������ �ڿ����Դϴ�.
���� �� �ִ� ���� �� ���� ���� ������ ���̸� return �ϸ� �˴ϴ�.
����� ��
road	n	result
"111011110011111011111100011111"	3	18
"001100"	5	6
	 */
}
