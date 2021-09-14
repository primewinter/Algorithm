package baekjoon.dynamicProgramming.makingOne;

import java.util.Scanner;

/**
 * TITLE: BOJ 1로 만들기
 * 
 * URL: https://www.acmicpc.net/problem/1463
 * 
 * HINT: d[N을 1로 만드는 최소 횟수]
 * 
 * = d[N-1을 1로 만드는 최소 횟수] + 1
 * 
 * or d[N/2를 1로 만드는 최소 횟수] + 1
 * 
 * or D[N/3을 1로 만드는 최소 횟수] + 1
 */
public class MakingOne {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
        sc.close();
    }
}
