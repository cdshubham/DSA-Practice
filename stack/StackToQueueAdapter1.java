package stack;

import java.util.*;

//Pop Eficient
public class StackToQueueAdapter1 {
    Stack<Integer> mainS;
    Stack<Integer> helperS;
    StackToQueueAdapter1(){
        mainS=new Stack<>();
        helperS=new Stack<>();
    }
    int size(){
        return mainS.size();
    }
    void add(int val){
        while(mainS.isEmpty()){
            helperS.push(mainS.pop());
        }
        mainS.push(val);

        while(helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
    }
    int remove(){
        if(mainS.isEmpty()){
            return -1;
        }else{
            return mainS.pop();
        }
    }
    int peek(){
        if(mainS.isEmpty()){
            return -1;
        }else{
            return mainS.peek();
        }
    }
}


class StackToQueueAdapter2 {
    Stack<Integer> mainS;
    Stack<Integer> helperS;
    StackToQueueAdapter2(){
        mainS=new Stack<>();
        helperS=new Stack<>();
    }
    int size(){
        return mainS.size();
    }
    void add(int val){
        mainS.push(val);
    }
    int remove(){
        if(mainS.isEmpty()){
            return -1;
        }else{
            while(mainS.size()>1){
                helperS.add(mainS.pop());
            }
            int val=mainS.pop();

            while(helperS.isEmpty()){
                mainS.push(helperS.pop());
            }
            return val;
        }
    }
    int peek(){
        if(mainS.isEmpty()){
            return -1;
        }else{
            while(mainS.size()>1){
                helperS.add(mainS.pop());
            }
            int val=mainS.pop();
            helperS.push(val);
            while(helperS.isEmpty()){
                mainS.push(helperS.pop());
            }
            return val;
        }
    }
}
