package Heap;

import java.util.*;

public class KLargestElements {

    public static List<Integer> findKLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        List<Integer> result = new ArrayList<>(minHeap);
        result.sort(Collections.reverseOrder()); // optional: largest first
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        List<Integer> kLargest = findKLargest(arr, k);
        System.out.println(k + " largest elements: " + kLargest);
    }
}
