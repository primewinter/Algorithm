package programmers.level01;

public class P30 {
	/* �ִ������� �ּҰ����
	 * https://programmers.co.kr/learn/courses/30/lessons/12940
	 * ���� ����
	�� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� ������. �迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� ��ȯ�ϸ� �˴ϴ�. ���� ��� �� �� 3, 12�� �ִ������� 3, �ּҰ������ 12�̹Ƿ� solution(3, 12)�� [3, 12]�� ��ȯ�ؾ� �մϴ�.
	
	���� ����
	�� ���� 1�̻� 1000000������ �ڿ����Դϴ�.
	����� ��
	n	m	return
	3	12	[3, 12]
	2	5	[1, 10]
	����� �� ����
	����� �� #1
	���� ����� �����ϴ�.
	
	����� �� #2
	�ڿ��� 2�� 5�� �ִ������� 1, �ּҰ������ 10�̹Ƿ� [1, 10]�� �����ؾ� �մϴ�.
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
	 
	
	//�ٸ� ��� Ǯ�� : ����Լ� �̿�... �� ���� �����ϵ��� ����.
	public static int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];
		
		answer[0] = gcd(a,b);
		answer[1] = (a*b)/answer[0];
		return answer;
	}
	 
	public static int gcd(int p, int q) {
		System.out.println(p+","+q);
	    if (q == 0) return p; // q�� 0�� ������ �ǹ̴�? 
	    //p�� q�� �������� �� 0�̶�� p�� �ִ������̴�. 
	    return gcd(q, p%q); // q�� 0�� �ƴ϶��(=q�� p�� ����� �ƴ϶��), q�� p������q�� ������(<=p)�� �ִ´�.
	}
	
	// �ٸ� ��� Ǯ�� 2 : �ּҰ���� = �� ���� �� / �ִ����� �� �̿��Ͽ� ���
	// �ٸ� ��� Ǯ�� 1�� Ǯ�� �� �� 
		public int[] gcdlcm2(int a, int b) {
	        int[] answer = new int[2];
	      int temp=1;
	      int gcd=a*b;
	      while(temp!=0){
	      temp=b%a; // temp : b ������ a �� ������
	        b=a; // �ڸ��� �ٲ۴�.
	        a=temp;
	      }
	      answer[0]=b;
	      answer[1]=gcd/b;
	        return answer;
	    }
	
	// �ٸ� ��� Ǯ�� 3 : ���� for������ ã�´�
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
