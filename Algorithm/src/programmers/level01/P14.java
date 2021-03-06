package programmers.level01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P14 {
/* 프로그래머스 Lv.1 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 문제 설명
	수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
	
	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	제한 조건
	시험은 최대 10,000 문제로 구성되어있습니다.
	문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	입출력 예
	answers	return
	[1,2,3,4,5]	[1]
	[1,3,2,4,2]	[1,2,3]
	입출력 예 설명
	입출력 예 #1
	
	수포자 1은 모든 문제를 맞혔습니다.
	수포자 2는 모든 문제를 틀렸습니다.
	수포자 3은 모든 문제를 틀렸습니다.
	따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
	
	입출력 예 #2
	
	모든 사람이 2문제씩을 맞췄습니다.
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
			
			// i) for문 이용한 list -> array : 시간 적게 걸림  
			int[] array = new int[answer.size()];
	        for(int i=0; i <answer.size(); i++) {
				array[i] = answer.get(i);
	        }
			return array;	
			
			
			
			
			// ii) stream() 이용한 list -> array : 시간 오래 걸림
			/* return answer.stream().mapToInt(i->i).toArray();
			 * 
			 * 
			answer.stream().mapToInt(i->i).toArray() 설명
			https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
			
			Thought process:

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
