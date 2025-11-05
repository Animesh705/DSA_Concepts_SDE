package Arrays;

import java.util.Scanner;
import java.util.*;
public class rotateByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.print("Enter value of k : ");
        int k=sc.nextInt();
        System.out.print("Enter value of each element of array : ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        rotate(arr,k);
}
public static void rotate(int[] arr, int k){
       int  n=arr.length;
       int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            //mod: mod has special power ,
            // if we do x%n -> the output will always range between 0 to n-1
            //aur iske help se , we are handeling the element will are going of range ,
            // and instead of going out of range it moving in a cycle
            newArr[(i+k)%n]=arr[i];
            }
        for (int i = 0; i < n; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}
