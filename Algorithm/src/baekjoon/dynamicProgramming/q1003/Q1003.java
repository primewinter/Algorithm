import java.io.IOException;
import java.util.Scanner;

/**
 * TITLE: BOJ 피보나치 함수
 * 
 * URL: https://www.acmicpc.net/problem/1003
 */
public class Q1003 {
    
    static int[] zero = new int[41];
    static int[] one = new int[41];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new java.util.Scanner(System.in);

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        int T = sc.nextInt();

        for(int i = 0 ; i < T ; i++) {
            int N = sc.nextInt();
            if( N <= 1 ) {
                append(zero[N], one[N]);
                continue;
            }

            for(int j = 2; j <= N; j++) {
                zero[j] = zero[j-1] + zero[j-2];
                one[j] = one[j-1] + one[j-2];
            }

            append(zero[N], one[N]);
        }

        System.out.println(sb);
        sc.close();
    }

    static void append(int a, int b) {
        sb.append(a).append(" ").append(b).append("\n");
    }
    
}
