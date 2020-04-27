package ESTSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,8,2,3,3,2};
		System.out.println(solution(A));

	}
	
	public static int solution(int[] A) {
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		List<Integer> duplicatedList = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			int duplicated = 1;
			for(int j=0; j<list.size(); j++) {
				if(i != j && list.get(i).equals(list.get(j))) {
					duplicated++;
				}
			}
			if(list.get(i).equals(duplicated)) {
				duplicatedList.add(list.get(i));
			}
		}
		if( duplicatedList.size()!=0) {
			return Collections.max(duplicatedList);
		} else {
			return 0;
		}
    }

}
