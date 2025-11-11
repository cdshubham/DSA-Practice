package linkedlist;

public class LLStackAdapter {
    linkedlist ll=new linkedlist();
    int size(){
        return ll.size();
    }
    void push(int val){
        ll.addFirst(val);
    }
    int pop(){
        if(ll.size()==0){
            return -1;
        }
        return ll.removeFirst();
    }
    int top(){
        if(ll.size()==0){
            return -1;
        }
        return ll.getFirst();
    }
}
