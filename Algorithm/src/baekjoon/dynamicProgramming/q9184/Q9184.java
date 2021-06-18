package baekjoon.dynamicProgramming.q9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 신나는 함수 실행
 * 
 * URL: https://www.acmicpc.net/problem/9184
 */
public class Q9184 {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int a, b, c, w;
        while (true) {

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            w = w(a, b, c);

            sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, w)).append("\n");

        }

        System.out.println(sb);
        br.close();
    }

    static int w(int a, int b, int c) {

        if (a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20) {
            if (dp[a][b][c] != 0) {
                return dp[a][b][c];
            }
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            dp[20][20][20] = w(20, 20, 20);
            return dp[20][20][20];
        }

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return dp[a][b][c];

    }
}
