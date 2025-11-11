package stack;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    // public static void main(String[] args) {
        // int n;
        // Scanner sc=new Scanner(System.in);
        // n=sc.nextInt();
        // Stack<Integer> st=new Stack<>();
        // int arr[]=new int[n];
        // int nge[]=new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i]=sc.nextInt();
        // }
    //     st.push(arr[n-1]);
    //     nge[n-1]=-1;
    //     for(int i=n-2;i>=0;i--){
    //         while(!st.isEmpty() && arr[i]>=st.peek()){
    //             st.pop();
    //         }
    //         if(st.isEmpty()){
    //             nge[i]=-1;
    //         }else{
    //             nge[i]=st.peek();
    //         }
    //         st.push(arr[i]);
    //     }
    //     for(int i: nge){
    //         System.out.print(i+" ");
    //     }
    // }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        Stack<Integer> st=new Stack<>();
        int arr[]=new int[n];
        int nge[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                int pos=st.peek();
                nge[pos]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int pos=st.peek();
            nge[pos]=-1;
            st.pop();
        }
        for(int i: nge){
            System.out.print(i+" ");
        }
    }
}
