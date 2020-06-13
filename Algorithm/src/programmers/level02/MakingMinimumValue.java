package programmers.level02;

import java.util.Arrays;

public class MakingMinimumValue {
	/* �ּҰ� �����(+2)
	 * https://programmers.co.kr/learn/courses/30/lessons/12941
	 * ���� ����
���̰� ���� �迭 A, B �ΰ��� �ֽ��ϴ�. �� �迭�� �ڿ����� �̷���� �ֽ��ϴ�.
�迭 A, B���� ���� �� ���� ���ڸ� �̾� �� ���� ���մϴ�. �̷��� ������ �迭�� ���̸�ŭ �ݺ��ϸ�, �� ���� ���� ���� �����Ͽ� ���մϴ�. �̶� ���������� ������ ���� �ּҰ� �ǵ��� ����� ���� ��ǥ�Դϴ�. (��, �� �迭���� k��° ���ڸ� �̾Ҵٸ� ������ k��° ���ڴ� �ٽ� ���� �� �����ϴ�.)

���� ��� A = [1, 4, 2] , B = [5, 4, 4] ���

A���� ù��° ������ 1, B���� �ι�° ������ 5�� �̾� ���Ͽ� ���մϴ�. (������ �� : 0 + 5(1x5) = 5)
A���� �ι�° ������ 4, B���� ����° ������ 4�� �̾� ���Ͽ� ���մϴ�. (������ �� : 5 + 16(4x4) = 21)
A���� ����° ������ 2, B���� ù��° ������ 4�� �̾� ���Ͽ� ���մϴ�. (������ �� : 21 + 8(2x4) = 29)
��, �� ��찡 �ּҰ� �ǹǷ� 29�� return �մϴ�.

�迭 A, B�� �־��� �� ���������� ������ �ּڰ��� return �ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
�迭 A, B�� ũ�� : 1,000 ������ �ڿ���
�迭 A, B�� ������ ũ�� : 1,000 ������ �ڿ���
����� ��
A	B	answer
[1, 4, 2]	[5, 4, 4]	29
[1,2]	[3,4]	10
����� �� ����
����� �� #1
������ ���ÿ� �����ϴ�.

����� �� #2
A���� ù��° ������ 1, B���� �ι�° ������ 4�� �̾� ���Ͽ� ���մϴ�. (������ �� : 4) ����, A���� �ι�° ������ 2, B���� ù��° ������ 3�� �̾� ���Ͽ� ���մϴ�. (������ �� : 4 + 6 = 10)
�� ��찡 �ּ��̹Ƿ� 10�� return �մϴ�.
	 */

	public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<A.length; i++) {
        	answer += A[i]*B[i];
        }
        return answer;
    }
	
	// �ٸ� ��� Ǯ�� (Arrays.sort ���� ����)
	public int getMinSum(int []A, int []B) {
		int answer = 0;
		int length = A.length;
		
		quickSort(A, 0, A.length-1);
		quickSort(B, 0, B.length-1);
		
		//System.out.println(A[0]);
		//System.out.println(B[0]);
		
		for(int i = 0 ; i < length ; i++) {
		    answer += A[i] * B[length-1-i];
		}
		
		return answer;
	 }

	 public static void quickSort(int[] arr, int left, int right) {
		int i, j, pivot, tmp;
		if (left < right) {
		    i = left; // ������ ��ġ 0
		    j = right; // �������� ��ġ 5
		    pivot = arr[left]; // ���ʰ�(���ذ�) 33
		    
		    //���� ����
			while (i < j) { 
			    while (arr[j] > pivot) j--; // ���ذ��� �����ʿ� �ִ� ���� �� ���� ��(�� ��ġ)�� ã�� �ڵ�
			    while (i < j && arr[i] <= pivot) i++; // ���ذ��� ã�Ƴ���(������)���� ���ʿ� ������ ���ذ��� �� �������� �ű��
			    // ���ذ��̶� ���� ���� ��ġ�� �ٲ۴�.
			    tmp = arr[i]; 
			    arr[i] = arr[j]; 
			    arr[j] = tmp;
			}
			// ���� ã�� ���� ���� pivot(���ذ�)�� �ǰ� �� ���� ��ġ�� left�� �ȴ�.
			arr[left] = arr[i];
			arr[i] = pivot;
			//���� ����
		    quickSort(arr, left, i - 1);
		    quickSort(arr, i + 1, right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
