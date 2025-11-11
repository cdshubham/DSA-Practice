package function;

import java.util.Scanner;

public class AnyBaseSubstration {
    public static void main(String[] args) {
        int n1,n2;
        int b;
        Scanner sc=new Scanner(System.in);
        n1=sc.nextInt();
        n2=sc.nextInt();
        b=sc.nextInt();
        int newNo=substract(n1,n2,b);
        System.out.print(newNo);
    }
    static int substract(int n1,int n2,int b){
        int newNo=0;
        int r1,r2,p=1,carry=0,neg=1;
        if(n1<n2){
            int temp=n1;
            n1=n2;
            n2=temp;
            neg=-1;
        }
        while(n1!=0){
            r1=n1%10;
            r2=n2%10;
            if(r1<r2){
                newNo=newNo+p*(r1-r2+b-carry);
                carry=1;
            }else{
                newNo=newNo+p*(r1-r2-carry);
                carry=0;
            }
            n1/=10;
            n2/=10;
            p*=10;
        }
        return newNo*neg;
    }
}
