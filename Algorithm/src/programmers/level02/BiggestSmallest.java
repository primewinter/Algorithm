package programmers.level02;

import java.util.Arrays;

public class BiggestSmallest {
	/* Lv2. �ִ밪�� �ּҰ� (+1)
	 * https://programmers.co.kr/learn/courses/30/lessons/12939
	 * ���� ����
	���ڿ� s���� �������� ���е� ���ڵ��� ����Ǿ� �ֽ��ϴ�. str�� ��Ÿ���� ���� �� �ּҰ��� �ִ밪�� ã�� �̸� (�ּҰ�) (�ִ밪)������ ���ڿ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.
	������� s�� 1 2 3 4��� 1 4�� �����ϰ�, -1 -2 -3 -4��� -4 -1�� �����ϸ� �˴ϴ�.
	
	���� ����
	s���� �� �̻��� ������ �������� ���еǾ� �ֽ��ϴ�.
	����� ��
	s	return
	1 2 3 4	1 4
	-1 -2 -3 -4	-4 -1
	-1 -1	-1 -1
	 */
	public static String solution(String s) {
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
        	intArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(intArr);
        
        return intArr[0]+" "+intArr[arr.length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1 2 3 4"));

	}

}
