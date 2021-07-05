package baekjoon.dynamicProgramming.tile01;

import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ 01타일
 * 
 * URL: https://www.acmicpc.net/problem/1904
 */
public class Tile01 {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 2;

        for(int i = 2 ; i < N ; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }

        System.out.println(arr[N-1]);        
        sc.close();
    }
}
