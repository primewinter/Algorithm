package baekjoon.q2750;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        insertionSort(arr, n);
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a+"\n");
        }
        
        System.out.println(sb);
    }
    
    private static void insertionSort(int[] a, int size) {
		
		
		for(int i = 1; i < size; i++) {
			// Ÿ�� �ѹ�
			int target = a[i];
			
			int j = i - 1;
			
			// Ÿ���� ���� ���Һ��� ũ�� �� ���� �ݺ�
			while(j >= 0 && target < a[j]) {
				a[j + 1] = a[j];	// ���� ���Ҹ� �� ĭ�� �ڷ� �̷��.
				j--;
			}
			
			/*
			 * �� �ݺ������� Ż�� �ϴ� ��� ���� ���Ұ� Ÿ�ٺ��� �۴ٴ� �ǹ��̹Ƿ�
			 * Ÿ�� ���Ҵ� j��° ���� �ڿ� �;��Ѵ�.
			 * �׷��Ƿ� Ÿ���� j + 1 �� ��ġ�ϰ� �ȴ�.
			 */
			a[j + 1] = target;	
		}
		
	}
}
