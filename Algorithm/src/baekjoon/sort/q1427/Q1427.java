package baekjoon.sort.q1427;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * TITLE: BOJ 소트인사이드
 * URL: https://www.acmicpc.net/problem/1427
 */
public class Q1427 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        Integer[] arr = new Integer[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = Character.getNumericValue(str.charAt(i));
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int val : arr) {
            sb.append(val);
        }

        System.out.println(sb);
    }

    

}
