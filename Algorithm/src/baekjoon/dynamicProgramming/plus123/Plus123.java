package baekjoon.dynamicProgramming.plus123;

import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ 123 더하기
 * 
 * URL: https://www.acmicpc.net/problem/9095
 */
public class Plus123 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[11];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            for (int j = 4; j <= N; j++) {
                if (arr[N] > 0)
                    break;
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

}
