package level01;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class P02 {

	public static int[] solution(int[] answers) {
		//Level1 모의고사
		int[] a = new int[10000];
		int[] b = new int[10000];
		int[] c = new int[10000];
		
		int i = 0;
		while( i < 10) {	
			if(i % 5 == 0) a[i] = 1;				
			else if(i%5==1) a[i] = 2;				
			else if(i%5==2) a[i] = 3;				
			else if(i%5==3) a[i] = 4;			
			else if(i%5==4) a[i] = 5;				
			
			if( i%2 == 0 ) b[i] = 2;
			else if(i%8==1) b[i] = 1;
			else if(i%8==3) b[i] = 3;
			else if(i%8==5) b[i] = 4;
			else if(i%8==7) b[i] = 5;
			
			if(i%10==0 || i%10==1) c[i] = 3;
			else if(i%10==2 || i%10==3) c[i] = 1;
			else if(i%10==4 || i%10==5) c[i] = 2;
			else if(i%10==6 || i%10==7) c[i] = 4;
			else if(i%10==8 || i%10==9) c[i] = 5;
			
			i++;
		}

		int countA = 0;
		int countB = 0;
		int countC = 0;
		for(int j= 0 ; j <answers.length; j++) {
			if(answers[j] == a[j]) countA++;
			if(answers[j] == b[j]) countB++;
			if(answers[j] == c[j]) countC++;
		}
		List<Integer> abc = new Vector<Integer>();
		
		int[] answer = {countA, countB, countC};	
		if(countA > countB) {
			if(countA > countC) {
				abc.add(1);
			} else if(countA < countC) {
				abc.add(3);
			} else {
				abc.add(1);
				abc.add(3);
			}
		} else if (countA < countB) {
			if(countB > countC) {
				abc.add(2);
			} else if(countB < countC) {
				abc.add(3);
			} else {
				abc.add(2);
				abc.add(3);
			}
		} else {
			if(countB > countC) {
				abc.add(1);
				abc.add(2);
			} else if (countB < countC) {
				abc.add(3);
			} else {
				abc.add(1);
				abc.add(2);
				abc.add(3);
			}
		}
		int[] full = new int[abc.size()];
		System.out.println("배열 : "+Arrays.toString(full));
		
		return null;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		System.out.println(solution(a));
		
		
	}

}
