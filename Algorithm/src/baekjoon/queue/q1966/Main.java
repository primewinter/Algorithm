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
            
            // ���� ū ������ �μ��ϱ�
			while(true) {
				int now = que.poll(); // ���� �տ� �ִ� ������ �߿䵵
				
				if(now == arr[printOrder]) { // ���� �߿䵵�� ���� �������
					printOrder++; // ���+1
					if(idx==0) { // ���� ����� ������ ��ǥ �������ٸ�
						System.out.println(printOrder);
						break;
					}
					idx--;
					
				} else { // �߿䵵�� ���� ���� ������ �ƴ϶��
					que.add(now); // ���� ������ �� �ڷ� ������
					idx--;
					if(idx==-1) { // ���� ������ ��ǥ �������ٸ�
						idx = que.size()-1; // movedIdx�� �� �ڷ� ����.
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