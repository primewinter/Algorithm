package Example;

public class CharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int + double vs double + double ���� �˱�
		int a = 300;
		System.out.println(a/7);
		double b = 300;
		System.out.println(b/7);
		
		
		// String abc = new String("abc", 0, count); �� �˱�
		/* java8 API
		String(char[] value)
		Allocates a new String so that it represents the sequence of characters currently contained in the character array argument.
		
		String(char[] value, int offset, int count) : ���⼭ offset�� value�� ���� index�� ���Ѵ�.
		Allocates a new String that contains characters from a subarray of the character array argument.
		*/
		char[] charArray = {'a','b','c'};
		String abc1 = new String(charArray, 0, 3); //charArray[0]�� 'a'���� ���� 3��ŭ
		String abc2 = new String(charArray, 1, 2); //charArray[1]�� 'b'���� ���� 2��ŭ
		String abc3 = new String(charArray, 2, 1); //charArray[2]�� 'a'���� ���� 1��ŭ
		String abc4 = new String(charArray, 3, 0); //charArray[3]�� �����Ƿ� ������ �� �� ������ ���� �ʴ´�.
		/* �ҽ��ڵ带 ���� �Ʒ��� ����. offset > value.length - count �� ������� �����Ƿ� exception �߻� ����
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
		String abc5 = new String(charArray, 3, 1); //offset > value.length - count �̹Ƿ� StringIndexOutOfBoundsException �߻�
		System.out.println(abc1);
		System.out.println(abc2);
		System.out.println(abc3);
		System.out.println(abc4);

	}

}
