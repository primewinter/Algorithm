package level01;

public class P11 {
	public static String solution(String[] seoul) {
		//김서방찾기 내코드    
		String answer = "";
		     for(int i=0; i<seoul.length;i++) {
		          if( seoul[i].equals( "Kim") ) {
		              answer = "김서방은 "+i+"에 있다";
		              break;
		          }
		      }
		      return answer;
		      
		          //다른사람 코드
//		          int x = Arrays.asList(seoul).indexOf("Kim");
//
//		          return "김서방은 "+ x + "에 있다";
		      }
	
		
	public static void main(String[] args) {
		String[] seoul= {"Jane", "Kim"};
		System.out.println(solution(seoul));
		}
	}
