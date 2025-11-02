import java.util.*;
public class subSetSumII {
    public void findSubset(int ind, int[] num, List<Integer> ds, List<List<Integer>> ansList){
        ansList.add(new ArrayList<>(ds));
        for(int i = ind;i<num.length;i++){
            if (i != ind && num[i] == num[i - 1]) continue;
            ds.add(num[i]);
            findSubset(i + 1, num, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetWithDup(int[] num){
        Arrays.sort(num);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubset(0, num, new ArrayList<>(), ansList);
        return ansList;
    }
    public static void main(String[] args) {
        subSetSumII solution = new subSetSumII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetWithDup(nums);

        for(List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}