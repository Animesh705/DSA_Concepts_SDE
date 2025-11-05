package Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class removeDupli_findRepeatingAndNonRepeatingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.print("Enter value of each element of array : ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
            removeDuplicates(arr);
        nonRepeating(arr);
}
    public static void removeDuplicates(int[] arr) {
        Arrays.sort(arr);

        System.out.print("Array without duplicates and also elements which are repeating: ");
        int prev = 0;
        for(int i=0;i<arr.length;i++) {
            //dry run table:
            //
            //| Step | num  | prev (pichla element)  | num != prev? | Output                | Update prev       |
            //|-------|------|-----------------------|--------------|-----------------------|-------------------|
            //| 1     | 1    | -2147483648 (MIN_VALUE) | true         | Print 1               | prev = 1          |
            //| 2     | 1    | 1                     | false        | Skip                  | prev = 1          |
            //| 3     | 2    | 1                     | true         | Print 2               | prev = 2          |
            //| 4     | 3    | 2                     | true         | Print 3               | prev = 3          |
            //| 5     | 3    | 3                     | false        | Skip                  | prev = 3          |
            //| 6     | 4    | 3                     | true         | Print 4               | prev = 4          |
            if(arr[i] != prev) {
                System.out.print(arr[i] + " ");
                prev = arr[i];
            }
        }
        System.out.println();
    }
    public static void nonRepeating(int[] arr) {
      Map<Integer,Integer> freqmap = new HashMap<>();
      for(int i : arr) {
          freqmap.put(i,freqmap.getOrDefault(i,0)+1);
          }
          System.out.print("non-repeating element ");
      for(int i : arr){
          if(freqmap.get(i)==1) {
              System.out.print(i + " ");
          }
      }
      }
}