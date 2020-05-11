package programmers.level01;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P31 {
	/* ��Ʈ����
	 * https://programmers.co.kr/learn/courses/30/lessons/17682
	 * īī�� �ؼ�: https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
	 * ���� ����
	��Ʈ ����
	īī���忡 �� �� ��° ��! �ɽ��� ��? īī���� ���Ӻ�~
	
	Game Star
	
	īī���� ���Ӻ��� �Ϲݱ� �ű� ���񽺷� ��Ʈ ������ ����ϱ�� �ߴ�. ��Ʈ ������ ��Ʈ�ǿ� ��Ʈ�� �� ���� ���� �� ������ �հ�� �Ƿ��� �ܷ�� ��������, ��ΰ� ������ ��� �� �ִ�.
	�� �Ի��� ������ �ڵ� �Ƿ��� �����޾� ������ �ٽ� �κ��� ���� ��� ������ �ð� �Ǿ���. ��Ʈ ������ ���� ��� ������ �Ʒ��� ����.
	
	��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�.
	�� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�.
	������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ �� �������� 1����, 2����, 3���� (����1 , ����2 , ����3 )���� ���ȴ�.
	�ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�.
	��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����)
	��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����)
	��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
	Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�.
	��Ÿ��(*), ������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�.
	0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.
	
	�Է� ����
	����|���ʽ�|[�ɼ�]���� �̷���� ���ڿ� 3��Ʈ.
	��) 1S2D*3T
	
	������ 0���� 10 ������ �����̴�.
	���ʽ��� S, D, T �� �ϳ��̴�.
	�ɼ��� *�̳� # �� �ϳ��̸�, ���� ���� �ִ�.
	��� ����
	3���� ��ȸ���� ���� ���� �հ迡 �ش��ϴ� �������� ����Ѵ�.
	��) 37
	
	����� ����
	����	dartResult	answer	����
	1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
	2	1D2S#10S	9	12 + 21 * (-1) + 101
	3	1D2S0T	3	12 + 21 + 03
	4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
	5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
	6	1T2D3D#	-4	13 + 22 + 32 * (-1)
	7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
	 */

	// �� ���ھ� �߶� ���
	public static int solution(String dartResult) {
	    double[] score = new double[3];
        char[] chArr = dartResult.toCharArray();
        int idx = 0;
        for(int i=0; i<chArr.length; i++) {
        	System.out.println(idx+"��° ���� ::");
        	
        	if(chArr[i]>='0' && chArr[i]<='9') {
        		if(i<=chArr.length-1&&chArr[i+1]=='0') {
        			//score[idx] = Character.getNumericValue(chArr[i])*10+Character.getNumericValue(chArr[i+1]);
        			score[idx] = 10;
        			System.out.println(score[idx]);
        			idx++;
        			i++;
        		} else {
        			score[idx] = Character.getNumericValue(chArr[i]);
        			System.out.println(score[idx]);
        			idx++;
        		}
        	} else if(chArr[i]=='S'||chArr[i]=='D'||chArr[i]=='T') {
        		
        		if(chArr[i]=='D') {
        			score[idx-1] = Math.pow(score[idx-1], 2);
        			System.out.println("["+(idx-1)+"]�� ���� :"+score[idx-1]);
        		}
        		if(chArr[i]=='T') {
        			score[idx-1] = Math.pow(score[idx-1], 3);
        			System.out.println("["+(idx-1)+"]�� ������ :"+score[idx-1]);
        		}
        	} else {
        		
        		if(chArr[i]=='*') {
        			score[idx-1] *=2;
        			System.out.println("** ["+(idx-1)+"]�� 2��� : "+score[idx-1]);
        			if(idx>=2) {
        				score[idx-2] *=2;
        				System.out.println("** ["+(idx-2)+"]�� 2���: "+score[idx-2]);
        			}
        		} else if(chArr[i]=='#') {
        			score[idx-1] *= -1;
        			System.out.println("## ["+(idx-1)+"]�� ������ : "+score[idx-1]);
        		}
        	}
        	
        }
        
        for(int i=0; i<3;i++) {
        	System.out.println("����:"+score[i]);
        }
        
        return (int)(score[0]+score[1]+score[2]);
    }
	
	// ����ǥ���� �̿��� �Ѽ־� Ǯ��
	  public static int other(String dartResult) {
	        int answer = 0;
	        Pattern pattern = Pattern.compile("\\d+|[SDT]|\\#|\\*");
	        Matcher matcher = pattern.matcher(dartResult);
	        int num = 0;
	        List<Integer> calcList = new ArrayList<>();;
	        
	        while(matcher.find()){
	            String letter = matcher.group();
	            System.out.println(letter);
	            int clSize = calcList.size();
	            
	            if(letter.matches("\\d+")) {
	                num = Integer.parseInt(letter);
	            } else if(letter.matches("[SDT]")) { 
	                answer = num;
	                if(letter.equals("D")){
	                    answer = num * num;
	                } else if(letter.equals("T")){
	                    answer = num * num * num;
	                }
	                calcList.add(answer);
	            } else if(letter.equals("*")){
	                if(clSize != 1) {
	                    calcList.set(clSize - 2, calcList.get(clSize - 2) * 2);
	                }
	                calcList.set(clSize - 1, calcList.get(clSize - 1) * 2);
	            } else if(letter.equals("#")){
	                calcList.set(clSize - 1, calcList.get(clSize - 1) * (-1));
	            }
	        }
	        return calcList.get(0) + calcList.get(1) + calcList.get(2);
	    }

	
	// ����ǥ���� �̿��ؼ� Ǯ��� 
	public static int solution2(String dartResult) {
	    String regExp = "[A-Z]";
	    String[] shots = dartResult.split(regExp);
	    for(int i=0; i<shots.length;i++) {
	    	System.out.println(shots[i]);
	    }
	    
	    return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("���� :"+solution("1S2D*3T"));
		System.out.println("���� :"+other("10S*2T*3S"));
	}

}
