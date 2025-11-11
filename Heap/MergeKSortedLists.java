package Heap;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeKSortedLists {
    
    // Merge K sorted lists using PriorityQueue
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        
        // Add head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            
            if (minNode.next != null) pq.add(minNode.next);
        }
        
        return dummy.next;
    }

    // Utility to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 3 sorted lists
        ListNode l1 = new ListNode(1); l1.next = new ListNode(4); l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1); l2.next = new ListNode(3); l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2); l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode merged = mergeKLists(lists);
        System.out.print("Merged list: ");
        printList(merged);
    }
}
