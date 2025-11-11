package String;

import java.util.*;

public class toggleCase {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuffer res=new StringBuffer(str);
        for (int i = 0; i < res.length(); i++) {
            Character c=res.charAt(i);
            if(Character.isLowerCase(c)){
                res.setCharAt(i, Character.toUpperCase(c));
            }
            if(Character.isUpperCase(c)){
                res.setCharAt(i, Character.toLowerCase(c));
            }
        }
        System.out.println(res);
    }
}
