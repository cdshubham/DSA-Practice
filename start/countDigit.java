package start;

import java.util.Scanner;

public class countDigit {
    public static void main(String args[]){
        int num,digits=0;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        while(num!=0){
            num=num/10;
            digits++;
        }
        System.out.println(digits);
    }
}
