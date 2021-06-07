package baekjoon.q1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * TITLE: BOJ �Ҽ�ã��
     * URL: https://www.acmicpc.net/problem/1978
     */
    static boolean[] primeNumbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if( arr[i] > max ) max = arr[i];
        }

        makePrimeNumbers(max);
        
        int answer = 0;
        for(int num : arr) {
            if( primeNumbers[num] == false ) answer++;
        }

        System.out.println(answer);
        br.close();

    }

    public static void makePrimeNumbers(int n) {

        primeNumbers = new boolean[n+1]; // 0 ~ n

        /*
        �Ҽ��� �ƴ� index = true
        �Ҽ��� index = false
        */

        // 2 �̸��� n�� �Է¹����� �Ҽ��� �Ǻ��� �ʿ䰡 �����Ƿ� �ٷ� return
        if( n < 2 ) return;

        primeNumbers[0] = primeNumbers[1] = true;


        for(int i = 2; i <= Math.sqrt(n) ; i++) {
            
            // �̹� üũ�� �迭�̸� �������� ��ŵ
            if( primeNumbers[i] == true ) continue;

            // i�� ������� �ɷ��ֱ� ���� �ݺ���
            for(int j = i*i ; j < primeNumbers.length ; j+=i) {
                //System.out.println("i: "+i+" | j: "+j);
                primeNumbers[j] = true;
            }  
        }
        
    }

}

