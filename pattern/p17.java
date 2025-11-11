package pattern;

import java.util.Scanner;

public class p17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=n/2+1;
        int st=1,sp=l-1;
        for(int i=1;i<=n;i++){

            if(i==l){
                for(int j=1;j<=sp;j++){
                    System.out.print("* ");
                }
            }else{
                for(int j=1;j<=sp;j++){
                    System.out.print("  ");
                }
            }

            for(int j=1;j<=st;j++){
                System.out.print("* ");
            }
            if(i<l) st++;
            else if(i==l)   st=l-1;
            else    st--;
            System.out.println();
        }
    }
}
