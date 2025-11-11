package linkedlist;

class LLQueueAdapter{
    linkedlist ll=new linkedlist();
    int size(){
        return ll.size();
    }
    void add(int val){
        ll.addLast(val);
    }
    int remove(){
        if(ll.size()==0){
            return -1;
        }
        return ll.removeFirst();
    }
    int peek(){
        if(ll.size()==0){
            return -1;
        }
        return ll.getFirst();
    }
}