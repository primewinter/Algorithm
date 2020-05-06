package programmers.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P18 {
	/*프로그래머스 Lv1. 나누어 떨어지는 숫자 배열
	 * https://programmers.co.kr/learn/courses/30/lessons/12910
	 * 
	 * 문제 설명
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
	
	제한사항
	arr은 자연수를 담은 배열입니다.
	정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
	divisor는 자연수입니다.
	array는 길이 1 이상인 배열입니다.
	입출력 예
	arr	divisor	return
	[5, 9, 7, 10]	5	[5, 10]
	[2, 36, 1, 3]	1	[1, 2, 3, 36]
	[3,2,6]	10	[-1]
	입출력 예 설명
	입출력 예#1
	arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.
	
	입출력 예#2
	arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.
	
	입출력 예#3
	3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
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
	
	// 다른 사람 풀이
	public int[] divisible(int[] array, int divisor) {
	        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
	    return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
	}
	
	
	// 다른 사람 풀이2
	public int[] divisible2(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
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
