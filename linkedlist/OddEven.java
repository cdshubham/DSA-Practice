package linkedlist;

public class OddEven {
    linkedlist ll=new linkedlist();
    Node oddeven(){
        if(ll.head==null || ll.head.next==null)    return null;
        linkedlist even=new linkedlist();
        linkedlist odd=new linkedlist();
        Node temp=ll.head;
        while(temp!=null){
            if(temp.data%2==0){
                even.addLast(temp.data);
            }else{
                odd.addLast(temp.data);
            }
            temp=temp.next;
        }
        if(odd.size!=0 && even.size!=0){
            odd.tail.next=even.head;
            odd.tail=even.tail;
            return odd.head;
        }else if(odd.size!=0){
            return odd.head;
        }else{
            return even.head;
        }
    }

    Node oddeven2() {
        if (ll.head == null || ll.head.next == null) return ll.head;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;
        Node temp = ll.head;

        while (temp != null) {
            if (temp.data % 2 == 0) { 
                if (evenHead == null) {
                    evenHead = evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }
            } else { 
                if (oddHead == null) {
                    oddHead = oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            }
            temp = temp.next;
        }

        if (oddHead == null) return evenHead;
        if (evenHead == null) return oddHead;

        oddTail.next = evenHead;
        evenTail.next = null; // important: avoid cycle

        return oddHead;
    }
}
