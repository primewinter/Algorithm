package programmers.level02;

import java.math.BigInteger;

public class Fibonacci {
	/* �Ǻ���ġ ��(+10)
	 * https://programmers.co.kr/learn/courses/30/lessons/12945
	 * ���� ����
�Ǻ���ġ ���� F(0) = 0, F(1) = 1�� ��, 1 �̻��� n�� ���Ͽ� F(n) = F(n-1) + F(n-2) �� ����Ǵ� �� �Դϴ�.

�������

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
�� ���� �̾����ϴ�.

2 �̻��� n�� �ԷµǾ��� ��, n��° �Ǻ���ġ ���� 1234567���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��� �ּ���.

���� ����
* n�� 1�̻�, 100000������ �ڿ����Դϴ�.

����� ��
n	return
3	2
5	5
����� �� ����
�Ǻ���ġ���� 0��°���� 0, 1, 1, 2, 3, 5, ... �� ���� �̾����ϴ�.
	 */
	public static int solution(int n) {
		BigInteger[] fArr = new BigInteger[n+1];
		fArr[0] = BigInteger.valueOf(0);
		fArr[1] = BigInteger.valueOf(1);
		for(int i=2; i<=fArr.length-1; i++) {
			fArr[i] = fArr[i-1].add(fArr[i-2]);
		}
		
		BigInteger answer = fArr[n].remainder(BigInteger.valueOf(1234567)); 
		return answer.intValue();
	}
	
	
	// �ٸ� ��� Ǯ��
	public static int other(int n) {
        int answer = 0;
        long[] pib=new long[n+1];
        pib[0]=0L;
        pib[1]=1L;
        for(int i=2; i<=n; i++){
            pib[i]=(pib[i-1]+pib[i-2])%1234567L; // ó������ ���� ���� �迭�� �־ long ���� �ȿ��� Ǯ������ �ߴ�.
            System.out.println(i+"��° : "+pib[i]);
        }
        answer=(int)(pib[n]);
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(other(500));
		System.out.println(solution(500));

	}

}
