
import java.util.Scanner;

// package pattern;

// import java.util.Scanner;

// public class p16 {
//         public static void main(String[] args) {
//         int n;
//         Scanner sc=new Scanner(System.in);
//         n=sc.nextInt();
//         int k=n+2;
//         int l=n/2+1;
//         int t=0;
//         for(int i=0;i<n;i++){
//             if(i<l-1){
//             }else{
//                 for (int j = 1; j <= k; j++) {
//                     if(j<=i-l+2){
//                         t++;
//                         System.out.print(t+" ");
//                     }else if (k-(i-l+2)<j) {
//                         System.out.print(t+" ");
//                         t--;
//                     }else{
//                         System.out.print("  ");
//                     }
//                 }
//                 System.out.println();
//             }
//         }
//     }
    
// }


class p16{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int sp= 2*n-3;
        int st=1;
        for(int i=1;i<=n;i++){
            int val=1;
            for(int j=1;j<=st;j++){
                System.out.print(val+" ");
                val++;
            }
            for(int j=1;j<=sp;j++){
                System.out.print("  ");
            }
            if(i==n){
                st--;
                val--;
            }
            for(int j=1;j<=st;j++){
                val--;
                System.out.print(val+" ");
            }
            st++;
            sp-=2;
            System.out.println();
        }
    }
}