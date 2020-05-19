package programmers.level02;

import java.util.ArrayList;

public class StockPrice {
	public static int[] solution(int[] prices) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<prices.length;i++) {
        	int time = 0;
        	boolean isFallen = false;
        	for(int k=i+1; k<prices.length;k++) {
        		System.out.println(prices[i]+" vs " + prices[k]);
        		time++;
        		if(prices[i]>prices[k]) {
        			arr.add(time);
        			isFallen = true;
        			System.out.println(i+"일때 "+time+" 넣었다");
        			break;
        		}
        	}
        	if(!isFallen) {
        		arr.add(prices.length-i-1);
        	}
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = arr.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,2,3,2,3}));

	}

}
