import  java.util.*;
public class combiSumII {
    private void findcombi(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){

        if(target==0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind;i<arr.length;i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            findcombi(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates , int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findcombi(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        combiSumII solution = new combiSumII();
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8; // Added missing target parameter
        List<List<Integer>> result = solution.combinationSum(nums, target);

        System.out.println("unique Combinations that sum to " + target + ":");
        for(List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
