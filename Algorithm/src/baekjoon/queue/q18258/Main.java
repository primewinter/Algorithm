package baekjoon.queue.q18258;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int front=-1;
	static int rear=-1;
	static int[] queue;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			switch(line) {
			case "pop":
				sb.append(pop()+"\n");
			case "size":
				sb.append(size()+"\n");
				break;
			case "empty":
				sb.append(empty()+"\n");
				break;
			case "front":
				sb.append(front()+"\n");
				break;
			case "back":
				sb.append(back()+"\n");
				break;
			default:
				if(line.indexOf("push")!=-1) {
					String str[]=line.split(" ");
					int temp=Integer.parseInt(str[1]);
					push(temp);
				}
			}
		}
	}
	
	public static void push(int num) {
		queue[++rear]=num;
	}
	
	public static int pop() {
		if(rear>front) return queue[++front];
		else return -1;
	}
	
	public static int size() {
		return rear-front;
	}
	
	public static int empty() {
		if(size()<=0) return 1;
		else return 0;
	}
	
	public static int front(){
		if(size()<=0) return -1;
		else return queue[front+1];
	}
	
	public static int back() {
		if(size()<=0) return -1;	
		else return queue[rear];
	} 

}
