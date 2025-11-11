package linkedlist;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class linkedlist {
    Node head = null; 
    Node tail = null;  
    int size = 0;      

    void addLast(int val) {
        if (size == 0) {
            head = new Node(val, null);
            tail = head;
        } else {
            Node newNode = new Node(val, null);
            tail.next = newNode;
            tail = newNode; 
        }
        size++;  
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    int size() {  
        return size;
    }
    
    int removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else if (size == 1) {
            int data=head.data;
            tail = head = null;
            size = 0;
            return data;
        } else {
            int data=head.data;
            head = head.next;
            size--;
            return data;
        }
    }
    
    int getFirst() {
        if (size == 0) {
            return -1;
        }
        return head.data;
    }
    
    int getLast() {
        if (size == 0) {
            return -1;
        }
        return tail.data;
    }
    
    int getAt(int index) {
        if (index < 0 || index >= size) {  
            return -1;
        }
        Node temp = head; 
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.data;  
    }
    
    void addFirst(int value) {
        Node n = new Node(value, null);
        if (size == 0) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
        size++;
    }
    
    void addAt(int index,int value){
        if(index<0 || index>size) return;
        if(index==0){
            addFirst(value);
        }else if(size==index){
            addLast(value);
        }else{
            Node n=head;
            for(int i=1;i<index;i++){
                n=n.next;
            }
            Node temp=new Node(value,null);
            temp.next=n.next;
            n.next=temp;
            size++;
        }
    }
    
    void removeLast(){
        if(size==0){
            return;
        }else if(size==1){
            head=tail=null;
            size--;
        }else{
            Node n=head;
            for(;n.next!=tail;n=n.next){}
            tail=null;
            tail=n;
            size--;
        }
    }

    void reverseDataIterative() {
        if (size <= 1) {
            return; 
        }
        
        Node left = head;
        Node right = tail;
        int steps = size / 2;

        for (int i = 0; i < steps; i++) {
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            
            left = left.next;
            
            Node current = head;
            for (int j = 0; j < size - i - 2; j++) { 
                current = current.next;
            }
            right = current;
        }
    }
    
    void reversePointerIterative(){
        if(size<=1){
            return;
        }
        Node past=null;
        Node current=head;
        Node future=head;
        tail=head;
        while(current!=null){
            future=future.next;
            current.next=past;
            past=current;
            current=future;
        }
        head=past;
    }
    
    void removeAt(int index){
        if(index>=size || index<0){
        }else if(index==0){
            removeFirst();
        }else if(index==size-1){
            removeLast();
        }else{
            Node temp=head;
            int i=0;
            while(i<index-1){
                temp=temp.next;
                i++;
            }
            temp.next=temp.next.next;
            size--;
        }
    }

    Node KthFromEnd(int k){
        if(size==0 || k>size || k<=0){
            return null;
        }
        Node slow=head;
        Node fast=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    Node middleNode(){
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

    Node KthReverse(int k) {
    if (head == null || k <= 1) return head;

    linkedlist prev = null;
    linkedlist curr = new linkedlist();
    int l = size;

    for (int i = 0; i < l; i++) {
        curr.addFirst(head.data);  // add first
        removeFirst();

        if ((i+1) % k == 0) { // flush only after group is complete
            if (prev != null) {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
            } else {
                prev = curr;
            }
            curr = new linkedlist();
        }
    }

    // leftover nodes
    if (curr.size() != 0 && prev != null) {
        prev.tail.next = curr.head;
        prev.tail = curr.tail;
        return prev.head;
    } else {
        return (prev != null) ? prev.head : curr.head;
    }
}
   
    private void displayReverseHelper(Node head){
        if(head==null){
            return;
        }
        displayReverseHelper(head.next);
        System.out.println(head.data+" ");
    }
    
    void displayReverse(){
        displayReverseHelper(head);
    }

    Node reverseLLRecursionHelper(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLLRecursionHelper(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    void reverseLLRecursion(){
        head=reverseLLRecursionHelper(head);
    }

    public static void main(String[] args) {
        linkedlist linkedList = new linkedlist();
        linkedList.addLast(1); 
        linkedList.addLast(2);
        linkedList.printList();
        System.out.println(linkedList.size());
        linkedList.removeFirst();
        System.out.println(linkedList.getAt(0));
    }
}