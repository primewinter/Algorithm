package programmers.level01;

public class P27 {
	/* 
	 * �������
	 * ��Ʈ������ �ƴ��� ���� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/17681?language=java
	 * ���� ����
	�׿��� ��� ���ε��� ������ ���ܳ��� ��Ҹ� �˷��� ��������� �տ� �־���. �׷��� �� ��������� ���ڷ� ��ȣȭ�Ǿ� �־� ��ġ�� Ȯ���ϱ� ���ؼ��� ��ȣ�� �ص��ؾ� �Ѵ�. ������ ���� ��ȣ�� �ص��� ����� ������� �޸� �Բ� �߰��ߴ�.
	
	������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, �� ĭ�� ����(" ) �Ǵº�(#") �� ������ �̷���� �ִ�.
	��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� ���� 1�� ���� 2��� ����. ���� 1 �Ǵ� ���� 2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. ���� 1�� ���� 2���� ��� ������ �κ��� ��ü ���������� �����̴�.
	���� 1�� ���� 2�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�.
	��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ���� �κ��� 0���� ��ȣȭ���� �� ������� �������� �ش��ϴ� ���� �迭�̴�.
	secret map
	
	�׿��� ���ε��� ������ �տ� ���� �� �ֵ���, ��������� ��ȣ�� �ص��ϴ� �۾��� ������ ���α׷��� �ۼ��϶�.
	
	�Է� ����
	�Է����� ������ �� �� ũ�� n �� 2���� ���� �迭 arr1, arr2�� ���´�.
	
	1 <= n <= 16
	arr1, arr2�� ���� n�� ���� �迭�� �־�����.
	���� �迭�� �� ���� x�� �������� ��ȯ���� ���� ���̴� n �����̴�. ��, 0 <= x <= 2n - 1�� �����Ѵ�.
	��� ����
	������ ��������� �ص��Ͽ� '#', �������� ������ ���ڿ� �迭�� ����϶�.
	
	����� ����
	�Ű�����	��
	n	5
	arr1	[9, 20, 28, 18, 11]
	arr2	[30, 1, 21, 17, 28]
	���	["#####","# # #", "### #", "# ##", "#####"]
	�Ű�����	��
	n	6
	arr1	[46, 33, 33 ,22, 31, 50]
	arr2	[27 ,56, 19, 14, 14, 10]
	���	["######", "### #", "## ##", " #### ", " #####", "### # "]
	 */
	public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      String binary = "";
	      for(int i=0; i<n; i++) {
	    	  binary += "0";
	      }
	      
	      for(int i=0; i<n; i++) {
	    	  String binary1 = binary + Integer.toBinaryString(arr1[i]);
	          binary1 = binary1.substring(binary1.length()-n);
	          String binary2 = binary + Integer.toBinaryString(arr2[i]);
	          binary2 = binary2.substring(binary2.length()-n);

	          String a = "";
	          for(int k=0; k<n; k++) {
	        	 if(binary1.charAt(k)=='0' && binary2.charAt(k)=='0') {
	        		 a += " ";
	        	 } else {
	        		 a += "#";
	        	 }
	          }
	          answer[i] = a;
	      }
	      
	      return answer;
	  }
	
	public String[] other(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]); // ��Ʈ ������
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28}));

	}

}
