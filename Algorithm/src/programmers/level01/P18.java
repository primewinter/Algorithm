package programmers.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P18 {
	/*���α׷��ӽ� Lv1. ������ �������� ���� �迭
	 * https://programmers.co.kr/learn/courses/30/lessons/12910
	 * 
	 * ���� ����
	array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
	divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.
	
	���ѻ���
	arr�� �ڿ����� ���� �迭�Դϴ�.
	���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�.
	divisor�� �ڿ����Դϴ�.
	array�� ���� 1 �̻��� �迭�Դϴ�.
	����� ��
	arr	divisor	return
	[5, 9, 7, 10]	5	[5, 10]
	[2, 36, 1, 3]	1	[1, 2, 3, 36]
	[3,2,6]	10	[-1]
	����� �� ����
	����� ��#1
	arr�� ���� �� 5�� ������ �������� ���Ҵ� 5�� 10�Դϴ�. ���� [5, 10]�� �����մϴ�.
	
	����� ��#2
	arr�� ��� ���Ҵ� 1���� ������ �������ϴ�. ���Ҹ� ������������ ������ [1, 2, 3, 36]�� �����մϴ�.
	
	����� ��#3
	3, 2, 6�� 10���� ������ �������� �ʽ��ϴ�. ������ �������� ���Ұ� �����Ƿ� [-1]�� �����մϴ�.
	 */
	
	public int[] solution(int[] array, int divisor) {
	      ArrayList<Integer> arr = new ArrayList<Integer>();
	      for(int i=0;i<array.length;i++) {
	          if(array[i]%divisor==0) 
	              arr.add(array[i]);
	          }
	          Collections.sort(arr);
	          if(arr.size()==0) {
	              int[]answer = {-1};
	              return answer;
	          } else {
	              int[] answer = new int[arr.size()];
	              for(int j=0;j<arr.size();j++) {
	                  answer[j]=arr.get(j);
	              }

	              return answer;

	      }
	  }
	
	// �ٸ� ��� Ǯ��
	public int[] divisible(int[] array, int divisor) {
	        //ret�� array�� ���Ե� ������, divisor�� ������ �������� ���ڸ� ������� ��������.
	    return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
	}
	
	
	// �ٸ� ��� Ǯ��2
	public int[] divisible2(int[] array, int divisor) {
        //ret�� array�� ���Ե� ������, divisor�� ������ �������� ���ڸ� ������� ��������.
    int count=0,two=0;
    for(int i=0; i< array.length; i++){
        if(array[i]%divisor==0)
       count++;
    }
        int[] ret = new int[count];
    for(int i=0; i< array.length; i++){
        if(array[i]%divisor==0)
        ret[two++]=array[i];
    }
        return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
