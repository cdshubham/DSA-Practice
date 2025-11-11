package Heap;

import java.util.ArrayList;

public class PriorityQueueUsingHeap {
    private ArrayList<Integer> heap;

    public PriorityQueueUsingHeap() {
        heap = new ArrayList<>();
    }

    // Return the size of the priority queue
    public int size() {
        return heap.size();
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Add an element to the priority queue
    public void add(int val) {
        heap.add(val);
        upHeapify(heap.size() - 1);
    }

    // Remove and return the minimum element
    public int remove() throws Exception {
        if (isEmpty()) throw new Exception("Priority Queue is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            downHeapify(0);
        }
        return min;
    }

    // Return the minimum element without removing
    public int peek() throws Exception {
        if (isEmpty()) throw new Exception("Priority Queue is empty");
        return heap.get(0);
    }

    // Maintain heap property after insertion
    private void upHeapify(int idx) {
        int parent = (idx - 1) / 2;
        if (idx > 0 && heap.get(idx) < heap.get(parent)) {
            swap(idx, parent);
            upHeapify(parent);
        }
    }

    // Maintain heap property after removal
    private void downHeapify(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int smallest = idx;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;

        if (smallest != idx) {
            swap(idx, smallest);
            downHeapify(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Driver code
    public static void main(String[] args) throws Exception {
        PriorityQueueUsingHeap pq = new PriorityQueueUsingHeap();
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(3);

        System.out.println("Size: " + pq.size());
        System.out.println("Min element: " + pq.peek());

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }
}
