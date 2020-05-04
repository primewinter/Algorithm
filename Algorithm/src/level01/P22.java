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
	 * ���α׷��ӽ� Lv1. ���ڿ� �� ������� �����ϱ�
	���� ����
	���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�. ���� ��� strings�� [sun, bed, car]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� u, e, a�� strings�� �����մϴ�.
	
	���� ����
	strings�� ���� 1 �̻�, 50������ �迭�Դϴ�.
	strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
	strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�.
	��� strings�� ������ ���̴� n���� Ů�ϴ�.
	�ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
	����� ��
	strings	n	return
	[sun, bed, car]	1	[car, bed, sun]
	[abce, abcd, cdx]	2	[abcd, abce, cdx]
	����� �� ����
	����� �� 1
	sun, bed, car�� 1��° �ε��� ���� ���� u, e, a �Դϴ�. �̸� �������� strings�� �����ϸ� [car, bed, sun] �Դϴ�.
	
	����� �� 2
	abce�� abcd, cdx�� 2��° �ε��� ���� c, c, x�Դϴ�. ���� ���� �Ŀ��� cdx�� ���� �ڿ� ��ġ�մϴ�. abce�� abcd�� ���������� �����ϸ� abcd�� �켱�ϹǷ�, ���� [abcd, abce, cdx] �Դϴ�.
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
	
	// �ٸ� ��� Ǯ�� : ArrayList, substring Ȱ��
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
	
	// �ٸ� ��� Ǯ��  : Comparator Ȱ��
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
