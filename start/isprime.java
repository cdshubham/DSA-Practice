package start;

import java.util.Scanner;

// class IsPrime{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int num=sc.nextInt();
//         for(int i=2;i<num;i++){
//             if(num%i==0){
//                 System.out.println(num + " is not a prime number.");
//                 return;
//             }
//         };
//         System.out.println(num + " is a prime number.");
//     }
// }


class IsPrime{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                System.out.println(num + " is not a prime number.");
                return;
            }
        };
        System.out.println(num + " is a prime number.");
    }
}