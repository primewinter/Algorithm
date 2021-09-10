package baekjoon.implementation.year2007;

import java.util.Scanner;

public class year2007 {

    static int[] dateArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT " };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getDay(sc.nextInt(), sc.nextInt()));
        sc.close();
    }

    public static String getDay(int month, int date) {
        int sum = date;
        for (int i = 0; i < month - 1; i++) {
            sum += dateArr[i];
        }

        return days[sum % 7];
    }
}
