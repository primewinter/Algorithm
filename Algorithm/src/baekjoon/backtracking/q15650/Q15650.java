package baekjoon.backtracking.q15650;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * TITLE: BOJ N과 M(2)
 * 
 * URL: https://www.acmicpc.net/problem/15650
 * 
 * BRIEF: 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * 고른 수열은 오름차순
 * 
 * INPUT: (3 2)
 * 
 * OUTPUT: (1 2), (1 3), (2 1), (2 3), (3 1), (3 2)
 */
public class Q15650 {

    static int N, M;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(0, 0);

        bw.flush();
        bw.close();
        sc.close();
    }

    static void dfs(int at, int depth) throws IOException {

        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = at; i < N; i++) {

            arr[depth] = i + 1;
            dfs(i + 1, depth + 1);

        }
    }

}
