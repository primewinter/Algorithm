package codeUp.basic100;

import java.util.Scanner;

public class Q1441 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int el:arr) {
            el = sc.nextInt()+1;
        }
        
        for(int i=0; i<arr.length;i++) {
            for(int j=1; j<arr.length-i;j++) {
                if(arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        
        for(int i=0; i<arr.length;i++) {
            System.out.println(i);
        }
    }
}