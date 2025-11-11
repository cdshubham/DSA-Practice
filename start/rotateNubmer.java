package start;

import java.util.Scanner;
import java.lang.Math;
// public class rotateNubmer {
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         int num=sc.nextInt();
//         int rot=sc.nextInt();
//         int front=num%(int)Math.pow(10,rot);
//         int back=num/(int)Math.pow(10,rot);
//         int digits=(int)Math.pow(10,(int)Math.log10(num))-(int)Math.pow(10,rot);
//         int finalNum=front*(int)Math.pow(10,digits+1)+back;
//         System.out.println(finalNum);
//     }
// }

public class rotateNubmer {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int div=1,mul=1;
        int digits=(int)Math.log10(n)+1;
        System.out.println(digits);
        k=k%digits;
        if(k<0) k=k+digits;
        System.out.println(k);
        for(int i=1;i<=digits;i++){
            if(i<=k){
                div=div*10;
            }else{
                mul=mul*10;
            }
        }
        int q=n/div;
        int r=n%div;
        int newNum=r*mul+q;
        System.out.println(newNum);
    }
}
