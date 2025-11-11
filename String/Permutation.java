package String;

import java.util.*;

public class Permutation {
    static int factorial(int n){
        int f=1;
        while(n>1){
            f*=n;
            n--;
        }
        return f;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=str.length();
        int f=factorial(n);
        for(int i=0;i<f;i++){
            StringBuilder sb=new StringBuilder(str);
            int temp=i;
            for(int div=n;div>=1;div--){
                int q=temp/div;
                int r=temp%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp=r;
            }
            System.out.println();
        }
    }
}
