package baekjoon.q1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * TITLE: BOJ 소수찾기
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
        소수가 아닌 index = true
        소수인 index = false
        */

        // 2 미만의 n을 입력받으면 소수는 판별할 필요가 없으므로 바로 return
        if( n < 2 ) return;

        primeNumbers[0] = primeNumbers[1] = true;


        for(int i = 2; i <= Math.sqrt(n) ; i++) {
            
            // 이미 체크된 배열이면 다음으로 스킵
            if( primeNumbers[i] == true ) continue;

            // i의 배수들을 걸러주기 위한 반복문
            for(int j = i*i ; j < primeNumbers.length ; j+=i) {
                //System.out.println("i: "+i+" | j: "+j);
                primeNumbers[j] = true;
            }  
        }
        
    }

}

