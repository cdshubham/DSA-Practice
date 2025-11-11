package pattern;

import java.util.Scanner;

// public class p6 {
//         public static void main(String[] args) {
//         int n;
//         Scanner sc=new Scanner(System.in);
//         n=sc.nextInt();
//         int k=n+2;
//         int l=n/2+1;
//         for(int i=0;i<n;i++){
//             if(i<l){
//                 for(int j=1;j<=k;j++){
//                     if(j<=l-i || j>l+i+1){
//                         System.out.print("* ");
//                     }else{
//                         System.err.print("  ");
//                     }
//                 }
//                 System.out.println();
//             }else{
//                 for (int j = 1; j <= k; j++) {
//                     if(j<=i-l+2 || k-(i-l+2)<j){
//                         System.out.print("* ");
//                     }else{
//                         System.out.print("  ");
//                     }
//                 }
//                 System.out.println();
//             }
//         }
//     }
    
// }


public class p6{
        public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int st=n/2+1;
        int sp=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=st;j++){
                System.out.print("* ");
            }
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=st;j++){
                System.out.print("* ");
            }
            if(i<=n/2){
                st--;
                sp+=2;
            }else{
                st++;
                sp-=2;
            }
            System.out.println();
        }
    }
}