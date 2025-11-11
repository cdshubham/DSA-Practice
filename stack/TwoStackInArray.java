package stack;

public class TwoStackInArray {
    int[] data;
    int tos1;
    int tos2;

    public TwoStackInArray(int cap) {
        data=new int[cap];
        tos1=-1;
        tos2=cap;
    }
    int size1(){
        return tos1+1;
    }
    int size2(){
        return data.length - tos2;
    }
    void push1(int val){
        if(tos2==tos1+1){
            System.out.println("Stack Overflow");
        }else{
            tos1++;
            data[tos1]=val;
        }
    }
    void push2(int val){
        if(tos2==tos1+1){
            System.out.println("Stack Overflow");
        }else{
            tos2--;
            data[tos2]=val;
        }
    }
    int pop1(){
        if(size1()>0){
            int val=data[tos1];
            tos--;
            return val;
        }else{
            return -1;
        }
    }
    int pop2(){
        if(size2()>0){
            int val=data[tos2];
            tos2++;
            return val;
        }else{
            return -1;
        }
    }
    int top1(){
        if(size1()>0){
            int val=data[tos1];
            return val;
        }else{
            return -1;
        }
    }
    int top2(){
        if(size2()>0){
            int val=data[tos2];
            return val;
        }else{
            return -1;
        }
    }
    
}
