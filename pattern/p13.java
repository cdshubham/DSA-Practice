package pattern;

import java.util.Scanner;

public class p13 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            int icj=1;
            for(int j=0;j<=i;j++){
                System.out.print(icj+" ");
                int i1cj1=icj*(i-j)/(j+1);
                icj=i1cj1;
            }
            System.out.println();
        }
    }
}
