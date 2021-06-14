package baekjoon.backtracking.q15651;

import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ N과 M(3)
 * 
 * URL: https://www.acmicpc.net/problem/15651
 * 
 * BRIEF: 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 
 * 같은 수를 여러 번 골라도 된다. 수열은 사전 순으로 증가하는 순서로 출력
 * 
 * INPUT: (3 2)
 * 
 * OUTPUT: (1 1), (1 2), (1 3), (2 1), (2 2), (2 3), (3 1), (3 2), (3 3)
 */
public class Q15651 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        dfs(0);

        System.out.println(sb);
        sc.close();

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
