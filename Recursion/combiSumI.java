import  java.util.*;
public class combiSumI {
    private void findcombi(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target) {
            ds.add(arr[ind]);
            findcombi(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findcombi(ind +1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates , int target){
        List<List<Integer>> ans = new ArrayList<>();
        findcombi(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        combiSumI solution = new combiSumI();
        int[] nums = {2, 3, 6, 7};
        int target = 7; // Added missing target parameter
        List<List<Integer>> result = solution.combinationSum(nums, target);

        System.out.println("Combinations that sum to " + target + ":");
        for(List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}