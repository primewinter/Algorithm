package baekjoon.backtracking.putOperators;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * TITLE: BOJ 연산자 끼워넣기
 * 
 * URL: https://www.acmicpc.net/problem/14888
 * 
 * NOTE: 중복 숫자가 있는 경우의 모든 조합 구하기
 */
public class Q14888 {

    static int N;
    static int min = 1000000000;
    static int max = -1000000000;
    static int[] nums;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        arr = new int[N - 1];
        int[] operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
            if (operators[i] > 0) {
                set.add(i);
            }
        }

        putOperators(operators, 0);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    static void putOperators(int[] operators, int depth) {
        if (depth == N - 1) {
            int result = nums[0];

            for (int i = 0; i < N - 1; i++) {
                switch (arr[i]) {
                    case 0:
                        result += nums[i + 1];
                        break;
                    case 1:
                        result -= nums[i + 1];
                        break;
                    case 2:
                        result *= nums[i + 1];
                        break;
                    case 3:
                        result /= nums[i + 1];
                        break;
                }
            }

            if (result < min)
                min = result;
            if (result > max)
                max = result;
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (set.contains(i)) {
                    arr[depth] = i;
                    if (operators[i] == 0)
                        set.remove(i);
                    putOperators(operators, depth + 1);
                    if (operators[i] == 0)
                        set.add(i);
                }
                operators[i]++;
            }
        }

    }

}