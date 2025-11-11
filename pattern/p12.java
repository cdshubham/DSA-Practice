package pattern;

import java.util.Scanner;

public class p12 {
    public static void main(String[] args) {
        int n,a=-1,b=1,c=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=i){
                    c=a+b;
                    a=b;
                    b=c;
                    System.out.print(c+" ");
                }
            }
            System.out.println();
        }
    }    
}
