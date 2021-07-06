package baekjoon.dynamicProgramming.padovanSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanSequence {

    static long[] arr = new long[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(padovan(N - 1)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static long padovan(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return arr[n];
        }

        if (arr[n] > 0) {
            return arr[n];
        }

        return arr[n] = padovan(n - 2) + padovan(n - 3);
    }
}
