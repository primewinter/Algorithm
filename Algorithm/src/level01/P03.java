package level01;

public class P03 {

	public static void main(String[] args) {
		// Level 1 ������� ��������
		String s = "abcde";
		String answer = "";
		char[] set = s.toCharArray();
		int length = set.length;
		int med = 0;
		if(length%2 != 0) {
			med = length/2;
			answer +=set[med];
		} else {
			med = length/2;
			answer +=set[med-1];
			answer +=set[med];
		}
		
		System.out.println(answer);
		
		//�ٸ� ��� �ڵ� : ���ٷ� �������Ӥ�
		
		System.out.println(s.substring((s.length()-1) / 2, s.length()/2 + 1));
	}

}
