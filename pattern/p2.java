package pattern;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=n;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
