package programmers.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P32 {
	/* �������� ���� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/42576
	 * ���� ����
	������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
	
	�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
	completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
	�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
	������ �߿��� ���������� ���� �� �ֽ��ϴ�.
	����� ��
	participant	completion	return
	[leo, kiki, eden]	[eden, kiki]	leo
	[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
	[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
	����� �� ����
	���� #1
	leo�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
	
	���� #2
	vinko�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
	
	���� #3
	mislav�� ������ ��ܿ��� �� ���� ������, ������ ��ܿ��� �� ��ۿ� ���� ������ �Ѹ��� �������� ���߽��ϴ�.
	 */
	
	
	public String solution(String[] participant, String[] completion) {
        List<String> participants = new ArrayList<String>(Arrays.asList(participant));
        List<String> completions = new ArrayList<String>(Arrays.asList(completion));
       
        Collections.sort(participants);
        Collections.sort(completions);

        
        for(int i=0; i<completions.size(); i++) {
            if( !participants.get(i).equals(completions.get(i))) {
                return participants.get(i);   
            }
        }
        
        return participants.get(participants.size()-1);
    }
	
	// �ٸ� ��� Ǯ��
	public String other(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
	
	// �ٸ� ��� Ǯ�� 2
	public String other2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for ( i=0; i<completion.length; i++){

            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
