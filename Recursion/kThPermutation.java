package Recursion;
import java.util.*;
public class kThPermutation {
    public String getPermutation(int n, int k){
        int fact=1;
        List<Integer> numbers=new ArrayList<>();
        for(int i=1;i<n;i++){
            fact=fact*i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k-1;
        while(true){
            ans = ans+numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k = k%fact;
            fact=fact/numbers.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        int n;
        int k;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the n: ");
        n=sc.nextInt();
        System.out.print("Enter the k: ");
        k=sc.nextInt();
        System.out.println(new kThPermutation().getPermutation(n, k));

    }

}
