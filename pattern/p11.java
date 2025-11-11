package pattern;

import java.util.Scanner;

public class p11 {
    public static void main(String[] args) {
        int n,k=1;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=i){
                    System.out.print(k+" ");
                    k++;
                }
            }
            System.out.println();
        }
    }
}
