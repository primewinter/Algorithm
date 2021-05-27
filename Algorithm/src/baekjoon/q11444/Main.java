package baekjoon.q11444;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /**
     * TITLE: BOJ 피보나치 수6
     * URL: https://www.acmicpc.net/problem/11444
     * HINT: 행렬의 제곱을 이용해서 피보나치 수를 구한다.
     */
    
    static final int mod = 1000000007;
    static long[][] unitMatrix = {{1, 1}, {1, 0}}; // 항등행렬

    public static long[][] pow(long n) {
        long[][] tmp = new long[2][2];
        // n 이 1이면 항등행렬 리턴
        if(n == 1) {
            return unitMatrix;
        }

        // m = 재귀함수로 만든 행렬의 제곱
        long[][] m = pow(n / 2);

        for(int i = 0 ; i < 2 ; i++) {
            for(int j = 0; j < 2 ; j++) {
                for(int k = 0 ; k < 2 ; k++) {
                    tmp[i][j] += m[i][k] * m[k][j];
                }
                tmp[i][j] %= mod;
            }
        }
        
        // n 홀수면 항등원 한 번 더 곱하고 리턴
        if(n % 2 == 1) {
            long[][] t = new long[2][2];

            for(int i = 0 ; i < 2 ; i++) {
                for(int j = 0; j < 2 ; j++) {
                    for(int k = 0 ; k < 2 ; k++) {
                        t[i][j] += tmp[i][k] * unitMatrix[k][j];
                    }
                    t[i][j] %= mod;
                }
            }

            return t;
        }

        return tmp;
        
    }
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());

        if(n == 1) 
            System.out.println(1);
        else {
            long[][] ans = pow(n-1);
            System.out.println(ans[0][0]);
        }
        
        br.close();

    }

}

