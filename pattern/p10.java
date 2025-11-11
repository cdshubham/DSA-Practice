package pattern;

import java.util.Scanner;

public class p10 {
        public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int l=n/2+1;
        for(int i=1;i<=n;i++){
            if(i<=l){
                for(int j=1;j<=n;j++){
                    if(j==l-i+1 || j==l+i-1){
                        System.out.print("* ");
                    }else{
                        System.err.print("  ");
                    }
                }
                System.out.println();
            }else{
                for (int j = 1; j <= n; j++) {
                    if((i-l+1)==j || j==n+l-i){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }
}
