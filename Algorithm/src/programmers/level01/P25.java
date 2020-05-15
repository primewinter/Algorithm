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
	
	
	
	// ������ Ǯ��
	static class StageS {	// 2)
		int stageNum;
		double failureRate;
		
		public StageS(int stageNum, double failureRate) {
			super();
			this.stageNum = stageNum;
			this.failureRate = failureRate;
		}
	}

    public static int[] other(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] reached = new int[N];
        int[] unclear = new int[N];
        
        for(int i=0; i<stages.length; i++) {
        	int playerStage = stages[i]-1;
        	
        	if( playerStage < N ) {
        		unclear[playerStage]++;
        		reached[playerStage]++;
        	}
        	for(int j=0; j<playerStage; j++) {
        		reached[j]++;
        	}
        }
        
        Double[] failureRates = new Double[N];
        StageS[] stageArray = new StageS[N];
        
        for(int k=0; k<N; k++) {
        	
        	//double failureRate = (double)unclear[k]/reached[k];	//0���� ������ ��� �����Ͽ����� �ȶ����� NaN�� ��
        	double failureRate = reached[k] == 0 ? 0 : (double)unclear[k]/reached[k];	//0���� �����°� ����!
        	failureRates[k] = failureRate;
        	
        	//No enclosing instance of ~ : static �޼ҵ��� main �ȿ��� non-static class �� ȣ���Ϸ��� �ϴ� �߻��ϴ� ����
        	StageS currentStage = new StageS(k+1, failureRate);	
        	stageArray[k] = currentStage;
        }
        
        //List<Double> failureList = Arrays.asList(failureRates);
        //Arrays.sort(failureRates, Collections.reverseOrder());

        System.out.println(Arrays.toString(failureRates));
        
        //1) class Stage implements Comparable<Stage> �� ���!
        //Arrays.sort(stageArray);	
        
        ///*
        //2) sort�� Comparator�� �������̵� �ϴ� ���!
        Arrays.sort(stageArray, new Comparator<StageS>() { 
			@Override
			public int compare(StageS o1, StageS o2) {
				
				if(o1.failureRate == o2.failureRate) {	
					return o1.stageNum - o2.stageNum;
				}	//stageNum�� �̹� �������� ������ �Ǿ��ֱ� ������ �����൵ �� ������ Ȯ���ϰ� �ϱ����� ����! 
				
				//������ �������� �������� �����ϱ�
				if(o1.failureRate < o2.failureRate) {
					return 1;
				}else if(o1.failureRate > o2.failureRate) {
					return -1;
				}
				return 0;
			}
        });
        //*/
        
        for (int i = 0; i < N; i++) {
            answer[i] = stageArray[i].stageNum;
        }
        
        return answer;
    }
    
    // ���ڸ� Ǯ��
    public static int[] other2(int N, int[] stages) {
        Failure[] failure = new Failure[N];
        
        for(int i = 0; i < failure.length; i++) {
            failure[i] = new Failure(i + 1);
        }
        
        for(int i = 0; i < stages.length; i++) {
            if( stages[i] != (N + 1) ) {
                failure[stages[i] - 1].clearUsers++;
            }
        }
        
        int totalUsers = stages.length; 
        System.out.println("���� �ȵǴ� �κ�");
        for(int i = 0; i < failure.length; i++) {
            if(failure[i].clearUsers == 0 || totalUsers == 0) {
                failure[i].failureRate = 0.0; 
            }
            else {
                failure[i].failureRate = (double) failure[i].clearUsers / totalUsers;
                System.out.println(failure[i].failureRate);
                totalUsers -= failure[i].clearUsers;
                System.out.println(totalUsers);
                System.out.println();
            }
        }
        System.out.println("�������");
        Arrays.sort(failure, new Comparator<Failure>() {
                        public int compare(Failure f1, Failure f2) {
                            if(f1.failureRate == f2.failureRate) {
                                return f1.stage - f2.stage; 
                            }
                            
                            return Double.compare(f2.failureRate, f1.failureRate);
                        }    
                    }
        );
        
        int[] answer = new int[failure.length];
        
        for(int i = 0; i < failure.length; i++) {
            answer[i] = failure[i].stage;
            System.out.print(failure[i].stage + " ");
        }
        
        return answer;
    }
    
    static class Failure {
        int stage; 
        int clearUsers;
        double failureRate; 
        
        public Failure(int stage) {
            this.stage = stage;
        }
    }

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(solution(4, new int[]{4,4,4,4,4}));
		//System.out.println(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
		
		//System.out.println(solution(5, new int[]{1,2,3,3,4}));
		System.out.println(other2(2, new int[] {1,1,2,2,3}));
	}

}
