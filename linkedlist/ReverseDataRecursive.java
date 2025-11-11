package linkedlist;

public class ReverseDataRecursive {
    Node head;
    Node left;
    Node tail;  
    int size;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    private void reverseDataRecursiveHelper(Node right, int floor, int size) {
        if (right == null) return;

        reverseDataRecursiveHelper(right.next, floor + 1, size);

        if (floor >= size / 2) {
            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            left = left.next; 
        }
    }

    void reverseDataRecursive() {
        left = head; 
        reverseDataRecursiveHelper(head, 0, size);
    }

    boolean pallindromeHelper(Node head,int len){
        if(head==null)  return true;
        boolean b=pallindromeHelper(head.next, len+1);
        if(len>=size/2){
            boolean f = b && left.data==head.data;
            left=left.next;
            return f;
        }
        return b; 
    }

    void pallindrome(){
        boolean isPallindrome=pallindromeHelper(head,0);
        System.out.println(isPallindrome);
    }

    void foldLLHelper(Node right, int len) {
        if (right == null) return;

        foldLLHelper(right.next, len + 1);

        if (len > size / 2) {
            Node temp = left;
            left = left.next;
            temp.next = right;
            right.next = left;
        } 
        else if (len == size / 2) {
            tail=right;
            right.next = null;
        }
    }

    void foldLL() {
        left = head;   // reset before recursion
        foldLLHelper(head, 0);
    }

    static int addTwoLinkedlistHelper(Node one, int l1, Node two, int l2, linkedlist res) {
        if (one == null && two == null) return 0;

        int sum, carry;

        if (l1 > l2) {
            carry = addTwoLinkedlistHelper(one.next, l1 - 1, two, l2, res);
            sum = one.data + carry;
        } else if (l1 < l2) {
            carry = addTwoLinkedlistHelper(one, l1, two.next, l2 - 1, res);
            sum = two.data + carry;
        } else {
            carry = addTwoLinkedlistHelper(one.next, l1 - 1, two.next, l2 - 1, res);
            sum = one.data + two.data + carry;
        }

        int nodeData = sum % 10;
        int newCarry = sum / 10;

        res.addFirst(nodeData);

        return newCarry;
    }

    static linkedlist addTwoLinkedlist(linkedlist one, linkedlist two) {
        linkedlist res = new linkedlist();
        int carry = addTwoLinkedlistHelper(one.head, one.size, two.head, two.size, res);

        if (carry != 0) {
            res.addFirst(carry);
        }

        return res;
    }

    void intersectionPoint(linkedlist one, linkedlist two){
        Node t1=one.head;
        Node t2=two.head;

        int diff=Math.abs(one.size-two.size);
        if(one.size>two.size){
            for(int i=0;i<diff;i++) t1=t1.next;
        }else{
            for(int i=0;i<diff;i++) t2=t2.next;
        }
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t1.data;
    } 

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

