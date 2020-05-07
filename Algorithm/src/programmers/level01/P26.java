package programmers.level01;

public class P26 {

	/* �̻��� ���� �����
	 * https://programmers.co.kr/learn/courses/30/lessons/12930
	 * ���� ����
	���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ� �ֽ��ϴ�. �� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
	
	���� ����
	���ڿ� ��ü�� ¦/Ȧ�� �ε����� �ƴ϶�, �ܾ�(������ ����)���� ¦/Ȧ�� �ε����� �Ǵ��ؾ��մϴ�.
	ù ��° ���ڴ� 0��° �ε����� ���� ¦����° ���ĺ����� ó���ؾ� �մϴ�.
	����� ��
	s	return
	try hello world	TrY HeLlO WoRlD
	����� �� ����
	try hello world�� �� �ܾ� try, hello, world�� �����Ǿ� �ֽ��ϴ�. �� �ܾ��� ¦����° ���ڸ� �빮�ڷ�, Ȧ����° ���ڸ� �ҹ��ڷ� �ٲٸ� TrY, HeLlO, WoRlD�Դϴ�. ���� TrY HeLlO WoRlD �� �����մϴ�.
	 */
	public static String solution(String s) {
		String answer = "";
		char[] chArr = s.toCharArray();
		boolean isOdd = false;
		for(int i=0; i<chArr.length; i++) {
			if(chArr[i]==' ') {
				answer += " ";
				isOdd = false;
			} else {
				if(isOdd) {
					answer += Character.toLowerCase(chArr[i]);
					isOdd = true;
				} else {
					answer += Character.toUpperCase(chArr[i]);
					isOdd = false;
				}
			}
		}
		
		
		// �Ʒ��� Ʋ�� �� : ���鿡 ���� ó���� ���
		String[] sa = s.split(" ");
		for(String str:sa) {
			for(int i=0; i<str.length(); i++) {
				if(i%2==0) {
					answer += Character.toUpperCase(str.charAt(i));
				} else {
					answer += Character.toLowerCase(str.charAt(i));
				}
			}
			answer += " ";
		}
		
		return answer.substring(0, answer.length()-1);
	}
	
	// �ٸ� ��� Ǯ��
	public String other(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
        
      return answer;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
