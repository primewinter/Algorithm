package baekjoon.sort.q2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * TITLE: BOJ 통계학
 * 
 * URL: https://www.acmicpc.net/problem/2108
 */
public class Q2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        // 빈도수 체크 배열
        int[] freq = new int[8001];

        int num;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            sum += num;
            freq[num + 4000]++;
        }

        Arrays.sort(numbers);

        // 최빈도수 구하기
        int most = 0;
        for (int i = 0; i < 8001; i++) {
            if (freq[i] > most)
                most = freq[i];
        }

        // 최빈 숫자들 중 두 번째로 작은 값 구하기
        int idx = 0;
        int order = 0;
        for (int i = 0; i < 8001; i++) {
            if (freq[i] == most) {
                idx = i;
                order++;

                if (order == 2) {
                    break;
                }
            }
        }

        double avg = sum / N;
        sb.append((int) Math.round(avg)).append("\n"); // 산술평균
        sb.append(numbers[N / 2]).append("\n"); // 중앙값
        sb.append(idx - 4000).append("\n");// 최빈값
        sb.append(numbers[N - 1] - numbers[0]).append("\n"); // 범위

        System.out.println(sb);

    }

}
