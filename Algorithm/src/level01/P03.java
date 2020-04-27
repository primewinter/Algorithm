package level01;

public class P03 {

	public static void main(String[] args) {
		// Level 1 가운데글자 가져오기
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
		
		//다른 사람 코드 : 한줄로 끝내벌임ㅋ
		
		System.out.println(s.substring((s.length()-1) / 2, s.length()/2 + 1));
	}

}
