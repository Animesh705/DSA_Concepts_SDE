import java.util.*;

class median_ofTwoSortedArray {

    // Function to find the median
    public static double median(int[] a, int[] b) {

        // Get sizes of both arrays
        int n1 = a.length, n2 = b.length;

        // Total size
        int n = n1 + n2;

        // Median indices
        int ind2 = n / 2;
        int ind1 = ind2 - 1;

        // Initialize pointers and values
        int cnt = 0, i = 0, j = 0;
        int ind1el = -1, ind2el = -1;

        // Merge step to find median
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                j++;
            }
            cnt++;
        }

        // Remaining elements in a
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }

        // Remaining elements in b
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        // Return median
        if (n % 2 == 1) return (double) ind2el;
        return (ind1el + ind2el) / 2.0;
    }

    public static void main(String[] args) {

        // Input arrays
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};

        // Output the result
        System.out.printf("The median is %.1f\n", median_ofTwoSortedArray.median(a, b));
    }
}
