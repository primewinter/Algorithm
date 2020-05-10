package programmers.level01;

public class P30 {
	/* 최대공약수와 최소공배수
	 * https://programmers.co.kr/learn/courses/30/lessons/12940
	 * 문제 설명
	두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
	
	제한 사항
	두 수는 1이상 1000000이하의 자연수입니다.
	입출력 예
	n	m	return
	3	12	[3, 12]
	2	5	[1, 10]
	입출력 예 설명
	입출력 예 #1
	위의 설명과 같습니다.
	
	입출력 예 #2
	자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
	 */
	
	 public static int[] solution(int n, int m) {
		 int[] answer = new int[2];
	        if(Math.max(n,m)%Math.min(n,m)==0) {
	            answer[0] += Math.min(n,m);
	            answer[1] += Math.max(n,m);
	            return answer;
	        }
	        int small = Math.min(n,m);
	        if(small==1) {
	            answer[0] += 1;
	            answer[1] += n*m;
	            return answer;
	        } else {
	            while(small!=1) {
	                if(n%small==0&&m%small==0) {
	                    answer[0] += small;
	                    break;
	                }
	                small--;
	            }
	            if(small==1) {
	                answer[0] += 1;
	            }
	            answer[1] += Math.min(n,m)*(Math.max(n,m)/answer[0]);
	            return answer;
	        }
    }
	 
	
	//다른 사람 풀이 : 재귀함수 이용... 그 논리를 이해하도록 하자.
	public static int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];
		
		answer[0] = gcd(a,b);
		answer[1] = (a*b)/answer[0];
		return answer;
	}
	 
	public static int gcd(int p, int q) {
		System.out.println(p+","+q);
	    if (q == 0) return p; // q가 0인 명제의 의미는? 
	    //p를 q로 나누었을 때 0이라면 p는 최대공약수이다. 
	    return gcd(q, p%q); // q가 0이 아니라면(=q가 p의 약수가 아니라면), q와 p나누기q의 나머지(<=p)를 넣는다.
	}
	
	// 다른 사람 풀이 2 : 최소공배수 = 두 수의 곱 / 최대공약수 를 이용하여 계산
	// 다른 사람 풀이 1을 풀어 쓴 것 
		public int[] gcdlcm2(int a, int b) {
	        int[] answer = new int[2];
	      int temp=1;
	      int gcd=a*b;
	      while(temp!=0){
	      temp=b%a; // temp : b 나누기 a 의 나머지
	        b=a; // 자리를 바꾼다.
	        a=temp;
	      }
	      answer[0]=b;
	      answer[1]=gcd/b;
	        return answer;
	    }
	
	// 다른 사람 풀이 3 : 이중 for문으로 찾는다
	public int[] gcdlcm3(int a, int b) {
        int[] answer = new int[2];
        int mini = 0;
        int maxi = 1;

        for(int i = 1; i<=a; i++) 
                    if(a%i==0&&b%i==0)
                        maxi = i;

                for(int i = a*b; i>0; i--)
                    if(i%a==0&&i%b==0)
                        mini = i;

        answer[0] = maxi;
        answer[1] = mini;

        return answer;
    }
	
	
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solution(3,12);
		gcdlcm(8,12);
	}

}
