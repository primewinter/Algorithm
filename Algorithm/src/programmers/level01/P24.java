package programmers.level01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P24 {

	/*
	 * 문자열 내림차순으로 배치하기
	 * https://programmers.co.kr/learn/courses/30/lessons/12917
	문제 설명
	문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
	s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
	
	제한 사항
	str은 길이 1 이상인 문자열입니다.
	입출력 예
	s	return
	Zbcdefg	gfedcbZ
	 */
	public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");
        Arrays.sort(strArr, Collections.reverseOrder());
        
        for(int i=0; i<strArr.length; i++){
            answer+=strArr[i];
        }
        
        // <!----sort 메소드 직접 구현해보기
        for(int i=0; i<strArr.length; i++) {
            for(int k=0; k<strArr.length;k++) {
               // if(strArr[i])
            }
        }
        // ----!>
        char[] chArr = s.toCharArray();
        return new StringBuilder().append(chArr).reverse().toString();
        
        //return answer;
    }
	
	// 다른 사람 풀이 : StringBuilder 사용
	public String reverseStr(String str){
	    char[] sol = str.toCharArray();
	    Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString();
    }
	
	// 다른 사람 풀이 : Stream 사용
	public String reverseStr2(String str){
        return Stream.of(str.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
