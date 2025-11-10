package TCS_NQT;

import java.util.Scanner;

//Jack is always excited about sunday. It is favourite day, when he gets to play all day. And goes to cycling with his friends.
//So every time when the months starts he counts the number of sundays he will get to enjoy.
// Considering the month can start with any day, be it Sunday, Monday…. Or so on.
//Count the number of Sunday jack will get within n number of days.
//
// Example 1:
//Input
//mon-> input String denoting the start of the month.
//13  -> input integer denoting the number of days from the start of the month.
public class sundays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        String arr[] = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
        int rem = n % 7;
        int res = n / 7;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(s)) {
                index = i;              // store index if found
                break;                  // stop searching (first match only)
            }
        }
        int result = res;
        // Check if remaining days include a Sunday
        // Sunday index is 0, so next Sunday will occur after (7 - index) days
        if (index + rem > 6) {  // if leftover days go beyond Saturday
            result++;
        }

        System.out.println(result);
        sc.close();
    }
}
