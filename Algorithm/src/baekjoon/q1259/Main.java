package baekjoon.q1259;

import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = "";
        boolean isPalindrome = true;
        while(true) {
            num = br.readLine();
            if( num.equals("0") ) break;

            isPalindrome = true;

            for(int i=0; i<num.length()/2 ; i++) {
                if( num.charAt(i) != num.charAt(num.length()-i-1) ) {
                    isPalindrome = false;
                }
            }

            if(isPalindrome) sb.append("yes").append("\n");
            else sb.append("no").append("\n");

        }

        System.out.println(sb);
    }
}
