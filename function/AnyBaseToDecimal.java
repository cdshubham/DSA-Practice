package function;

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int b=sc.nextInt();
        int newNo=change(n,b);
        System.out.print(newNo);
    }
    static int change(int n,int b){
        int p=1,newNo=0;
        while(n!=0){
            newNo+=(n%10)*p;
            n/=10;
            p=p*b;
        }
        return newNo;
    }
}
