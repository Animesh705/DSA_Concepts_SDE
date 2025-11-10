//Problem Statement –
//A chocolate factory is packing chocolates into the packets.
// The chocolate packets here represent an array  of N number of integer values.
// The task is to find the empty packets(0) of chocolate and push it to the end of the conveyor belt(array).
package TCS_NQT;
import java.util.*;
public class chocolate_factory {
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i< n;i++)
            arr[i]=sc.nextInt();

        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count++;
            }
        }

        for(int i=count;i<arr.length;i++){
            arr[i]=0;
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i] + " ");
        }
        sc.close();
    }
}
