//A thief needs to rob money in a street. The houses in the street are arranged in a circular manner.
//Therefore the first and the last house are adjacent to each other.
// The security system in the street is such that if adjacent houses are robbed, the police will get notified.
//
//Given an array of integers “Arr'' which represents money at each house,
//we need to return the maximum amount of money that the thief can rob without alerting the police.
package DP;
import java.util.*;
public class g6_houseRobber {
    public int maxSum(List<Integer> nums) {
        int n=nums.size();
//if only one element is present
        if(n==1) return 0;
        // Compare first two elements
        int prev = nums.get(0);
        int prev2 = 0;
        int curi;

        // Iterate from index 1
        for(int i = 1; i < n; i++) {
            // Take current and d[i-2]/prev2 or just dp[i-1]/prev
            curi = Math.max(nums.get(i) + prev2, prev);
            prev2=prev;
            prev=curi;
        }

        // Return result from last index
        return prev;
    }
    public long houseRob( int arr[]){
        int n=arr.length;
        //if no house
        if(n==0) return 0;
        //if single house , return the what's present
        if(n==1) return arr[0];
//created to array , one with all elements except first , and other with all except last
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i!=0) arr1.add(arr[i]);
            if(i!=n-1) arr2.add(arr[i]);
        }
        return Math.max(maxSum(arr1),maxSum(arr2));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //size of array
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        g6_houseRobber sol = new g6_houseRobber();
        System.out.println(sol.houseRob(nums));
    }
}
