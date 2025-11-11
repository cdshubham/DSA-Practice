package stack;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Stack<Character>st=new Stack<>();
        
        for (Character ch : str.toCharArray()) {
            if(ch==')'){
                if(st.peek()=='('){
                    System.out.print(true); 
                    return;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }   System.out.print(false);
    }
}
