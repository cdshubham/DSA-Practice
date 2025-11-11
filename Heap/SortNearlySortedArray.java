package Heap;

import java.util.*;

public class SortNearlySortedArray {

    public static void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;
        int index = 0;

        // Add first k+1 elements to the heap
        for (int i = 0; i <= Math.min(k, n - 1); i++) {
            minHeap.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        // Extract remaining elements from heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3; // each element is at most k positions away from its target

        sortKSortedArray(arr, k);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
