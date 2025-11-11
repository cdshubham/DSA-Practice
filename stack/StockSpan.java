package stack;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int []arr=new int[n];
        int []span=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Stack<Integer> st=new Stack<>();
        st.push(0);
        span[0]=1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-st.peek();
            }
            st.push(i);
        }
        for(int i: span){
            System.out.print(i+" ");
        }
    }
}
