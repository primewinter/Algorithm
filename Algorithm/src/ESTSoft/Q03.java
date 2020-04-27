package ESTSoft;

public class Q03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A
		//= {1,2,3,4,5,6,7,8};
		//= {2,5,2,6,2,7,2,8,2,9};
		//= {2,2,5,2,5,2,5,2};
		= {1,3,1,2};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		int flag = 100;
		for(int i = 0; i < A.length-3 ; i++) {
				int result = pleased(A[i], A[i+1], A[i+2], A[i+3]);
				if(result == 2) {
					break;
				} else if (result == 1) {
					return -1;
				} else if (result == 0) {
					flag = 0;
				}
		}
		
		if(flag==0) {
			return 0;
		}
		
		
		
		return 1;
    }
	
	public static int pleased(int A, int B, int C, int D) {
		if((B>A && B>C && D>C) || (B<A && B<C && D<C)) {
			return 0;
		} else if ( (B>A && C>B && D>C) || (A>B && B>C && C>D)){
			return 1;
		} else {
			return 2;
		}
	}

}
