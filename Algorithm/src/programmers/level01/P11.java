package level01;

public class P11 {
	public static String solution(String[] seoul) {
		//�輭��ã�� ���ڵ�    
		String answer = "";
		     for(int i=0; i<seoul.length;i++) {
		          if( seoul[i].equals( "Kim") ) {
		              answer = "�輭���� "+i+"�� �ִ�";
		              break;
		          }
		      }
		      return answer;
		      
		          //�ٸ���� �ڵ�
//		          int x = Arrays.asList(seoul).indexOf("Kim");
//
//		          return "�輭���� "+ x + "�� �ִ�";
		      }
	
		
	public static void main(String[] args) {
		String[] seoul= {"Jane", "Kim"};
		System.out.println(solution(seoul));
		}
	}
