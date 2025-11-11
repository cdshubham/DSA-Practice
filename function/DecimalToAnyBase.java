package function;

import java.util.Scanner;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int b=sc.nextInt();
        int newNo=BaseChange(n,b);
        System.out.print(newNo);
    }

    static int BaseChange(int n,int b){
        int p=1,newNo=0;
        while(n!=0){
            newNo+=(n%b)*p;
            n/=b;
            p=p*10;
        }
        return newNo;
    }
}
