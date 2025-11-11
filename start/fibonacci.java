package start;

import java.util.*;

public class fibonacci {
    public static void main(String args[]){
        int num,a=-1,b=1,c;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        for(int i=0;i<num;i++){
            c=a+b;
            System.out.print(c+ " ");
            a=b;
            b=c;
        }
    }
}
