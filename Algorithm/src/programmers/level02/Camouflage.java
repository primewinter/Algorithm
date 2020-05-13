package programmers.level02;

import java.util.HashMap;
import java.util.*;

public class Camouflage {

	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
        	String category = clothes[i][1];
        	int count = map.get(category)==null?0:map.get(category);
        	map.put(category, (Integer)(count+1));
        }
        
        Iterator<Integer> iter = map.values().iterator();
        while(iter.hasNext()) {
            answer *= iter.next().intValue()+1;
        }
        
        for(Integer cnt : map.values()) {
        	answer *= (cnt+1);
        }
        
        return answer-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[][] {{"y","head"},{"b", "eye"},{"g","head"}}));
		System.out.println(solution(new String[][] {{"c","head"},{"b", "head"},{"s","head"}}));

	}

}
