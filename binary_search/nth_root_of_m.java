package binary_search;
import java.util.*;

public class nth_root_of_m {

    public int nthRoot(int n, int m) {

        int low = 1, high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= mid;
                if (ans > m) break; // overflow / extra computation avoided
            }

            if (ans == m) return mid;
            else if (ans < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        nth_root_of_m obj = new nth_root_of_m();

        System.out.println(obj.nthRoot(3, 27));  // 3
        System.out.println(obj.nthRoot(2, 16));  // 4
        System.out.println(obj.nthRoot(4, 15));  // -1
    }
}