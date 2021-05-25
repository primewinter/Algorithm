package baekjoon.q2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M 초기화
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        // 카드 초기화
        int[] cards = new int[n];
        String[] line2 = br.readLine().split(" ");
        for(int i=0 ; i < n ; i++) {
            cards[i] = Integer.parseInt(line2[i]);
        }

        // 카드 오름차순 정렬
        int temp;
        for(int i=0 ; i < n-1 ; i++) {
            for(int k=1 ; k < n-1 ; k++) {
                if( cards[k-1] > cards[k] ) {
                    temp = cards[k-1];
                    cards[k-1] = cards[k];
                    cards[k] = temp;
                }
            }
        }

        // 카드 3장 뽑기
        int sum = 0;
        for(int i=0 ; i < n-2 ; i++) {
            if( cards[i] > m ) continue;
            for(int k=i+1; k < n-1 ; k ++) {
                if( cards[i]+cards[k] > m ) continue;
                for(int j=k+1 ; j < n ; j++) {
                    if( (cards[i] + cards[j] + cards[k]) == m ) {
                        System.out.println(m);
                        br.close();
                        return;    
                    } else if ( (cards[i] + cards[j] + cards[k]) < m && (cards[i] + cards[j] + cards[k]) > sum) {
                        sum = cards[i] + cards[j] + cards[k];
                    }
                }
            }
        }

        System.out.println(sum);
        br.close();
    }
}
