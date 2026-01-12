package Heaps;
import java.util.*;
public class min_heap_implementation {
        ArrayList<Integer> heap = new ArrayList<>();
    void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) > heap.get(i)) {
                swap(parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }
    int remove() {
        if (heap.size() == 0) return -1;

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    void heapifyDown(int i) {
        int size = heap.size();

        while (true) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest))
                smallest = left;

            if (right < size && heap.get(right) < heap.get(smallest))
                smallest = right;

            if (smallest == i) break;

            swap(i, smallest);
            i = smallest;
        }
    }
    void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public void printHeap() {
        System.out.println(heap);
    }
    public static void main(String[] args) {

        min_heap_implementation heap = new min_heap_implementation();

        heap.insert(10);
        heap.insert(30);
        heap.insert(20);
        heap.insert(5);
        heap.insert(40);

        System.out.println("Heap after insertions:");
        heap.printHeap();

        System.out.println("Removed max: " + heap.remove());
        System.out.println("Heap after deletion:");
        heap.printHeap();
    }
}

//for max. heap :
// Parent >= children
//
//Replace:
//	•	< with >
//	•	smallest with largest
//
//That’s it.

