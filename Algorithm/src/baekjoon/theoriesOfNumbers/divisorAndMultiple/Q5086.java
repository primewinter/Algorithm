package baekjoon.theoriesOfNumbers.divisorAndMultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE : BOJ 배수와 약수
 * URL : https://www.acmicpc.net/problem/5086
 */
public class Q5086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break;
            }

            if (isFactor(A, B)) {
                sb.append("factor");
            }
            else if (isMultiple(A, B)) {
                sb.append("multiple");
            }
            else {
                sb.append("neither");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static boolean isFactor(int a, int b) {
        return b % a == 0;
    }

    static boolean isMultiple(int a, int b) {
        return a % b == 0;
    }
}