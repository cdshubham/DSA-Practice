package linkedlist;

public class MergeTwoSortedLL {
    static Node merge(Node h1,Node h2){
        Node fTail=null;
        Node fHead=null;
        if(h1==null || h2==null)    return null;
        while(h1!=null && h2!=null){
            if(h1.data>h2.data){
                if(fHead==null){
                    fHead=fTail=h1;
                }else{
                    fTail.next=h1;
                    fTail=fTail.next;
                }
                h1=h1.next;

            }else{
                if(fHead==null){
                    fHead=fTail=h2;
                }else{
                    fTail.next=h2;
                    fTail=fTail.next;
                }
                h2=h2.next;
            }
        }

        while (h1 != null) {
            if (fHead == null) {
                fHead = fTail = h1;
            } else {
                fTail.next = h1;
                fTail = fTail.next;
            }
            h1 = h1.next;
        }

        while (h2 != null) {
            if (fHead == null) {
                fHead = fTail = h2;
            } else {
                fTail.next = h2;
                fTail = fTail.next;
            }
            h2 = h2.next;
        }
        return fHead;
    }
}
