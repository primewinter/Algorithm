package programmers.level01;

public class P26 {

	/* 이상한 문자 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/12930
	 * 문제 설명
	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
	
	제한 사항
	문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
	첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
	입출력 예
	s	return
	try hello world	TrY HeLlO WoRlD
	입출력 예 설명
	try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.
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
		
		
		// 아래는 틀린 답 : 공백에 대한 처리가 없어서
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
	
	// 다른 사람 풀이
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
