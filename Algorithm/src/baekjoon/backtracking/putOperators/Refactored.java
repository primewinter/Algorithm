package baekjoon.backtracking.putOperators;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 연산자 끼워넣기
 * 
 * URL: https://www.acmicpc.net/problem/14888
 * 
 * NOTE: 중복 숫자가 있는 경우의 모든 조합 구하기
 */
public class Refactored {

    static int N;
    static int min = 1000000000;
    static int max = -1000000000;
    static int[] nums;
    static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        putOperators(0, nums[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    static void putOperators(int depth, int result) {
        if (depth == N - 1) {
            min = Integer.min(min, result);
            max = Integer.max(max, result);
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                putOperators(depth + 1, calculate(i, result, nums[depth + 1]));
                operators[i]++;
            }
        }
    }

    static int calculate(int operator, int a, int b) {
        int result = 0;
        switch (operator) {
            case 0:
                result = a + b;
                break;
            case 1:
                result = a - b;
                break;
            case 2:
                result = a * b;
                break;
            case 3:
                result = a / b;
                break;
        }
        return result;
    }

}