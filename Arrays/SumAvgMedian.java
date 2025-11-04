package Arrays;
import java.util.*;
public class SumAvgMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.print("Enter value of each element of array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        math(arr);
    }
    public static void math(int[] arr){
        int sum=0;
        double avg=0;
        int median=0;
        for(int j=0;j<arr.length;j++){
           sum= sum +arr[j];
        }
        avg= sum/arr.length;
        if(arr.length%2==0) {
            median = arr.length / 2;
        }
                else {
            median = arr.length / 2 + 1;
        }
        System.out.println("sum of the array is : "+sum);
        System.out.println("average is : "+avg);
        System.out.println("median is : "+median);

    }
}
