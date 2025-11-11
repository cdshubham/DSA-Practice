// package pattern;

// import java.util.Scanner;

// public class p15 {
//     public static void main(String[] args) {
//         int n;
//         Scanner sc=new Scanner(System.in);
//         n=sc.nextInt();
//         int l=n/2+1;
//         int a=-1;
//         for(int i=1;i<=n;i++){
//             if(i<=l) a++;
//             else    a--;
//             int k=a;
//             if(i<=l){
//                 for(int j=1;j<=n;j++){
//                     if(j<=l-i || j>=l+i){
//                         System.out.print("  ");
//                     }else{
//                         if(j<=l){
//                             k++;
//                         }else{
//                             k--;
//                         }
//                         System.err.print(k+" ");
//                     }
//                 }
//                 System.out.println();
//             }else{
//                 for (int j = 1; j <= n; j++) {
//                     if((i-l)>=j || j>n+(l-i)){
//                         System.out.print("  ");
//                     }else{
//                         if(j<=l){
//                             k++;
//                         }else{
//                             k--;
//                         }
//                         System.out.print(k+" ");
//                     }
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }


package pattern;

import java.util.Scanner;

public class p15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sp=n/2;
        int st=1;
        int val=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            int cval=val;
            for(int j=1;j<=st;j++){
                System.out.print(cval+" ");

                cval++;
            }
            if(i<=n/2){
                sp--;
                st+=2;
                val++;
            }else{
                sp++;
                st-=2;
                val--;
            }
            System.out.println();
        }
    }
}
