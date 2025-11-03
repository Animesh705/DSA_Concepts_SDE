package Recursion_and_Backtracking;

import Recursion.kThPermutation;

import java.util.*;

public class printAllPermutation {
    public void recPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recPermute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recPermute(nums, ds, ans, freq);
        return ans;
    }

    public static void main(String[] args) {
        int nums;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n: ");
        nums = sc.nextInt();
        int[] arr = new int[nums];
        for (int i = 0; i < nums; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> result = new printAllPermutation().permute(arr);
        System.out.println(result);
    }
}
