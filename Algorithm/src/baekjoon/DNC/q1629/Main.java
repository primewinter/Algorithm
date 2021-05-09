package baekjoon.DNC.q1629;

import java.util.*;
import java.io.*;

public class Main {
	
	public static long C;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        /*
        long remainder = A%C;
        for(int i=1; i<B; i++) {
            remainder = ( remainder * A ) % C;
        }
        
        System.out.println(remainder);
        */
        System.out.println(pow(A, B));
        br.close();
    }
    
    // A^exponent
 	public static long pow(long A, long exponent) {
 		
 		// ������ 1�� ��� A^1 �̹Ƿ� A�� �״�� ����
 		if(exponent == 1) {
 			return A % C;
 		}
 		
 		// ������ ���ݿ� �ش��ϴ� A^(exponent / 2) �� ���Ѵ�.
 		long temp = pow(A, exponent / 2);
 		
 		/*
 		 * ���� ������ Ȧ �� ���ٸ�
 		 * A^(exponent / 2) * A^(exponent / 2) * A �̹Ƿ�
 		 * A�� �� �� �� �����־�� �Ѵ�.
 		 * 
 		 * ex) A^9 = A^4 * A^4 * A
 		 */
 		if(exponent % 2 == 1) {
 			return (temp * temp % C) * A % C;
 		}
 		return temp * temp % C;
 		
 	}
}
