package programmers.level01;

import java.util.ArrayList;

public class NotSameNumber {
	
	public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = arr[0];
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(temp!=arr[i]) {
                temp = arr[i];
                list.add(temp);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
