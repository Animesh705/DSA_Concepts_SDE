//Problem Statement: Given two integer arrays nums1 and nums2 and an integer k, return the maximum k valid sum combinations from all possible sum combinations using the elements of nums1 and nums2. A valid sum combination is made by adding one element from nums1 and one element from nums2. Return the answer in non-increasing order.
//
//Examples
// Input : nums1 = [7, 3], nums2 = [1, 6], k = 2
// Output : [13, 9]
// Explanation : The 2 maximum combinations are made by: nums1[0] + nums2[1] = 13 nums1[1] + nums2[1] = 9
//
// Input : nums1 = [3, 4, 5], nums2 = [2, 6, 3], k = 2
//Output : [11, 10]
//Explanation : The 2 maximum combinations are made by: nums1[2] + nums2[1] = 11 nums1[1] + nums2[1] = 10
package Heaps;
import java.util.*;
public class k_max_sum {
    // Function to find k maximum sum combinations
    public List<Integer> maxCombinations(int[] nums1, int[] nums2, int k) {
        // Sort both arrays in descending order
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;

        // Max heap to store sums and their indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Set to keep track of visited index pairs
        Set<String> visited = new HashSet<>();

        // Push initial max sum combination
        maxHeap.offer(new int[]{nums1[n - 1] + nums2[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        // Result list
        List<Integer> result = new ArrayList<>();

        // Extract top k combinations
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0], i = current[1], j = current[2];

            result.add(sum);

            // Check for new combination (i - 1, j)
            if (i - 1 >= 0) {
                String key1 = (i - 1) + "," + j;
                if (!visited.contains(key1)) {
                    maxHeap.offer(new int[]{nums1[i - 1] + nums2[j], i - 1, j});
                    visited.add(key1);
                }
            }

            // Check for new combination (i, j - 1)
            if (j - 1 >= 0) {
                String key2 = i + "," + (j - 1);
                if (!visited.contains(key2)) {
                    maxHeap.offer(new int[]{nums1[i] + nums2[j - 1], i, j - 1});
                    visited.add(key2);
                }
            }
        }

        return result;
    }
        public static void main(String[] args) {
            k_max_sum obj = new k_max_sum();
            int[] nums1 = {7, 3};
            int[] nums2 = {1, 6};
            int k = 2;
            System.out.println(obj.maxCombinations(nums1, nums2, k)); // Output: [13, 9]
        }
    }
