package Line;

import java.util.*;

public class q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String[] solution(String[] directory, String[] command) {
	        String[] answer = {};
	        List<String> dir = Arrays.asList(directory);
	        //List<String> cmdList = Arrays.asList(command);
	        
	        for(String cmd : command) {
	        	String[] oneLine = cmd.split(" ");
        		if(oneLine[0].equals("mkdir")) {
        			String[] mkdir = oneLine[1].split("/");
        			for(String dirOne : dir) {
        				if( dirOne.contains(mkdir[0]) ) {
        					if( dirOne.contains(mkdir[1]) ) {
        						
        					}
        				}
        			}
        		} else if (oneLine[0].equals("rm")) {
        			
        		} else if (oneLine[0].equals("cp")) {
        			
        		}
	        }
	        
	        return answer;
    }
/*
 * �������� �� ��ɾ �ϴ� ���� �����ϰ� ���� �ϴ� ���α׷��� �ۼ��Ϸ��� �մϴ�.

���� �� ���� ��ɾ �����ϵ��� ���α׷��� �ۼ����ּ���.

1.
�̸�	mkdir
��� ���	mkdir directory
����	Ư�� ��ġ�� ���丮�� �����մϴ�.
2.
�̸�	rm
��� ���	rm directory
����	Ư�� ���丮�� �����մϴ�. ������ ���丮�� ���� ���丮�� ���� �Բ� �����˴ϴ�.
3.
�̸�	cp
��� ���	cp source dest
����	source ���丮�� dest�� �����մϴ�. source ���丮�� ���� ���丮�� ���� ����Ǿ�� �մϴ�.
�� ����� ������ �ý��ۿ��� ���� ���丮�� �����ϸ�, �ֻ��� ���丮�� /�� ǥ���ϰ� �� ���� ���丮�� /root, /usr, /tmp, /tmp/tmp2�� ���� �����մϴ�.

���ѻ���
directory�� �ý����� ���丮 ������ ��Ÿ���� ���ڿ� �迭�Դϴ�.

directory�� ���̴� 1 �̻� 20 �����Դϴ�.
directory�� ���Ҵ� �� ���丮�� ���� ���(�ֻ��� ���丮������ ���)�� ��Ÿ���ϴ�.
�ý��ۻ��� ��� ���丮�� ���� ��ΰ� �־����ϴ�.
�� ���丮 �̸��� ���̰� 1 �̻� 10 �����Դϴ�.
��θ� ��Ÿ���� ���ڿ��� ���ĺ� �ҹ��ڿ� '/' �θ� �̷���� �ֽ��ϴ�.
�� ���丮 �ȿ� ���� �̸��� ���丮�� �� �� �̻� �ִ� ���� ������, ���� �߸��� ��ΰ� �־����� ���� �����ϴ�.
���丮 ��δ� ���� ������ ���ĵǾ� �־����ϴ�.
command�� ��ɾ���� ��� ���ڿ� �迭�Դϴ�.

command�� ���̴� 1 �̻� 20 �����Դϴ�.
command�� ���Ҵ� �� ��ɾ ��Ÿ���� ���ڿ��Դϴ�.
������ �־��� ��ɾ �Է����� �־�����, �߸��� ��ΰ� �־����� ���� �����ϴ�.
��δ� �׻� ���� ���(�ֻ��� ���丮������ ���)�θ� �־����ϴ�.
cp����� ��� �ڱ� �ڽ��� ���� ���丮�� �����ϴ� ����� �־����� �ʽ��ϴ�.
cp����� ��� �����ϴ� ��ġ�� �̸��� ������ �ٸ� ���丮�� �̹� �ִ� ���� �־����� �ʽ��ϴ�.
rm / ����� �Է����� �־����� �ʽ��ϴ�.
rm ����� �׻� ���丮 �ϳ��� ���������� �����ϴ� ��츸 �Է����� �־����ϴ�. (�������� �ʰų� �߸��� ���, ���� ���丮 ���� �����ϴ� ���� �����ϴ�)
mkdir ����� �׻� ���丮 �ϳ��� ���������� �����ϴ� ��츸 �Է����� �־����ϴ�. (�������� �ʰų� �߸��� ���, �ش� ��ο� ���� �̸��� ���丮�� �̹� �ִ� ���, �߰� ��ο� �ش��ϴ� ���丮�� ���� ��� ���� �Է����� �־����� �ʽ��ϴ�.)
��� ��ɾ ������ �� ���丮 ������ ���ڿ� ���·� �迭�� ��� ���� ������ �����ؼ� return���ּ���.

�ԷµǴ� ���丮 ������ ����������, ��� ���丮�� ���� ���� ��θ� ���ڿ� ���·� ���� �� ���� ������ �����ؼ� return �ϸ� �˴ϴ�.
'/'�� ���ĺ����� ���� ������ �� �տ� �´ٰ� �����մϴ�.
��ɾ� �� �� ���� �Ǵ� �� ������ ������ ��쿡�� �κ� ������ ȹ���� �� �ֽ��ϴ�.

����� �� #1
directory
[
"/",
"/hello",
"/hello/tmp",
"/root",
"/root/abcd",
"/root/abcd/etc",
"/root/abcd/hello"
]
command
[
"mkdir /root/tmp",
"cp /hello /root/tmp", 
"rm /hello"
]
result
[
"/", 
"/root", 
"/root/abcd", 
"/root/abcd/etc", 
"/root/abcd/hello", 
"/root/tmp", 
"/root/tmp/hello", 
"/root/tmp/hello/tmp"
]
����� �� #2
directory
[
"/"
]
command
[
"mkdir /a",
"mkdir /a/b",
"mkdir /a/b/c",
"cp /a/b /",
"rm /a/b/c"
]
result
[
"/",
"/a",
"/a/b",
"/b",
"/b/c"
]
 */
}
