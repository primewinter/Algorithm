package level01;

import java.util.Arrays;

public class P07 {

	public static void main(String[] args) {
		// Level1 : K번째수
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = { {2,5,3}, {4,4,1}, {1,7,3} };
		
		int[] answer = new int[commands.length];
		
		//int[] crop = commands[i] 의 commands[i][1]부터 array[i][0]까지 자른 배열
		//answer[i] = crop[commands[i][2]]
		//내 풀이
		for(int i = 0; i < commands.length ; i++) {
			int first = commands[i][0];
			int sec = commands[i][1];
			int third = commands[i][2];
			int[] crop = new int[sec-first+1];
			int zero = 0;
			for(int j = first-1; j <sec; j++) {
				crop[zero] = array[j];
				zero++;
			}		
			Arrays.sort(crop);
			answer[i] = crop[third-1];		
		}
		
		//다른 사람 풀이 : Arrays 의 copyOfRange 메소드 사용
       // int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }



	}
}
