package programmers.level02;

import java.util.HashMap;

public class OpenChatting {
	/* ����ä�ù�(+5)
	 * https://programmers.co.kr/learn/courses/30/lessons/42888
	 * ���� ����
īī���� ����ä�ù濡���� ģ���� �ƴ� ������ ��ȭ�� �� �� �ִµ�, ���� �г����� �ƴ� ������ �г����� ����Ͽ� ä�ù濡 �� �� �ִ�.

���Ի���� ��ũ��� īī���� ���� ä�ù��� ������ ����� ����, �پ��� ������� ������, ������ ���� ���Ѻ� �� �ִ� ������â�� ������ �ߴ�. ä�ù濡 ������ ������ ���� �޽����� ��µȴ�.

[�г���]���� ���Խ��ϴ�.

ä�ù濡�� ������ ������ ���� �޽����� ��µȴ�.

[�г���]���� �������ϴ�.

ä�ù濡�� �г����� �����ϴ� ����� ������ ���� �� �����̴�.

ä�ù��� ���� ��, ���ο� �г������� �ٽ� ����.
ä�ù濡�� �г����� �����Ѵ�.
�г����� ������ ���� ������ ä�ù濡 ��µǾ� �ִ� �޽����� �г��ӵ� ���� ����ȴ�.

���� ���, ä�ù濡 Muzi�� Prodo��� �г����� ����ϴ� ����� ������� ������ ä�ù濡�� ������ ���� �޽����� ��µȴ�.

Muzi���� ���Խ��ϴ�.
Prodo���� ���Խ��ϴ�.

ä�ù濡 �ִ� ����� ������ ä�ù濡�� ������ ���� �޽����� ���´�.

Muzi���� ���Խ��ϴ�.
Prodo���� ���Խ��ϴ�.
Muzi���� �������ϴ�.

Muzi�� ������ �ٽ� ���� ��, Prodo ��� �г������� ���� ��� ������ ä�ù濡 �����ִ� Muzi�� Prodo�� ������ ���� ����ȴ�.

Prodo���� ���Խ��ϴ�.
Prodo���� ���Խ��ϴ�.
Prodo���� �������ϴ�.
Prodo���� ���Խ��ϴ�.

ä�ù��� �ߺ� �г����� ����ϱ� ������, ���� ä�ù濡�� Prodo��� �г����� ����ϴ� ����� �� ���� �ִ�. ����, ä�ù濡 �� ��°�� ���Դ� Prodo�� Ryan���� �г����� �����ϸ� ä�ù� �޽����� ������ ���� ����ȴ�.

Prodo���� ���Խ��ϴ�.
Ryan���� ���Խ��ϴ�.
Prodo���� �������ϴ�.
Prodo���� ���Խ��ϴ�.

ä�ù濡 ������ �����ų�, �г����� ������ ����� ��� ���ڿ� �迭 record�� �Ű������� �־��� ��, ��� ����� ó���� ��, ���������� ���� ������ ����� ���� �Ǵ� �޽����� ���ڿ� �迭 ���·� return �ϵ��� solution �Լ��� �ϼ��϶�.

���ѻ���
record�� ������ ���� ���ڿ��� ��� �迭�̸�, ���̴� 1 �̻� 100,000 �����̴�.
������ record�� ��� ���ڿ��� ���� �����̴�.
��� ������ [���� ���̵�]�� �����Ѵ�.
[���� ���̵�] ����ڰ� [�г���]���� ä�ù濡 ���� - Enter [���� ���̵�] [�г���] (ex. Enter uid1234 Muzi)
[���� ���̵�] ����ڰ� ä�ù濡�� ���� - Leave [���� ���̵�] (ex. Leave uid1234)
[���� ���̵�] ����ڰ� �г����� [�г���]���� ���� - Change [���� ���̵�] [�г���] (ex. Change uid1234 Muzi)
ù �ܾ�� Enter, Leave, Change �� �ϳ��̴�.
�� �ܾ�� �������� ���еǾ� ������, ���ĺ� �빮��, �ҹ���, ���ڷθ� �̷�����ִ�.
���� ���̵�� �г����� ���ĺ� �빮��, �ҹ��ڸ� �����Ѵ�.
���� ���̵�� �г����� ���̴� 1 �̻� 10 �����̴�.
ä�ù濡�� ���� ������ �г����� �����ϴ� �� �߸� �� �Է��� �־����� �ʴ´�.
����� ��
record	result
["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo���� ���Խ��ϴ�.", "Ryan���� ���Խ��ϴ�.", "Prodo���� �������ϴ�.", "Prodo���� ���Խ��ϴ�."]
����� �� ����
����� �� #1
������ ����� ����.
	 */


	public static String[] solution(String[] record) {
		HashMap<String, String> visitors = new HashMap<>();
        int size = 0;
        for(String r : record) {
        	String[] msg = r.split(" ");
        	String act = msg[0];
        	if(act.equals("Leave")) {
        		size++;
        	} else {
        		visitors.put(msg[1], msg[2]);
        		if(act.equals("Enter")) {
        			size++;
        		}
        	}
        }
        
        String[] answer = new String[size];
        int i=0;
        for(String r : record) {
        	String[] msg = r.split(" ");
        	String act = msg[0];
        	String nickname = visitors.get(msg[1]);
        	
        	if(act.equals("Enter")) {
        		answer[i] = nickname+"���� ���Խ��ϴ�.";
        		i++;
        	} else if(act.equals("Leave")) {
        		answer[i] = nickname+"���� �������ϴ�.";
        		i++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = solution(record);
		for(String a: answer) {
			System.out.println(a);
		}
		// "Prodo���� ���Խ��ϴ�.", "Ryan���� ���Խ��ϴ�.", "Prodo���� �������ϴ�.", "Prodo���� ���Խ��ϴ�."

	}

}
