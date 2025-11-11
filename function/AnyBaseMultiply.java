package function;

import java.util.Scanner;

public class AnyBaseMultiply {
    public static void main(String[] args) {
        int n1,n2,b;
        Scanner sc=new Scanner(System.in);
        n1=sc.nextInt();
        n2=sc.nextInt();
        b=sc.nextInt();
        int newNo=multiply(n1,n2,b);
        System.out.print(newNo);
    }
    static int multiply(int n1,int n2,int b){
        int p=1;
        int res,newNo=0;
        while(n2!=0){
            res=multiplySingle(n1,n2%10,b);
            n2/=10;
            newNo=addition(newNo,res*p,b);
            System.out.println(newNo);

            p*=10;
        }
        return newNo;
    }
    static int multiplySingle(int n,int d,int b){
        int newNo=0,p=1,carry=0;
        while(n!=0){
            newNo=newNo+((n%10)*d%b+carry)*p;
            carry=(n%10)*d/b;
            p*=10;
            n/=10;
        }
        return newNo;
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
