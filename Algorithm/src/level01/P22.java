package level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P22 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12915
	 * 프로그래머스 Lv1. 문자열 내 마음대로 정렬하기
	문제 설명
	문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
	
	제한 조건
	strings는 길이 1 이상, 50이하인 배열입니다.
	strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
	strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
	모든 strings의 원소의 길이는 n보다 큽니다.
	인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
	입출력 예
	strings	n	return
	[sun, bed, car]	1	[car, bed, sun]
	[abce, abcd, cdx]	2	[abcd, abce, cdx]
	입출력 예 설명
	입출력 예 1
	sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.
	
	입출력 예 2
	abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다. abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.
	 */
	public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Map<Integer, List<String>> map = new HashMap<>();
        for(int i=0; i<strings.length; i++) {
        	int charIndex = strings[i].charAt(n);
        	if(map.get(charIndex)==null) {
        		List<String> list = new ArrayList<>();
        		list.add(strings[i]);
        		map.put(charIndex, list);
        	} else {
        		map.get(charIndex).add(strings[i]);
        	}
        }

        Object[] mapKeys = map.keySet().toArray();
        Arrays.sort(mapKeys);
        int i = 0;
        for(Object key : mapKeys) {
        	Collections.sort(map.get(key));
        	for(String str:map.get(key)) {
        		answer[i] = str;
        		i++;
        	}
        }        
    
        return answer;
    }
	
	// 다른 사람 풀이 : ArrayList, substring 활용
	public String[] other(String[] strings, int n) {
		String[] answer = {};
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
		    arr.add("" + strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(arr);
		answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
		    answer[i] = arr.get(i).substring(1, arr.get(i).length());
		}
		return answer;
	}
	
	// 다른 사람 풀이  : Comparator 활용
	public String[] other2(String[] strings, int n) {
	      Arrays.sort(strings, new Comparator<String>(){
	          @Override
	          public int compare(String s1, String s2){
	              if(s1.charAt(n) > s2.charAt(n)) return 1;
	              else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
	              else if(s1.charAt(n) < s2.charAt(n)) return -1;
	              else return 0;
	          }
	      });
	      return strings;
	  }
	 
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"sun", "bed", "car"};
		int b = 1;
		System.out.println(solution(a,b));
		String[] c = {"abce","abcd","cdx"};
		int d = 2;
		System.out.println(solution(c,d));

	}

}
