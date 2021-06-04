package baekjoon.q7658;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bigger = new int[n];
        for(int i = 0 ; i < n ; i++) {
        	bigger[i] = 1;
            for(int k = 0; k < n ; k++) {
                if( i == k ) continue;
                if( arr[i][0] < arr[k][0] && arr[i][1] < arr[k][1] )  {
                    bigger[i] += 1;
                }
            }
        }

        for(int el : bigger) {
            bw.write(el+" ");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
       
}

