package Heaps;
import java.util.*;
public class merge_sorted_arrays {
    // Function to merge K sorted arrays
    static ArrayList<Integer> mergeArrays(int[][] mat){

        // Number of arrays (K)
        int k = mat.length;

        // Output list to store final merged sorted elements
        ArrayList<Integer> output = new ArrayList<>();

        /*
         Min Heap that stores:
         [ value, arrayIndex, elementIndex ]

         value        -> actual number
         arrayIndex   -> which array this number came from
         elementIndex -> index inside that array

         Heap is ordered by 'value' (smallest at top)
        */
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Step 1: Insert the FIRST element of each array into the heap
        for (int i = 0; i < k; i++) {

            // Check array is not empty
            if (mat[i].length > 0) {

                // Push: value = mat[i][0]
                // i = array index
                // 0 = element index
                minHeap.add(new int[]{mat[i][0], i, 0});
            }
        }

        // Step 2: Keep extracting the smallest element
        while (!minHeap.isEmpty()) {

            // Remove smallest element from heap
            int[] top = minHeap.poll();

            int val = top[0]; // actual value
            int i = top[1];   // which array
            int j = top[2];   // index in that array

            // Add smallest value to output list
            output.add(val);

            // Step 3: Push the NEXT element from the SAME array
            if (j + 1 < mat[i].length) {

                // Insert next element of array i
                minHeap.add(new int[]{
                        mat[i][j + 1], // next value
                        i,             // same array
                        j + 1           // next index
                });
            }
        }

        // Final merged sorted array
        return output;
    }

    public static void main(String[] args){

        // Example input: 3 sorted arrays
        int[][] mat = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        // Merge arrays
        ArrayList<Integer> result = mergeArrays(mat);

        // Print result
        for (int x : result){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}