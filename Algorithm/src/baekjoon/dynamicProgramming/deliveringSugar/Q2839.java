package baekjoon.dynamicProgramming.deliveringSugar;

import java.util.Scanner;

public class Q2839 {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;

        if (N == 4 || N == 7) {
            answer = -1;
        } else if (N % 5 == 0) {
            answer = N / 5;
        } else if (N % 5 == 1 || N % 5 == 3) {
            answer = (N / 5) + 1;
        } else if (N % 5 == 2 || N % 5 == 4) {
            answer = (N / 5) + 2;
        }

        System.out.println(answer);
        sc.close();
    }
}
