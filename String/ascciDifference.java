package String;

import java.util.*;

public class ascciDifference {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuffer res=new StringBuffer();
        for(int i=0;i<str.length()-1;i++){
            char c1=str.charAt(i);
            char c2=str.charAt(i+1);
            res.append(c1);
            res.append(c2-c1);
        }
        res.append(str.charAt(str.length()-1));
        System.out.println(res);
    }
}
