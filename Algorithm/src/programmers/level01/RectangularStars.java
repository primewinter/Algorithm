package programmers.level01;

import java.util.Scanner;

public class RectangularStars {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int height = sc.nextInt();
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<length;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
