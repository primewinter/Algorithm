package ESTSoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {51,31,43};
		System.out.println(solution(A));

	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8
		List<Integer> list = new ArrayList<>();
		String one;
		for(int num : A) {
			one = num+"";
			int splitedSum = 0;
			for(String n : one.split("")) {
				splitedSum += Integer.parseInt(n);
			}
			list.add(splitedSum);
		}
		
		List<Integer> sumList = new ArrayList<>();
		
		for(int i =0; i < list.size(); i++) {
			for(int j=0; j < list.size(); j++) {
				if( i!=j && list.get(i) == list.get(j) ) {
					sumList.add(A[i] + A[j]);
				}
			}
		}
		
		if( sumList.size()==0 ) {
			return -1;
		} else {
			return Collections.max(sumList);
		}
    }
}
