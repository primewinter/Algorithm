package programmers.level02;

import java.util.Arrays;

public class BiggestSmallest {
	/* Lv2. 최대값과 최소값 (+1)
	 * https://programmers.co.kr/learn/courses/30/lessons/12939
	 * 문제 설명
	문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값) (최대값)형태의 문자열을 반환하는 함수, solution을 완성하세요.
	예를들어 s가 1 2 3 4라면 1 4를 리턴하고, -1 -2 -3 -4라면 -4 -1을 리턴하면 됩니다.
	
	제한 조건
	s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
	입출력 예
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
