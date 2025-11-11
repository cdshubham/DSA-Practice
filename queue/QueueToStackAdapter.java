package queue;

import java.util.*;

//pop efficient
class QueueToStackAdapter1{
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter1() {
        mainQ=new ArrayDeque<>();
        helperQ=new ArrayDeque<>();
    }

    int size(){
        return mainQ.size();
    }
    
    void push(int val){
        while(!mainQ.isEmpty()){
            helperQ.add(mainQ.remove());
        }
        mainQ.add(val);
        while(!helperQ.isEmpty()){
            mainQ.add(helperQ.remove());
        }
    }

    int pop(){
        if(size()==0){
            System.out.println("Stack overflow");
            return -1;
        }else{
            return mainQ.remove();
        }
    }
    
    int top(){
        if(size()==0){
            System.out.println("Stack overflow");
            return -1;
        }else{
            return mainQ.peek();
        }
    }
    
}


class QueueToStackAdapter2{
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter2() {
        mainQ=new ArrayDeque<>();
        helperQ=new ArrayDeque<>();
    }

    int size(){
        return mainQ.size();
    }
    
    void push(int val){
        mainQ.add(val);
    }

    int pop(){
        if(size()==0){
            System.out.println("Stack overflow");
            return -1;
        }else{
            while(mainQ.size() > 1){
                helperQ.add(mainQ.remove());
            }
            int val=mainQ.remove();

            while(!helperQ.isEmpty()){
                mainQ.add(helperQ.remove());
            }
            return val;
        }
    }
    
    int top(){
        if(size()==0){
            System.out.println("Stack overflow");
            return -1;
        }else{
            while(mainQ.size() > 1){
                helperQ.add(mainQ.remove());
            }
            int val=mainQ.remove();
            helperQ.add(val);

            while(!helperQ.isEmpty()){
                mainQ.add(helperQ.remove());
            }
            return val;
        }
    }
}