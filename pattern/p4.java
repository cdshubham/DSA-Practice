package pattern;

import java.util.Scanner;

// public class p4 {
//     public static void main(String[] args) {
//         int n;
//         Scanner sc=new Scanner(System.in);
//         n=sc.nextInt();
//         for (int i = 0; i<n; i++) {
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



public class p4 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int sp=0;
        int st=n;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=st;j++){
                System.out.print("* ");
            }
            sp++;
            st--;
            System.out.println();
        }
    }
}
