package pattern;

import java.util.Scanner;

// public class p3 {
//     public static void main(String[] args) {
//         int n;
//         Scanner sc=new Scanner(System.in);
//         n=sc.nextInt();
//         for (int i = n; i>=0; i--) {
//             for(int j=0;j<2*n-1;j++){
//                 if(j%2==0 && j>2*i-1){
//                     System.out.print("*");
//                 }else{
//                     System.out.print(" ");
//                 }
//             }
//             System.out.println();
//         }
//     }
// }


public class p3 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int st=1;
        int sp=n-1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=st;j++){
                System.out.print("* ");
            }

            sp--;
            st++;
            System.out.println();
        }
    }
}
