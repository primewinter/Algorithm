package baekjoon.q2609;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int GCD = getGCD(Math.max(a, b), Math.min(a,b));
        int LCM = GCD * (a/GCD) * (b/GCD);

        System.out.println(GCD+"\n"+LCM);
        
    }

    public static int getGCD(int num1, int num2) {
        if( num2 == 0 ) return num1;
        else if( num1 % num2 == 0 ) return num2;
        else return getGCD(num2, num1%num2);
    }
}
