package baekjoon.q11729;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	/*
	 * TITLE: BOJ �ϳ��� ž �̵�����
	 * URL: https://www.acmicpc.net/problem/11729
	 * HINT: ����Լ�
	 */
 
    static int count;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        hanoi(n, 1, 2, 3);

        System.out.println(count+"\n"+sb);
        br.close();

    }
    
    /*
     * �ϳ����� ž 
     * N���� ������ ���A���� ���C�� �ű�� ���ؼ��� ������ ������ ��ģ��.
     * 
     * 1) N-1���� ������ A���� B�� �̵����Ѿ� �Ѵ�.
     * 2) N��° ������ A���� C�� �̵���Ų��.
     * 3) N-1���� ������ B���� C�� �̵���Ų��.
     * 
     */
    static void hanoi(int target, int from, int via, int to) {                
    	
        if( target == 0 ) {
            return;
        }
        else {
            hanoi(target-1, from, to, via); // 1)
            sb.append(from+" "+to).append("\n");
            count++; // 2)
            hanoi(target-1, via, from, to); // 3)
        }
                
        
    }
   
}

