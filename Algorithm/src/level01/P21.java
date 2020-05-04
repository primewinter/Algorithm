package level01;

public class P21 {
	/* ���α׷��ӽ� Lv1. ���� ���� �� �����ϱ�
	 * https://programmers.co.kr/learn/courses/30/lessons/12935
	���� ����
	������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���. ��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���. ������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.
	
	���� ����
	arr�� ���� 1 �̻��� �迭�Դϴ�.
	�ε��� i, j�� ���� i �� j�̸� arr[i] �� arr[j] �Դϴ�.
	����� ��
	arr	return
	[4,3,2,1]	[4,3,2]
	[10]	[-1]
	 */
	
	
	public static int[] solution(int[] arr) {
		if(arr.length <= 1) {
              return new int[]{-1};
          } else {

        	  int minIndex = 0;
              for(int i=0; i<arr.length; i++) {
                  if(arr[i] < arr[minIndex]) {
                  	minIndex = i;
                  }
              }
            
  	          int[] answer = new int[arr.length-1];
  	          for(int i=0; i<minIndex; i++) {
  	        	  answer[i] = arr[i];
  	          }
  	          
  	          for(int i=minIndex; i<arr.length-1;i++) {
  	        	  answer[i] = arr[i+1];
  	          }

  	          
//  	          boolean skipped = false;
//	          for(int i=0; i<arr.length-1; i++) {
//	        	  if(!skipped) {
//	        		  if(i!=minIndex) {
//	        			  answer[i] = arr[i];
//	        		  } else {
//	        			  skipped = true;
//	        		  }
//	        	  } else {
//	        		  answer[i] = arr[i+1];
//	        	  }
//	          }
	
	          return answer;
          }
		      
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,3,2,1};
		System.out.println(solution(a));

	}

}
