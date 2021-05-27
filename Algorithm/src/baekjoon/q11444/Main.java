package baekjoon.q11444;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /**
     * TITLE: BOJ �Ǻ���ġ ��6
     * URL: https://www.acmicpc.net/problem/11444
     * HINT: ����� ������ �̿��ؼ� �Ǻ���ġ ���� ���Ѵ�.
     */
    
    static final int mod = 1000000007;
    static long[][] unitMatrix = {{1, 1}, {1, 0}}; // �׵����

    public static long[][] pow(long n) {
        long[][] tmp = new long[2][2];
        // n �� 1�̸� �׵���� ����
        if(n == 1) {
            return unitMatrix;
        }

        // m = ����Լ��� ���� ����� ����
        long[][] m = pow(n / 2);

        for(int i = 0 ; i < 2 ; i++) {
            for(int j = 0; j < 2 ; j++) {
                for(int k = 0 ; k < 2 ; k++) {
                    tmp[i][j] += m[i][k] * m[k][j];
                }
                tmp[i][j] %= mod;
            }
        }
        
        // n Ȧ���� �׵�� �� �� �� ���ϰ� ����
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

