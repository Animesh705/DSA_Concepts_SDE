package DP.Longest_inc_subSeq;
import java.util.*;
public class Len_of_LIS_BinaryS {
    public int LIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            //if the current element is greater than the last element in tempm list
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {//find the first greater element after the current element
                //what binary search return :
                // -> If key is found: return the actual index
                // ->if key  not found :return -(insertionPoint) - 1
                //remember the list is getting generated in rev. order
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) {
                    ind = -(ind + 1);
                }
                //place the curr element in the temp list
                temp.set(ind, nums[i]);
            }
        }
        return temp.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        Len_of_LIS_BinaryS obj = new Len_of_LIS_BinaryS();
        System.out.println(obj.LIS(nums));
    }
}
