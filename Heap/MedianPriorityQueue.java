package Heap;

import java.util.*;

public class MedianPriorityQueue {
    private PriorityQueue<Integer> left;  // Max-Heap
    private PriorityQueue<Integer> right; // Min-Heap

    public MedianPriorityQueue() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    // Add a number
    public void add(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }
        balanceHeaps();
    }

    // Balance heaps so that left.size() >= right.size()
    private void balanceHeaps() {
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    // Get median
    public double getMedian() {
        if (left.isEmpty()) throw new NoSuchElementException("Median queue is empty");
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    // Remove median
    public int removeMedian() {
        if (left.isEmpty()) throw new NoSuchElementException("Median queue is empty");
        int median = left.poll();
        balanceHeaps();
        return median;
    }

    public int size() {
        return left.size() + right.size();
    }

    public static void main(String[] args) {
        MedianPriorityQueue mpq = new MedianPriorityQueue();
        int[] arr = {5, 15, 1, 3};

        for (int num : arr) {
            mpq.add(num);
            System.out.println("Current Median: " + mpq.getMedian());
        }

        System.out.println("Removed Median: " + mpq.removeMedian());
        System.out.println("New Median: " + mpq.getMedian());
    }
}
