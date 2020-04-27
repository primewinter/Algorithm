package ESTSoft;

import java.util.ArrayList;
import java.util.List;

public class Q04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		//String S = "John Joe; Peter Benjamin; Mary Jane Fever; Hi My Name-is";
		String C = "Example";
		System.out.println(solution(S,C));

	}
	
	 public static String solution(String S, String C) {
	     // write your code in Java SE 8
		 String[] nameList = S.split("; ");
		 List<String> idList = new ArrayList<>();
		 
		 for(String name : nameList) {
			 String[] splitedName = name.split(" ");
			 if( splitedName.length==3) {
				 if( splitedName[2].contains("-")) {
					 splitedName[2] = splitedName[2].replace("-", "");
				 }
				 idList.add(splitedName[2].toLowerCase()+"_"+splitedName[0].toLowerCase());
			 } else {
				 if( splitedName[1].contains("-")) {
					 splitedName[1] = splitedName[1].replace("-", "");
					 idList.add(splitedName[1].replace("-", "").toLowerCase()+"_"+splitedName[0].toLowerCase());
				 }
				 idList.add(splitedName[1].toLowerCase()+"_"+splitedName[0].toLowerCase());
			 }
		 }
		 
		 
		 for(int i =0; i < idList.size(); i++) {
			int duplicated = 1;
			//System.out.print("비교할 id("+i+") : "+idList.get(i));
			for(int j=0; j < idList.size(); j++) {
				if( i!=j && idList.get(i).equals(idList.get(j)) ) {
					//System.out.println(" == 비교할 id("+j+") : "+idList.get(j));
					duplicated++;
					idList.set(j, idList.get(j)+duplicated);
				}
			}
		}
		
		String answer = "";
		for(int i = 0 ; i < idList.size(); i++) {
			answer += nameList[i]+" <"+idList.get(i)+"@"+C.toLowerCase()+".com>; ";
		}
		 
		 
		 return answer;
	 }

}
