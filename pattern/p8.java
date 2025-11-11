package pattern;

import java.util.Scanner;

public class p8 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==(n-j-1)){
                    System.out.print("* ");
                }else{
                    System.out.print(" ");
                }
            }
            System.err.println();
        }
    }
}
