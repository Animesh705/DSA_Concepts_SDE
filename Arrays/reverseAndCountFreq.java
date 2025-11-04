package Arrays;
import java.util.*;
public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.print("Enter value of each element of array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        rev(arr);
    }
    static void rev( int[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
        return;
    }
}