package Line;

import java.util.*;

public class q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] dataSource = {
				{"doc1", "t1", "t2", "t3"},
				{"doc2", "t0", "t2", "t3"},
				{"doc3", "t1", "t6", "t7"},
				{"doc4", "t1", "t2", "t4"},
				{"doc5", "t6", "t100", "t8"}
		};
		String[] tags = {				"t1", "t2", "t3" 		};
		solution(dataSource, tags);

	}
	 public static String[] solution(String[][] dataSource, String[] tags) {
	        List<String> tagList = Arrays.asList(tags);
	        Map<Integer, List<String>> result = new HashMap<>();
	        List<Integer> countList = new ArrayList<>();
	        
	        for(String[] docNtags : dataSource) {
	        	List<String> list = new ArrayList(Arrays.asList(docNtags));
	        	String doc = list.get(0);
	        	int count = 0;
	        	for(String tag : list ) {
	        		if( tagList.contains(tag)) {
	        			count++;
	        		}
	        	}
	        	
	        	if(count>0) {
	        		if( result.containsKey(count)) {
	        			result.get(count).add(doc);
	        		} else {
	        			List<String> docList = new ArrayList<>();
	        			docList.add(doc);
	            		result.put(count, docList);
	        		}
	        		if( !countList.contains(count)) {
	        			countList.add(count);
	        		}
	        	}
	        }
	        
	        Collections.sort(countList, Collections.reverseOrder());
	        List<String> finalList = new ArrayList<>();
	        for(Integer no : countList ) {
	            if(result.get(no).size()>1) {
	        		Collections.sort(result.get(no));
	        		for(String doc:result.get(no)) {
	        			finalList.add(doc);
	        		}
	        	} else {
	                finalList.add(result.get(no).get(0));
	            }
	            if(finalList.size()==10) {
	            	break;
	            }
	        }
	        return finalList.toArray(new String[0]);
	    }
/*
 * ���� ��� ������ ���� �ý����� �ٷ�� ������ ���ϰ� �Ǿ����ϴ�.
������ ���� �ý����� ������ Ư¡�� �� ��Ÿ�� �� �ֵ��� ���� Ű���带 ����Ͽ� �����ϴ� �±� ����� �����ϰ� �ֽ��ϴ�.

������ ���� ���� ������ ������� ������ �±׸� �̿��Ͽ� ������ �ִ� ������ ����� ��ȯ�ϴ� ���ο� ����� ����� �Ǿ����ϴ�.
�Ʒ��� ���� ������ Ȯ���ϰ� �� �˻� ����� ������ �ּ���.

���� ����
[
    ["����1", "�±�1", "�±�2", "�±�3", ...],
    ["����2", "�±�2", "�±�3", "�±�5", ...],
    ["����3", "�±�99", "�±�100", ..],
    ...
]
dataSource�� 2���� �迭�� ���� ���� ������ �׿� ���� �±� ������ �����մϴ�
�� ������ ���� ������ �迭�� �����Ǿ� ������, ù ��° ���Ҵ� ���� �̸���, �� ��° ���Һ��ʹ� �±׸� ��Ÿ���ϴ�
�±��� ���� �������� �ٸ� �� �ֽ��ϴ�
�� ���� ���� �ȿ� �ߺ��� �±״� �����ϴ�
���� �ٸ� ������ ���� �±׸� ���� �� �ֽ��ϴ�
������ ������ 1 �̻� 105 �����Դϴ�
�±��� ������ 0 �̻� 105 �����Դϴ�
["�±�1", "�±�2", "�±�3", "�±�5"]
tags�� �˻��� ���� �±� ���ڿ��� �迭�Դϴ�
�±��� ������ 1 �̻� 104 �����Դϴ�
["����1", "����2", ...]
�־��� �±� �� �ϳ� �̻� ������ �±׸� ������ �������� ��ȯ�մϴ�
�־��� �±׸� ���� ���� �����ϴ� �����ϼ��� �տ� ��ġ��ŵ�ϴ�
�����ϴ� �±��� ���� ������ ���� ���� �̸��� ������ ����(lexicographical order)�� �����մϴ�
���������̼�(pagination) ����� �����ϱ� ���ؼ� �˻� ����� ���ĵ� ������ �� ���� 10�Ǹ� ��ȯ�մϴ�
����� ��
dataSource
[
    ["doc1", "t1", "t2", "t3"],
    ["doc2", "t0", "t2", "t3"],
    ["doc3", "t1", "t6", "t7"],
    ["doc4", "t1", "t2", "t4"],
    ["doc5", "t6", "t100", "t8"]
]
tags
["t1", "t2", "t3"]
result
["doc1", "doc2", "doc4", "doc3"]
 */
}
