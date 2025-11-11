package function;

import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int b=sc.nextInt();
        int newNo=addition(n1,n2,b);
        System.out.print(newNo);
    }
    static int addition(int n1,int n2,int b){
        int r1,r2,newNo=0,p=1,carry=0;
        while(n1!=0 || n2!=0 || carry!=0){
            r1=n1%10;
            r2=n2%10;
            newNo=newNo+((r1+r2)%b+carry)*p;
            carry=(r1+r2)/b;
            p*=10;
            n1/=10;
            n2/=10;
        }
        return newNo;
    }
}
