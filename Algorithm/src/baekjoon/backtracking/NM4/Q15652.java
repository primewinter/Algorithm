package baekjoon.backtracking.q15652;

import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ N과 M(4)
 * 
 * URL: https://www.acmicpc.net/problem/15652
 * 
 * BRIEF: 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 
 * 같은 수를 여러 번 골라도 된다.
 * 
 * 고른 수열은 비내림차순이어야 한다. => 길이가 K인 수열 A가 A1 <= A2 <= ... <= AK-1 <= AK를 만족하면,
 * 비내림차순이라고 한다.
 * 
 * INPUT: (3 2)
 * 
 * OUTPUT: (1 1), (1 2), (1 3), (2 2), (2 3), (3 3)
 */
public class Q15652 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(0, 0);

        System.out.println(sb);
        sc.close();

    }

    static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < N; i++) {

            arr[depth] = i + 1;
            /**
             * Q15650( N과 M(2) ) 에서는 사전순으로 증가하는 순서로 출력해야 하므로 i+1을 넣어 재귀호출했으나
             * 
             * Q15652( N과 M(4) ) 에서는 중복을 허용하므로 i를 그대로 넣어 재귀호출한다.
             **/
            dfs(i, depth + 1);

        }
    }

}
