package programmers.level02;

public class NumericRepresentation {
	/* ������ ǥ��(+4)
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 * 	���� ����
n���� ���� �ƴ� ������ �ֽ��ϴ�. �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�. ���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־��� �� ���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�־����� ������ ������ 2�� �̻� 20�� �����Դϴ�.
�� ���ڴ� 1 �̻� 50 ������ �ڿ����Դϴ�.
Ÿ�� �ѹ��� 1 �̻� 1000 ������ �ڿ����Դϴ�.
����� ��
numbers	target	return
[1, 1, 1, 1, 1]	3	5
����� �� ����
������ ���� ���� �����ϴ�.
	 */

	public static int solution(int target) {
		int answer = 0;
        int count = 2;
        while(count <= target/2) {
        	answer += represent(count, target);
        	count++;
        }
        return answer+1;
	}
	
	public static int represent(double count, double target) {
		double startNum = -count/2+0.5+target/count;
		if(startNum>0 && startNum == (int)startNum) {
			System.out.println(startNum);
			return 1;
		} else {
			return 0;
		}
	}
	
	
	// �ٸ� ����� Ǯ�� : �־��� �ڿ����� ���ӵ� �ڿ����� ������ ǥ���ϴ� ����� ���� �־��� ���� Ȧ�� ����� ������ ���ٶ�� ������ ������ �ֽ��ϴ�.
	public int expressions(int num) {
	        int answer = 0;
	        for (int i = 1; i <= num; i += 2) {
	            if (num % i == 0) {
	                answer++;
	            }
	        }
	        return answer;
	}
	
	// �ٸ� ��� Ǯ�� 2
	public int other2(int num) {
        int answer = 0;

	    for(int fNum=1; fNum <= num; fNum++){
	    	int chkNum = 0;
	        for(int sNum=fNum; sNum <=num; sNum++){
	         chkNum = chkNum + sNum;
	
	         if(chkNum == num){
	             answer++;
	             break;
	         }else if(chkNum > num){
	             break;
	         }
	      }
	      //chkNum = 0;
	    }

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println("�� : "+solution(18));

	}

}
