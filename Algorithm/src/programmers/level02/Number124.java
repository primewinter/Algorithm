package programmers.level02;

public class Number123 {
	/* 124 ������ ���� (+6)
	 * https://programmers.co.kr/learn/courses/30/lessons/12899
	 * ���� ����
124 ���� �ֽ��ϴ�. 124 ���󿡼��� 10������ �ƴ� ������ ���� �ڽŵ鸸�� ��Ģ���� ���� ǥ���մϴ�.

124 ���󿡴� �ڿ����� �����մϴ�.
124 ���󿡴� ��� ���� ǥ���� �� 1, 2, 4�� ����մϴ�.
���� �� 124 ���󿡼� ����ϴ� ���ڴ� ������ ���� ��ȯ�˴ϴ�.

10����	124 ����	10����	124 ����
1	1	6	14
2	2	7	21
3	4	8	22
4	11	9	24
5	12	10	41
�ڿ��� n�� �Ű������� �־��� ��, n�� 124 ���󿡼� ����ϴ� ���ڷ� �ٲ� ���� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
n�� 500,000,000������ �ڿ��� �Դϴ�.
����� ��
n	result
1	1
2	2
3	4
4	11
	 * 
	 */
	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();
        while(n>0) { // n = 12; 3;
        	answer.insert(0, n%3); // answer = 0; answer = 00;
//        	if(n%3==0) {
//        		n-=3;
//        	}
//        	n /= 3;
        	n = (n-1)/3; // n = 11/3 = 3; 2/3 = 0;
        	System.out.println("���簪 : "+answer.toString());
        }

        return answer.toString().replaceAll("[0]", "4");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���� : "+solution(4)); // 4
		System.out.println();
		System.out.println("���� : "+solution(9)); // 111

	}

}
