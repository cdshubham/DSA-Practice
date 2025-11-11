package start;

import java.util.Scanner;
import java.lang.Math;
public class digitsOfNumber {
    public static void main(String args[]){
        int num=0,digits;
        
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        
        digits=(int)Math.pow(10,(int)Math.log10(num));

        while(digits!=0){
            System.out.println(num/digits);
            num=num%digits;
            digits=digits/10;
        }
    }
}
