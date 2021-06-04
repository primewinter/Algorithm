package baekjoon.q2231;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int constructor = getConstructor(n);
        System.out.println(constructor);
    }

    public static int getConstructor(int n) {
        int min = n;
        int sum;
        int num;
        for(int i = 1 ; i < n ; i++ ) {
            num = i;
            sum = i;
            while( num > 0) {
                sum += num % 10;
                num = num / 10;
            }
                        
            if ( sum == n ) {
                if( min > i ) {
                    min = i;
                }
            }
            
        }

        return min==n?0:min;
    }
       
}
