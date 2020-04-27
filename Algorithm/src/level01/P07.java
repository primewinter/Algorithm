package level01;

import java.util.Arrays;

public class P07 {

	public static void main(String[] args) {
		// Level1 : K��°��
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = { {2,5,3}, {4,4,1}, {1,7,3} };
		
		int[] answer = new int[commands.length];
		
		//int[] crop = commands[i] �� commands[i][1]���� array[i][0]���� �ڸ� �迭
		//answer[i] = crop[commands[i][2]]
		//�� Ǯ��
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
		
		//�ٸ� ��� Ǯ�� : Arrays �� copyOfRange �޼ҵ� ���
       // int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }



	}
}
