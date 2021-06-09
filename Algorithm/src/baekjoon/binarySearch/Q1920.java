package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
    /**
     * TITLE: BOJ 수 찾기
     * 
     * URL: https://www.acmicpc.net/problem/1920
     * 
     * HINT: 이진탐색
     */

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int target;
        boolean isExists;

        for (int i = 0; i < m; i++) {

            target = Integer.parseInt(st.nextToken());

            isExists = findNumber(target, 0, n);

            if (isExists) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
        br.close();

    }

    public static boolean findNumber(int target, int offset, int size) {
        // 찾고자 하는 숫자가 첫번째 값보다 작거나, 마지막 값보다 크면 배열에 존재하지 않는다.
        if (arr[offset] > target || arr[offset + size - 1] < target) {
            return false;
        } else {

            int center = offset + size / 2;
            int newSize;

            if (size % 2 == 0)
                newSize = size / 2;
            else
                newSize = (size + 1) / 2;

            if (arr[center] == target) {
                return true;
            } else if (arr[center] > target) {
                return findNumber(target, offset, newSize);
            } else {
                return findNumber(target, center, newSize);
            }

        }
    }

}