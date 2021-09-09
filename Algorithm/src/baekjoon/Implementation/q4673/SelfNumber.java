package baekjoon.Implementation.q4673;

/**
 * TITLE: BOJ 셀프넘버
 * 
 * URL: https://www.acmicpc.net/problem/4673
 */
public class SelfNumber {

    static int MAX = 10000;
    static int[] arr = new int[MAX + 1];

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= MAX; i++) {
            if (arr[i] == 0) {
                d(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX; i++) {
            if (arr[i] == 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void d(int num) {
        int sum = num;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }

        if (sum > MAX)
            return;

        arr[sum] = 1;
        d(sum);
    }
}
