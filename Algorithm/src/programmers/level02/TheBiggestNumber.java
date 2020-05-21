package programmers.level02;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {
	
	/* ���� ū ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 * ���� ����
	0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
	
	���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.
	
	0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���� ����
	numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
	numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
	������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
	����� ��
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
//				System.out.println("�� :: "+d1+" || "+d2);
//				
//				if(d1.intValue() == d2.intValue()) {
//					return (int)(o2-o1); // ��������
//				} else {
//					return (int)(o1-o2); // ��������
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
					
					// ���ʷ� �޶����� ���� ���� : 234, 232 --> 4,2 ���� || 234,2341 --> 4,1 ���� &�÷��� T
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
		System.out.println("���� : "+biggest(new int[] {6,0,235,234,23,67})); // 6 61 235
	}

}
