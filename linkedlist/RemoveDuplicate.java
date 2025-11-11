package linkedlist;

public class RemoveDuplicate {
    linkedlist ll=new linkedlist();
    Node removeDuplicate(){
        if(ll.head==null || ll.head.next==null)    return ll.head;
        Node fTail=ll.head;
        while(fTail!=null && fTail.next!=null){
            if(fTail.data!=fTail.next.data){
                fTail=fTail.next;
            }else{
                fTail.next=fTail.next.next;
            }
        }
        return ll.head;
    }
}
