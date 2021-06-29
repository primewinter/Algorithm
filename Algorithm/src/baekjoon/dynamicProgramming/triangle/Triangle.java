package baekjoon.dynamicProgramming.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 정수삼각형
 * 
 * URL: https://www.acmicpc.net/problem/1932
 * 
 * NOTE: TOP-DOWN 식으로 풀었다.
 */
public class Triangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        board[0][0] = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int num;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                num = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    board[i][j] = num + board[i - 1][j];
                } else if (j == i) {
                    board[i][j] = num + board[i - 1][j - 1];
                } else if (j > 0) {
                    board[i][j] = num + Integer.max(board[i - 1][j - 1], board[i - 1][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (board[N - 1][i] > max)
                max = board[N - 1][i];
        }

        System.out.println(max);
        br.close();
    }

}
