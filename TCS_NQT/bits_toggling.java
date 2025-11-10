//Problem Statement –
//
//Joseph is learning digital logic subject which will be for his next semester.
// He usually tries to solve unit assignment problems before the lecture.
// Today he got one tricky question. The problem statement is “A positive integer has been given as an input.
// Convert decimal value to binary representation. Toggle all bits of it after the most significant bit including the most significant bit.
// Print the positive integer value after toggling all bits”.
package TCS_NQT;
import java.util.*;
public class bits_toggling {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int mask=0;
        int temp=n;

        while(temp>0){
            mask = (mask << 1)|1;
            temp=temp>>1;
        }
        int result=n^mask;
       System.out.println(result);
    }
}
