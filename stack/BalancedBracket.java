package stack;

import java.util.Scanner;
import java.util.Stack;


public class BalancedBracket{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Stack<Character> st=new Stack<>();
        for(Character ch : str.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch==')'){
                boolean val=handleClosing(st, '(');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch=='}'){
                boolean val=handleClosing(st, '{');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch==']'){
                boolean val=handleClosing(st, '[');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }
        }
        if(st.isEmpty()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    public static boolean handleClosing(Stack<Character>st ,char corresoch){
        if(st.isEmpty()){
            return false;
        }else if(st.peek()!=corresoch){
            return false;
        }else{
            st.pop();
            return true;
        }
    }
}