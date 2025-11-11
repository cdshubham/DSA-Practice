package linkedlist;

public class MergeSortLL {
    Node mergeSort(Node l1){
        if(l1==null || l1.next!=null)    return l1;
        Node temp=middleNode(l1);
        Node h1=mergeSort(temp);
        Node h2=mergeSort(temp.next);
        return MergeTwoSortedLL.merge(h1, h2);
    }

    Node middleNode(Node head){
        if (head == null) {
            return null;
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
