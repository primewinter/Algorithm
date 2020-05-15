package programmers.level01;

import java.util.Arrays;
import java.util.Comparator;


public class P25 {
	/*
	 * 실패율
	 * https://programmers.co.kr/learn/courses/30/lessons/42889
	 * 문제 설명
	failture_rate1.png
	
	슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
	
	이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.
	
	실패율은 다음과 같이 정의한다.
	스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
	
	제한사항
	스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
	stages의 길이는 1 이상 200,000 이하이다.
	stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
	각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
	단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
	만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
	스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
	입출력 예
	N	stages	result
	5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
	4	[4,4,4,4,4]	[4,1,2,3]
	입출력 예 설명
	입출력 예 #1
	1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
	
	1 번 스테이지 실패율 : 1/8
	2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
	
	2 번 스테이지 실패율 : 3/7
	마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
	
	3 번 스테이지 실패율 : 2/4
	4번 스테이지 실패율 : 1/2
	5번 스테이지 실패율 : 0/1
	각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
	
	[3,4,2,1,5]
	입출력 예 #2
	
	모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
	
	[4,1,2,3]
	 */

	
	// 첫번째 풀이(실패) : string으로 붙여서 계산 -> 2/3의 정확도 (double을 string 하는 과정에서 오차가 발생하는 듯함)
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
			System.out.println("분자 : "+failed[i]+" || 분모 : "+cleared[i]);
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

	// 두번째 풀이(성공) : Class 를 새로 만들어서 풀이
	 public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double[] failed = new double[N];
		double[] cleared = new double[N];

		for(int i=0; i<stages.length; i++) {
			
			// i) 변수 선언을 줄이기 위함 + 3항 연산자 사용 : 시간이 더 오래 걸린다
//			if(stages[i]<=N) {
//				failed[stages[i]-1]++;
//			}
//			for(int k=0; stages[i]>N ? k<N : k<stages[i]; k++) {
//				cleared[k]++;
//			}
			
			
			// ii) 변수 선언 + if문 사용 : 방법i)에 비해 효율적
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
			System.out.println("분자 : "+failed[i]+" || 분모 : "+cleared[i]);
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
	
	
	
	// 서영쓰 풀이
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
        	
        	//double failureRate = (double)unclear[k]/reached[k];	//0으로 나누는 경우 컴파일에러는 안뜨지만 NaN가 됨
        	double failureRate = reached[k] == 0 ? 0 : (double)unclear[k]/reached[k];	//0으로 나누는거 조심!
        	failureRates[k] = failureRate;
        	
        	//No enclosing instance of ~ : static 메소드인 main 안에서 non-static class 를 호출하려고 하니 발생하는 오류
        	StageS currentStage = new StageS(k+1, failureRate);	
        	stageArray[k] = currentStage;
        }
        
        //List<Double> failureList = Arrays.asList(failureRates);
        //Arrays.sort(failureRates, Collections.reverseOrder());

        System.out.println(Arrays.toString(failureRates));
        
        //1) class Stage implements Comparable<Stage> 인 경우!
        //Arrays.sort(stageArray);	
        
        ///*
        //2) sort시 Comparator를 오버라이드 하는 경우!
        Arrays.sort(stageArray, new Comparator<StageS>() { 
			@Override
			public int compare(StageS o1, StageS o2) {
				
				if(o1.failureRate == o2.failureRate) {	
					return o1.stageNum - o2.stageNum;
				}	//stageNum은 이미 오름차순 정렬이 되어있기 때문에 안해줘도 됨 하지만 확실하게 하기위해 해줌! 
				
				//실패율 기준으로 내림차순 정렬하기
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
    
    // 감자면 풀이
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
        System.out.println("이해 안되는 부분");
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
        System.out.println("여기까지");
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
