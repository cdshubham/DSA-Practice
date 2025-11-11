package pattern;

import java.util.Scanner;

// public class p5 {
//     public static void main(String[] args) {
//         int n;
//         Scanner sc=new Scanner(System.in);
//         n=sc.nextInt();
//         int l=n/2+1;
//         for(int i=1;i<=n;i++){
//             if(i<=l){
//                 for(int j=1;j<=l;j++){
//                     if(j<=l-i){
//                         System.out.print(" ");
//                     }else{
//                         System.err.print("* ");
//                     }
//                 }
//                 System.out.println();
//             }else{
//                 for (int j = 1; j <= l; j++) {
//                     if((i-l)>=j){
//                         System.out.print(" ");
//                     }else{
//                         System.out.print("* ");
//                     }
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }

public class p5 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int sp=n/2;
        int st=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=st;j++){
                System.out.print("* ");
            }
            if(i<=n/2){
                sp--;
                st+=2;
            }else{
                sp++;
                st-=2;
            }
            System.out.println();
        }
    }
}
