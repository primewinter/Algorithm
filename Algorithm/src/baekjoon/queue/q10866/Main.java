package baekjoon.queue.q10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> deck = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            switch(input) {
                case "pop_front":
                	sb.append(deck.isEmpty()?-1:deck.pollFirst());
                	sb.append("\n");
                    break;
                case "pop_back":
                	sb.append(deck.isEmpty()?-1:deck.pollLast());
                	sb.append("\n");
                	break;
                case "size":
                	sb.append(deck.size());
                	sb.append("\n");
                	break;
                case "empty":
                	sb.append(deck.isEmpty()?"1":"0");
                	sb.append("\n");
                	break;
                case "front":
                	sb.append(deck.isEmpty()?-1:deck.peekFirst());
                	sb.append("\n");
                	break;
                case "back":
                	sb.append(deck.isEmpty()?-1:deck.peekLast());
                	sb.append("\n");
                	break;
                default:
                	String[] str = input.split(" ");
                	if(input.indexOf("push_front")!=-1) {
                		deck.addFirst(Integer.parseInt(str[1]));
                	} else if(input.indexOf("push_back")!=-1) {
                		deck.addLast(Integer.parseInt(str[1]));
                	}
                    break;
            }
        }
        System.out.println(sb.toString());
        br.close();
	}

}
