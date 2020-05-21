package programmers.level02;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {
	
	/* 가장 큰 수
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * 문제 설명
	0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	
	예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	numbers의 길이는 1 이상 100,000 이하입니다.
	numbers의 원소는 0 이상 1,000 이하입니다.
	정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	입출력 예
	numbers	return
	[6, 10, 2]	6210
	[3, 30, 34, 5, 9]	9534330
	 */

	public static String biggest(int[] numbers) {
        String answer = "";
        
        Double[] arr = new Double[numbers.length];
        Integer[] intArr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        String[] boxedArray = new String[numbers.length];
        for(int i=0; i<numbers.length;i++) {
        	boxedArray[i] = numbers[i]+"";
        }
//        Arrays.sort(intArr, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				Double d1 = o1.doubleValue();
//				Double d2 = o2.doubleValue();
//				if(o1 >= 10) {
//					int length = (int)Math.log10(o1);
//					d1 = (double)(o1/Math.pow(10, length));
//				}
//				if(o2 >= 10) {
//					int length = (int)Math.log10(o2);
//					d2 = (double)(o2/Math.pow(10, length));
//				}
//				System.out.println("비교 :: "+d1+" || "+d2);
//				
//				if(d1.intValue() == d2.intValue()) {
//					return (int)(o2-o1); // 오름차순
//				} else {
//					return (int)(o1-o2); // 내림차순
//				}
//			}
//        });
        Arrays.sort(boxedArray, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				long long1 = Long.parseLong(o1+o2);
				long long2 = Long.parseLong(o2+o1);
				return (int)(long1-long2);
				
				/*
				char[] ch1 = o1.toCharArray();
				char[] ch2 = o2.toCharArray();
				if(ch1[0]==ch2[0]) {
					char diff1;
					char diff2;
					char same;
					int minLeng = Math.min(ch1.length, ch2.length);
					boolean isContained = true;
					
					// 최초로 달라지는 숫자 추출 : 234, 232 --> 4,2 추출 || 234,2341 --> 4,1 추출 &플래그 T
					for(int i=0; i<minLeng; i++) {
						if(ch1[i] != ch2[i]) {
							diff1 = ch1[i];
							diff2 = ch2[i];
							isContained = false;
							break;
						} else {
							same = ch1[i];
						}
					}
					
					// 23, 232 || 234, 2325
					if(!isContained) {
						
					}
					
					if(isContained) { // 234, 2345 or 234, 2341
						diff1 = ch1[minLeng-1];
						diff2 = ch2[minLeng];
						
						if(diff2 > ch1[0]) { // 2345, 234
							return 0;
						} else if (diff2 < ch1[0]) { // 2341, 234
							return 0;
						} else { // 2142, 214  2142214  2142142
							
						}
					}
					
					// 234, 235 or 232, 231
					
					
				}
				return 0;
				 */
				
			}
        });
        for(String str : boxedArray) {
        	answer += str;
        }
        	
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("정답 : "+biggest(new int[] {6,0,235,234,23,67})); // 6 61 235
	}

}
