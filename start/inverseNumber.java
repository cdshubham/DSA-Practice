package start;

import java.util.Scanner;
import java.lang.Math;
public class inverseNumber {
    public static void main(String args[]){
        int num,newNum=0,inc=1;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        while(num!=0){
            newNum=newNum+inc*(int)Math.pow(10,num%10-1);
            inc++;
            num=num/10;
        }
        System.out.println(newNum);
    }
}
