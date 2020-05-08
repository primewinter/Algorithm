package Example;

public class CharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int + double vs double + double 차이 알기
		int a = 300;
		System.out.println(a/7);
		double b = 300;
		System.out.println(b/7);
		
		
		// String abc = new String("abc", 0, count); 뜻 알기
		/* java8 API
		String(char[] value)
		Allocates a new String so that it represents the sequence of characters currently contained in the character array argument.
		
		String(char[] value, int offset, int count) : 여기서 offset은 value의 시작 index를 뜻한다.
		Allocates a new String that contains characters from a subarray of the character array argument.
		*/
		char[] charArray = {'a','b','c'};
		String abc1 = new String(charArray, 0, 3); //charArray[0]인 'a'부터 길이 3만큼
		String abc2 = new String(charArray, 1, 2); //charArray[1]인 'b'부터 길이 2만큼
		String abc3 = new String(charArray, 2, 1); //charArray[2]인 'a'부터 길이 1만큼
		String abc4 = new String(charArray, 3, 0); //charArray[3]은 없으므로 에러가 날 것 같지만 나지 않는다.
		/* 소스코드를 보면 아래와 같다. offset > value.length - count 를 통과하지 않으므로 exception 발생 안함
		 * public String(char value[], int offset, int count) {
		        if (offset < 0) {
		            throw new StringIndexOutOfBoundsException(offset);
		        }
		        if (count <= 0) {
		            if (count < 0) {
		                throw new StringIndexOutOfBoundsException(count);
		            }
		            if (offset <= value.length) {
		                this.value = "".value;
		                return;
		            }
		        }
		        // Note: offset or count might be near -1>>>1.
		        if (offset > value.length - count) {
		            throw new StringIndexOutOfBoundsException(offset + count);
		        }
		        this.value = Arrays.copyOfRange(value, offset, offset+count);
		    }
		 */
		String abc5 = new String(charArray, 3, 1); //offset > value.length - count 이므로 StringIndexOutOfBoundsException 발생
		System.out.println(abc1);
		System.out.println(abc2);
		System.out.println(abc3);
		System.out.println(abc4);

	}

}
