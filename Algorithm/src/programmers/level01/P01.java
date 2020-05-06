package programmers.level01;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class P01 {

	public static String solution(String[] participant, String[] completion) {
//	    String answer = "";
//	    List<String> list = new Vector<String>();
//	    List<String> finish = new Vector<String>();
//	    
//	    for(int i = 0 ; i <participant.length ; i++) {
//	    	list.add(participant[i]);	
//	    }
//	    for(int i = 0; i < completion.length; i++) {
//	    	finish.add(completion[i]);
//	    }
//	   
//	    for(int i=0 ; i < list.size() ; i++) {
//	    	for(int j =0; j < finish.size(); j++) {
//	    		
//	    		if( finish.get(j).equals(list.get(i)) ) {
//	    			list.remove(i);
//	    			finish.remove(j);	    			
//	    		}
//	    	}
//	    }
//	    	
////	    for(String a : list) {
////	    	answer += a;
////	    }
//	    answer = list.get(0);
//	    return answer;
	    
	    
	    //==============String[] 로 푸는 방법 : 정확성 50점, 효율성 0점 ================
//	    String answer = "";
//        
//	    for(int i = 0; i < participant.length ; i++ ) {
//	    	for(int j = 0; j< completion.length; j++) {
//		    		if( completion[j].equals(participant[i])) {
//		    			participant[i] = "";
//		    			completion[j] = "";
//		    		}
//	    	}
//	    }
//	    for(String a : participant) {
//	    	answer += a;
//	    }
//	    return answer;
		
		//============Array Sort를 이용한 방법 
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
		
		String[] a = {"leo", "kiki", "eden"};
		String[] b = {"eden", "kiki"};

		System.out.println(solution(a, b));
		String[] c = {"marina", "josipa", "nikola","vinko", "filipa"};
		String[] d = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(c, d));
		
		String[] e = {"mislav", "stanko", "mislav", "ana", "mislav"};
		String[] f = {"stanko", "ana", "mislav"};
		System.out.println(solution(e, f));
	}
}
