package level01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P14 {
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * ���α׷��ӽ� Lv.1 ���ǰ��
 * ���� ����
	�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
	
	1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���� ����
	������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
	������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
	���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
	����� ��
	answers	return
	[1,2,3,4,5]	[1]
	[1,3,2,4,2]	[1,2,3]
	����� �� ����
	����� �� #1
	
	������ 1�� ��� ������ �������ϴ�.
	������ 2�� ��� ������ Ʋ�Ƚ��ϴ�.
	������ 3�� ��� ������ Ʋ�Ƚ��ϴ�.
	���� ���� ������ ���� ���� ����� ������ 1�Դϴ�.
	
	����� �� #2
	
	��� ����� 2�������� ������ϴ�.
 */
	 public int[] solution(int[] answers) {
	     	List<Integer> answer = new ArrayList<>();
	     	int[] result = new int[3];
			int[] a = {1,2,3,4,5};
			int[] b = {2,1,2,3,2,4,2,5};
			int[] c = {3,3,1,1,2,2,4,4,5,5};
			
			
			for(int i=0; i<answers.length; i++) {
				if(answers[i]==a[i%5]) {
					result[0]++;
				}
				if(answers[i]==b[i%8]) {
					result[1]++;
				}
				if(answers[i]==c[i%10]) {
					result[2]++;
				}
			}
			
			int biggest = Math.max(Math.max(result[0], result[1]), result[2]);
			for(int i=0; i <result.length; i++) {
				if(biggest==result[i]) {
					answer.add(i+1);
				}
			}
			
			Collections.sort(answer);
			return answer.stream().mapToInt(i->i).toArray();
			/*answer.stream().mapToInt(i->i).toArray() ����
			 * https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
			 * 
			 * Thought process:

			simple Stream#toArray returns Object[], so it is not what we want. Also Stream#toArray(IntFunction<A[]> generator) doesn't do what we want because generic type A can't represent primitive int
			so it would be nice to have some stream which could handle primitive type int instead of wrapper Integer, because its toArray method will most likely also return int[] array (returning something else like Object[] or even boxed Integer[] would be unnatural here). And fortunately Java 8 has such stream which is IntStream
			so now only thing we need to figure out is how to convert our Stream<Integer> (which will be returned from list.stream()) to that shiny IntStream. Here Stream#mapToInt(ToIntFunction<? super T> mapper) method comes to a rescue. All we need to do is pass to it mapping from Integer to int. We could use something like Integer#getValue which returns int like :
			
			mapToInt( (Integer i) -> i.intValue() )  
			(or if someone prefers mapToInt(Integer::intValue) )
			
			but similar code can be generated using unboxing, since compiler knows that result of this lambda must be int (lambda in mapToInt is implementation of ToIntFunction interface which expects body for int applyAsInt(T value) method which is expected to return int).
			
			So we can simply write
			
			mapToInt((Integer i)->i)
			Also since Integer type in (Integer i) can be inferred by compiler because List<Integer>#stream() returns Stream<Integer> we can also skip it which leaves us with
			
			mapToInt(i -> i)
			 * 
			 */
		
	    }
}
