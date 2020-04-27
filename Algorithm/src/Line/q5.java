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
 * 신입 사원 브라운은 문서 시스템을 다루는 팀에서 일하게 되었습니다.
기존의 문서 시스템은 문서의 특징을 잘 나타낼 수 있도록 관련 키워드를 등록하여 관리하는 태그 기능을 포함하고 있습니다.

브라운은 기존 문서 정보를 기반으로 복수의 태그를 이용하여 관련이 있는 문서의 목록을 반환하는 새로운 기능을 만들게 되었습니다.
아래의 제약 조건을 확인하고 새 검색 기능을 구현해 주세요.

제한 사항
[
    ["문서1", "태그1", "태그2", "태그3", ...],
    ["문서2", "태그2", "태그3", "태그5", ...],
    ["문서3", "태그99", "태그100", ..],
    ...
]
dataSource는 2차원 배열로 여러 건의 문서와 그에 따른 태그 정보를 포함합니다
한 문서에 대한 정보는 배열로 구성되어 있으며, 첫 번째 원소는 문서 이름을, 두 번째 원소부터는 태그를 나타냅니다
태그의 수는 문서마다 다를 수 있습니다
한 문서 정보 안에 중복된 태그는 없습니다
서로 다른 문서가 같은 태그를 가질 수 있습니다
문서의 개수는 1 이상 105 이하입니다
태그의 개수는 0 이상 105 이하입니다
["태그1", "태그2", "태그3", "태그5"]
tags는 검색에 사용될 태그 문자열의 배열입니다
태그의 개수는 1 이상 104 이하입니다
["문서1", "문서2", ...]
주어진 태그 중 하나 이상 동일한 태그를 가지는 문서들을 반환합니다
주어진 태그를 가장 많이 포함하는 문서일수록 앞에 위치시킵니다
포함하는 태그의 수가 동일할 때는 문서 이름을 사전식 순서(lexicographical order)로 정렬합니다
페이지네이션(pagination) 기능을 적용하기 위해서 검색 결과는 정렬된 문서들 중 상위 10건만 반환합니다
입출력 예
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
