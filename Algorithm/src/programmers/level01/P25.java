package programmers.level01;

import java.util.Arrays;
import java.util.Comparator;


public class P25 {
	/*
	 * ������
	 * https://programmers.co.kr/learn/courses/30/lessons/42889
	 * ���� ����
	failture_rate1.png
	
	���� ���� ������ �������� ū ��ο� ������. �׳డ ���� ������ ��õ���� �뼺���� �ŵ�����, ���� �ű� ������� ���� �ް��� ���̴�. ������ �ű� ����ڿ� ���� ����� ���̿� �������� ���̰� �ʹ� ū ���� ��������.
	
	�� ������ ��� �ұ� ��� �� �׳�� �������� ���� �ð��� �÷��� ���̵��� �����ϱ�� �ߴ�. ���� ���� �����ڶ� ��κ��� ������ ���� ����������, �������� ���ϴ� �κп��� ���⿡ ������ ���Ҵ�. �������� ���� �������� ���ϴ� �ڵ带 �ϼ��϶�.
	
	�������� ������ ���� �����Ѵ�.
	���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
	��ü ���������� ���� N, ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages�� �Ű������� �־��� ��, �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭�� return �ϵ��� solution �Լ��� �ϼ��϶�.
	
	���ѻ���
	���������� ���� N�� 1 �̻� 500 ������ �ڿ����̴�.
	stages�� ���̴� 1 �̻� 200,000 �����̴�.
	stages���� 1 �̻� N + 1 ������ �ڿ����� ����ִ�.
	�� �ڿ����� ����ڰ� ���� ���� ���� ���������� ��ȣ�� ��Ÿ����.
	��, N + 1 �� ������ ��������(N ��° ��������) ���� Ŭ���� �� ����ڸ� ��Ÿ����.
	���� �������� ���� ���������� �ִٸ� ���� ��ȣ�� ���������� ���� ������ �ϸ� �ȴ�.
	���������� ������ ������ ���� ��� �ش� ���������� �������� 0 ���� �����Ѵ�.
	����� ��
	N	stages	result
	5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
	4	[4,4,4,4,4]	[4,1,2,3]
	����� �� ����
	����� �� #1
	1�� ������������ �� 8���� ����ڰ� ����������, �� �� 1���� ����ڰ� ���� Ŭ�������� ���ߴ�. ���� 1�� ���������� �������� ������ ����.
	
	1 �� �������� ������ : 1/8
	2�� ������������ �� 7���� ����ڰ� ����������, �� �� 3���� ����ڰ� ���� Ŭ�������� ���ߴ�. ���� 2�� ���������� �������� ������ ����.
	
	2 �� �������� ������ : 3/7
	���������� ������ ���������� �������� ������ ����.
	
	3 �� �������� ������ : 2/4
	4�� �������� ������ : 1/2
	5�� �������� ������ : 0/1
	�� ���������� ��ȣ�� �������� ������������ �����ϸ� ������ ����.
	
	[3,4,2,1,5]
	����� �� #2
	
	��� ����ڰ� ������ ���������� �����Ƿ� 4�� ���������� �������� 1�̸� ������ ���������� �������� 0�̴�.
	
	[4,1,2,3]
	 */

	
	// ù��° Ǯ��(����) : string���� �ٿ��� ��� -> 2/3�� ��Ȯ�� (double�� string �ϴ� �������� ������ �߻��ϴ� ����)
	public static int[] first(int N, int[] stages) {
		int[] answer = new int[N];
		double[] failed = new double[N];
		double[] cleared = new double[N];

		for(int i=0; i<stages.length; i++) {
			if(stages[i]<=N) {
				failed[stages[i]-1]++;
			}
			for(int k=0; stages[i]>N ? k<N : k<stages[i]; k++) {
				cleared[k]++;
			}
		}
		
		String[] sa = new String[N];
		for(int i=0; i<N; i++) {
			System.out.println("���� : "+failed[i]+" || �и� : "+cleared[i]);
			if(failed[i] != 0 && cleared[i] != 0) {
				failed[i] = failed[i]/cleared[i];
				sa[i]=failed[i]+"-"+(i+1);
			} else {
				sa[i]=0+"-"+(i+1);
			}
			System.out.println(sa[i]);
		}
		
		Arrays.sort(sa, new Comparator<String>() {
			public int compare(String s1, String s2) {
				double d1 = Double.parseDouble(s1.substring(0, s1.indexOf("-")));
				double d2 = Double.parseDouble(s2.substring(0, s2.indexOf("-")));
				System.out.println("d1 : "+d1+" || d2 :"+d2 );
				if(d1==d2) {
					int i1 = Integer.parseInt(s1.substring(s1.indexOf("-")+1));
					int i2 = Integer.parseInt(s2.substring(s2.indexOf("-")+1));
					return i1-i2;
				}
				return d1<d2?1:-1;
			}
		});
		
		
		for(int i=0; i<N; i++) {
			answer[i] += Integer.parseInt(sa[i].substring(sa[i].indexOf("-")+1));
			System.out.println(answer[i]);
		}
		
		return answer;
	 }

	// �ι�° Ǯ��(����) : Class �� ���� ���� Ǯ��
	 public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double[] failed = new double[N];
		double[] cleared = new double[N];

		for(int i=0; i<stages.length; i++) {
			
			// i) ���� ������ ���̱� ���� + 3�� ������ ��� : �ð��� �� ���� �ɸ���
//			if(stages[i]<=N) {
//				failed[stages[i]-1]++;
//			}
//			for(int k=0; stages[i]>N ? k<N : k<stages[i]; k++) {
//				cleared[k]++;
//			}
			
			
			// ii) ���� ���� + if�� ��� : ���i)�� ���� ȿ����
			int currentStage = stages[i]-1;
			
			if(currentStage<N) {
				failed[currentStage]++;
				cleared[currentStage]++;
			}
			
			for(int j=0; j<currentStage; j++) {
				cleared[j]++;
			}
			
		}

		
		Stage[] stageArr = new Stage[N];
		for(int i=0; i<N; i++) {
			System.out.println("���� : "+failed[i]+" || �и� : "+cleared[i]);
			if(failed[i] != 0 && cleared[i] != 0) {
				Stage stage = new Stage(failed[i]/cleared[i], i+1);
				stageArr[i] = stage;
			} else {
				Stage stage = new Stage(0, i+1);
				stageArr[i] = stage;
			}
		}
		
		
		Arrays.sort(stageArr, new Comparator<Stage>() {

			@Override
			public int compare(Stage o1, Stage o2) {
				if(o1.failureRate==o2.failureRate) {
					return o1.currentStage-o2.currentStage;
				}
				return o1.failureRate<o2.failureRate?1:-1;
			}
			
		});
		
		for(int i=0; i<N; i++) {
			answer[i] = stageArr[i].currentStage;
		}
		
		
		return answer;
	 }
	 
	public static class Stage {
		public double failureRate;
		public int currentStage;
		
		public Stage() {
		}
		public Stage(double fr, int cs) {
			this.failureRate = fr;
			this.currentStage = cs;
		}
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(4, new int[]{4,4,4,4,4}));
		//System.out.println(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
		
		System.out.println(solution(5, new int[]{1,2,3,3,4}));
		System.out.println(solution(2, new int[] {1,1,2,2,3}));
	}

}
