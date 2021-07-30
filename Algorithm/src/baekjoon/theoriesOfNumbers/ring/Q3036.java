package baekjoon.theoriesOfNumbers.ring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Q3036
 */
public class Q3036 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int first = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N - 1 ; i++) {
            int ring = Integer.parseInt(st.nextToken());
            int gcd = getGCD(first, ring);
            sb.append(first/gcd).append("/").append(ring/gcd).append("\n");
        }
        System.out.println(sb);
        br.close();
       
    }

    public static int getGCD(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}