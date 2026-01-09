package binary_search;
import java.util.*;
class find_target_inRotatedSortedArray {
        // Function to search target in rotated sorted array using binary search
        public int search(int[] nums, int target) {

            // Initialize search space
            int low = 0;
            int high = nums.length - 1;

            // Continue while there is still a valid search range
            while (low <= high) {

                // Calculate middle index
                int mid = (low + high) / 2;

                // If target found, return index
                if (nums[mid] == target)
                    return mid;

                // If left part is sorted
                if (nums[low] <= nums[mid]) {

                    // If target lies within sorted left part
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1;
                    }
                    // Else, search in right half
                    else {
                        low = mid + 1;
                    }
                }

                // Else, right part is sorted
                else {

                    // If target lies within sorted right part
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    }
                    // Else, search in left half
                    else {
                        high = mid - 1;
                    }
                }
            }

            // Target not found
            return -1;
        }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        find_target_inRotatedSortedArray obj = new find_target_inRotatedSortedArray();
        int result = obj.search(nums, target);

        System.out.println(result);
    }
}