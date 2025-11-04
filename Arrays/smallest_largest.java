package Arrays;
import java.util.*;
public class smallest_largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.print("Enter value of each element of array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr);
    }
        static void sort ( int[] arr){
            Arrays.sort(arr);
            System.out.println("smallest no." + arr[0]);
            System.out.println("second smallest no." + arr[1]);
            System.out.println("largest no." + arr[arr.length - 2]);
            System.out.println("largest no." + arr[arr.length - 1]);
            return;
        }
    }

