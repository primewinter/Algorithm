package baekjoon.dynamicProgramming.rgbStreet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ RGB거리
 * 
 * URL: https://www.acmicpc.net/problem/1149
 */
public class RGBStreet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] street = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        street[0][0] = Integer.parseInt(st.nextToken());
        street[0][1] = Integer.parseInt(st.nextToken());
        street[0][2] = Integer.parseInt(st.nextToken());

        int r, g, b;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            street[i][0] = Integer.min(street[i - 1][1], street[i - 1][2]) + r;
            street[i][1] = Integer.min(street[i - 1][0], street[i - 1][2]) + g;
            street[i][2] = Integer.min(street[i - 1][0], street[i - 1][1]) + b;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (min > street[N - 1][i])
                min = street[N - 1][i];
        }

        System.out.println(min);
        br.close();
    }

}
