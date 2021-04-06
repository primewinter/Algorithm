package baekjoon.queue.q1966;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int N = sc.nextInt();
			int idx = sc.nextInt();

			LinkedList<Integer> que = new LinkedList<>();
			int[] arr = new int[N];
			for(int j=0; j<N; j++) {
				int el = sc.nextInt();
				arr[j] = el;
				que.add(el);
			}

			sort(arr);
			
			int printOrder = 0;
            int k = 0;
            
            // 가장 큰 수부터 인쇄하기
			while(true) {
				int now = que.poll(); // 가장 앞에 있는 문서의 중요도
				
				if(now == arr[printOrder]) { // 가장 중요도가 높은 문서라면
					printOrder++; // 출력+1
					if(idx==0) { // 현재 출력한 문서가 목표 문서였다면
						System.out.println(printOrder);
						break;
					}
					idx--;
					
				} else { // 중요도가 가장 높은 문서는 아니라면
					que.add(now); // 현재 문서를 맨 뒤로 보낸다
					idx--;
					if(idx==-1) { // 현재 문서가 목표 문서였다면
						idx = que.size()-1; // movedIdx는 맨 뒤로 간다.
					}
				}
			}
		}
		sc.close();
	}
	
	
	public static int[] sort(int[] arr) {
		int temp = 0;
		for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
		return arr;
	}

}