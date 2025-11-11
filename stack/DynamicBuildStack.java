package stack;

public class DynamicBuildStack {
    int []data;
    int tos;

    public DynamicBuildStack(int cap){
        data=new int[cap];
        tos=-1;
    }

    int size(){
        return tos+1;
    }
    void display(){
        for(int i=tos;i>=0;i--){
            System.out.print(data[i]+" ");
        }
    }
    void push(int val){
        if(tos==data.length-1){
            int[] ndata = new int[2 * data.length];
            System.arraycopy(data, 0, ndata, 0, data.length);
            data = ndata;
            tos++;
            data[tos]=val;
        }else{
            tos++;
            data[tos]=val;
        }
    }
    int pop(){
        if(tos==-1){
            System.out.println("Stack underflow");
            return -1;
        }else{
            int val=data[tos];
            tos--;
            return val;
        }

    }
    int top(){
        if(tos==-1){
            System.out.println("Stack oVerflow");
            return -1;
        }else{
            return data[tos];
        }
    }
}

