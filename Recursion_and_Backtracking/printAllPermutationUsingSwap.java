package Recursion_and_Backtracking;
import java.util.*;


public class printAllPermutationUsingSwap {
    public void recPermute(int ind, int[] nums, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i< nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<nums.length; i++){
            swap(i, ind,nums);
            recPermute(ind+1, nums, ans);
            swap(i , ind, nums);
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recPermute(0, nums, ans);
        return ans;
    }
    public static void main(String[] args) {
        int nums;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n: ");
        nums = sc.nextInt();
        int[] numsArr = new int[nums];

        for(int i=0; i<numsArr.length; i++) {
            System.out.print("Enter the " + (i+1) + " number: ");
            numsArr[i] = sc.nextInt();
        }
            List<List<Integer>>  result = new printAllPermutationUsingSwap().permute(numsArr);
        System.out.println(result);

    }
}
