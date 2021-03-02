package baekjoon.stack.q4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//56604KB	584ms
public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line.equals(".")) break;
            if(check(line)) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb.toString());
    }
    
    static boolean check(String str) {
        String refined = str.replaceAll("[^()\\[\\]]","");
        String result = "";
        while(true) {
            result = refined.replaceAll("\\[\\]", "").replaceAll("\\(\\)","");
            if(refined.equals(result)) break;
            refined = result;
        }
        if(result.length()==0) return true;
        return false;
    }
}