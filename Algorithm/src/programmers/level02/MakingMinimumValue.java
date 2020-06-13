package programmers.level02;

import java.util.Arrays;

public class MakingMinimumValue {
	/* 최소값 만들기(+2)
	 * https://programmers.co.kr/learn/courses/30/lessons/12941
	 * 문제 설명
길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)

예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면

A에서 첫번째 숫자인 1, B에서 두번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
A에서 세번째 숫자인 2, B에서 첫번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
즉, 이 경우가 최소가 되므로 29를 return 합니다.

배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 A, B의 크기 : 1,000 이하의 자연수
배열 A, B의 원소의 크기 : 1,000 이하의 자연수
입출력 예
A	B	answer
[1, 4, 2]	[5, 4, 4]	29
[1,2]	[3,4]	10
입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
A에서 첫번째 숫자인 1, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 4) 다음, A에서 두번째 숫자인 2, B에서 첫번째 숫자인 3을 뽑아 곱하여 더합니다. (누적된 값 : 4 + 6 = 10)
이 경우가 최소이므로 10을 return 합니다.
	 */

	public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<A.length; i++) {
        	answer += A[i]*B[i];
        }
        return answer;
    }
	
	// 다른 사람 풀이 (Arrays.sort 직접 구현)
	public int getMinSum(int []A, int []B) {
		int answer = 0;
		int length = A.length;
		
		quickSort(A, 0, A.length-1);
		quickSort(B, 0, B.length-1);
		
		//System.out.println(A[0]);
		//System.out.println(B[0]);
		
		for(int i = 0 ; i < length ; i++) {
		    answer += A[i] * B[length-1-i];
		}
		
		return answer;
	 }

	 public static void quickSort(int[] arr, int left, int right) {
		int i, j, pivot, tmp;
		if (left < right) {
		    i = left; // 왼쪽의 위치 0
		    j = right; // 오른쪽의 위치 5
		    pivot = arr[left]; // 왼쪽값(기준값) 33
		    
		    //분할 과정
			while (i < j) { 
			    while (arr[j] > pivot) j--; // 기준값의 오른쪽에 있는 값들 중 작은 값(의 위치)을 찾는 코드
			    while (i < j && arr[i] <= pivot) i++; // 기준값이 찾아낸값(작은값)보다 왼쪽에 있으면 기준값을 그 다음으로 옮긴다
			    // 기준값이랑 작은 값의 위치를 바꾼다.
			    tmp = arr[i]; 
			    arr[i] = arr[j]; 
			    arr[j] = tmp;
			}
			// 새로 찾은 작은 값이 pivot(기준값)이 되고 그 값의 위치가 left가 된다.
			arr[left] = arr[i];
			arr[i] = pivot;
			//정렬 과정
		    quickSort(arr, left, i - 1);
		    quickSort(arr, i + 1, right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
