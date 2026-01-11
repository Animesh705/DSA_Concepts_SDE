package Heaps;
import java.util.*;
public class kth_largestSmallest_inArray {
        // Function to get the Kth largest element
        public int kthLargestElement(int[] nums, int k) {
            // Return -1, if the Kth largest element does not exist
            if (k > nums.length) return -1;

            // Pointers to mark the part of working array
            int left = 0, right = nums.length - 1;

            // Until the Kth largest element is found
            while (true) {
                // Get the pivot index
                int pivotIndex = randomIndex(left, right);

                // Update the pivotIndex
                pivotIndex = partitionAndReturnIndex(nums, pivotIndex, left, right);

                // If Kth largest element is found, return
                if (pivotIndex == k - 1) return nums[pivotIndex];

                    // Else adjust the end pointers in array
                else if (pivotIndex > k - 1) right = pivotIndex - 1;
                else left = pivotIndex + 1;
            }
        }

        private Random rand = new Random();

        // Function to get a random index
        private int randomIndex(int left, int right) {
            // Length of the array
            int len = right - left + 1;

            // Return a random index from the array
            return rand.nextInt(len) + left;
        }

        // Function to perform the partition and return the updated index of pivot
        private int partitionAndReturnIndex(int[] nums, int pivotIndex, int left, int right) {
            int pivot = nums[pivotIndex]; // Get the pivot element

            // Swap the pivot with the left element
            int temp = nums[left];
            nums[left] = nums[pivotIndex];
            nums[pivotIndex] = temp;

            int ind = left + 1; // Index to mark the start of right portion

            // Traverse on the array
            for (int i = left + 1; i <= right; i++) {

                // If the current element is greater than the pivot
                if (nums[i] > pivot) {
                    // Place the current element in the left portion
                    temp = nums[ind];
                    nums[ind] = nums[i];
                    nums[i] = temp;

                    // Move the right portion index
                    ind++;
                }
            }

            // Place the pivot at the correct index
            temp = nums[left];
            nums[left] = nums[ind - 1];
            nums[ind - 1] = temp;

            return ind - 1; // Return the index of pivot now
        }
        public static void main(String[] args) {
            int[] nums = {-5, 4, 1, 2, -3};
            int k = 5;

            // Creating an object of the kth_largestSmallest_inArray class
            kth_largestSmallest_inArray sol = new kth_largestSmallest_inArray();

            // Function call to get the Kth largest element
            int ans = sol.kthLargestElement(nums, k);

            // Output array
            System.out.println("The Kth largest element in the array is: " + ans);
        }
    }
