package baekjoon.backtracking.lotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lotto {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] lotto;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            if( n == 0 ) break;

            arr = new int[n];
            visited = new boolean[n];
            lotto = new int[6];

            for(int i = 0 ; i < n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int at, int depth) throws IOException {

        if( depth == 6 ) {

            for ( int val : lotto ) {
                bw.write(val+" ");
            }
            bw.newLine();

            return;
        }

        for(int i = at; i < arr.length; i++) { 

            if ( at == 0 || arr[i] > lotto[at - 1] ) {
                lotto[at] = arr[i];
                dfs(at + 1, depth + 1);
            }
        }
    }

}
