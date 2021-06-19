package baekjoon.sort.q1427;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Q1427 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        Integer[] arr = new Integer[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = Character.getNumericValue(str.charAt(i));
        }

        Arrays.sort(arr, Comparator.reverseOrder());

//        sort(arr, 0, arr.length - 1);

        StringBuilder sb = new StringBuilder();
        for(int val : arr) {
            sb.append(val);
        }

        System.out.println(sb);
    }

    static void sort(int[] arr, int hi, int lo) {
        
        if( hi >= lo ) return;
        
        int pivot = partition(arr, hi, lo);

        sort(arr, hi, pivot - 1);
        sort(arr, pivot + 1, lo);
    }

    static int partition(int[] arr, int left, int right) {
        
        int hi = left;
        int lo = right;
        int pivot = arr[left];

        while( hi > lo ) {

            while( arr[hi] > pivot && hi > lo ) {
                lo--;
            }

            while( arr[lo] <= pivot && lo < hi ) {
                lo++;
            }

            swap(arr, lo, hi);

        }

        swap(arr, left, lo);

        return lo;
    }

    static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
