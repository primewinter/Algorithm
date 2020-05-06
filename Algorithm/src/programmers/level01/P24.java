package programmers.level01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P24 {

	/*
	 * ���ڿ� ������������ ��ġ�ϱ�
	 * https://programmers.co.kr/learn/courses/30/lessons/12917
	���� ����
	���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
	s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.
	
	���� ����
	str�� ���� 1 �̻��� ���ڿ��Դϴ�.
	����� ��
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
        
        // <!----sort �޼ҵ� ���� �����غ���
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
	
	// �ٸ� ��� Ǯ�� : StringBuilder ���
	public String reverseStr(String str){
	    char[] sol = str.toCharArray();
	    Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString();
    }
	
	// �ٸ� ��� Ǯ�� : Stream ���
	public String reverseStr2(String str){
        return Stream.of(str.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
