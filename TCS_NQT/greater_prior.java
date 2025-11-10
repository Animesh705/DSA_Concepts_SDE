package TCS_NQT;
/*
Given an integer array Arr of size N the task is to find the count of elements whose value is greater than all of its prior elements.
Note : 1st element of the array should be considered in the count of the result.
For example,
Arr[]={7,4,8,2,9}
As 7 is the first element, it will consider in the result.
8 and 9 are also the elements that are greater than all of its previous elements.
Since total of  3 elements is present in the array that meets the condition.
Hence the output = 3.
 */

import java.util.*;
public class greater_prior {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 1; // first element always counts
        //You don’t actually need nested loops for this.
        //Instead of checking all previous elements each time,
        //just track the maximum value you’ve seen so far.

        //If the current element > max so far → it’s a new “record-breaker,” so count it and update the max.
        int maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxSoFar) {
                count++;
                maxSoFar = arr[i];
            }
        }

        System.out.println(count);
        sc.close();
    }
}