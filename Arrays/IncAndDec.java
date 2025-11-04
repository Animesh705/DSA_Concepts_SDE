package Arrays;

import java.util.Scanner;
import java.util.*;
public class IncAndDec {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter value of n : ");
            int n = sc.nextInt();
            System.out.print("Enter value of each element of array : ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            inc(arr);
            dec(arr);
        }
        public static void inc(int[] arr){
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        public static void dec(int[] arr){
            Arrays.sort(arr);
            for(int i = arr.length-1; i >= 0; i--){
                System.out.print(arr[i] + " ");
            }
        }
}
