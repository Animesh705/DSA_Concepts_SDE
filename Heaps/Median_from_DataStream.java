package Heaps;
import java.util.*;
public class Median_from_DataStream {
        // Max-heap for smaller half
        private PriorityQueue<Integer> maxHeap;
        // Min-heap for larger half
        private PriorityQueue<Integer> minHeap;

        // Constructor
        public Median_from_DataStream() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        // Function to add a number to the data structure
        public void addNum(int num) {
            // Step 1: Add to maxHeap
            maxHeap.offer(num);

            // Step 2: Move the largest of maxHeap to minHeap
            minHeap.offer(maxHeap.poll());

            // Step 3: Balance the heaps if needed
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // Function to return the current median
        public double findMedian() {
            // If equal sizes, return average
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            // Otherwise, return top of maxHeap
            return maxHeap.peek();
        }
        public static void main(String[] args) {
            Median_from_DataStream mf = new Median_from_DataStream();
            mf.addNum(1);
            mf.addNum(2);
            System.out.println(mf.findMedian()); // 1.5
            mf.addNum(3);
            System.out.println(mf.findMedian()); // 2
        }
    }
