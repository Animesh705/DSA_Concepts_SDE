package Heaps;
import java.util.*;
public class top_k_frequentElement {
    static ArrayList<Integer> topKFreq(int[] arr, int k)
    {
        // HashMap banaya to store:
        // key   -> element
        // value -> us element ki frequency
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Array ke har element ke liye frequency count kar rahe hain
        for (int val : arr)
            mp.put(val, mp.getOrDefault(val, 0) + 1);

        /*
         Min-heap banaya hai jo int[] store karega:
         { frequency, element }

         Comparator ka matlab:
         - Pehle frequency compare hogi (a[0])
         - Chhoti frequency upar rahegi (min heap)
         - Agar frequency same ho, to element ke basis pe compare
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>
                ((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // HashMap ke har entry pe iterate kar rahe hain
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

            // Heap me daal rahe hain:
            // entry.getValue() -> frequency
            // entry.getKey()   -> element
            pq.add(new int[] { entry.getValue(), entry.getKey() });

            // Agar heap ka size k se zyada ho gaya
            // to sabse kam frequency wala element hata do
            if (pq.size() > k)
                pq.poll();
        }

        /*
         Ab heap me sirf k elements bache hain
         jo k most frequent elements hain
        */
        ArrayList<Integer> res = new ArrayList<>();

        // Heap se elements nikaal rahe hain
        // poll()[1] => element (frequency nahi chahiye)
        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }

        // Result return kar rahe hain
        return res;
    }

    public static void main(String[] args)
    {
        // Input array
        int[] arr = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int k = 2;

        // Function call
        ArrayList<Integer> res = topKFreq(arr, k);

        // Reverse isliye kiya kyunki heap se
        // elements increasing frequency me nikle the
        Collections.reverse(res);

        // Final output print
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}

